package kokofarm.customercenter.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kokofarm.customercenter.domain.BoardDTO;
import kokofarm.customercenter.persistence.BoardDao;
import kokofarm.customercenter.service.BoardService;

public class updateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		request.setCharacterEncoding("utf-8");
		String num = request.getParameter("customer_no");
		int customer_no = Integer.parseInt(num);
		
		
		
		//오늘 새로 수정한거
		BoardService service = BoardService.getInstance();
//		BoardDTO boarddto = service.selectBoardService(customer_no);
		
	//원래 줄	
	//	BoardDao dao =BoardDao.getInstance();		
	    BoardDTO boarddto = new BoardDTO();		/////
		
		boarddto.setCustomer_no(customer_no);	
		boarddto.setCustomer_title(request.getParameter("customer_title"));
		boarddto.setMember_id(request.getParameter("member_id"));
		boarddto.setCustomer_content(request.getParameter("customer_content"));

/////추가할거
//		BoardDTO boarddto = service.selectBoardService(customer_no);
///////////////
		
		service.updateBoardService(boarddto);
//	   dao.updateBoard(boarddto);
	
//		request.setAttribute("boarddto", boarddto);
		
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("listAction.gogo");

		return forward;
	}

}
