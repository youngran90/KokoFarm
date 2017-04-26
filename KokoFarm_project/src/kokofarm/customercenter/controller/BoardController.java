package kokofarm.customercenter.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kokofarm.customercenter.action.Action;
import kokofarm.customercenter.action.ActionForward;
import kokofarm.customercenter.action.DetailAction;
import kokofarm.customercenter.action.InsertAction;
import kokofarm.customercenter.action.InsertFormAction;
import kokofarm.customercenter.action.ListAction;
import kokofarm.customercenter.action.UpdateFormAction;
import kokofarm.customercenter.action.deleteAction;
import kokofarm.customercenter.action.updateAction;


@WebServlet("*.a")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BoardController() {
        super();
       
    }
    
    public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	//요청url식별
    	String requestURI = request.getRequestURI();
    	//System.out.println(requestURI);  /MVC_Project/insert.do
    	String contextPath = request.getContextPath();
    	String command = requestURI.substring(contextPath.length()+1);
       	//System.out.println(command);
    	
    	ActionForward forward = null;
    	Action action = null;
    	
    	
    	if(command.equals("insertForm.a")){
    		//insertForm.jsp로 이동하기 위한 목적
    		action = new InsertFormAction();
    		try {
    			forward = action.execute(request, response);
    			
			} catch (Exception e) {
				e.printStackTrace();
			}
    		
    		
    		
    	}else if(command.equals("insertAction.a")){
    		action = new InsertAction();
    		try {
				forward = action.execute(request, response);
						
			} catch (Exception e) {
					e.printStackTrace();
			}
    		
    	}else if(command.equals("listAction.a")){
    		action = new ListAction();
    		
    		try {
				forward = action.execute(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
    		
    	}else if(command.equals("DetailAction.a")){
    		action = new DetailAction();
    		try {
				forward = action.execute(request, response);
    			
			} catch (Exception e) {
				e.printStackTrace();
			}
    		
    	}else if (command.equals("UpdateFormAction.a")) {
			action = new UpdateFormAction();
			try {
				forward = action.execute(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			}else if(command.equals("updateAction.a")){
			   action = new updateAction();
			   
				try {
					forward = action.execute(request, response);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
		}else if(command.equals("deleteAction.a")){
			action = new deleteAction();
			
			try {
				forward = action.execute(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
    	
    	if(forward != null){
    		//action이 실행되었음
    		if(forward.isRedirect()){
    			//redirect 가 true일 경우 
    			response.sendRedirect(forward.getPath());
    		}else{
    			RequestDispatcher dispatcher = 
    					 request.getRequestDispatcher(forward.getPath());
    			 							dispatcher.forward(request, response);
    		}
    	}
    	
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   doProcess(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 doProcess(request, response);
		
	}

}
