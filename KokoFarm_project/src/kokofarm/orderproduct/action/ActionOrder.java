package kokofarm.orderproduct.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kokofarm.orderproduct.service.OrderProductService;


public class ActionOrder implements OrderProductAction{

	@Override
	public OrderProductActionFoward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		OrderProductService service = OrderProductService.getInstance();
		
		HttpSession session = request.getSession();
		String member_id = (String)session.getAttribute("member_id"); // 회원 아이디 세션받는다(테스트)
		request.setAttribute("member_id", member_id);
		
		
		String product_no[] = request.getParameterValues("check");
		request.setAttribute("no",product_no); //제품번호 받는다

		//service.OrderProduct(product_no, member_id);
		OrderProductActionFoward foward = new OrderProductActionFoward();
		foward.setPath("orderproductlist.orderproduct");
		foward.setRedirect(false);
		return foward;
	}

}
