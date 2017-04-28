package kokofarm.cart.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CartAction {
	public CartActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
