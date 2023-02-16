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

@WebServlet("/InfoChangeServlet")
public class InfoChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		// 「infoChange.jsp」にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/infoChange/infoChange.jsp");
		dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータを取得
		request.setCharacterEncoding("UTF-8");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		String birth = request.getParameter("birth");
		String mail = request.getParameter("mail");
		String tel = request.getParameter("tel");
		
		// セッションスコープから「loginUser」を取得
		HttpSession session = request.getSession();
		Account loginUser = (Account) session.getAttribute("loginUser");
		if (pass != null && pass.equals("")) {
			pass = loginUser.getPass();
		}
		if (name != null && name.equals("")) {
			name = loginUser.getName();
		}
		if (birth != null && birth.equals("")) {
			birth = loginUser.getBirth();
		}
		if (mail != null && mail.equals("")) {
			mail = loginUser.getMail();
		}
		if (tel != null && tel.equals("")) {
			tel = loginUser.getTel();
		}
		String id = loginUser.getId();		
		String role = loginUser.getRole();
		String active = loginUser.getActive();
		
		Account editLoginUser = new Account(id, pass, name, birth, mail, tel, role, active);
		
		// セッションスコープに「editLoginUser」を保存
		session.setAttribute("editLoginUser", editLoginUser);
		
		// フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/infoChange/infoChangeCheck.jsp");
		dispatcher.forward(request, response);
	}
}
