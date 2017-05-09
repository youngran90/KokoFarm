package kokofarm.register.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kokofarm.register.action.ActionForward;

public interface Action {
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response)
	throws Exception;
}
