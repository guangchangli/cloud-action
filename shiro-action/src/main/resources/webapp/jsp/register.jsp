<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>用户注册</h1>
<form action="${pageContext.request.contextPath}/user/register" method="post">
    用户名:<input type="text" name="userName"><br/>
    密  码:<input type="text" name="password"><br/>
    <input type="submit" value="立即注册"/>
</form>
</body>
</html>
