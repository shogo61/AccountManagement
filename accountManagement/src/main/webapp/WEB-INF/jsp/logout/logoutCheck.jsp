<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログアウト確認</title>
</head>
<body>
<h1>ログアウトしますか？</h1>
<form action="/accountManagement/LogoutServlet" method="post">
<input type="submit" value="はい">
</form>
<input type="button" value="いいえ" onClick="history.back()">
</body>
</html>