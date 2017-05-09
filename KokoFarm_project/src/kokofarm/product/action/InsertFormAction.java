package kokofarm.product.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kokofarm.Inquiry.action.Action;
import kokofarm.Inquiry.action.ActionForward;

public class InsertFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		
		forward.setPath("/KokoFarm_project/kokofarm_product.view/insert_product.jsp");
		forward.setRedirect(true);
		return forward;
	}

}
