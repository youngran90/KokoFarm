package kokofarm.register.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kokofarm.register.model.RegDao;
import kokofarm.register.model.RegDto;

public class RegStart implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
	
		forward.setRedirect(false);
		forward.setPath("/reg_view/reg_form.jsp");
		return forward;
	}

}
