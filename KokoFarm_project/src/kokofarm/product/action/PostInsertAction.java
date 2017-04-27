package kokofarm.product.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kokofarm.product.domain.PostDTO;
import kokofarm.product.service.ProductService;

public class PostInsertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ProductService service = ProductService.getInstance();
		System.out.println("insertpost");
		String product_no = request.getParameter("product_no");
		PostDTO post = new PostDTO();
		post.setProduct_no(product_no);
		service.InsertPostService(post);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("detailAction.product");
		
		return forward;
	}

}
