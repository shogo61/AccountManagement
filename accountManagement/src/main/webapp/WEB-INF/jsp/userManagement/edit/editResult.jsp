<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Account" %>
<%
Account editAccount = (Account) session.getAttribute("editAccount");
int pg = 4;
session.setAttribute("pg", pg);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>アカウント編集完了</title>
</head>
<body>
	<h1>この内容で登録いたしました</h1>
	<table border="">
		<tr>
			<th>ID</th>
			<td><%= editAccount.getId() %></td>
		</tr>
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
	<form action="/accountManagement/UserManagementServlet" method="get">
		<input type="submit" value="OK">
	</form>　　
</body>
</html>