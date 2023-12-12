<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List Comment</title>
    <link rel="stylesheet" href="../css/style.css">
</head>
<body>
<h1>Các comment đã đăng </h1>
<a href="http://localhost:8080/comments?action=create">
    <button>Thêm mới</button>
</a>
<table border="1px">
    <tr>
        <td>STT</td>
        <td>Thời gian</td>
        <td>Nội Dung</td>
        <td>ID bài viết</td>
        <td>ID Người dùng</td>
        <td>Tên Người dùng</td>
        <td>Ảnh Người Dùng</td>
        <td colspan="2">Hành động</td>
    </tr>
    <c:forEach var="comment" items="${comments}">
        <tr>
            <td>${comment.id}</td>
            <td>${comment.time}</td>
            <td>${comment.content}</td>
            <td>${comment.post.id}</td>
            <td>${comment.user.id}</td>
            <td>${comment.user.name}</td>
            <td><img src="${comment.user.image}"></td>
            <td>
                <a href="http://localhost:8080/comments?action=update&id=${comment.id}">
                    <button>Sửa</button>
                </a>
            </td>
            <form action="comments" method="post">
                <td>

                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" name="id" value="${comment.id}">
                    <button>Xóa</button>
                </td>
            </form>
        </tr>
    </c:forEach>
</table>
</body>
</html>
