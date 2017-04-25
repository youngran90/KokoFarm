package kokofarm.customercenter.model;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kokofarm.customercenter.mapper.BoardMapper;


public class BoardDao {
	static List<Board> list = null;

	private static BoardDao dao = new BoardDao();

	public static BoardDao getInstance() {
			return dao;
	}

	//
	public SqlSessionFactory getSqlSessionFactory(){
		String resource = "mybatis-config.xml";
		InputStream in = null;
		try {
			in = Resources.getResourceAsStream(resource);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		//sql session factory를 연결시켜줌
		return new SqlSessionFactoryBuilder().build(in);
	}
	
	public void insertBoard(Board board) throws Exception {
		//session 객체를 연결후 open
		SqlSession session = getSqlSessionFactory().openSession();
		int re = -1;
		try {
			//mapper를 session에 등록
			//입력시 입력한 횟수가 넘어옴. 
			re = session.getMapper(BoardMapper.class).insertBoard(board);
			if(re > 0){
				session.commit();
			}else{
				//입력이 안됐을 경우 다시 돌아감
				session.rollback();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
	}

	public List<Board> listBoard(Search search) throws Exception{
		//board 객체를 불러올시 객체 직렬화를 해주어야함.
		//board.java 에서 implements Serializable
		SqlSession session = getSqlSessionFactory().openSession();
		
		try {
			return session.getMapper(BoardMapper.class).listBoard(search);
			
		} catch (Exception e) {
			return null;
			
		}finally {
			session.close();
		}
	}

	public Board detailBoard(int seq) throws Exception{
		SqlSession session = getSqlSessionFactory().openSession();
		try {
			return session.getMapper(BoardMapper.class).detailBoard(seq);
			
		} catch (Exception e) {
			return null;
		}
		finally {
			session.close();
		}
		
	}
	
	public void updateBoard(Board board) throws Exception{
		 SqlSession session = getSqlSessionFactory().openSession();
		 int re = -1;

		 try {
			 re = session.getMapper(BoardMapper.class).updateBoard(board);
			
			if(re>0){
				 session.commit();
			 }else{
				 session.rollback();
			 }
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			session.close();
		}
	}
	
	public void delete(Board board) throws Exception{
	 SqlSession session = getSqlSessionFactory().openSession();
	 int re = -1;
	 try {
		re = session.getMapper(BoardMapper.class).delete(board);
		if(re>0){
			session.commit();
		}else{
			session.rollback();
		}
	
	} catch (Exception e) {
		e.printStackTrace();
		
	}finally {
		session.close();
	}
	}
}