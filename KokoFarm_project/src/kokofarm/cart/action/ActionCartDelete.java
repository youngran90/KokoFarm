package kokofarm.cart.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kokofarm.cart.domain.CartDTO;
import kokofarm.cart.domain.CartListDTO;
import kokofarm.cart.service.CartService;

public class ActionCartDelete implements CartAction {

	@Override
	public CartActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		CartService service = CartService.getInstance();
		
		HttpSession session = request.getSession();
		String member_id = (String)session.getAttribute("member_id");
		session.setAttribute("member_id", member_id); //세션
		
		String product_no = request.getParameter("product_no");
		
		CartDTO cart_delete = new CartDTO();
		cart_delete.setMember_id(member_id);
		cart_delete.setProduct_no(product_no);
		service.cart_delete(cart_delete); // 선택한 항목만 삭제
		
		CartActionForward forward = new CartActionForward();
		forward.setPath("AcitonCartList.cart");
		forward.setRedirect(true);
		return forward;
	}

}
