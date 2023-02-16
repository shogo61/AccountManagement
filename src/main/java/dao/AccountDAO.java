package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import model.Account;
import model.Login;

public class AccountDAO {
	private final static String JDBC_URL = "";
	private final static String DB_USER = "";
	private final static String DB_PASS = "";

    public Account findByLogin(Login login){
		//インスタンスを初期化
    	Account account = null;

		//データベースに接続
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			//SELECT文を準備
        	String sql = "SELECT ID, PASS, NAME, BIRTH, MAIL, TEL, ROLE, ACTIVE FROM ACCOUNT WHERE ID = ? AND PASS = ? AND ACTIVE = 'active'";
        	PreparedStatement pStmt = conn.prepareStatement(sql);

			//IDとPASSをSELECT文にセット
        	pStmt.setString(1, login.getId());
        	pStmt.setString(2, login.getPass());

			//SELECT文の検索結果を取得
        	ResultSet rs = pStmt.executeQuery();

        	if (rs.next()) {
				//検索結果のレコードを表示
        		String id = rs.getString("ID");
        		String pass = rs.getString("PASS");
        		String name = rs.getString("NAME");
        		Date birthDate = rs.getDate("BIRTH");
        		String mail = rs.getString("MAIL");
        		String tel = rs.getString("TEL");
        		String role = rs.getString("ROLE");
        		String active = rs.getString("ACTIVE");

				//String型に変換
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						String birth = dateFormat.format(birthDate);
//						String role = String.valueOf(roleInt);
//						String active = String.valueOf(activeInt);

				//インスタンスに格納
        		account = new Account(id, pass, name, birth, mail, tel, role, active);
        	}
        } catch (SQLException e){
        	e.printStackTrace();
        	return null;
        }
        return account;
    }

    public ArrayList<Account> findAll() {
		//ArrayListインスタンスを作成
    	ArrayList<Account>  accountList = new ArrayList<>();

		//データベースに接続
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			//SELECT文を準備
        	String sql = "SELECT * FROM ACCOUNT";
        	PreparedStatement pStmt = conn.prepareStatement(sql);

			//SELECT文の検索結果を取得
        	ResultSet rs = pStmt.executeQuery();

        	while (rs.next()) {
				//検索結果のレコードを取得
        		String id = rs.getString("ID");
        		String pass = rs.getString("PASS");
        		String name = rs.getString("NAME");
        		Date birthDate = rs.getDate("BIRTH");
        		String mail = rs.getString("MAIL");
        		String tel = rs.getString("TEL");
        		String role = rs.getString("ROLE");
        		String active = rs.getString("ACTIVE");


				//String型に変換
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String birth = dateFormat.format(birthDate);
//				String role = String.valueOf(roleInt);
//				String active = String.valueOf(activeInt);

				//Accountインスタンスに格納し、ArrayListインスタンスに設定
        		Account account = new Account(id, pass, name, birth, mail, tel, role, active);
        		accountList.add(account);
        	}
        } catch (SQLException e){
        	e.printStackTrace();
        	return null;
        }

		return accountList;
    }

	public boolean insert(Account account) {
		//データベースへ接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			//INSERT文を準備
			String sql = "INSERT INTO ACCOUNT(ID, PASS, NAME, BIRTH, MAIL, TEL, ROLE, ACTIVE) VALUES (?,?,?,?,?,?,?,'active')";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//INSERT文の中の「?」に使用する値をセットし、SQLを組み立て
			pStmt.setString(1, account.getId());
			pStmt.setString(2, account.getPass());
			pStmt.setString(3, account.getName());
//			String temp = account.getBirth(); //一時変数に格納
//			String strA = temp.substring(0, 4); //年を切り出し
//			String strB = temp.substring(4, 6); //月の切り出し
//			String strC = temp.substring(6, 8); //日の切り出し
//			temp = strA + "-" + strB + "-" + strC; //それぞれの間に"-"を置き結合
			Date sBirth = Date.valueOf(account.getBirth()); //String型からDate型へ
			pStmt.setDate(4, sBirth);
			pStmt.setString(5, account.getMail());
			pStmt.setString(6, account.getTel());
			pStmt.setString(7, account.getRole());

			//INSERT文を実行し、実行結果をresultに格納
			int result = pStmt.executeUpdate();
			System.out.println(result);

			//成功すると1が戻るので、1ではない時には失敗
			if(result != 1) {
				return false;
			}
		} catch (SQLException e) {
			System.out.println("!! レコードは追加(INSERT)されませんでした。");
			e.printStackTrace();
			return false;
		}
		System.out.println("!! レコードは正常に追加(INSERT)されました。");
		return true;
	}
	public boolean update(Account account) {
		//データベースへ接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			//UPDATE文を準備
			String sql = "UPDATE ACCOUNT SET NAME = ?, Birth = ?, MAIL = ?, TEL = ?, ROLE = ?, PASS = ? WHERE ID = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//UPDATE文の中の「?」に使用する値をセットし、SQLを組み立て
			pStmt.setString(1, account.getName());
//			String temp = account.getBirth(); //一時変数に格納
//			String strA = temp.substring(0, 4); //年の切り出し
//			String strB = temp.substring(4, 6); //月の切り出し
//			String strC = temp.substring(6, 8); //日の切り出し
//			temp = strA + "-" + strB + "-" + strC; //それぞれの間に"-"を置き結合
			Date sBirth = Date.valueOf(account.getBirth()); //String型からDate型へ
			pStmt.setDate(2, sBirth);
			pStmt.setString(3, account.getMail());
			pStmt.setString(4, account.getTel());
			pStmt.setString(5, account.getRole());
			pStmt.setString(6, account.getPass());
			pStmt.setString(7, account.getId());

			//UPDATE文を実行し、実行結果をresultに格納
			int result = pStmt.executeUpdate();

			//成功すると1が戻るので、1ではない時には失敗
			if(result != 1) {
				return false;
			}
		} catch (SQLException e) {
			System.out.println("!! レコードは更新(UPDATE)されませんでした。");
			e.printStackTrace();
			return false;
		}
		System.out.println("!! レコードは正常に更新(UPDATE)されました。");
		return true;
	}
}