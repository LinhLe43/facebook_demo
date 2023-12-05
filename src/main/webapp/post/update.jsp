<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/5/2023
  Time: 9:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
<h1>Thông tin bài post</h1>
<form action="/posts" method="post">
    <input type="hidden" name="action" value="update">
    <input type="hidden" name="id" value="${post.id}">
    <label>Nội Dung</label>
    <input type="text" name="content" value="${post.content}">
    <label>Ảnh</label>
    <input type="text" name="image" value="${post.image}">
    <label>Thời Gian</label>
    <input type="text" name="time" value="${post.time}">
    <label>Trạng Thái</label>
    <select name="idSituation">
        <c:forEach var="situation" items="${situations}">
            <option value="${situation.id}">${situation.name}</option>
        </c:forEach>
    </select>
    <label>Thể Loại</label>
    <select name="idCategory">
        <c:forEach var="category" items="${categories}">
            <option value="${category.id}">${category.name}</option>
        </c:forEach>
    </select>
    <label>Người Đăng</label>
    <input type="number" name="idUser" value="${post.user.id}">
    <button>Cập nhật</button>
</form>
</body>
</html>
