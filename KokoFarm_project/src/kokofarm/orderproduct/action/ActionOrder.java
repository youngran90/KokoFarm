package kokofarm.orderproduct.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kokofarm.orderproduct.model.OrderProductService;


public class ActionOrder implements OrderProductAction{

	@Override
	public OrderProductActionFoward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		OrderProductService service = OrderProductService.getInstance();
		
		
		String no = request.getParameter("product_no");
		request.setAttribute("no",no);
		
		HttpSession session = request.getSession();
		String member_id = (String)session.getAttribute("member_id");
		request.setAttribute("member_id", member_id);

		service.OrderProduct(no, member_id);
		
		
		OrderProductActionFoward foward = new OrderProductActionFoward();
		foward.setPath("orderproduct.jsp");
		foward.setRedirect(false);
		return foward;
	}

}
