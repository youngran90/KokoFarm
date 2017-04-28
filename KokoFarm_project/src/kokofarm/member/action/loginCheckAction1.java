package kokofarm.member.action;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.sun.xml.internal.bind.v2.runtime.Location;

import kokofarm.member.domain.MemberDTO;
import kokofarm.member.persistence.MemberDao;
import kokofarm.member.service.MemberService;

public class loginCheckAction1 implements Action {
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		MemberDao dao = MemberDao.getInstance();
	
		HttpSession session = request.getSession();
		
		String member_id = request.getParameter("member_id");
		String member_password = request.getParameter("member_password");
		
		HashMap<String, String> map = 
					new HashMap<String,String>();
		map.put("member_id",member_id);
		map.put("member_password", member_password);
		
		int re = dao.logincheck(map);
		
		
		String message ="";
		
		if(re==1){
			message = member_id+"님 환영 합니다.";
			session.setAttribute("member_id", member_id);
			request.setAttribute("message", message);
			
			request.setAttribute("message", message);
			
			
			ActionForward forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("listMember.member");
			return forward;
			
			
					
		}else{
			message = "로그인을 할 수 없습니다.";
			
			request.setAttribute("message", message);
			
			
			ActionForward forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("logincheck.jsp");
			return forward;
				
					
		}
		
		
		
	
	}

}
