<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Account" %>
<%
Account signUpUser = (Account) session.getAttribute("signUpUser");
session.setAttribute("account", signUpUser);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規登録結果</title>
</head>
<body>
<h1>新規登録結果</h1>
<h2>以下の内容で登録致しました。</h2>
<table border="1">
   <tr>
     <th>ID</th>
     <th>名前</th>
     <th>生年月日</th>
     <th>メールアドレス</th>
     <th>電話番号</th>
   </tr>
   <tr>
	 <td><%= signUpUser.getId() %></td>
     <td><%= signUpUser.getName() %></td>
     <td><%= signUpUser.getBirth() %></td>
     <td><%= signUpUser.getMail() %></td>
     <td><%= signUpUser.getTel() %></td>
   </tr>
</table>
<h3><a href="/accountManagement/TopMoveServlet">トップへ</a></h3>
</body>
</html>