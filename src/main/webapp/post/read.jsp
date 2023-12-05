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
<table border="1px">
    <tr>
        <td>STT</td>
        <td>Time</td>
        <td>User</td>
        <td>Category</td>
        <td>Situation</td>
        <td colspan="3">Action</td>
    </tr>
    <c:forEach items="${posts}" var="post">
        <tr>
            <td>${post.id}</td>
            <td>${post.time}</td>
            <td>${post.user.name}</td>
            <td>${post.category.name}</td>
            <td>${post.situation.name}</td>
            <td><button>Xem chi tiết</button></td>
            <td><button>Sửa</button></td>
            <td><button>Xóa</button></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
