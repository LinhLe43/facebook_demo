<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/5/2023
  Time: 9:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../css/style.css">
</head>
<body>
<h1>Danh sách các bài Post</h1>
<a href="http://localhost:8080/posts?action=create">
    <button>Thêm mới</button>
</a>
<table border="1px">
    <tr>
        <td>STT</td>
        <td>Thời Gian</td>
        <td>Người dùng</td>
        <td>Thể Loại</td>
        <td>Trạng Thái</td>
        <td colspan="3">Hoạt Động</td>
    </tr>
    <c:forEach items="${posts}" var="post">
        <tr>
            <td>${post.id}</td>
            <td>${post.time}</td>
            <td>${post.user.name}</td>
            <td>${post.category.name}</td>
            <td>${post.situation.name}</td>
            <td>
                <button>Xem chi tiết</button>
            </td>
            <td>
                <button>Sửa</button>
            </td>
            <form action="posts" method="post">
                <td>
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" name="id" value="${post.id}">
                    <button>Xóa</button>
                </td>
            </form>
        </tr>
    </c:forEach>
</table>
</body>
</html>
