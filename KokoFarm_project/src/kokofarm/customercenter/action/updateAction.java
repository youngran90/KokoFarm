package kokofarm.customercenter.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kokofarm.customercenter.model.Board;
import kokofarm.customercenter.model.BoardDao;

public class updateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		String num = request.getParameter("seq");
		int seq = Integer.parseInt(num);
		
		BoardDao dao =BoardDao.getInstance();
		
		Board board = new Board();
		
		board.setSeq(seq);	
		board.setTitle(request.getParameter("title"));
		board.setContents(request.getParameter("contents"));

		
	   dao.updateBoard(board);
	
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("listAction.do");

		return forward;
	}

}
