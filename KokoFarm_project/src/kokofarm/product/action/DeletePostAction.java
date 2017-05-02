package kokofarm.product.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kokofarm.product.service.ProductService;

public class DeletePostAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ProductService service = ProductService.getInstance();
		
		System.out.println("deletepostAction");
		String post_no = request.getParameter("post_no");
		System.out.println(post_no);

		service.deletePostService(post_no);
		ActionForward forward = new ActionForward();
		forward.setPath("detailProdutAction.product");
		forward.setRedirect(false);
		
		return forward;
	}

}
