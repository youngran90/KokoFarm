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
@WebServlet("*.do")
public class OrderProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public OrderProductController() {
        super();
    }
    
    public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	String requstUrl = request.getRequestURI(); // /KokoFarm/Product.do
    	String contextPath = request.getContextPath(); // /KokoFarm
    	String command = requstUrl.substring(contextPath.length()+1); // Product.do
    	
    	OrderProductAction action = null;
    	OrderProductActionFoward forward = null;
    	
    	if(command.equals("insert.do")){
    		action = new ActionInsert();
    		try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}
    	else if(command.equals("list.do")){
    		action = new ActionList();
    		try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("orderproduct.do")){
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
