package kokofarm.cart.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kokofarm.cart.domain.CartDTO;
import kokofarm.cart.service.CartService;

public class ActionCartDeleteALL implements CartAction{

	@Override
	public CartActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		CartService service = CartService.getInstance();
		
		HttpSession session = request.getSession();
		String member_id = (String)session.getAttribute("member_id");
		session.setAttribute("member_id", member_id); //세션
		
		
		
		String m_id = request.getParameter("m_id");
		
		CartDTO cart_delete_all = new CartDTO();
		cart_delete_all.setMember_id(m_id);
		
		service.cart_delte_all(cart_delete_all); // 장바구니 전체 목록 삭제
		
		CartActionForward forward = new CartActionForward();
		forward.setPath("AcitonCartList.cart");
		forward.setRedirect(true);
		return forward;
	}
	
}
