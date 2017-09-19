<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <style>.error{color:red;}</style>
</head>
<body>

<div class="error">${error}</div>
<form action="${pageContext.request.contextPath}/shiroUserManager/loginCheck.htm" method="post">
    用户名：<input type="text" name="loginUsername"><br/>
    密码：<input type="password" name="loginPassword"><br/>
    令牌：<input type="text" name="tokenKey"><br/>
    <input type="submit" value="登录">
</form>

</body>
</html>