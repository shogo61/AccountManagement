package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Account;
import model.InfoChangeLogic;
import model.UserManagmentLogic;

@WebServlet("/UserManagementServlet")
public class UserManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		//インスタンス化
		UserManagmentLogic user = new UserManagmentLogic();
		ArrayList<Account>  accountList  = user.execute();


		//アカウントリストをセッションに格納する
		session.setAttribute("accountList", accountList);

		//管理画面へフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userManagement/userManagement.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

        //画面の遷移元を判断する
        int pg = (int) session.getAttribute("pg");
        switch(pg) {

        	case 0:	//管理画面
	    		//リクエストパラメーターを取得
	    		request.setCharacterEncoding("UTF-8");
	    		String id = request.getParameter("id");
	    		String name = request.getParameter("name");
	    		String pass = request.getParameter("pass");
	    		String birth = request.getParameter("birth");
	    		String mail = request.getParameter("mail");
	    		String tel = request.getParameter("tel");
	    		String role = request.getParameter("role");
	    		String active = request.getParameter("active");
	    		String check = request.getParameter("check");
	    		
	    		//インスタンス化
	            Account managementAccount = new Account(id, pass, name, birth, mail, tel, role, active);
	            
	    		//セッションスコープに保存
	            session.setAttribute("managementAccount", managementAccount);
	            
	            if (check.equals("状態")) {
	            	//削除確認画面へフォワード
	        		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userManagement/delete/deleteCheck.jsp");
	        		dispatcher.forward(request, response);
	            } else {
	            	//変更画面へフォワード
	        		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userManagement/edit/edit.jsp");
	        		dispatcher.forward(request, response);
	            }
            break;
            
	        case 1:	//削除確認画面
	    		//アクティブを非アクティブ化する
	        	active = "0";
	        	
	    		//インスタンス化
	        	managementAccount = (Account) session.getAttribute("managementAccount");
                //アカウント状態の切り替え
                String chkActive = managementAccount.getActive();
                if(chkActive.equals("active")){
                    chkActive = "inactive";
                }else {
                    chkActive = "active";
                }
	            Account AccountDelete = new Account(managementAccount.getId(), managementAccount.getPass(), managementAccount.getName(), 
	            		managementAccount.getBirth(), managementAccount.getMail(), managementAccount.getTel(), managementAccount.getRole(), chkActive);
	            
	    		//セッションスコープに保存
	            session.setAttribute("AccountDelete", AccountDelete);
	            
	        	//更新する
	        	InfoChangeLogic changeLogic = new InfoChangeLogic();
	        	changeLogic.execute(AccountDelete);
	        	
	    		//削除完了画面へフォワード
	    		RequestDispatcher dispatcher1 = request.getRequestDispatcher("/WEB-INF/jsp/userManagement/delete/deleteResult.jsp");
	    		dispatcher1.forward(request, response);
            break;

	        case 2:	//変更画面
	    		//リクエストパラメーターを取得
	    		String nameN = request.getParameter("name");
	    		String birthN = request.getParameter("birth");
	    		String mailN = request.getParameter("mail");
	    		String telN = request.getParameter("tel");

	        	managementAccount = (Account) session.getAttribute("managementAccount");
	    		if (nameN != null && nameN.equals("")) {
	    			nameN = managementAccount.getName();
	    		}
	    		if (birthN != null && birthN.equals("")) {
	    			birthN = managementAccount.getBirth();
	    		}
	    		if (mailN != null && mailN.equals("")) {
	    			mailN = managementAccount.getMail();
	    		}
	    		if (telN != null && telN.equals("")) {
	    			telN = managementAccount.getTel();
	    		}
	    		
	    		//インスタンス化
	            Account editAccount = new Account(managementAccount.getId(), managementAccount.getPass(), nameN, 
	            		birthN, mailN, telN, managementAccount.getRole(), managementAccount.getActive());
	            
	    		//セッションスコープに保存
	            session.setAttribute("editAccount", editAccount);
	            
	    		//変更確認画面へフォワード
	    		RequestDispatcher dispatcher2 = request.getRequestDispatcher("/WEB-INF/jsp/userManagement/edit/editCheck.jsp");
	    		dispatcher2.forward(request, response);
            break;
            
	        case 3:	//変更確認画面
	        	//更新する
	        	editAccount = (Account) session.getAttribute("editAccount");
	        	changeLogic = new InfoChangeLogic();
	        	changeLogic.execute(editAccount);
	        	
	    		//変更完了画面へフォワードする
	    		RequestDispatcher dispatcher3 = request.getRequestDispatcher("/WEB-INF/jsp/userManagement/edit/editResult.jsp");
	    		dispatcher3.forward(request, response);
    		break;
    		
	        case 4:	//削除完了画面/変更完了画面
	        	//セッションを破棄する
	        	session.removeAttribute("managementAccount");
	        	session.removeAttribute("AccountDelete");
	        	session.removeAttribute("editAccount");
	        	
	    		//管理画面へフォワード
	    		RequestDispatcher dispatcher4 = request.getRequestDispatcher("/WEB-INF/jsp/userManagement/userManagement.jsp");
	    		dispatcher4.forward(request, response);
            break;
        }
	}
}