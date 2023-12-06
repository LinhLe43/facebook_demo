<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/6/2023
  Time: 10:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Facebook Login Page</title>
    <link rel="stylesheet" href="../css/facebook.css"/>
</head>
<body>
<div class="content">
    <div class="flex-div">
        <div class="name-content">
            <h1 class="logo">Facebook</h1>
            <p>Connect with friends and the world around you on Facebook.</p>
        </div>
        <form action="/login" method="post">
            <input type="text" placeholder="Email or Phone Number" name="username"/>
            <input type="password" placeholder="Password" name="password">
            <button class="login">Log In</button>
        </form>
    </div>
</div>
</body>
</html>

