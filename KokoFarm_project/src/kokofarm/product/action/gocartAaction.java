package kokofarm.product.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class gocartAaction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	System.out.println("question*********goAction");
		
		String product_no = request.getParameter("product_no");
		String product_unit = request.getParameter("ea");
		
		HttpSession session = request.getSession();
		session.setAttribute("product_no", product_no);
		session.setAttribute("product_unit", product_unit);
	
		
		System.out.println("--------------------------------");
		System.out.println(product_no);
		System.out.println(product_unit);
		System.out.println("--------------------------------");
		
		ActionForward forward = new ActionForward();
		
		forward.setPath("ActionCartListInsert.cart");
		forward.setRedirect(true);
		
		return forward;
	}
}
