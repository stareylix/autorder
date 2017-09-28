<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>登录</title>
    <style>.error{color:red;}</style>
</head>
<body>
<c:if test="${error=='tokenIllegal'}">
	<c:redirect url="${pageContext.request.contextPath}/shiroUserManager/login.htm"/>
</c:if>
<div class="error">${error}</div>
<form action="${pageContext.request.contextPath}/shiroUserManager/loginCheck.htm" method="post">
    用户名：<input type="text" name="loginUsername"><br/>
    密码：<input type="password" name="loginPassword"><br/>
    令牌：<input type="text" name="tokenKey" value="${token}" readonly="readonly"><br/>
    <input type="submit" value="登录">
</form>
</body>
</html>