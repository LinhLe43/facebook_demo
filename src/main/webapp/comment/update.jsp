<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Comment</title>
</head>
<body>
<h1>Sửa Comment Bài Viết</h1>
<h1>${comment.id}</h1>
<form action="/comments" method="post">
    <input type="hidden" name="action" value="update">
    <input type="hidden" name="id" value="${comment.id}">
    <label>Nội Dung</label>
    <input type="text" name="content" value="${comment.content}">
    <label>ID Bài Viết</label>
    <input type="number" name="idPost" value="${comment.post.id}">
    <label>ID Người Dùng</label>
    <input type="number" name="idUser" value="${comment.user.id}">
    <button>Thêm</button>
</form>
</body>
</html>
