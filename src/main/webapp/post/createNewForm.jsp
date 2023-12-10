<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/29/2023
  Time: 11:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Create</title>
    <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
            integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
            crossorigin="anonymous"
    />
    <script
            src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"
    ></script>
    <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
            crossorigin="anonymous"
    ></script>
    <link rel="stylesheet" href="../css/style.css"/>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-12 mt-5">
            <h2>Nhập thông tin bài viết</h2>
        </div>
        <div class="col-12 mt-5">
            <form
                    action="http://localhost:8080/posts"
                    method="post"
            >
                <input type="hidden" name="action" value="create">
                <input type="hidden" name="idUser" value="1">
                <div class="form-row">
                    <div class="form-group col-12">
                        <label for="inputContent">Nội dung</label>
                        <input type="text" class="form-control" id="inputContent" name="content"
                               placeholder="Nhập nội dung">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-3">
                        <label for="inputImage">Ảnh</label>
                        <input type="text" class="form-control" id="inputImage" name="image"
                               placeholder="Nhập link ảnh">
                    </div>
                    <div class="form-group col-3">
                        <label for="inputTime">Thời gian</label>
                        <input type="text" class="form-control" id="inputTime" name="image"
                               placeholder="Nhập thời gian">
                    </div>
                    <div class="form-group col-3">
                        <label for="inputSituation">Trạng thái</label>
                        <select name="idSituation" id="inputSituation" class="form-control">
                            <c:forEach var="situation" items="${situations}">
                                <option value="${situation.id}">${situation.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group col-3">
                        <label for="inputCategory">Thể loại</label>
                        <select name="idCategory" id="inputCategory" class="form-control">
                            <c:forEach var="category" items="${categories}">
                                <option value="${category.id}">${category.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <button type="submit" class="btn btn-primary">
                    Create Product
                </button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
