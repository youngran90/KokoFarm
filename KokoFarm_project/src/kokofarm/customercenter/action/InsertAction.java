package kokofarm.customercenter.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kokofarm.customercenter.action.Action;
import kokofarm.customercenter.action.ActionForward;
import kokofarm.customercenter.model.Board;
import kokofarm.customercenter.model.BoardDao;

public class InsertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		BoardDao dao = BoardDao.getInstance();
		Board board = new Board();
		board.setTitle(request.getParameter("title"));
		board.setWriter(request.getParameter("writer"));
		board.setContents(request.getParameter("contents"));
		
		dao.insertBoard(board);
		
		ActionForward forward = new ActionForward();
		//요청해서 그 jsp로 갈 경우는 디스패쳐
		//요청에의해서 새로운 요청으로 갈 경우 redirect
		forward.setRedirect(true);
		forward.setPath("listAction.do");
		
		return forward;
	}

}
