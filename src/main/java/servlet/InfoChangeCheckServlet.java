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
import model.InfoChangeLogic;

@WebServlet("/InfoChangeCheckServlet")
public class InfoChangeCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// HttpSessionインスタンスの取得
		HttpSession session = request.getSession();
		
		// セッションスコープからインスタンスを取得
		Account editLoginUser = (Account) session.getAttribute("editLoginUser");
		
		// 登録情報変更処理の実行
		InfoChangeLogic bo = new InfoChangeLogic();
		boolean result = bo.execute(editLoginUser);
		
		// 登録情報変更処理の成否によって処理を分岐
		if(result) {	// 登録情報変更成功時
			// 「editLoginUser」を「loginUser」として更新
			session.setAttribute("loginUser", editLoginUser);
			// フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/infoChange/infoChangeResult.jsp");
			dispatcher.forward(request, response);
		} else {	// 登録情報変更失敗時
			// フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/infoChange/infoChangeError.jsp");
			dispatcher.forward(request, response);
		}
	}
}
