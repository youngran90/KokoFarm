package kokofarm.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.RequestWrapper;

import kokofarm.member.action.Action;
import kokofarm.member.action.ActionForward;
import kokofarm.member.action.insertFormAction;

@WebServlet({"/MemberController","*.do"})
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public MemberController() {
        super();
       
    }
    
    public void doProcess(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
    	String requestURI = request.getRequestURI();
    	String contextPath = request.getContextPath();
    
    	
    	int last =  requestURI.lastIndexOf("/");
    	String command = requestURI.substring(last+1, requestURI.length());
    	
    	System.out.println(requestURI);
    	System.out.println(command);
    	
    	ActionForward forward = null;
    	Action action =null;
    	
    	if(command.equals("insertMember.do")){
    		action = new insertFormAction();
    		try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
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
