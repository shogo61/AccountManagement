<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="java.util.ArrayList" %>
<%@ page import="servlet.UserManagementServlet" %>
<%@ page import="model.Account" %>
<%
ArrayList<Account> accountList = (ArrayList<Account>) session.getAttribute("accountList");
int pg = 0;
session.setAttribute("pg", pg);
%><!-- 警告無視してOK -->
<html>
<head>
<meta charset="UTF-8">
<title>利用者管理画面</title>
</head>
<body>
	<h1>利用者管理画面</h1>
	<table border="1">
		<thead>
			<tr>
				<th>ID</th>
				<th>名前</th>
				<th>生年月日</th>
				<th>メールアドレス</th>
				<th>電話番号</th>
				<th>権限</th>
				<th>状態</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
		<%for(int i = 0; i < accountList.size(); i++){ %>
			<tr>
				<form action="/accountManagement/UserManagementServlet" method="post">
				<td><input type="hidden" name="id" value =<%= accountList.get(i).getId()%>><%= accountList.get(i).getId() %></td>
				<td><input type="hidden" name="name" value =<%= accountList.get(i).getName()%>><%= accountList.get(i).getName()%></td>
				<td><input type="hidden" name="birth" value =<%= accountList.get(i).getBirth()%>><%= accountList.get(i).getBirth()%></td>
				<td><input type="hidden" name="mail" value =<%= accountList.get(i).getMail()%>><%= accountList.get(i).getMail()%></td>
				<td><input type="hidden" name="tel" value =<%= accountList.get(i).getTel()%>><%= accountList.get(i).getTel()%></td>
				<td><input type="hidden" name="role" value =<%= accountList.get(i).getRole()%>><%= accountList.get(i).getRole()%></td>
				<td><input type="hidden" name="active" value =<%= accountList.get(i).getActive()%>><%= accountList.get(i).getActive()%></td>
				<td><input type="submit" name="check" value="編集"></td>
				<td><input type="submit" name="check" value="状態"></td>
				
				<input type="hidden" name="pass" value =<%= accountList.get(i).getPass()%>>
				</form>
			</tr>
		<%} %>
		</tbody>
	</table>
	<a href="/accountManagement/TopMoveServlet">トップへ</a>
</body>
</html>