<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Account" %>
<%@ page import="servlet.UserManagementServlet" %>
<%
Account editAccount = (Account) session.getAttribute("editAccount");
int pg = 3;
session.setAttribute("pg", pg);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>編集内容確認</title>
</head>
<body>
	<h1>この内容で登録してもよろしいでしょうか？</h1>
	<table border="">
		<tr>
			<th>名前</th>
			<td><%= editAccount.getName() %></td>
		</tr>
		<tr>
			<th>生年月日</th>
			<td><%= editAccount.getBirth() %></td>
		</tr>
		<tr>
			<th>メールアドレス</th>
			<td><%= editAccount.getMail() %></td>
		</tr>
		<tr>
			<th>電話番号</th>
			<td><%= editAccount.getTel() %></td>
		</tr>
	</table>
	<form action="/accountManagement/UserManagementServlet" method="post">
		<input type="submit" value="OK">
	</form>　　
	<input type="button" value="キャンセル" onClick="history.back()">
</body>
</html>