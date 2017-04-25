package kokofarm.customercenter.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kokofarm.customercenter.model.Board;
import kokofarm.customercenter.model.BoardDao;

public class DetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String num = request.getParameter("seq"); 
	  	int seq = 1;
	  	if(num != null){
	  		seq = Integer.parseInt(num);
	  	}
	  	BoardDao dao = BoardDao.getInstance();
	  	Board board = dao.detailBoard(seq);
	    
	    request.setAttribute("board", board);
	    
	    ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/detail.jsp");
		
		return forward;
	}

}
