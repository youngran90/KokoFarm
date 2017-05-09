package kokofarm.register.model;

import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kokofarm.register.mapper.RegMapper;
import kokofarm.register.model.RegPaging;

public class RegDao {
private static final int PAGE_SIZE = 15;
	//	private static final int PAGE_SIZE = 3;
//	
	private static RegDao dao = new RegDao();
	public static RegDao getInstance(){
		return dao;
	}
	
	public SqlSessionFactory getSqlSessionFactory(){ //sqlSession 객체를 얻어오기 위해.
		String resource = "mybatis-config_auction.xml"; //클래스 패스 경로가 src 이기 때문에 경로없이 사용가능
		InputStream in = null;
		try {
			in = Resources.getResourceAsStream(resource);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new SqlSessionFactoryBuilder().build(in); //sqlSessionFactory 를 얻어온다.
	}
	
	public void insert(RegDto regDto) throws Exception{
		SqlSession session = getSqlSessionFactory().openSession();
		int re = -1;
		try {
			re = session.getMapper(RegMapper.class).insert(regDto);
			if(re>0){
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
	}
	public int selectAuction_no(){
		SqlSession session = getSqlSessionFactory().openSession();
		try {
			if(session.getMapper(RegMapper.class).selectAuction_no()==null){
				return 0;
			}else{
				return session.getMapper(RegMapper.class).selectAuction_no();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			session.close();
		}
	}
	
	public List<RegDto> regList() throws Exception{
		SqlSession session = getSqlSessionFactory().openSession();
		List<RegDto> list = null;
		try{
			list = session.getMapper(RegMapper.class).regList();
		} catch(Exception e){
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
		return list;
	}
	
	public RegPaging RegPaging() throws Exception{
		SqlSession session = getSqlSessionFactory().openSession();
		
		return null;
		
	}

	public RegDto regDetail(String auction_no) throws Exception{
		SqlSession session = getSqlSessionFactory().openSession();
		RegDto regDto= null;
		try{
			regDto = session.getMapper(RegMapper.class).regDetail(auction_no);
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			session.close();
		}
		return regDto;
	}
	
	public int countReg(){
		SqlSession session = getSqlSessionFactory().openSession();
		int re = 0;
		try {
			re = session.getMapper(RegMapper.class).countBoard();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return re;
	}

}
