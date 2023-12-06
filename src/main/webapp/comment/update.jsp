
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update</title>

</head>
<body>
<h1>Thông tin comment</h1>
<form action="/comments" method="post">
    <input type="hidden" name="action" value="update">
    <input type="hidden" name="id" value="${post.id}">
    <label>Người Comment</label>
    <input type="number" name="idUser" value="${post.user.id}">
    <label>Nội Dung</label>
    <input type="text" name="content" value="${post.content}">
    <label>Ảnh</label>
    <input type="text" name="image" value="${post.image}">
    <label>Thời Gian</label>
    <input type="text" name="time" value="${post.time}">


    <label>Người Đăng</label>
    <input type="number" name="idUser" value="${post.user.id}">
    <button>Cập nhật</button>
</form>
</body>
</html>
