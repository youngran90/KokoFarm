package kokofarm.Inquiry.persistence;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kokofarm.Inquiry.domain.InquiryDTO;
import kokofarm.Inquiry.mapper.InquiryMapper;

public class InquiryDao {

	 private static InquiryDao inquirydao = new InquiryDao();
	 
	 public static InquiryDao getInstance(){
		 return inquirydao;
	 }
	 
	 public SqlSessionFactory getSqlSessionFactory(){
		 String resource = "mycon.xml";
			InputStream in = null;
			try {
				in = Resources.getResourceAsStream(resource);

			} catch (Exception e) {
				e.printStackTrace();
			}
			return new SqlSessionFactoryBuilder().build(in);
	 }
	
	 //문의글 삽입
	public int insertInquiry(InquiryDTO Inquiry){
		System.out.println("Insert at insertInquiry");
		SqlSession session = getSqlSessionFactory().openSession();
		int re = -1;
		
		try {
			re = session.getMapper(InquiryMapper.class).insertInquiry(Inquiry);
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
	
	//리스트
	public List<InquiryDTO> listInquiry(String seller_no){
		SqlSession session = getSqlSessionFactory().openSession();
		List<InquiryDTO> list = null;
		try {
			list = session.getMapper(InquiryMapper.class).listInquiry(seller_no);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return list;
	}
	
	//상세글보기
	public InquiryDTO detailInquiry(String Inquiry_no){
		SqlSession session = getSqlSessionFactory().openSession();
		InquiryDTO Inquiry = session.getMapper(InquiryMapper.class).detailInquiry(Inquiry_no);
		return Inquiry;
	}
	
	//댓글등록
	public int insertInquiryReply(InquiryDTO Inquiry){
		SqlSession session = getSqlSessionFactory().openSession();
		int re= -1;
		try {
			re = session.getMapper(InquiryMapper.class).insertInquiryReply(Inquiry);
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
}
