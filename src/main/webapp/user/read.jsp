<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/7/2023
  Time: 11:36 AM
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
<table border="1px">
    <tr>
        <td>Id</td>
        <td>Name</td>
        <td>Password</td>
        <td>Image</td>
        <td>Sex</td>
        <td>Dob</td>
        <td>Address</td>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.password}</td>
            <td><img src="${user.image}"></td>
            <td>${user.sex}</td>
            <td>${user.dob}</td>
            <td>${user.address}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
