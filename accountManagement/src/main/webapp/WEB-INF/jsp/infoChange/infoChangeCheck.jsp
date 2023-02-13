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
<title>利用者情報変更確認画面</title>
</head>
<body>
<h1>登録情報変更確認</h1>
<br>
<p>以下の内容に変更します
パスワード：<%= a.getPass() %><br><br>
名前：<%= a.getName() %><br><br>
生年月日：<%= a.getBirth() %><br><br>
メールアドレス：<%= a.getMail() %><br><br>
電話番号：<%= a.getTel() %><br><br>
</p>
<form action="/accountManagement/infoChangeCheckServlet" method="post">
<input type="submit" value="変更確定">
</form>
</body>
</html>