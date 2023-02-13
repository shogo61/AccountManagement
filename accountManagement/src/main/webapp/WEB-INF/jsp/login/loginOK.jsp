<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Account" %>
<% Account account = (Account) session.getAttribute("account"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン完了</title>
</head>
<body>
<h1>ようこそ<%=account.getId()%>さん</h1>
<a href="/accountManagement/TopMoveServlet">トップへ</a>
</body>
</html>