<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Account" %>
<%
// セッションスコープからインスタンスを取得
Account editLoginUser = (Account) session.getAttribute("editLoginUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>利用者情報変更確認画面</title>
</head>
<body>
<h1>登録情報変更確認</h1>
<br>
<p>以下の内容に変更します。</p>
<table border="">
	<tr>
		<th>パスワード</th>
		<td><%= editLoginUser.getPass() %></td>
	</tr>
	<tr>
		<th>名前</th>
		<td><%= editLoginUser.getName() %></td>
	</tr>
	<tr>
		<th>生年月日</th>
		<td><%= editLoginUser.getBirth() %></td>
	</tr>
	<tr>
		<th>メールアドレス</th>
		<td><%= editLoginUser.getMail() %></td>
	</tr>
	<tr>
		<th>電話番号</th>
		<td><%= editLoginUser.getTel() %></td>
	</tr>
</table><br>
<form action="/accountManagement/InfoChangeCheckServlet" method="post">
	<input type="submit" value="変更確定"><br><br>
	<input type="button" value="入力に戻る" onClick="history.back()">
</form>
</body>
</html>