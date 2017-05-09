package kokofarm.cart.action;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kokofarm.cart.domain.CartDTO;
import kokofarm.cart.service.CartService;

public class ActionCartListInsert implements CartAction{
	 private static String cart_no;
	@Override
	public CartActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		CartService service = CartService.getInstance();
		
		HttpSession session = request.getSession();
		String member_id  = (String)session.getAttribute("member_id");
		session.setAttribute("member_id", member_id);
		System.out.println("장바구니 리스트 입력 세션 : "+member_id);
		
		CartDTO cart = new CartDTO();
		cart_no = service.create_UUID();
		
		cart.setMember_id("aaaa");
		cart.setCart_no(cart_no);
		cart.setProduct_no(request.getParameter("product_no"));
		cart.setProduct_unit(request.getParameter("ea"));
		
		
		System.out.println(request.getParameter("@@@@@@@@@@@@@@@ "+"product_no"));
		System.out.println(request.getParameter("@@@@@@@@@@@@@@@ "+"ea"));
		//service.cart_insert(cart);
		
		
		CartActionForward forward = new CartActionForward();
		forward.setRedirect(true);
		forward.setPath("AcitonCartList.cart");
		return forward;
	}

}
