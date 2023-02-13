<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Account" %>
<%
Account managementAccount = (Account) session.getAttribute("managementAccount");
int pg = 4;
session.setAttribute("pg", pg);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>アカウント削除</title>
</head>
<body>
	<h1><%= managementAccount.getName() %>さんのアカウントを削除しました</h1>
	<table border="">
		<tr>
			<th>ID</th>
			<td><%= managementAccount.getId() %></td>
		</tr>
		<tr>
			<th>名前</th>
			<td><%= managementAccount.getName() %></td>
		</tr>
		<tr>
			<th>生年月日</th>
			<td><%= managementAccount.getBirth() %></td>
		</tr>
		<tr>
			<th>メールアドレス</th>
			<td><%= managementAccount.getMail() %></td>
		</tr>
		<tr>
			<th>電話番号</th>
			<td><%= managementAccount.getTel() %></td>
		</tr>
	</table>
	<form action="/accountManagement/UserManagementServlet" method="get">
		<input type="submit" value="OK">
	</form>　　
</body>
</html>