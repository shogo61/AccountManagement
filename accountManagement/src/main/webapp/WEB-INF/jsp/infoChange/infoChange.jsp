<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Account" %>
<%
// セッションスコープからインスタンスを取得
Account a = (Account) session.getAttribute("account");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録情報変更</title>
</head>
<body>
<h1>登録情報変更</h1>
<a href="/accountManagement/TopMoveServlet">トップ</a>
<form action="/accountManagement/InfoChangeServlet" method="post">
パスワード：<input type="text" name="pass" value="<%= a.getPass() %>"><br><br>
名前：<input type="text" name="name" value="<%= a.getName() %>"><br><br>
生年月日：<input type="date" name="birth" value="<%= a.getBirth() %>" min="<?php echo date(Y-m-d), strtotime('-123 year')); ?>" max="<?php echo date('Y-m-d'); ?>"><br><br>
メールアドレス：<input type="text" name="mail" value="<%= a.getMail() %>"><br><br>
電話番号：<input type="text" name="tel" value="<%= a.getTel() %>"><br><br>
<input type="submit" value="確認">
</form>
</body>
</html>