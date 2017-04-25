package kokofarm.orderproduct.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kokofarm.orderproduct.model.OrderProductService;
import kokofarm.orderproduct.model.ProductDTO;


public class ActionInsert implements OrderProductAction{

	@Override
	public OrderProductActionFoward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		OrderProductService service = OrderProductService.getInstance();
		ProductDTO product = new ProductDTO();
		
		product.setProduct_name(request.getParameter("product_name"));
		product.setProduct_unit(request.getParameter("product_unit"));
		product.setProduct_price(Integer.parseInt(request.getParameter("product_price")));
		product.setSeller_no(request.getParameter("seller_no"));
		
		//System.out.println(product.getProduct_no());
		service.insertList(product);
		
		OrderProductActionFoward forward = new OrderProductActionFoward();
		forward.setRedirect(false);
		forward.setPath("list.do");
		
		return forward;
	}


}
