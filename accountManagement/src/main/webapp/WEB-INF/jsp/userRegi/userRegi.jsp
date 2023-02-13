<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Account" %>
<%
Account regiUser = (Account) session.getAttribute("regiUser");
String errormsg = (String) request.getAttribute("errormsg");
boolean exists = false;

//sessionからsignUpUserインスタンスを取得できたか確認する
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>利用者登録</title>
</head>
<body>
<h1>利用者登録</h1>
<form action="/accountManagement/UserRegiCheckServlet" method="post">
<% if(exists) { %>
<%=errormsg %><br><br>
ID:<input type="text" name="id" value="<%= regiUser.getId() %>"><br><br>
名前:<input type="text" name="name" value="<%= regiUser.getName() %>"><br><br>
生年月日:<input type="text" name="birth" value="<%= regiUser.getBirth() %>"><br><br>
メールアドレス:<input type="text" name="mail"value="<%= regiUser.getMail() %>"><br><br>
電話番号:<input type="text" name="tel" value="<%= regiUser.getTel() %>"><br><br>
パスワード:<input type="password" name="pass"><br><br>
users:<input type="radio" name="role" value="1" checked="checked"><br>
admins:<input type="radio" name="role" value="2"><br><br>
<input type="submit" value="送信">
<input type="reset">
<% } else { %>
ID:<input type="text" name="id"><br><br>
名前:<input type="text" name="name"><br><br>
生年月日:<input type="text" name="birth"><br><br>
メールアドレス:<input type="text" name="mail"><br><br>
電話番号:<input type="text" name="tel"><br><br>
パスワード:<input type="password" name="pass"><br><br>
users:<input type="radio" name="role" value="1" checked="checked"><br>
admins:<input type="radio" name="role" value="2"><br><br>
<input type="submit" value="送信">
<input type="reset">
<% } %>
</form>
<a href="/accountManagement/TopMoveServlet">トップへ</a>
</body>
</html>