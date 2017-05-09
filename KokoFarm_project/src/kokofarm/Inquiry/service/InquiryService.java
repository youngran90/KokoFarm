package kokofarm.Inquiry.service;

import java.util.List;
import java.util.UUID;

import kokofarm.Inquiry.domain.InquiryDTO;
import kokofarm.Inquiry.persistence.InquiryDao;

public class InquiryService {
 private static InquiryService service = new InquiryService();
 private static InquiryDao inquiryDao;
 
 public static InquiryService getInstance(){
	 inquiryDao = InquiryDao.getInstance();
	 return service;
 }
 
 public String create_UUID(){
	 String uuid = UUID.randomUUID().toString().replace("-", "");
	 return uuid;
 }
 
 //삽입
 public int insertInquiryService(InquiryDTO Inquiry){
	 String uuid = create_UUID();
	 Inquiry.setInquiry_no("In-"+uuid);
	 System.out.println(Inquiry.toString());
	 System.out.println("***************************");
	 return inquiryDao.insertInquiry(Inquiry);
 }
 
 //리스트출력
 public List<InquiryDTO>listInquiryService(String seller_no){
	 return inquiryDao.listInquiry(seller_no);
 }
 
 //상세글보기
 public InquiryDTO detailInquiryService(String Inquiry_no){
	 return inquiryDao.detailInquiry(Inquiry_no);
 }
 
 //답글달기
 public int insertInquiryReplySerivce(InquiryDTO Inquiry){
	 return inquiryDao.insertInquiryReply(Inquiry);
 }
}
