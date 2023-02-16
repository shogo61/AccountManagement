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
<title>登録情報変更</title>
</head>
<body>
<h1>登録情報変更</h1>
<form action="/accountManagement/InfoChangeServlet" method="post">
<table border="">
	<tr>
		<th>パスワード:</th>
		<th><%= loginUser.getPass() %></th>
		<td><input type="text" name="pass"></td>
	</tr>
	<tr>
		<th>名前:</th>
		<th><%= loginUser.getName() %></th>
		<td><input type="text" name="name"></td>
	</tr>
	<tr>
		<th>生年月日:</th>
		<th><%= loginUser.getBirth() %></th>
		<td><input type="date" name="birth" ></td>
	</tr>
	<tr>
		<th>メールアドレス:</th>
		<th><%= loginUser.getMail() %></th>
		<td><input type="email" placeholder="info@sample.com" name="mail"></td>
	</tr>
	<tr>
		<th>電話番号:</th>
		<th><%= loginUser.getTel() %></th>
		<td><input type="tel" pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}" placeholder="090-1234-5678"  name="tel"></td>
	</tr>
</table><br>
<input type="submit" value="確認">
</form>
<br><br><a href="/accountManagement/TopMoveServlet">トップ</a>
</body>
</html>