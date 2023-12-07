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
        <td>Người Comment</td>
        <td>Ảnh</td>
        <td>Thời gian</td>
        <td>Nội dung</td>
        <td>Action</td>
    </tr>
    <c:forEach var="comment" items="${comments}">
        <tr>
            <td>${comment.id}</td>
            <td>${comment.user.name}</td>
            <td>${comment.date}</td>
            <td>${comment.content}</td>
            <td>${comment.image}</td>
            <td>
                <button>Xóa</button>
            </td>
            <td>
                <a
                    href="http://localhost:8080/comments?action=update&id=${comment.id} ">
                    <button>Sửa</button>
                </a>

            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
