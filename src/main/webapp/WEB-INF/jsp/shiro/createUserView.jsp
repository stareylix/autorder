<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>创建新用户</title>
</head>
<body>
<shiro:hasRole name="admin">
	<form action="#" method="post">
		用户名：<input type="text" name="username">
		<br>
		密码：<input type="password" name="password">
		<br>
		<input type="submit" value="提交">
	</form>
</shiro:hasRole>
<shiro:lacksRole name="admin">
	对不起，您没有新增用户的权限！
</shiro:lacksRole>
</body>
</html>