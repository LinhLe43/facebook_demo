
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>view</title>
    <link rel="stylesheet" href="../css/style.css">
</head>
<body >
<table border="1">
    <tr>
        <td>STT</td>
        <td>Người Comment</td>
        <td>Thời gian</td>
        <td> Nội dung</td>
        <td> Ảnh</td>
        <td colspan="2">Action </td>
    </tr>
    <tr>
        <td>${comment.id}</td>
        <td>${comment.user.name}</td>
        <td>${comment.time}</td>
        <td>${comment.content}</td>
        <td><img src=" ${comment.image}"></td>
        <td>
            <a href="http://localhost:8080/comment?action=update&id=${comment.id}" >
                <button>Sửa</button>
            </a>
        </td>
        <td>
            <form action="comments" method="post">
                <td>
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" name="id" value="${comment.id}">
                    <button>Xóa</button>
                </td>
            </form>
    </tr>
</table>
</body>
</html>
