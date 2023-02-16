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
import model.UserRegiLogic;

/**
 * Servlet implementation class UserRegi
 */
@WebServlet("/UserRegiServlet")
public class UserRegiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//セッションスコープから情報を取得
		HttpSession session = request.getSession();
		Account account = (Account) session.getAttribute("regiUser");
		
		//登録処理
		UserRegiLogic userRegiLogic = new UserRegiLogic();
		boolean isUserRegi = userRegiLogic.execute(account);
		
		//登録後の流れ
		if(isUserRegi) {
			//再入力を促す(userRegi.jspにフォワード)
			String errormsg = "データべースに登録できました。";
			//リクエストスコープにメッセージを保存
			request.setAttribute("errormsg", errormsg);
			
			//userRegiResult.jspにフォワード
			RequestDispatcher dispatcher_2 = request.getRequestDispatcher("/WEB-INF/jsp/userRegi/userRegiResult.jsp");
			dispatcher_2.forward(request, response);
		} else { //登録できなかった場合
			//再入力を促す(userRegi.jspにフォワード)
			String errormsg = "データべースに登録できませんでした。お手数ですが再登録をお願いいたします。";
			//リクエストスコープにエラーメッセージを保存
			request.setAttribute("errormsg", errormsg);
			
			//前登録した情報をセッションスコープに保存、jspで再表示する
			session.setAttribute("regiUser", account);
			
			RequestDispatcher dispatcher_2 = request.getRequestDispatcher("/WEB-INF/jsp/userRegi/userRegi.jsp");
			dispatcher_2.forward(request, response);
		}
	}
}
