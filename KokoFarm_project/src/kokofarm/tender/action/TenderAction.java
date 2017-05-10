package kokofarm.tender.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kokofarm.tender.domain.TenderDto;
import kokofarm.tender.persistence.AuctionDao;

public class TenderAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		AuctionDao dao= AuctionDao.getInstance();
		TenderDto tender =new TenderDto();
		int tender_price=Integer.parseInt(request.getParameter("tender_price"));
		int current_price = Integer.parseInt(request.getParameter("current_price"));
		String auction_no=request.getParameter("auction_no");
		int auction_up = dao.selectPriceUp(auction_no);
		int auction_down = dao.selectPriceDown(auction_no);
		
		request.setAttribute("tender_price", tender_price);
		
		HttpSession session = request.getSession();
		String member_id= (String)session.getAttribute("member_id");
		
		if(tender_price <= auction_down || tender_price <= current_price){
			System.out.println("가격을 다시 입력하세요.");
			
			ActionForward forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("tenderform.te");
			return forward;
			
		}else{
			tender.setTender_price(tender_price);
			tender.setMember_id(member_id);
			/*tender.setMember_id("koskos");*/
			tender.setAuction_no(auction_no);
	
			dao.insertTender(tender);
			
			int visitingTime=Integer.parseInt(request.getParameter("visitingTime"));
			System.out.println("방문시간:" +visitingTime);
			
			if(visitingTime==0){
				if(current_price!=0){
					tender= dao.selectSuccess(auction_no, current_price);
					System.out.println(tender);
					dao.updateTender(tender_price);
				}else{ 
					dao.updateAuctionResult(auction_no);
					
				}
			}else{
				if(auction_up==tender_price){
					System.out.println("현재가격:"+ current_price);
					System.out.println("입찰가격:"+ tender_price);
					tender= dao.selectSuccess(auction_no, tender_price);
					System.out.println(tender);
					dao.updateTender(tender_price);
				}
			}
			
			request.setAttribute("tender", tender);
			
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/kokofarm.tender.view/tender_finish.jsp");
		return forward;
		}
	}

}
