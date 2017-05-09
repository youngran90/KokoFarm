package kokofarm.customercenter.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kokofarm.customercenter.domain.BoardDTO;
import kokofarm.customercenter.domain.ListModel;
import kokofarm.customercenter.domain.SearchCustomer;
import kokofarm.customercenter.persistence.BoardDao;

public class BoardService {
	private static BoardService service = new BoardService();
	private static BoardDao dao;
	private static final int PAGE_SIZE = 4;	//페이지 당 글갯수(한페이지에 보이게 하는 글 갯수)
	
	public static BoardService getInstance(){
		dao = BoardDao.getInstance();
		return service;
	}
	
/*	
	//답변글일때 (기존)
	public int insertBoardService(HttpServletRequest request)throws Exception{
		BoardDTO boarddto = new BoardDTO();
		
		int re = dao.insertBoard(boarddto);		
		return re;
	}
	*/

	
	public int insertBoardService(BoardDTO boarddto) throws Exception {

		
		if(boarddto.getCustomer_no()!=0){				//답변글일 때 (수정한 것)
			HashMap<String, Integer>map = 
					new HashMap<String,Integer>();
			map.put("customer_step", boarddto.getCustomer_step());
			map.put("customer_ref", boarddto.getCustomer_ref());
			
			dao.updateStep(map);		//부모글 밑에 있는 것, 한칸씩 미룸
			boarddto.setCustomer_no(dao.selectcustomer_no()+1);
			boarddto.setCustomer_step(boarddto.getCustomer_step()+1); //부모 바로밑에 답글
			boarddto.setCustomer_level(boarddto.getCustomer_level()+1); //부모의 들여쓰기 +1			
		
		}else{			//원본글			//글 중에 가장 큰 번호 +1
			boarddto.setCustomer_no(dao.selectcustomer_no()+1); 	//새로운 no값
			boarddto.setCustomer_ref(dao.selectcustomer_no()+1); 	//자신의 그룹번호 = 자신의 글번호no
		}
		int re = dao.insertBoard(boarddto);
		return re;
	}
	

/*	
	//페이징 처리 전 list
	public List<BoardDTO>listBoardService(SearchCustomer searchCustomer) throws Exception{
		return dao.listBoard(searchCustomer);
	}*/
	
	
	public ListModel listBoardService(HttpServletRequest request, int requestPage) {	//ListAction에서 보낸 request객체 받음

		SearchCustomer searchCustomer = new SearchCustomer();
		HttpSession session = request.getSession();
		
		//session안에 search를 넣어 -> 다음페이지에도 검색된게 출력되도록
		//1. 기존에 검색된 내용 삭제
		if(request.getParameter("temp") != null){
			session.removeAttribute("searchCustomer");
		}
		
		//2. 검색시
		if(request.getParameter("area")!=null){
			searchCustomer.setArea(request.getParameterValues("area"));	//list.jsp의 area객체를 받고
			searchCustomer.setSearchKey("%" + request.getParameter("searchKey") + "%");	
			session.setAttribute("searchCustomer", searchCustomer);		//session에 search한 값 받고
		}else if((SearchCustomer)session.getAttribute("searchCustomer")!=null){		//session에 search한 내용 있으면
			searchCustomer = (SearchCustomer)session.getAttribute("searchCustomer");	//검색된 것 있으면 새로운 search를 session넣음
		}
		
		
		//페이지 당 글갯수, 총 글갯수, 총 페이지갯수 ,start_row, end_row
		int totalCount = dao.countBoard(searchCustomer);		//총 글갯수
		int tatalPageCount = totalCount/PAGE_SIZE;				//총 페이지 갯수
		if(totalCount%PAGE_SIZE > 0){									//나머지 있다면
			tatalPageCount++;
		}
		
		
		//현재페이지(requestPage)의해 시작(이전)페이지, 마지막(이후)페이지 정해짐
		int startPage = requestPage - (requestPage-1)%5;		//공식
		int endPage = startPage + 4;
		if(endPage > tatalPageCount){
			endPage = tatalPageCount;
		}
		
		
		//startRow : 시작하는 시점
		int startRow = (requestPage-1) * PAGE_SIZE;	//공식
		List<BoardDTO>list = dao.listBoard(startRow, searchCustomer);
		return new ListModel(list, requestPage, tatalPageCount, startPage, endPage);
		
		
		
		/*		
		SearchCustomer searchCustomer = new SearchCustomer();
		searchCustomer.setArea(request.getParameterValues("area"));
		searchCustomer.setSearchKey("%"+request.getParameter("searchKey")+"%");
//		List<BoardDTO> list = dao.listBoard(search);
		List<BoardDTO>list = service.listBoardService(searchCustomer);
		request.setAttribute("list", list);
	*/	
			
//		return dao.listBoard(searchCustomer);
	}
	
	//1개글 선택
	public BoardDTO selectBoardService(int customer_no){
		return dao.selectBoard(customer_no);
	}
	
	
	//조회수
	public int updatecustomer_hitcount(BoardDTO boarddto){
		return dao.updatecustomer_hitcount(boarddto);
	}
	
	
	public int updateBoardService(BoardDTO boarddto){
		return dao.updateBoard(boarddto);
	}
	
	
	public int countBoard(BoardDTO boardDTO){
		return dao.countBoard(boardDTO);
	}
	
}










