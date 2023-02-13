<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Account" %>
<%
Account signUpUser = (Account) session.getAttribute("signUpUser");
String errormsg = (String) request.getAttribute("errormsg");
boolean exists = false;

//sessionからsignUpUserインスタンスを取得できたか確認する

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規登録</title>
</head>
<body>
<h1>新規登録</h1>
<form action="/accountManagement/SignUpCheckServlet" method="post">
<% if(exists) { %>
<%=errormsg %><br><br>
ID:<input type="text" name="id" value="<%= signUpUser.getId() %>"><br><br>
名前:<input type="text" name="name" value="<%= signUpUser.getName() %>"><br><br>
生年月日:<input type="text" name="birth" value="<%= signUpUser.getBirth() %>"><br><br>
メールアドレス:<input type="text" name="mail"value="<%= signUpUser.getMail() %>"><br><br>
電話番号:<input type="text" name="tel" value="<%= signUpUser.getTel() %>"><br><br>
パスワード:<input type="password" name="pass"><br><br>
<input type="submit" value="送信">
<input type="reset">
<% } else { %>
ID:<input type="text" name="id"><br><br>
名前:<input type="text" name="name"><br><br>
生年月日:<input type="text" name="birth"><br><br>
メールアドレス:<input type="text" name="mail"><br><br>
電話番号:<input type="text" name="tel"><br><br>
パスワード:<input type="password" name="pass"><br><br>
<input type="submit" value="送信">
<input type="reset">
<% } %>
</form>
<input type="button" value="キャンセル" onClick="history.back()">
</body>
</html>