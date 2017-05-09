package kokofarm.Inquiry.mapper;

import java.util.List;

import kokofarm.Inquiry.domain.InquiryDTO;

public interface InquiryMapper {
	public int insertInquiry(InquiryDTO Inquiry);
	public List<InquiryDTO> listInquiry(String seller_no);
	public InquiryDTO detailInquiry(String Inquiry_no);
	public int insertInquiryReply(InquiryDTO Inquiry);
}
