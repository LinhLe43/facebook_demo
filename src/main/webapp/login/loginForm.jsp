<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/6/2023
  Time: 10:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Trang Đăng Nhập</h1>
<form action="/login" method="post">
    <div>
        <label>Tên Đăng nhập</label>
        <input type="text" name="username">
    </div>
    <div>
        <label>Mật Khẩu</label>
        <input type="password" name="password">
    </div>
    <input type="submit" value="login">
</form>
</body>
</html>
