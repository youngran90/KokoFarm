package kokofarm.cart.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kokofarm.cart.domain.ProductDTO;
import kokofarm.cart.service.CartService;



public class ActionInsert implements CartAction{

	@Override
	public CartActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		CartService service = CartService.getInstance();
		ProductDTO product = new ProductDTO();

		
		product.setProduct_no(service.create_UUID());
		product.setProduct_name(request.getParameter("product_name"));
		product.setProduct_unit(request.getParameter("product_unit"));
		product.setProduct_price(Integer.parseInt(request.getParameter("product_price")));
		product.setSeller_no(request.getParameter("seller_no"));		
		service.insertList(product);
		
		HttpSession session = request.getSession(); //회원 아이디 세션 생성(테스트)
		session.setAttribute("member_id", service.create_UUID());
		
		
		CartActionForward forward = new CartActionForward();
		forward.setRedirect(false);
		forward.setPath("AcitonList.cart");
		
		return forward;
	}


}
