package kokofarm.customercenter.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kokofarm.customercenter.domain.BoardDTO;
import kokofarm.customercenter.domain.ListModel;
import kokofarm.customercenter.domain.SearchCustomer;
import kokofarm.customercenter.persistence.BoardDao;
import kokofarm.customercenter.service.BoardService;

public class ListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		String member_id = (String)session.getAttribute("member_id");
		request.setAttribute("member_id", member_id);

		//****//
		request.setCharacterEncoding("utf-8");
		
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null){
			pageNum= "1";
		}
		
		int requestPage = Integer.parseInt(pageNum);	//요청한 페이지(현재페이지)
		
		BoardService service = BoardService.getInstance();
		ListModel listModel = service.listBoardService(request, requestPage);
		//request, requestPage객체 담아서 service로 보낸다
		
		
		request.setAttribute("listModel", listModel);
		//key값으로 listmodel넣고
		
		
		//****//
		
		
/*		
		SearchCustomer searchCustomer = new SearchCustomer();
		searchCustomer.setArea(request.getParameterValues("area"));
		searchCustomer.setSearchKey("%"+request.getParameter("searchKey")+"%");
//		List<BoardDTO> list = dao.listBoard(search);
		List<BoardDTO>list = service.listBoardService(searchCustomer);
		request.setAttribute("list", list);
	*/	
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/kokofarm_customercenter.view/list.jsp");
		return forward;
	}

}
