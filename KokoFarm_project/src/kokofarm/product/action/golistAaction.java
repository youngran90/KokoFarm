package kokofarm.product.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class golistAaction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	System.out.println("question*********goAction");
		ActionForward forward = new ActionForward();
	
		forward.setPath("/KokoFarm_project/kokofarm_product.view/list_Product.jsp");
	
		forward.setRedirect(true);
		
		return forward;
	}
}
