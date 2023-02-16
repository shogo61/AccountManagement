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
<title>利用者登録結果</title>
</head>
<body>
<h1>利用者登録結果</h1>
<h2>以下の内容で登録致しました。</h2>
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
     <td><%= regiUser.getId() %></td>
     <td><%= regiUser.getName() %></td>
     <td><%= regiUser.getBirth() %></td>
     <td><%= regiUser.getMail() %></td>
     <td><%= regiUser.getTel() %></td>
     <td><%= regiUser.getRole() %></td>
   </tr>
 </table>
 <h3><a href="/accountManagement/UserRegiCheckServlet">OK</a></h3>
</body>
</html>