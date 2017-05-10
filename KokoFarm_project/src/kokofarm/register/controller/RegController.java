package kokofarm.register.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kokofarm.register.action.Action;
import kokofarm.register.action.ActionForward;
import kokofarm.register.action.RegAction;
import kokofarm.register.action.RegDetailAction;
import kokofarm.register.action.RegListAction;
import kokofarm.register.action.RegStart;

@WebServlet("*.reg")
public class RegController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public RegController() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void doProcess(HttpServletRequest request, HttpServletResponse response)
    	throws ServletException, IOException {
    	String requestURI = request.getRequestURI();
    	String contextPath = request.getContextPath();
    	String command = requestURI.substring(contextPath.length()+1);
    	System.out.println(command);
    	int le = command.indexOf("/");
    	String path = command.substring(le+1, command.length());
    	System.out.println(path);
    	ActionForward forward = null;
    	Action action = null;
    	
    	if(requestURI.indexOf("start.reg")!=-1){
    		System.out.println(command);
    		System.out.println(path);
    		action = new RegStart();
    		try{
    		forward = action.execute(request, response);
    		} catch (Exception e){
    			e.printStackTrace();
    		}
    	}else if(requestURI.indexOf("reg_form.reg")!=-1){
    		action = new RegAction();
    		try {
			forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(requestURI.indexOf("reg_list.reg")!=-1){
    		System.out.println("넘어오십시요,,,");
    		action = new RegListAction();
    		try {
    		forward = action.execute(request, response);
    		} catch (Exception e){
    			e.printStackTrace();
    		}
    	}else if(requestURI.indexOf("reg_detail.reg")!=-1){
    		System.out.println("제발 넘어오세여,,");
    		action = new RegDetailAction();
    		try {
    		forward = action.execute(request, response);
    		} catch (Exception e){
    			e.printStackTrace();
    		}
    	}
    		
    	
    	
    	if(forward != null){
    		if(forward.isRedirect()){
    			response.sendRedirect(forward.getPath());
    		}else{
    			RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
    			dispatcher.forward(request, response);
    		}
    	}
    }
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doProcess(request, response);
	}

}
