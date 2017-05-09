package kokofarm.Inquiry.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kokofarm.Inquiry.domain.InquiryDTO;
import kokofarm.Inquiry.service.InquiryService;

public class ListInquiryAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		InquiryService service = InquiryService.getInstance();
		List<InquiryDTO> inquirylist = null;
		System.out.println("************inquirylistAction");
		HttpSession session = request.getSession();
		String member_id = (String)session.getAttribute("member_id");
		String seller_no = member_id;
		inquirylist = service.listInquiryService(seller_no);
		
		request.setAttribute("inquirylist", inquirylist);
		
		System.out.println(inquirylist.toString());
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("/KokoFarm_project/kokofarm_Inquiry.view/list_Inquiry.jsp");
		
		return forward;
	}

}
