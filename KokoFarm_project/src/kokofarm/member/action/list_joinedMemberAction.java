package kokofarm.member.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kokofarm.member.domain.ListModel;
import kokofarm.member.domain.MemberDTO;
import kokofarm.member.domain.MemberSearch;
import kokofarm.member.persistence.MemberDao;
import kokofarm.member.service.MemberService;

public class list_joinedMemberAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");	
		
		
		MemberService service = MemberService.getInstance();
		MemberDao dao = MemberDao.getInstance();
		
		String pageNum = request.getParameter("pageNum");
		
		if(pageNum ==null){
			pageNum ="1";
		}
		int requestPage = Integer.parseInt(pageNum);
	
			
		ListModel listModel = service.listJoinedMemberService(request, requestPage);		
		//List<MemberDTO> list = service.listJoinedMemberService(search);
		
		request.setAttribute("listModel", listModel);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("list_joinedMember.jsp");
		
		return forward;
	}

}
