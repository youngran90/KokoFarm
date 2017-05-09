package kokofarm.Inquiry.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kokofarm.Inquiry.domain.InquiryDTO;
import kokofarm.Inquiry.persistence.InquiryDao;
import kokofarm.Inquiry.service.InquiryService;

public class doInquiryAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("question*********doAction");
		 
		
		String product_name = request.getParameter("product_name");
		String product_no = request.getParameter("product_no");
		HttpSession session = request.getSession();
		String member_id = (String)session.getAttribute("member_id");
		String seller_no = request.getParameter("seller_no");
		
		System.out.println("--------------------------------");
		System.out.println(product_name);
		System.out.println(product_no);
		System.out.println(member_id);
		System.out.println(seller_no);
		System.out.println("--------------------------------");
		
		
		request.setAttribute("product_name", product_name);
		request.setAttribute("product_no", product_no);
		request.setAttribute("seller_no", seller_no);
		
		
		ActionForward forward = new ActionForward();
		if(member_id != null){
			forward.setPath("/kokofarm_Inquiry.view/insert_Inquiry.jsp");
		}else{
		response.setContentType("text/html; charset=UTF-8");
	    PrintWriter out = response.getWriter();
        out.println("<script>alert('로그인이 필요합니다');  window.close(); </script>");
		}
		
		forward.setRedirect(false);
		return forward;
	}

}
