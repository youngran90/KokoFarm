package kokofarm.orderproduct.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ActionRoutingOrderProduct implements OrderProductAction {

	@Override
	public OrderProductActionFoward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		String member_id  = (String)session.getAttribute("member_id");
		session.setAttribute("member_id", member_id);
		
		String path = request.getContextPath();
		String command = path+"/kokofarm_cart.view/";
		
		
		OrderProductActionFoward forward = new OrderProductActionFoward();
		forward.setPath(command+"ActionList.cart");
		forward.setRedirect(true);
		return forward;
	}

}
