package kokofarm.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class logoutAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		HttpSession session = request.getSession();
		String member_id1 =(String)session.getAttribute("member_id");
		System.out.println("세션의 아이디 :"+member_id1);
	
		session.invalidate();
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("mainAction.member");
		
		return forward;
	}

}
