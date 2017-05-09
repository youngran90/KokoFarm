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
//import kokofarm.customercenter.action.InsertFormAction;
import kokofarm.customercenter.action.ListAction;
import kokofarm.customercenter.action.ReplyAction;
import kokofarm.customercenter.action.ReplyOkAction;
import kokofarm.customercenter.action.UpdateFormAction;
import kokofarm.customercenter.action.deleteAction;
import kokofarm.customercenter.action.updateAction;


@WebServlet("*.gogo")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BoardController() {
        super();
       
    }
    
    public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	
    	//request.setCharacterEncoding("EUC-KR");	
    	
    	//요청url식별
    	String requestURI = request.getRequestURI();	//전체경로
    //System.out.println(requestURI);  // KokoFaram_projectprac/kokofarm_customercenter.view/insertAction.gogo
    	
    	String contextPath = request.getContextPath();	//context경로
    	System.out.println(contextPath);	// KokoFaram_projectprac   	
       	
       	int last = requestURI.lastIndexOf("/");
       	String command = requestURI.substring(last + 1, requestURI.length());	//command경로
       	System.out.println(command);		// insertAction.gogo
       	
    	ActionForward forward = null;
    	Action action = null;
    	
    	
    	if(command.equals("insertAction.gogo")){
    		action = new InsertAction();
    		try {
				forward = action.execute(request, response);
						
			} catch (Exception e) {
					e.printStackTrace();
			}
    		
    	}
    	
    	else if(command.equals("replyAction.gogo")){
    		action = new ReplyAction();
    		try{
    			forward = action.execute(request, response);
    		}catch(Exception e){
    			e.printStackTrace();
    		}
    	}
    	
    	
    	else if(command.equals("replyokAction.gogo")){
    		action = new ReplyOkAction();
    		try{
    			forward = action.execute(request, response);
    		}catch(Exception e){
    			e.printStackTrace();
    		}
    	}
    	
    	
    	else if(command.equals("listAction.gogo")){
    		action = new ListAction(); 		
    		try {
				forward = action.execute(request, response);				
			} catch (Exception e) {
				e.printStackTrace();
			}    		
    		
    	}else if(command.equals("DetailAction.gogo")){
    		action = new DetailAction();
    		try {
				forward = action.execute(request, response);    			
			} catch (Exception e) {
				e.printStackTrace();
			}
    		
    	}else if (command.equals("UpdateFormAction.gogo")) {
			action = new UpdateFormAction();
			try {
				forward = action.execute(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			}else if(command.equals("updateAction.gogo")){
			   action = new updateAction();
			   
				try {
					forward = action.execute(request, response);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
		}else if(command.equals("deleteAction.gogo")){
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
