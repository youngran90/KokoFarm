package kokofarm.customercenter.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("../kokofarm_customercenter.view/insert_form.jsp");
		return forward;
		
	}

}
