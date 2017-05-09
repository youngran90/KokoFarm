package kokofarm.Inquiry.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kokofarm.Inquiry.action.Action;
import kokofarm.Inquiry.action.ActionForward;
import kokofarm.Inquiry.action.DetailInquiryAction;
import kokofarm.Inquiry.action.InsertInquiryAction;
import kokofarm.Inquiry.action.InsertInquiryReplyAction;
import kokofarm.Inquiry.action.ListInquiryAction;
import kokofarm.Inquiry.action.doInquiryAction;


@WebServlet("*.Inquiry")
public class InquiryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public InquiryController() {
        super();
    }
    
    public void doProcess(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
    	request.setCharacterEncoding("utf-8");
    	String requestURI = request.getRequestURI();
		int index = requestURI.lastIndexOf("/");
		String path = requestURI.substring(index+1, requestURI.length());

		ActionForward forward = null;
		Action action = null;
		
		if (path.equals("InsertInquiryAction.Inquiry")) {
			System.out.println("----------insert!!");
			action = new InsertInquiryAction();

			try {
			forward = action.execute(request, response);

			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if(path.equals("doInquiry.Inquiry")){
			System.out.println("doInquiry.Inquiry!!");
			
			action = new doInquiryAction();

			try {
			forward = action.execute(request, response);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(path.equals("ListInquiryAction.Inquiry")){
			System.out.println("-----------------listInquiry");
			action = new ListInquiryAction();
			
			try {
				forward = action.execute(request, response);

				} catch (Exception e) {
					e.printStackTrace();
				}
		}else if(path.equals("detailInquiry.Inquiry")){
			System.out.println("-----------------detailInquiry");
			action = new DetailInquiryAction();
			
			try {
				forward = action.execute(request, response);

				} catch (Exception e) {
					e.printStackTrace();
				}
			
		}else if(path.equals("InsertInquiryReply.Inquiry")){
			System.out.println("-----------------InsertInquiryReply");
				action = new InsertInquiryReplyAction();
			
			try {
				forward = action.execute(request, response);

				} catch (Exception e) {
					e.printStackTrace();
				}
		}
		
		  if (forward != null) {
		         if (forward.isRdirect()) {
		            response.sendRedirect(forward.getPath());
		         } else {
		            RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
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
