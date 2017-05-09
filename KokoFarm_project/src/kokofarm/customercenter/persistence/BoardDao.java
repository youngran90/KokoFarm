package kokofarm.customercenter.persistence;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kokofarm.customercenter.domain.BoardDTO;
import kokofarm.customercenter.domain.SearchCustomer;
import kokofarm.customercenter.mapper.BoardMapper;


public class BoardDao {
	static List<BoardDTO> list = null;

	private static BoardDao dao = new BoardDao();

	public static BoardDao getInstance() {
			return dao;
	}

	
	public SqlSessionFactory getSqlSessionFactory(){
		String resource = "inhee.xml";
		InputStream in = null;
		try {
			in = Resources.getResourceAsStream(resource);			
		} catch (Exception e) {
			e.printStackTrace();
		}
		//sql session factory를 연결시켜줌
		return new SqlSessionFactoryBuilder().build(in);
	}
	
	
	//새글쓰기
	public int insertBoard(BoardDTO boarddto) throws Exception {
		int re = -1;
		//session 객체를 연결후 open
		SqlSession session = getSqlSessionFactory().openSession();

		try {
			//mapper를 session에 등록		//입력시 입력한 횟수가 넘어옴. 
			re = session.getMapper(BoardMapper.class).insertBoard(boarddto);
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
		return re;
	}
	
	
	public int selectcustomer_no(){
		SqlSession sqlSession = getSqlSessionFactory().openSession();	
		try {			//글 한개도 없을 경우  null
			if(sqlSession.getMapper(BoardMapper.class).selectcustomer_no()==null){
				return 0;
			}else{
				return sqlSession.getMapper(BoardMapper.class).selectcustomer_no();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}finally{
			sqlSession.close();
		}
	}
	
	
	
	//페이징처리 한 list	//전체글리스트   
	public List<BoardDTO> listBoard(int startRow, SearchCustomer searchCustomer) {
		SqlSession session = getSqlSessionFactory().openSession();
		List<BoardDTO>list = null;     
		try {
			list = session.getMapper(BoardMapper.class).listBoard(new RowBounds(startRow, 4), searchCustomer);		
			//RowBounds : 전체내용이 아니라 일부내용만 보고 싶을 때 사용
			
		} catch (Exception e) {
			e.printStackTrace();			
		}finally {
			session.close();
		}
		  return list;     
	}
	
	
	
/*	//페이징 처리 전 list
	//전체글리스트     // !!수정한거
	public List<BoardDTO> listBoard(SearchCustomer searchCustomer) throws Exception{
		//board 객체를 불러올시 객체 직렬화를 해주어야함.
		//board.java 에서 implements Serializable
		SqlSession session = getSqlSessionFactory().openSession();
		List<BoardDTO>list = null;          ///////////////////
		
		try {
			list = session.getMapper(BoardMapper.class).listBoard(searchCustomer);		/////////////////
//			return session.getMapper(BoardMapper.class).listBoard(searchCustomer);
		} catch (Exception e) {
			e.printStackTrace();			
		//	return null;				//////11111
		}finally {
			session.close();
		}
		     return list;       /////////////////////////
	}
	*/
	
	//1개 글 선택
	public BoardDTO selectBoard(int customer_no){
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		BoardDTO boarddto = null;
		
		try {
			boarddto = sqlsession.getMapper(BoardMapper.class).selectBoard(customer_no);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			sqlsession.close();
		}
		return boarddto;
	}
	
	
	
	//조회수 
	public int updatecustomer_hitcount(BoardDTO boarddto) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;
		
		try {
			re = sqlSession.getMapper(BoardMapper.class).updatecustomer_hitcount(boarddto);

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
	
	
	//댓글 Step(그룹 내 순서)
	public int updateStep(HashMap<String, Integer>map){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;
		
		try {
			re = sqlSession.getMapper(BoardMapper.class).updateStep(map);
			
			if(re>0){
				sqlSession.commit();
			}else{
				sqlSession.rollback();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
		return re;
	}
	
	
	
	public int updateBoard(BoardDTO boarddto) {
		 SqlSession session = getSqlSessionFactory().openSession();
		 int re = -1;

		 try {
			 re = session.getMapper(BoardMapper.class).updateBoard(boarddto);
			
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
		 return re;
	}
	
	
	
	
	public void delete(BoardDTO board) throws Exception{
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
	
	
	
	public BoardDTO detailBoard(int seq) throws Exception{
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
		

	public int countBoard(SearchCustomer searchCustomer) {
		SqlSession session = getSqlSessionFactory().openSession();
		int re = 0;
		try {
			re = session.getMapper(BoardMapper.class).countBoard(searchCustomer);		
		} catch (Exception e) {
			e.printStackTrace();
	//		return 0;
		}
		finally {
			session.close();
		}
		return re;
	}
	
	public int countBoard(BoardDTO boardDTO) {
		SqlSession session = getSqlSessionFactory().openSession();
		int re = -1;
		
		try {
			re = session.getMapper(BoardMapper.class).countBoard(boardDTO);		
			if(re>0){
				session.commit();
			}else{
				session.rollback();
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}	finally {
			session.close();
		}
		return re;
	}
	
}