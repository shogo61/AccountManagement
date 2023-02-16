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
import model.SignUpLogic;

/**
 * Servlet implementation class SignUpResult
 */
@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//セッションスコープから情報を取得
		HttpSession session = request.getSession();
		Account account = (Account) session.getAttribute("signUpUser");
		
		//登録処理
		SignUpLogic signUpLogic = new SignUpLogic();
		boolean isSignUp = true;
		isSignUp = signUpLogic.execute(account);
		
		//登録後の流れ
		if(isSignUp) {
			//signUpResult.jspにフォワード
			RequestDispatcher dispatcher_2 = request.getRequestDispatcher("/WEB-INF/jsp/signUp/signUpResult.jsp");
			dispatcher_2.forward(request, response);
		} else { //登録できなかった場合
			//再入力を促す(signUp.jspにフォワード)
			String errormsg = "データべースに登録できませんでした。お手数ですが再登録をお願いいたします。";
			//リクエストスコープにエラーメッセージを保存
			request.setAttribute("errormsg", errormsg);
			
			//前登録した情報をセッションスコープに保存、jspで再表示する
			session.setAttribute("signUpUser", account);
			
			RequestDispatcher dispatcher_2 = request.getRequestDispatcher("/WEB-INF/jsp/signUp/signUp.jsp");
			dispatcher_2.forward(request, response);
		}
	}
}
