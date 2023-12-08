<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/8/2023
  Time: 7:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/users?action=update" method="post">
    <input type="text" name="id" placeholder="ID" value="${user.id}" readonly>
    <input type="text" name="name" placeholder="Name" value="${user.name}">
    <input type="text" name="email" placeholder="Email"  value="${user.email}">
    <input type="text" name="password" placeholder="Password" value="${user.password}">
    <input type="text" name="image" placeholder="Image" value="${user.image}">
    <input type="text" name="sex" placeholder="Sex" value="${user.sex}">
    <input type="text" name="dob" placeholder="Birthday" value="${user.dob}">
    <input type="text" name="address" placeholder="Address" value="${user.address}">
    <button type="submit">Submit</button>
</form>
</body>
</html>
