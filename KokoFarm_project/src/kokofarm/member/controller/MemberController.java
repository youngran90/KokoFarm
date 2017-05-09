package kokofarm.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kokofarm.member.action.Action;
import kokofarm.member.action.ActionForward;
import kokofarm.member.action.idcheckAction;
import kokofarm.member.action.insertFormAction;
import kokofarm.member.action.joinAction;
import kokofarm.member.action.joinMemberAction;
import kokofarm.member.action.list_joinedMemberAction;
import kokofarm.member.action.loginCheckAction1;
import kokofarm.member.action.logincheckAction;
import kokofarm.member.action.logoutAction;
import kokofarm.member.action.mainAction;

@WebServlet("*.member" )
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemberController() {
		super();

	}
	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();

		int last = requestURI.lastIndexOf("/");
		String command = requestURI.substring(last + 1, requestURI.length());

		System.out.println(requestURI);
		System.out.println(command);

		ActionForward forward = null;
		Action action = null;

		if (command.indexOf("insertMember.member") !=-1) {
			action = new insertFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}else if (command.indexOf("idcheck.member") !=-1){
			action = new idcheckAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}else if(requestURI.indexOf("loginCheck.member") !=-1){
				action = new logincheckAction();
			try {
				forward = action.execute(request, response);
								
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if(requestURI.indexOf("loginCheck1.member") != -1){
			action = new loginCheckAction1();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(requestURI.indexOf("listMember.member") !=-1){
			action = new list_joinedMemberAction();
			try{
				forward = action.execute(request, response);
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}else if(requestURI.indexOf("joinMember.member") !=-1){
			action = new joinMemberAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();						
			}
		}else if(requestURI.indexOf("join.member") !=-1){
			action = new joinAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if(requestURI.indexOf("mainAction.member") !=-1){
			action = new mainAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(requestURI.indexOf("logout.member") !=-1){
			action = new logoutAction();
			try{
				forward = action.execute(request, response);
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if(requestURI.indexOf("main.member") !=-1){
			action = new mainAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		

		if (forward != null) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
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
