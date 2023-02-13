package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/WelcomeServlet")
public class WelcomeServlet extends HttpServlet{
//	private static final long seriialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException{
		RequestDispatcher dispatcher =
				request.getRequestDispatcher(
				"/WEB-INF/welcome.jsp");
		dispatcher.forward(request, response);
	}
}
