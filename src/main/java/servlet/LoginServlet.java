package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Account;
import model.Login;
import model.LoginLogic;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{
//	private static final long seriialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		RequestDispatcher dispatcher =
				request.getRequestDispatcher(
				"/WEB-INF/jsp/login/login.jsp");
		dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
	
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		
		//ログイン処理の実行
		Login login = new Login(id, pass);
		LoginLogic bo = new LoginLogic();
		Account account = bo.execute(login);
		
		//ログイン処理の成否によって処理を分岐
		if(account != null) {
			//セッションスコープにユーザーIDを保存
			HttpSession session = request.getSession();
			session.setAttribute("account", account);
			
			//フォワード
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("WEB-INF/jsp/login/loginOK.jsp");
			dispatcher.forward(request, response);
		}else {
			//エラーメッセージをリクエストスコープに保存
			request.setAttribute("loginErrorMessage", "入力内容が間違っているか、アカウントがありません。");
			
			//リダイレクト
			//response.sendRedirect("/login/LoginServlet");
			
			//フォワード
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("WEB-INF/jsp/login/login.jsp");
			dispatcher.forward(request, response);
		}
	}
}
