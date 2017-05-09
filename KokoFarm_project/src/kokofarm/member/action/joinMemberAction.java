package kokofarm.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kokofarm.member.domain.MemberDTO;
import kokofarm.member.service.MemberService;

public class joinMemberAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
	
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("../kokofarm_memberjoin.view/Insert_MemberJoin.jsp");
		
		
		
		return forward;
	}

}
