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

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/SignUpCheckServlet")
public class SignUpCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//signUp.jspにフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signUp/signUp.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//エラー表示の確認フラグ
		boolean ch = true;
		String errormsg = "";
		final String fActive = "active";
		
		//signUp.jspに入力された値を取得
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		String birth = request.getParameter("birth");
		System.out.println(birth);
		String mail = request.getParameter("mail");
		String tel = request.getParameter("tel");
		String role = "user"; //signUpCheckはすべてuser
		String active = fActive; //最初は必ずアクティブ状態
		
		//Account.javaに設定
		Account account = new Account(id, pass, name, birth, mail, tel, role, active);
		
		//入力値チェック
		//細かいチェックは今後詰める
		if(account.getId() == null && account.getId().length() == 0) {
			errormsg += "IDが入力されていません。";
			ch = false;
		}
		if(account.getPass() == null && account.getPass().length() == 0) {
			errormsg += "パスワードが入力されていません。";
			ch = false;
		} else if(account.getPass().length() <= 8 && account.getPass().length() >= 20) {
			errormsg += "8文字以上20文字以下のパスワードを入力してください。";
			ch = false;
		}
		if(account.getName() == null && account.getName().length() == 0) {
			errormsg += "名前が入力されていません。";
			ch = false;
		}
		if(account.getBirth() == null && ((CharSequence) account.getBirth()).length() == 0) {
			errormsg += "生年月日が入力されていません。";
			ch = false;
		}
		if(account.getMail() == null && account.getMail().length() == 0) {
			errormsg += "メールアドレスが入力されていません。";
			ch = false;
		} else if(!(account.getMail().contains("@"))) { //Stringの中に@が含まれているか確認
			errormsg += "有効なメールアドレスを入力してください。";
			ch = false;
		}
		if(account.getTel() == null && account.getTel().length() == 0) {
			errormsg += "携帯電話番号が入力されていません。";
			ch = false;
		} else if(account.getTel().length() >= 20) {
			errormsg += "携帯電話番号の桁数が多いです。再入力してください。";
			ch = false;
		}//桁数少ない場合のエラー文
		
		//登録する情報をセッションスコープに保存
		HttpSession session = request.getSession();
		session.setAttribute("signUpUser", account);
		
		if(ch) {
			//signUpCheck.jspにフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signUp/signUpCheck.jsp");
			dispatcher.forward(request, response);
		} else if(!ch) { //入力内容に不備がある場合は再入力してもらう
			//リクエストスコープにエラーメッセージを保存
			request.setAttribute("errormsg", errormsg);
			
			//signUp.jspにフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signUp/signUp.jsp");
			dispatcher.forward(request, response);
		}
	}
}
