package kokofarm.product.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kokofarm.product.action.Action;
import kokofarm.product.action.ActionForward;
import kokofarm.product.action.InsertProductAction;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("*.product")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductController() {
		super();
	}

	public void doProcess(HttpServletResponse response, HttpServletRequest request)
			throws ServletException, IOException {
		System.out.println("insert!!");
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length() + 1);
		int le = command.indexOf("/");

		String jspname = command.substring(le + 1, command.length());
		System.out.println(jspname);
		
		ActionForward forward = null;
		Action action = null;

		if (jspname.equals("Product.product")) {
			// insertForm.jsp로 이동하기 위한 목적
			action = new InsertProductAction();

			try {
				forward = action.execute(request, response);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(response, request);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(response, request);
	}

}
