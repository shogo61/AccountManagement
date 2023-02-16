<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Account" %>
<%
// セッションスコープからインスタンスを取得
Account loginUser = (Account) session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>利用者情報変更結果画面</title>
</head>
<body>
<h1>登録情報変更完了</h1>
<p>以下の内容に変更が完了しました。</p>
<table border="">
	<tr>
		<th>パスワード</th>
		<td><%= loginUser.getPass() %></td>
	</tr>
	<tr>
		<th>名前</th>
		<td><%= loginUser.getName() %></td>
	</tr>
	<tr>
		<th>生年月日</th>
		<td><%= loginUser.getBirth() %></td>
	</tr>
	<tr>
		<th>メールアドレス</th>
		<td><%= loginUser.getMail() %></td>
	</tr>
	<tr>
		<th>電話番号</th>
		<td><%= loginUser.getTel() %></td>
	</tr>
</table>
<br><a href="/accountManagement/TopMoveServlet">トップへ</a>
</body>
</html>