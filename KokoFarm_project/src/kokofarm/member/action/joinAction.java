package kokofarm.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class joinAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String member_id = request.getParameter("member_id");
		
		System.out.println("조인액션의"+member_id);
		
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("../kokofarm_memberjoin.view/member_login.jsp");
		return forward;
	}

}
