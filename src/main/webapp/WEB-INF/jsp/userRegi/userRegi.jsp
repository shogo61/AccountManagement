<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Account" %>
<%
Account regiUser = (Account) session.getAttribute("regiUser");
String errormsg = (String) request.getAttribute("errormsg");
boolean exists = false;

//sessionからregiUserインスタンスを取得できたか確認する
//regiUserにデータが格納されているか確認
if (regiUser != null) {
	exists = true;
}
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
パスワード:<input type="password" name="pass"><br><br>
名前:<input type="text" name="name" value="<%= regiUser.getName() %>"><br><br>
生年月日:<input type="date" name="birth" value="<%= regiUser.getBirth() %>" min="<?php echo date(Y-m-d), strtotime('-123 year')); ?>" max="<?php echo date('Y-m-d'); ?>"><br><br>
メールアドレス:<input type="text" name="mail"value="<%= regiUser.getMail() %>"><br><br>
電話番号:<input type="text" name="tel" value="<%= regiUser.getTel() %>"><br><br>
user:<input type="radio" name="role" value="user" checked="checked"><br>
admin:<input type="radio" name="role" value="admin"><br><br>
<input type="submit" value="送信">
<input type="reset">
<% } else { %>
ID:<input type="text" name="id"><br><br>
パスワード:<input type="password" name="pass"><br><br>
名前:<input type="text" name="name"><br><br>
生年月日:<input type="date" name="birth" min="<?php echo date(Y-m-d), strtotime('-123 year')); ?>" max="<?php echo date('Y-m-d'); ?>"><br><br>
メールアドレス:<input type="text" name="mail"><br><br>
電話番号:<input type="text" name="tel"><br><br>
user:<input type="radio" name="role" value="user" checked="checked"><br>
admin:<input type="radio" name="role" value="admin"><br><br>
<input type="submit" value="送信">
<input type="reset">
<% } %>
</form>
<a href="/accountManagement/TopMoveServlet">トップへ</a>
</body>
</html>