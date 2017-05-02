package kokofarm.cart.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kokofarm.cart.action.AcitonCartList;
import kokofarm.cart.action.ActionCartDelete;
import kokofarm.cart.action.ActionCartDeleteALL;
import kokofarm.cart.action.ActionCartListInsert;
import kokofarm.cart.action.ActionInsert;
import kokofarm.cart.action.ActionList;
import kokofarm.cart.action.ActionRoutingCart;
import kokofarm.cart.action.CartAction;
import kokofarm.cart.action.CartActionForward;

@WebServlet("*.cart")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CartController() {
        super();
    }
    
    public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	String requestURI = request.getRequestURI(); // /KokoFarm_project/kokofarm.cart.view/insert.cart
    	String contextPath = request.getContextPath(); // /KokoFarm_project
    	String command = requestURI.substring(contextPath.length()+1,requestURI.length()); // kokofarm.cart.view/insert.cart
    	int le = command.indexOf("/");
    	String path = command.substring(le+1,command.length()); // insert.cart
    	
    	CartActionForward forward = null;
    	CartAction action = null;
    	
    	if(path.equals("insert.cart")){
    		action = new ActionInsert();
    		try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(path.equals("ActionList.cart")){
    		action = new ActionList();
    		try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(path.equals("ActionCartListInsert.cart")){
    		action = new ActionCartListInsert();
    		try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(path.equals("AcitonCartList.cart")){
    		action = new AcitonCartList();
    		try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(path.equals("ActionCartDelete.cart")){
    		action = new ActionCartDelete();
    		try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(path.equals("ActionCartDeleteALL.cart")){
    		action = new ActionCartDeleteALL();
    		try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(path.equals("ActionRoutingCart.cart")){
    		action = new ActionRoutingCart();
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
