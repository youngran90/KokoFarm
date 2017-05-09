package kokofarm.customercenter.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kokofarm.customercenter.domain.BoardDTO;
import kokofarm.customercenter.persistence.BoardDao;
import kokofarm.customercenter.service.BoardService;

public class UpdateFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
	       String num = request.getParameter("customer_no");
			int customer_no = Integer.parseInt(num);
		
	//수정한거		
			BoardService service = BoardService.getInstance();
			BoardDTO boarddto = service.selectBoardService(customer_no);
			
			
	//이전꺼 		
	 //      BoardDao dao = BoardDao.getInstance();	
	 //       BoardDTO boarddto = dao.detailBoard(customer_no);
	        request.setAttribute("boarddto", boarddto);
	        
	        ActionForward forward = new ActionForward();
	        forward.setRedirect(false);
	        forward.setPath("/kokofarm_customercenter.view/updateForm.jsp");
	       
		return forward;
	}

}
