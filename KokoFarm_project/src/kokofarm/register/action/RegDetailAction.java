package kokofarm.register.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import kokofarm.register.model.RegDao;
import kokofarm.register.model.RegDto;

public class RegDetailAction implements Action{
	
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		RegDao dao = RegDao.getInstance();
		List<RegDto> list = dao.regList();
		System.out.println(list);

		String auction_no = request.getParameter("auction_no");
		System.out.println(auction_no);
		
		RegDto dto = dao.regDetail(auction_no);
		HttpSession session=request.getSession();
		session.setAttribute("regDto", dto);
		//request.setAttribute("regDto", dto);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("tenderform.te");
		return forward;
	}
	
}
