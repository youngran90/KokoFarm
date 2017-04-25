package kokofarm.product.action;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kokofarm.product.domain.ProductDTO;
import kokofarm.product.persistence.ProductDao;
import kokofarm.product.service.ProductService;

public class InsertProductAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ProductService service = ProductService.getInstance();
		ProductDTO product = new ProductDTO();
		
		product.setProduct_name(request.getParameter("product_name"));
		product.setProduct_unit(request.getParameter("product_unit"));
		product.setProduct_price(Integer.parseInt(request.getParameter("product_price")));
		product.setSeller_no(request.getParameter("seller_no"));
		
		//System.out.println(product.getProduct_no());
		service.insertProdectService(product);
		
		ActionForward forward = new ActionForward();
		forward.setRdirect(false);
		forward.setPath("list.jsp");
		
		return forward;
	}

}
