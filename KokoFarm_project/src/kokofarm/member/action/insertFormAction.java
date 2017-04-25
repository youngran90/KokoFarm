package kokofarm.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kokofarm.member.domain.MemberDTO;
import kokofarm.member.service.MemberService;


public class insertFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberService service = MemberService.getInstance();
		MemberDTO member = new MemberDTO(); 
		
		member.setMember_id(request.getParameter("member_id"));
		member.setMember_password(request.getParameter("member_password"));
		member.setMember_name(request.getParameter("member_name"));
		member.setMember_email(request.getParameter("member_email"));
		member.setMember_phoneNum(request.getParameter("member_phoneNum"));
		member.setMember_address(request.getParameter("member_address"));
		member.setMember_account(request.getParameter("member_account"));
		
		service.insertMemberService(member);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("List_member.jsp");
			
		
		return forward;
		}
		
	}


