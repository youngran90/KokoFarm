package kokofarm.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import kokofarm.member.service.MemberService;

public class idcheckAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//사용자가 입력한 아이디
		MemberService service = MemberService.getInstance();
		
		String member_id = request.getParameter("userid");
		
	
		System.out.println(member_id);
		
	
		
		boolean result = service.idcheckService(member_id);
		System.out.println(result);
		
		String message = "";
		if(result){
			message=member_id+"는 사용 가능한 아이디 입니다.";
		}else{
			message =member_id+"는 사용 불가능한 아이디 입니다.";
		}
		request.setAttribute("message", message);
		System.out.println(message);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("../../KokoFarm_project/kokofarm_memberjoin.view/idcheck.jsp");
		
		return forward;
	}

}
