package kokofarm.member.persistence;

import java.io.InputStream;

import javax.websocket.Session;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kokofarm.member.domain.MemberDTO;
import kokofarm.member.mapper.MemberMapper;

public class MemberDao {

	private MemberDao(){}
	private static class MemberDaoSingleton{
		private static final MemberDao memberDao = new MemberDao();
		}
	
	public static MemberDao getInstance(){
		System.out.println("Create  dao instance");
		return MemberDaoSingleton.memberDao;		
	}
	
	public SqlSessionFactory getSqlSessionFaction(){
		String resource = "mybatis-config.xml";
		InputStream in = null;
		try {
			in = Resources.getResourceAsStream(resource);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new SqlSessionFactoryBuilder().build(in);
	}
	
	// sql 연결 
	
	public int insertMember(MemberDTO member) throws Exception{
		SqlSession sqlSession = getSqlSessionFaction().openSession();
		int re = -1;
		try {
			re= sqlSession.getMapper(MemberMapper.class).insertMember(member);
			if(re>0){
				sqlSession.commit();
			}else{
				sqlSession.rollback();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		
		return re;
	}
	public boolean idcheck(String userid) throws Exception{
		
		SqlSession session = getSqlSessionFaction().openSession();
		boolean result = false;
		try {
			if (session.getMapper(MemberMapper.class).idcheck(userid)==0){
				return result = true;
			}else{
				return false;
			}		
		}catch (Exception e) {
			e.printStackTrace();
			return result = true;
		}finally {
			session.close();
		}
		
	}
	
	
}


