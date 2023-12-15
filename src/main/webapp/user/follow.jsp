<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/14/2023
  Time: 12:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Follow User</title>
    <link rel="stylesheet" href="../css/style.css">
</head>
<body>
<table border="1px">
    <tr>
        <td>STT</td>
        <td>Tên</td>
        <td>Ảnh</td>
        <td>Hoạt động</td>
    </tr>
    <c:forEach items="${users}" var="user">
        <c:if test="${account.id != user.id}">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td><img src="${user.image}" alt=""></td>
                <form action="friendships" method="post">
                    <td>
                        <input type="hidden" name="action" value="create">
                        <input type="hidden" name="idUser" value="${user.id}">
                        <input type="hidden" name="idAccount" value="${account.id}">
                        <button>Theo Dõi</button>
                    </td>
                </form>

            </tr>
        </c:if>
    </c:forEach>
</table>

</body>
</html>
