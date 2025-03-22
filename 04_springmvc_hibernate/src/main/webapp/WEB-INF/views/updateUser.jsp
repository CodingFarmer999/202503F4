<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改頁</title>
</head>
<body>
<h1>修改頁</h1>
<form action="../update" method="POST">
	帳號：${user.username}<br/>
	密碼：<input type="password" name="password" value="${user.password}"/><br/>
	E-MAIL：<input type="text" name="email" value="${user.email}"/><br/>
	生日：<input type="date" name="birthDay" value="${user.birthDay}"/><br/>
	<input type="hidden" name="username" value="${user.username}"/>
	<button type="submit">更新</button>
</form>
<a href="../toUserList">回列表頁</a>
</body>
</html>