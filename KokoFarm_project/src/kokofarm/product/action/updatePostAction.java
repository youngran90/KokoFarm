package kokofarm.product.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kokofarm.product.domain.PostDTO;
import kokofarm.product.service.ProductService;

public class updatePostAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ProductService service = ProductService.getInstance();
		System.out.println("updatepost************Action");
		PostDTO post = new PostDTO();
		
		post.setPost_content(request.getParameter("post_content"));
		post.setPost_no(request.getParameter("post_no"));
		
		service.updatePostService(post);
		
		ActionForward forward = new ActionForward();
		forward.setPath("detailProdutAction.product");
		forward.setRedirect(false);
		
		return forward;
	}

}
