<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Account" %>
<%@ page import="servlet.UserManagementServlet" %>
<%
Account managementAccount = (Account) session.getAttribute("managementAccount");
int pg = 2;
session.setAttribute("pg", pg);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>アカウント変更</title>
</head>
<body>
<h1><%= managementAccount.getName() %>さんのアカウントを編集します</h1>
	<form action="/accountManagement/UserManagementServlet" method="post">
		<table border="">
			<tr>
				<th>名前:</th>
				<th><%= managementAccount.getName() %></th>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<th>生年月日:</th>
				<th><%= managementAccount.getBirth() %></th>
		<td><input type="date" name="birth" ></td>
			</tr>
			<tr>
				<th>メールアドレス:</th>
				<th><%= managementAccount.getMail() %></th>
				<td><input type="text" name="mail"></td>
			</tr>
			<tr>
				<th>電話番号:</th>
				<th><%= managementAccount.getTel() %></th>
				<td><input type="tel" pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}"  placeholder="090-1234-5678" name="tel"></td>
			</tr>
		</table>
		<input type="submit" value="OK">
	</form>  
	<input type="button" value="キャンセル" onClick="history.back()">
</body>
</html>