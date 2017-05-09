package kokofarm.member.action;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kokofarm.member.domain.MemberDTO;
import kokofarm.member.service.MemberService;


public class insertFormAction implements Action {

	 public String create_UUID(){ //각 고유한 번호 생성 메소드
         String uuid = UUID.randomUUID().toString().replace("-", "");
     return uuid;
   }

		
	
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String cartno = create_UUID();
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
		
		member.setCartNo(cartno);
		int re = -1;
		re = service.insertMemberService(member);
	
		if(re>0){
			ActionForward forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("List_member.jsp");
			return forward;
		}else{
			return null;
		}
		
			
	}
}

