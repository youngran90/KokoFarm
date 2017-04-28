package kokofarm.cart.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kokofarm.cart.domain.CartDTO;
import kokofarm.cart.service.CartService;

public class ActionCartListInsert implements CartAction{

	@Override
	public CartActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		CartService service = CartService.getInstance();
		
		HttpSession session = request.getSession();
		String member_id  = (String)session.getAttribute("member_id");
		session.setAttribute("member_id", member_id);
		System.out.println("장바구니 리스트 입력 세션 : "+member_id);
		
		String[] checklist = request.getParameterValues("check"); //체크한 제품의 제품 번호를 받는배열
		service.cart_list(checklist, member_id);
		
		
		CartActionForward forward = new CartActionForward();
		forward.setRedirect(false);
		forward.setPath("AcitonCartList.cart");
		return forward;
	}

}
