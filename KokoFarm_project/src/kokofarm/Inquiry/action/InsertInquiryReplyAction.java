package kokofarm.Inquiry.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kokofarm.Inquiry.domain.InquiryDTO;
import kokofarm.Inquiry.service.InquiryService;

public class InsertInquiryReplyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("question*********ReplyAction");
		InquiryService service = InquiryService.getInstance();
		InquiryDTO Inquiry = new InquiryDTO();
		
		Inquiry.setInquiry_no(request.getParameter("inquiry_no"));
		Inquiry.setInquiry_reply(request.getParameter("inquiry_reply"));
		
		System.out.println("inquiry_no :" +request.getParameter("inquiry_no"));
		System.out.println("inquiry_reply:" +request.getParameter("inquiry_reply"));

		service.insertInquiryReplySerivce(Inquiry);
	
		ActionForward forward = new ActionForward();
		forward.setPath("ListInquiryAction.Inquiry");
		forward.setRedirect(false);
		
		return forward;
	}

}
