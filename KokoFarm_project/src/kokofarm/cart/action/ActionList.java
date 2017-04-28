package kokofarm.cart.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kokofarm.cart.domain.ProductDTO;
import kokofarm.cart.service.CartService;

public class ActionList implements CartAction{

	@Override
	public CartActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		CartService service = CartService.getInstance();
		
		List<ProductDTO> list = service.product_list();
		request.setAttribute("list", list);
		
		HttpSession session = request.getSession();
		String member_id  = (String)session.getAttribute("member_id");
		session.setAttribute("member_id", member_id);
		System.out.println("물품 리스트 세션 : "+member_id);
		

		
		
		CartActionForward forward = new CartActionForward();
		forward.setPath("list_product.jsp");
		forward.setRedirect(false);
		return forward;
	}

}
