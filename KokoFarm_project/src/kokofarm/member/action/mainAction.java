package kokofarm.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class mainAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("../Kokofarm_Main/kokofarm_main.jsp");
		
		return forward;
	}

}
