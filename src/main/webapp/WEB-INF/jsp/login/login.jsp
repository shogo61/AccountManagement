<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "servlet.LoginServlet" %>
<% String loginErrorMessage = (String) request.getAttribute("loginErrorMessage"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
</head>
<body>
<h1>ログイン</h1>
<% if(loginErrorMessage != null) { %>
	<p><%= loginErrorMessage %></p>
<% } %>
<form action="/accountManagement/LoginServlet" method="post">
ID:<input type="text" name="id"><br>
パスワード:<input type="password" name="pass"><br>
<input type="submit" value="ログイン">
</form>
<input type="button" value="キャンセル" onClick="history.back()">
</body>
</html>