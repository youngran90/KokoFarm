package kokofarm.customercenter.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/insert_form.jsp");
		//action forward 객체 안에 담음
		
		return forward;
	}

}
