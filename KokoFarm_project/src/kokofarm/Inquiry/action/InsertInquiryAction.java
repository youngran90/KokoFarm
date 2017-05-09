package kokofarm.Inquiry.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kokofarm.Inquiry.domain.InquiryDTO;
import kokofarm.Inquiry.service.InquiryService;

public class InsertInquiryAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("question*********insertAction");
		InquiryService service = InquiryService.getInstance();
		InquiryDTO Inquiry = new InquiryDTO();
		HttpSession session = request.getSession();
		String member_id = (String)session.getAttribute("member_id");
		String seller_no= member_id;
		
		Inquiry.setMember_id(member_id);
		Inquiry.setInquiry_content(request.getParameter("inquiry_content"));
		Inquiry.setProduct_no(request.getParameter("product_no"));
		Inquiry.setProduct_name(request.getParameter("product_name"));
		//Inquiry.setSeller_no(request.getParameter("seller_no"));
		Inquiry.setSeller_no(seller_no);
		
		System.out.println("member_id : "+member_id);
		System.out.println("inquiry_content : "+request.getParameter("inquiry_content"));
		System.out.println("product_no : "+request.getParameter("product_no"));
		System.out.println("product_name : "+ request.getParameter("product_name"));
		System.out.println("*******seller_no: "+ seller_no);
		//System.out.println("seller_no : "+ request.getParameter("seller_no"));

		service.insertInquiryService(Inquiry);
	
		ActionForward forward = new ActionForward();
		forward.setPath("detailProdutAction.product");
		forward.setRedirect(false);
		
		return forward;
	}

}
