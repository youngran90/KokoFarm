package kokofarm.orderproduct.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kokofarm.orderproduct.model.OrderProductService;
import kokofarm.orderproduct.model.ProductDTO;


public class ActionList implements OrderProductAction{

	@Override
	public OrderProductActionFoward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		OrderProductService service = OrderProductService.getInstance();
		List<ProductDTO> list = service.Productlist();
		request.setAttribute("list", list);

		HttpSession session = request.getSession();
		session.setAttribute("member_id", service.create_UUID());
	
		
		OrderProductActionFoward forward = new OrderProductActionFoward();
		forward.setRedirect(false);
		forward.setPath("/list.jsp");
		
		return forward;
	}

}
