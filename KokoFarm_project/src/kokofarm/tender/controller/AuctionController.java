package kokofarm.tender.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kokofarm.tender.action.Action;
import kokofarm.tender.action.ActionForward;
import kokofarm.tender.action.TenderAction;
import kokofarm.tender.action.TenderFormAction;

@WebServlet("*.te")
public class AuctionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AuctionController() {
        super();
    }
    
    public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String requestURI = request.getRequestURI();
		//System.out.println(requestURI);
		String contextPath= request.getContextPath();
		String command = requestURI.substring(contextPath.length()+1);
		System.out.println(command);
		
		ActionForward forward =null;
		Action action =null;
		
		if(command.equals("tenderform.te")){
			action= new TenderFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if(command.equals("tenderAction.te")){
			action = new TenderAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(forward!=null){
			if(forward.isRedirect()){
				response.sendRedirect(forward.getPath());
			}else{
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

}
