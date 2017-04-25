package kokofarm.orderproduct.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface OrderProductAction {
	public OrderProductActionFoward excute(HttpServletRequest request, HttpServletResponse response) throws Exception; 
}
