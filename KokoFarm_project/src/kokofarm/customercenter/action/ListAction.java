package kokofarm.customercenter.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kokofarm.customercenter.model.Board;
import kokofarm.customercenter.model.BoardDao;
import kokofarm.customercenter.model.Search;

public class ListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardDao dao = BoardDao.getInstance();
		
		Search search = new Search();
		search.setArea(request.getParameterValues("area"));
		search.setSearchKey("%"+request.getParameter("searchKey")+"%");
		List<Board> list = dao.listBoard(search);
		request.setAttribute("list", list);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/list.jsp");
		
		return forward;
	}

}
