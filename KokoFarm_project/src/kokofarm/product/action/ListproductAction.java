package kokofarm.product.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kokofarm.product.domain.ListProductPage;
import kokofarm.product.service.ProductService;

public class ListproductAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ProductService service = ProductService.getInstance();
		System.out.println("listaction");
		int requestPage = 1;
		ListProductPage list = service.listProductService(request, requestPage);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("list_Product.jsp");
		
		return forward;
	}

}
