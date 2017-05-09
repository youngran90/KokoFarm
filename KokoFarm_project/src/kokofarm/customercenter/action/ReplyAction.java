package kokofarm.customercenter.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdk.nashorn.internal.ir.RuntimeNode.Request;
import kokofarm.customercenter.action.Action;
import kokofarm.customercenter.action.ActionForward;
import kokofarm.customercenter.domain.BoardDTO;
import kokofarm.customercenter.service.BoardService;

public class ReplyAction implements Action {
	

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{		

		String no = request.getParameter("customer_no");		//답변글 쓰기 위해
		int customer_no = 0;
		int customer_ref = 0;
		int customer_step = 0;
		int customer_level = 0;	
		
		if(no != null){
			customer_no = Integer.parseInt(no);
		}
	
		BoardService service = BoardService.getInstance();
		BoardDTO boarddto = new BoardDTO();		
		service.selectBoardService(customer_no);		//부모 1개글선택

		//답변글일 때
		if(boarddto != null){
			customer_ref = boarddto.getCustomer_ref();		//부모 그룹번호
			customer_step = boarddto.getCustomer_step();	//그룹내 순서(내꺼는 부모+1)
			customer_level = boarddto.getCustomer_level();	//들여쓰기(내꺼는 부모+1)
		}		
		request.setAttribute("boarddto", boarddto);	
	
///////////////////////////////////////////////////////////////////		
/*	
		boarddto.setCustomer_title(request.getParameter("customer_title"));
		boarddto.setMember_id(request.getParameter("member_id"));
		boarddto.setCustomer_pwd(request.getParameter("customer_pwd"));
		boarddto.setCustomer_content(request.getParameter("customer_content"));
		boarddto.setCustomer_ref(customer_ref);	////여기부터 댓글~~ 값받기
		boarddto.setCustomer_step(customer_step);		
		boarddto.setCustomer_level(customer_level);			
	*/	

//이건 지금!!!!		
//		service.insertBoardService(boarddto);
		
/*		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		int re = service.insertBoardService(boarddto);	
		if(re>0){
			forward.setPath("listAction.gogo");
		}else{
			forward.setPath("insertAction.gogo");
		}
		
		*/
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/kokofarm_customercenter.view/reply_form.jsp");		
		
		
/*		이건 지금 주석한 것!!!!
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);		//요청에의해서 새로운 요청으로 갈 경우 redirect
		forward.setPath("listAction.gogo");
*/		
		
		
		return forward;
	}

}
