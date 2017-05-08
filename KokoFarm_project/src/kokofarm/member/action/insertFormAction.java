package kokofarm.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kokofarm.member.domain.MemberDTO;
import kokofarm.member.service.MemberService;


public class insertFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		MemberService service = MemberService.getInstance();
		MemberDTO member = new MemberDTO(); 
		
		member.setMember_id(request.getParameter("member_id"));
		member.setMember_password(request.getParameter("member_password"));
		member.setMember_name(request.getParameter("member_name"));
		member.setMember_email(request.getParameter("member_email"));
		member.setMember_phoneNum(request.getParameter("member_phoneNum"));
		member.setMember_zipcode(request.getParameter("member_zipcode"));
		member.setMember_address1(request.getParameter("member_address1"));
		member.setMember_address2(request.getParameter("member_address2"));
		member.setMember_account(request.getParameter("member_account"));
		
		System.out.println(request.getParameter("member_id"));
		System.out.println(request.getParameter("member_password"));
		System.out.println(request.getParameter("member_name"));
		System.out.println(request.getParameter("member_email"));
		System.out.println(request.getParameter("member_phoneNum"));
		System.out.println(request.getParameter("member_zipcode"));
		System.out.println(request.getParameter("member_address1"));
		System.out.println(request.getParameter("member_address2"));
		System.out.println(request.getParameter("member_account"));
				
		service.insertMemberService(member);
	
		
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("List_member.jsp");
			
		
		return forward;
		}
		
	}


