<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>用户登录</h1>
<form action="${pageContext.request.contextPath}/user/login" method="post">
    用户名:<input type="text" name="username"><br/>
    密  码:<input type="text" name="password"><br/>
    <input type="submit" value="登录"/>

</form>
</body>
</html>
