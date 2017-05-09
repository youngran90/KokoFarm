package kokofarm.customercenter.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kokofarm.customercenter.domain.BoardDTO;
import kokofarm.customercenter.persistence.BoardDao;

public class deleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
	  	BoardDao dao = BoardDao.getInstance();
	  	
		String num = request.getParameter("customer_no");
		int customer_no = Integer.parseInt(num);
		
     
        BoardDTO boarddto = dao.detailBoard(customer_no);
        dao.delete(boarddto);
	 
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("listAction.gogo");
		
		return forward;
	}

}
