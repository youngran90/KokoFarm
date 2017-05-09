package kokofarm.product.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kokofarm.product.domain.ListProductPage;
import kokofarm.product.domain.ProductDTO;
import kokofarm.product.service.ProductService;

public class ListproductAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ProductService service = ProductService.getInstance();
		System.out.println("listaction");
		int requestPage = 1;
		
		ListProductPage list = service.listProductService(request, requestPage);
		
		//세션 저장
		HttpSession session = request.getSession();
		
		session.getAttribute("member_id");
		System.out.println("list_mid는"+session.getAttribute("member_id"));
		
		ActionForward forward = new ActionForward();
		//forward.setRedirect(true);
		forward.setRedirect(false);
		forward.setPath("list_Product.jsp");
		//forward.setPath("/KokoFarm_project/kokofarm_cart.view/list_product.jsp");
		return forward;
	}

}
