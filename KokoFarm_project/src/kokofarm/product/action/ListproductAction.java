package kokofarm.product.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kokofarm.product.domain.ListProductPage;
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
	
		String m_id = "0";
		session.setAttribute("m_id", m_id);
		System.out.println("list_mid는"+session.getAttribute("m_id"));
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("list_Product.jsp");
		
		return forward;
	}

}
