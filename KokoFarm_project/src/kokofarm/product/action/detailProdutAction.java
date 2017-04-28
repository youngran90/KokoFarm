package kokofarm.product.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.synth.SynthSeparatorUI;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import kokofarm.product.domain.PostDTO;
import kokofarm.product.domain.ProductDTO;
import kokofarm.product.service.ProductService;

public class detailProdutAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ProductService service = ProductService.getInstance();
		System.out.println("detailproductaction");
		String product_no = request.getParameter("product_no");
		System.out.println(product_no);
		ProductDTO product = service.detailProductService(product_no);
		request.setAttribute("product", product);
		
		
		
		System.out.println(product.getProduct_name());
		System.out.println(product.getProduct_price());
		System.out.println(product.getProduct_unit());
		System.out.println(product.getProduct_uploaddate());
		System.out.println(product.getProduct_harvestdate());
		
		ActionForward forward = new ActionForward();
		forward.setPath("detail_product.jsp");
		forward.setRedirect(false);
		
		return  forward;
	}

}
