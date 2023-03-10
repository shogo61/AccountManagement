package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SignUpResult
 */
@WebServlet("/TopMoveServlet")
public class TopMoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//signUpUserインスタンスが存在していたら破棄する
		HttpSession session = request.getSession();
		session.removeAttribute("signUpUser");
		
		//top.jspにフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/top/top.jsp");
		dispatcher.forward(request, response);
	}
}