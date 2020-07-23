<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <title>文件上传</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/go/upload" enctype="multipart/form-data">
    <input type="file" name="file"><br>
    <input type="text" name="path" value="product">
    <input type="submit" value="上传">
</form>
</body>
</html>

