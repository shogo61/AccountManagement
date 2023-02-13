<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Account" %>
<%
Account signUpUser = (Account) session.getAttribute("signUpUser");
session.setAttribute("signUpUser", signUpUser);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規登録確認</title>
</head>
<body>
<h1>新規登録確認</h1>
<h2>以下の内容でよろしいでしょうか？</h2>
<table border="1">
   <tr>
     <th>ID</th>
     <th>名前</th>
     <th>生年月日</th>
     <th>メールアドレス</th>
     <th>電話番号</th>
   </tr>
   <tr>
 	 <td></td>
     <td></td>
     <td></td>
     <td></td>
     <td></td>
   </tr>
 </table>
<a href="/accountManagement/SignUpServlet">OK</a><br>
<a href="/accountManagement/SignUpCheckServlet">キャンセル</a>
</body>
</html>