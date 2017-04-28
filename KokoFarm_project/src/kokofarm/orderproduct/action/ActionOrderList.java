package kokofarm.orderproduct.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kokofarm.orderproduct.domain.OrderProductListDTO;
import kokofarm.orderproduct.service.OrderProductService;

public class ActionOrderList implements OrderProductAction {

	@Override
	public OrderProductActionFoward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		OrderProductService service = OrderProductService.getInstance();
		
		HttpSession session = request.getSession(); //회원 아이디 세션
		String member_id = (String)session.getAttribute("member_id");
		request.setAttribute("member_id", member_id);
		
		
		List<OrderProductListDTO> orderlist = service.OrderProductListDTO(member_id);
		for(int i=0; i<orderlist.size(); i++){
			System.out.println(orderlist.get(i));
		}
		request.setAttribute("list", orderlist);
		
		
		OrderProductActionFoward foward = new OrderProductActionFoward();
		foward.setPath("list_orderproduct.jsp");
		foward.setRedirect(false);
		return foward;
	}

}
