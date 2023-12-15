<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/5/2023
  Time: 3:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View</title>
    <link rel="stylesheet" href="../css/style.css">
</head>
<body>
<table border="1px">
    <tr>
        <td>STT</td>
        <td>Thời Gian</td>
        <td>Người dùng</td>
        <td>Nội dung</td>
        <td>Ảnh</td>
        <td>Thể Loại</td>
        <td>Trạng Thái</td>
        <td colspan="2">Hoạt Động</td>
    </tr>
    <tr>
        <td>${post.id}</td>
        <td>${post.time}</td>
        <td>${post.user.name}</td>
        <td>${post.content}</td>
        <td><img src="${post.image}"></td>
        <td>${post.category.name}</td>
        <td>${post.situation.name}</td>
        <td>
            <a href="http://localhost:8080/posts?action=update&id=${post.id}">
                <button>Sửa</button>
            </a>
        </td>
        <form action="posts" method="post">
            <td>
                <input type="hidden" name="action" value="delete">
                <input type="hidden" name="id" value="${post.id}">
                <button>Xóa</button>
            </td>
        </form>
        <td>
            <a href="http://localhost:8080/comments?action=create&idPost=${post.id}">
                <button>Add Comment</button>
            </a>
        </td>

    </tr>
</table>
</body>
</html>
