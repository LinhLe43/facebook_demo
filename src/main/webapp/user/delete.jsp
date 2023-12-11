<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/8/2023
  Time: 8:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/users?action=delete" method="post">
    <input type="text" name="id" placeholder="ID" value="${user.id}" readonly>
    <button type="submit">Submit</button>
</form>
</body>
</html>
