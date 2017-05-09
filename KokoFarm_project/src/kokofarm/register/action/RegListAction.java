package kokofarm.register.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kokofarm.register.model.RegDao;
import kokofarm.register.model.RegDto;

public class RegListAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		RegDao dao = RegDao.getInstance();
		
		List<RegDto> list = dao.regList();
		request.setAttribute("regList", list);
		System.out.println(list);
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/reg_view/reg_list.jsp");
		
		return forward;
	}

}
