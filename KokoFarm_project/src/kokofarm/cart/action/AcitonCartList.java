package kokofarm.cart.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kokofarm.cart.domain.CartListDTO;
import kokofarm.cart.domain.ProductDTO;
import kokofarm.cart.service.CartService;

public class AcitonCartList implements CartAction {

	@Override
	public CartActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		CartService service = CartService.getInstance();
		
		HttpSession session = request.getSession();
		String member_id = (String)session.getAttribute("member_id");
		session.setAttribute("member_id", member_id);
		
		System.out.println("장바구니 리스트 출력 세션 : "+member_id);
		
		List<CartListDTO>list = service.cart_list(member_id);
		
		session.setAttribute("listcart", list);
		
		CartActionForward forward = new CartActionForward();
		forward.setPath("/KokoFarm_project/kokofarm_cart.view/list_cart.jsp");
		forward.setRedirect(true);
		return forward;
	}

}
