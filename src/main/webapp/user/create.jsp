<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/8/2023
  Time: 6:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>

    </title>
</head>
<body>
<form action="/users?action=create" method="post">
    <input type="text" name="name" placeholder="Name">
    <input type="text" name="email" placeholder="Email">
    <input type="text" name="password" placeholder="Password">
    <input type="text" name="image" placeholder="Image">
    <input type="text" name="sex" placeholder="Sex">
    <input type="text" name="dob" placeholder="Birthday">
    <input type="text" name="address" placeholder="Address">
    <button type="submit">Submit</button>
</form>
</body>
</html>
