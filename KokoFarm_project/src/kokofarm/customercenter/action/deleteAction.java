package kokofarm.customercenter.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kokofarm.customercenter.model.Board;
import kokofarm.customercenter.model.BoardDao;

public class deleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
	  	BoardDao dao = BoardDao.getInstance();
	  	
		String num = request.getParameter("seq");
		int seq = Integer.parseInt(num);
		
     
        Board board = dao.detailBoard(seq);
        dao.delete(board);
	 
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("listAction.do");
		
		return forward;
	}

}
