package kokofarm.cart.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ActionRoutingCart implements CartAction {

	@Override
	public CartActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		String member_id = (String)session.getAttribute("member_id"); // 회원 아이디 세션받는다(테스트)
		session.setAttribute("member_id", member_id);
		String path = request.getContextPath();
		String command = path+"/kokofarm_orderproduct.view/";
		
		String[] product_no = request.getParameterValues("order");
		String[] product_amount = request.getParameterValues("amount");
		String[] total_price = request.getParameterValues("total");
		
		session.setAttribute("product_no", product_no);
		session.setAttribute("product_amount", product_amount);
		session.setAttribute("total_price", total_price);
		
		/*for(int i=0; i<product_no.length; i++){
			System.out.println(product_no[i].toString()+"@@@@@@@");
			System.out.println(product_amount[i].toString());
			System.out.println(total_price[i].toString());
		}*/
		
		
		CartActionForward forward = new CartActionForward();
		forward.setPath(command+"orderproduct.orderproduct");
		forward.setRedirect(true);
		return forward;
	}

}
