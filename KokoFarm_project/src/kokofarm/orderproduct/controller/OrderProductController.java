package kokofarm.orderproduct.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kokofarm.orderproduct.action.ActionInsert;
import kokofarm.orderproduct.action.ActionList;
import kokofarm.orderproduct.action.ActionOrder;
import kokofarm.orderproduct.action.OrderProductAction;
import kokofarm.orderproduct.action.OrderProductActionFoward;


/**
 * Servlet implementation class OrderProductController
 */
@WebServlet("*.c")
public class OrderProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public OrderProductController() {
        super();
    }
    
    public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	String requstUrl = request.getRequestURI(); // /KokoFarm/Product.do
    	String contextPath = request.getContextPath(); // /KokoFarm
    	String command = requstUrl.substring(contextPath.length()+1); // Product.do
    	int le = command.indexOf("/");
		String path = command.substring(le + 1, command.length()); // insert.do
		
		System.out.println(requstUrl);
		System.out.println(contextPath);
		System.out.println(command);
		System.out.println(path);
    	
    	
    	OrderProductAction action = null;
    	OrderProductActionFoward forward = null;
    	
    	if(path.equals("insert.c")){
    		action = new ActionInsert();
    		try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}
    	else if(path.equals("list.c")){
    		action = new ActionList();
    		try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(path.equals("orderproduct.c")){
    		action = new ActionOrder();
    		try {
				forward = action.excute(request, response);
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
