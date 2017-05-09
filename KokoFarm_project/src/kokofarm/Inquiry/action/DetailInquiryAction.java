package kokofarm.Inquiry.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kokofarm.Inquiry.domain.InquiryDTO;
import kokofarm.Inquiry.service.InquiryService;

public class DetailInquiryAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("question*********detailAction");
		 
		InquiryService service = InquiryService.getInstance();
		InquiryDTO Inquiry = new InquiryDTO();
		
		Inquiry = service.detailInquiryService(request.getParameter("inquiry_no"));
		HttpSession session = request.getSession();
		session.setAttribute("Inquiry", Inquiry);
		
		System.out.println("inquiry_no : " + request.getParameter("inquiry_no"));
		
		ActionForward forward = new ActionForward();
		forward.setPath("detail_Inquiry.jsp");
		forward.setRedirect(false);
		return forward;
	}

}
