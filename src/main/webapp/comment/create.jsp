<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Comment</title>
</head>
<body>
<h1>Thêm Comment Bài Viết</h1>
<form action="/comments" method="post">
    <input type="hidden" name="action" value="create">
    <label>Nội Dung</label>
    <input type="text" name="content">
    <label>ID Bài Viết</label>
    <input type="number" name="idPost">
    <label>ID Người Dùng</label>
    <input type="number" name="idUser">
    <button>Thêm</button>
</form>
</body>
</html>
