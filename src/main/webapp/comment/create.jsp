
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Comment</title>
</head>
<body>
<h1>Các comment bài viết</h1>
<form action="/comments" method="post">
    <input type="hidden" name="action" value="create">
    <label>Thời Gian</label>
    <input type="text" name="time">
    <label>Nội Dung</label>
    <input type="text" name="content">
    <label>Ảnh</label>
    <input type="text" name="image">
    <label>Người Bình Luận </label>
    <input type="number" name="idUser">
    <input type="hidden" name="idPost" value="1">
    <button>Thêm</button>

</form>
</body>
</html>
