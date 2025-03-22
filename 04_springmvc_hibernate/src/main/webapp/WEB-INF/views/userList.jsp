<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>使用者列表</h1>

<table border="1">
	<c:forEach var="user" items="${users}">
	<tr>
		<td width="150px">${user.username}</td>
		<td width="100px">
			<a href="delete/${user.id}">刪除</a>
			<a href="toUpdate/${user.id}">編輯</a>
		</td>
	</tr>
	</c:forEach>

</table>

<a href="index.jsp">回首頁</a>

</body>
</html>