<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Account" %>
<%
Account regiUser = (Account) session.getAttribute("regiUser");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>利用者登録確認</title>
</head>
<body>
<h1>利用者登録確認</h1>
<h2>以下の内容でよろしいでしょうか？</h2>
<table border="1">
   <tr>
     <th>ID</th>
     <th>名前</th>
     <th>生年月日</th>
     <th>メールアドレス</th>
     <th>電話番号</th>
     <th>ロール</th>
   </tr>
   <tr>
 	 <td></td>
     <td></td>
     <td></td>
     <td></td>
     <td></td>
     <td></td>
   </tr>
 </table>
<a href="/accountManagement/UserRegiServlet">OK</a><br>
<a href="/accountManagement/UserRegiCheckServlet">キャンセル</a>
</body>
</html>