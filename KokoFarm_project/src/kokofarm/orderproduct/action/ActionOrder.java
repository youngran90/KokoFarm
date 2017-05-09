package kokofarm.orderproduct.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kokofarm.orderproduct.domain.OrderProductDTO;
import kokofarm.orderproduct.service.OrderProductService;


public class ActionOrder implements OrderProductAction{

	@Override
	public OrderProductActionFoward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		OrderProductService service = OrderProductService.getInstance();
		
		HttpSession session = request.getSession();
		String member_id = (String)session.getAttribute("member_id"); // 회원 아이디 세션받는다(테스트)
		request.setAttribute("member_id", member_id);
		String order_no=service.create_UUID();
		
		String[] product_no = (String[])session.getAttribute("product_no");
		String[] product_amount = (String[])session.getAttribute("product_amount");
		String[] total_price = (String[])session.getAttribute("total_price");
		
		service.OrderProduct(order_no,product_no, member_id, product_amount, total_price);
		
		OrderProductActionFoward foward = new OrderProductActionFoward();
		foward.setPath("orderproductlist.orderproduct");
		foward.setRedirect(true);
		return foward;
	}

}
