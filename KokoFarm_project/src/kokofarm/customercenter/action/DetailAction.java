package kokofarm.customercenter.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kokofarm.customercenter.domain.BoardDTO;
import kokofarm.customercenter.persistence.BoardDao;
import kokofarm.customercenter.service.BoardService;

public class DetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		String num = request.getParameter("customer_no"); 
	  	int customer_no = 1;
	  	if(num != null){
	  		customer_no = Integer.parseInt(num);
	  	}
	  	BoardService service = BoardService.getInstance();
	  	BoardDTO boarddto = service.selectBoardService(customer_no);
	  	service.updatecustomer_hitcount(boarddto);	    
	    request.setAttribute("boarddto", boarddto);
	   
	    
	    ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/kokofarm_customercenter.view/detail.jsp");
		
		return forward;
		
		
		
		
		
	}

}
