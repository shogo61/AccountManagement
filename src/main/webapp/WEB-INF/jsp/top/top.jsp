<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Account" %>
<%
Account loginUser = (Account) session.getAttribute("account");
boolean exists = true; //accountインスタンス存在フラグ
boolean isRole = false; //role確認フラグ
String role = "";

if(loginUser == null){
	exists = false;
} else {
	role = loginUser.getRole();
	isRole = role.contains("admin"); //引数と同じであればtrue
}
session.setAttribute("loginUser", loginUser);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>トップ</title>
</head>
<body>
<h1>トップ</h1>
<a href="/accountManagement/InfoChangeServlet">利用者情報変更</a><br><br>
<% if(isRole) { %>
<a href="/accountManagement/UserManagementServlet">利用者管理</a><br><br>
<a href="/accountManagement/UserRegiCheckServlet">利用者登録</a><br><br>
<% } %>
<a href="/accountManagement/LogoutServlet">ログアウト</a>
</body>
</html>