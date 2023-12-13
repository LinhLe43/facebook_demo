<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Facebook</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
          integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="<c:url value='/home/css/style.css'/> ">
    <link rel="stylesheet" href="<c:url value='/home/css/owl.theme.default.css'/>">
    <link rel="stylesheet" href="<c:url value='/home/css/owl.carousel.min.css'/>">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
          integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
</head>

<body>
<!--navbar-->
<nav>
    <!--logo and search-->
    <div class="left-side">
        <div class="logo">
            <img src="<c:url value='/home/img/icons/facebook.svg'/>" alt="">
        </div>
        <form action="posts" method="post">
            <input type="hidden" name="action" value="search">
            <div class="search">
                <input type="text" placeholder="Search Facebook" name="name">
            </div>
        </form>

    </div>

    <!--tab icons-->
    <div class="tabs">
        <div class="tab-icon active">
            <div class="icon">
                <img src="<c:url value='/home/img/icons/home.svg'/>" alt="">
            </div>
        </div>

        <div class="tab-icon">
            <div class="icon has-notification">
                <img src="<c:url value='/home/img/icons/flag.svg'/>" alt="">
            </div>
        </div>

        <div class="tab-icon">
            <div class="icon">
                <img src="<c:url value='/home/img/icons/tv.svg'/>" alt="">
            </div>
        </div>

        <div class="tab-icon">
            <div class="icon">
                <img src="<c:url value='/home/img/icons/users.svg'/>" alt="">
            </div>
        </div>


        <div class="tab-icon">
            <div class="icon has-notification">
                <img src="<c:url value='/home/img/icons/calendar.svg'/>" alt="">
            </div>
        </div>
    </div>

    <!--right side-->
    <div class="right-side">
        <div class="user">
            <div class="profile">
                <img src="${account.image}" alt="">
            </div>
            <h4>${account.name}</h4>
        </div>

        <!--icons-->
        <div class="user-icons">
            <div class="icon">
                <img src="<c:url value='/home/img/icons/plus.svg'/>" alt="">
            </div>

            <div class="icon has-notification">
                <img src="<c:url value='/home/img/icons/messenger.svg'/>" alt="">
            </div>

            <div class="icon">
                <img src="<c:url value='/home/img/icons/bell.svg'/>" alt="">
            </div>

            <%--            <div class="icon">--%>
            <%--                <a style="" href="http://localhost:8080/login"><</a>--%>
            <%--            </div>--%>
            <div class="icon">
                <a style="" href="http://localhost:8080/login"><i class="fa-solid fa-right-from-bracket"
                                                                  style="color: #f2f4f7"></i></a>
            </div>
        </div>
    </div>
</nav>


<!--content-->
<div class="wrapper">
    <div class="shortcuts">
        <div class="first-col">
            <div class="menu-item">
                <div class="user">
                    <div class="profile">
                        <img src="${account.image}" alt="">
                    </div>
                    <h4>${account.name}</h4>
                </div>
            </div>

            <div class="menu-item">
                <div class="item-row">
                    <div class="icon">
                        <img src="<c:url value='/home/img/icons/shield.svg'/>" alt="">
                    </div>
                    <h4>COVID-19 Infromation Center </h4>
                </div>
            </div>

            <div class="menu-item">
                <div class="item-row">
                    <div class="icon">
                        <img src="<c:url value='/home/img/icons/colored-people.svg'/>" alt="">
                    </div>
                    <h4>Friends </h4>
                </div>
            </div>

            <div class="menu-item">
                <div class="item-row">
                    <div class="icon">
                        <img src="<c:url value='/home/img/icons/colored-messenger.svg'/>" alt="">
                    </div>
                    <h4>Messenger </h4>
                </div>
            </div>

            <div class="menu-item">
                <div class="item-row">
                    <div class="icon">
                        <img src="<c:url value='/home/img/icons/colored-flag.svg'/>" alt="">
                    </div>
                    <h4>Pages </h4>
                </div>
            </div>

            <div class="menu-item">
                <div class="item-row">
                    <div class="icon more">
                        <img src="<c:url value='/home/img/icons/arrow-down.svg'/>" alt="">
                    </div>
                    <h4>see more </h4>
                </div>
            </div>
        </div>
        <div class="second-col">

            <h6 class="title">
                your shortcuts
            </h6>
            <div class="menu-item">
                <div class="item-row">
                    <div class="icon">
                        <img src="<c:url value='/home/img/stories/st-1.jpeg'/>" alt="">
                    </div>
                    <h4>Designers house </h4>
                </div>
            </div>

            <div class="menu-item">
                <div class="item-row">
                    <div class="icon">
                        <img src="<c:url value='/home/img/stories/st-2.jpeg'/>" alt="">
                    </div>
                    <h4>Script house </h4>
                </div>
                <div class="menu-item">
                    <div class="item-row">
                        <div class="icon">
                            <img src="<c:url value='/home/img/stories/page-1.jpg'/>" alt="">
                        </div>
                        <h4>ui ux Designers workshop </h4>
                    </div>
                </div>

                <div class="menu-item">
                    <div class="item-row">
                        <div class="icon">
                            <img src="<c:url value='/home/img/stories/st-3.jpeg'/>" alt="">
                        </div>
                        <h4>netflix movies recommends </h4>
                    </div>
                </div>

                <div class="menu-item">
                    <div class="item-row">
                        <div class="icon">
                            <img src="<c:url value='/home/img/stories/page-2.jpg'/>" alt="">
                        </div>
                        <h4>the futur </h4>
                    </div>
                </div>


                <div class="menu-item">
                    <div class="item-row">
                        <div class="icon">
                            <img src="<c:url value='/home/img/stories/page-3.jpeg'/>" alt="">
                        </div>
                        <h4>aj smart </h4>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <!--posts-->
    <div class="posts">
        <!-- stories -->
        <div class="stories">
            <div class="owl-controls">
                <div class="owl-nav">
                    <div class="controllers nxtBtn">
                        <img src="<c:url value='/home/img/icons/arrow-right.svg'/>" alt="">
                    </div>
                </div>
            </div>
            <div class="owl-carousel owl-theme slider">
                <div class="item">
                    <div class="overlay first">
                        <div class="create">
                            <div class="icon">
                                <img src="<c:url value='/home/img/icons/plus.svg'/>" alt="">
                            </div>
                            <span>Create a Story</span>
                        </div>
                    </div>
                    <div class="story-image">
                        <img src="<c:url value='/home/img/avatar/hero.png'/>" alt="">
                    </div>
                </div>
                <!---->

                <div class="item">
                    <div class="overlay">
                        <div class="person">
                            <div class="profile">
                                <img src="<c:url value='/home/img/avatar/2.jpg'/>" alt="">
                            </div>
                        </div>
                        <h4> Samantha John</h4>
                    </div>
                    <div class="story-image">
                        <img src="<c:url value='/home/img/stories/st-2.jpeg'/>" alt="">
                    </div>
                </div>
                <!---->

                <div class="item">
                    <div class="overlay">
                        <div class="person">
                            <div class="profile">
                                <img src="<c:url value='/home/img/avatar/3.jpg'/>" alt="">
                            </div>
                        </div>
                        <h4>Chris Evans</h4>
                    </div>
                    <div class="story-image">
                        <img src="<c:url value='/home/img/stories/st-3.jpeg'/>" alt="">
                    </div>
                </div>
                <!---->

                <div class="item">
                    <div class="overlay">
                        <div class="person">
                            <div class="profile">
                                <img src="<c:url value='/home/img/avatar/4.jpg'/>" alt="">
                            </div>
                        </div>
                        <h4>Amanda Cerny</h4>
                    </div>
                    <div class="story-image">
                        <img src="<c:url value='/home/img/stories/st-4.jpg'/>" alt="">
                    </div>
                </div>
                <!---->

                <div class="item">
                    <div class="overlay">
                        <div class="person">
                            <div class="profile">
                                <img src="<c:url value='/home/img/avatar/5.jpg'/>" alt="">
                            </div>
                        </div>
                        <h4>Stacy Lopez </h4>
                    </div>
                    <div class="story-image">
                        <img src="<c:url value='/home/img/stories/st-1.jpeg'/>" alt="">
                    </div>
                </div>
                <!---->

                <div class="item">
                    <div class="overlay">
                        <div class="person">
                            <div class="profile">
                                <img src="<c:url value='/home/img/avatar/6.jpg'/>" alt="">
                            </div>
                        </div>
                        <h4>Bibhushan Karki</h4>
                    </div>
                    <div class="story-image">
                        <img src="<c:url value='/home/img/stories/st-1.jpeg'/>" alt="">
                    </div>
                </div>
                <!---->
            </div>
        </div>

        <!--create post-->
        <div class="timeline">
            <div class="view create-post">
                <div class="input">
                    <div class="user">
                        <div class="profile">
                            <img src="${account.image}" alt="">
                        </div>
                    </div>
                    <input type="text" placeholder="What on your mind, ${account.name}?" name="" id="">
                </div>
                <%--                <div class="media">--%>
                <%--                    <div class="category">--%>
                <%--                        <div class="option">--%>
                <%--                            <div class="icon">--%>
                <%--                                <img src="<c:url value='/home/img/icons/video-live.svg'/>" alt="">--%>
                <%--                            </div>--%>
                <%--                            <span>Live video</span>--%>
                <%--                        </div>--%>

                <%--                        <div class="option">--%>
                <%--                            <div class="icon">--%>
                <%--                                <img src="<c:url value='/home/img/icons/photos.svg'/>" alt="">--%>
                <%--                            </div>--%>
                <%--                            <span>photo/video</span>--%>
                <%--                        </div>--%>

                <%--                        <div class="option">--%>
                <%--                            <div class="icon">--%>
                <%--                                <img src="<c:url value='/home/img/icons/smile.svg'/>" alt="">--%>
                <%--                            </div>--%>
                <%--                            <span>feeling/activity</span>--%>
                <%--                        </div>--%>
                <%--                    </div>--%>
                <%--                </div>--%>
            </div>

            <div class="create-post view smaller-margin">
                <div class="upper">
                    <div class="title">
                        <div class="icon">
                            <img src="<c:url value='/home/img/icons/video-room.svg'/>" alt="">
                        </div>
                        <span>Rooms</span>
                    </div>
                    <a href="http://localhost:8080/posts?action=create">
                        create
                    </a>
                </div>

                <div class="owl-carousel owl-theme rooms">
                    <div class="item">
                        <div class="user">
                            <div class="profile">
                                <img src="<c:url value='/home/img/avatar/hero.png'/>" alt="">
                            </div>
                        </div>
                    </div>
                    <!---->

                    <div class="item">
                        <div class="user">
                            <div class="profile">
                                <img src="<c:url value='/home/img/avatar/1.jpg'/>" alt="">
                            </div>
                        </div>
                    </div>
                    <!---->
                    <div class="item">
                        <div class="user">
                            <div class="profile">
                                <img src="<c:url value='/home/img/avatar/3.jpg'/>" alt="">
                            </div>
                        </div>
                    </div>
                    <!---->
                    <div class="item">
                        <div class="user">
                            <div class="profile">
                                <img src="<c:url value='/home/img/avatar/4.jpg'/>" alt="">
                            </div>
                        </div>
                    </div>
                    <!---->

                    <div class="item">
                        <div class="user">
                            <div class="profile">
                                <img src="<c:url value='/home/img/avatar/2.jpg'/>" alt="">
                            </div>
                        </div>
                    </div>
                    <!---->

                    <div class="item">
                        <div class="user">
                            <div class="profile">
                                <img src="<c:url value='/home/img/avatar/4.jpg'/>" alt="">
                            </div>
                        </div>
                    </div>
                    <!---->

                    <div class="item">
                        <div class="user">
                            <div class="profile">
                                <img src="<c:url value='/home/img/avatar/5.jpg'/>" alt="">
                            </div>
                        </div>
                    </div>
                    <!---->
                </div>
            </div>
            <!--post container-->
            <c:forEach var="post" items="${posts}">
                <div class="view view-post-container smaller-margin">
                    <div class="view-post">
                        <div class="upper">
                            <div class="d-flex">
                                <div class="user">
                                    <div class="profile">
                                        <img src="${post.user.image}" alt="">
                                    </div>
                                </div>

                                <div class="info">
                                    <h6 class="name">
                                            ${post.user.name}
                                    </h6>
                                    <span class="time">${post.time}</span>
                                </div>
                            </div>


                            <c:if test="${post.user.id == account.id}">
                                <%--                                <div class="dots">--%>
                                <%--                                    <a class="dot"--%>
                                <%--                                       href="http://localhost:8080/posts?action=update&id=${post.id}">Sửa</a>--%>
                                <%--                                </div>--%>
                            </c:if>
                            <c:if test="${account.id == post.user.id}">
                                <div class="dropdown">
                                    <button class="btn btn-secondary dropdown-toggle" type="button"
                                            data-toggle="dropdown"
                                            aria-expanded="false">
                                        ...
                                    </button>
                                    <div class="dropdown-menu">
                                        <a href="http://localhost:8080/posts?action=update&id=${post.id}">
                                            <button class="dropdown-item" type="button">Sửa</button>
                                        </a>
                                        <form action="posts" method="post">
                                            <input type="hidden" name="action" value="delete">
                                            <input type="hidden" name="id" value="${post.id}">
                                            <a href="">
                                                <button class="dropdown-item">Xóa</button>
                                            </a>
                                        </form>
                                    </div>
                                </div>
                            </c:if>
                        </div>

                        <div class="desc">
                            <p>${post.content}</p>
                        </div>

                        <div class="post-img">
                            <img src="${post.image}" alt="">
                        </div>

                        <div class="actions-container">
                            <div class="action">
                                <div class="icon">
                                    <img src="<c:url value='/home/img/icons/thumbs-up.svg'/>" alt="">
                                </div>
                                <span>
                                    like
                                </span>
                            </div>

                            <div class="action">
                                <div class="icon">
                                    <img src="<c:url value='/home/img/icons/comment.svg'/>" alt="">
                                </div>
                                <span>
                                        <a style="color: white"
                                           href="http://localhost:8080/comments?action=create&idPost=${post.id}">
                                        comment
                                        </a>
                                </span>


                            </div>

                            <div class="action">
                                <div class="icon">
                                    <img src="<c:url value='/home/img/icons/share.svg'/>" alt="">
                                </div>
                                <span>
                                    share
                                </span>
                            </div>
                        </div>
                        <form action="comments" method="post">
                            <input type="hidden" name="action" value="create">
                            <div class="write-comment">
                                <div class="user">
                                    <div class="profile">
                                        <img src="${account.image}" alt="">
                                    </div>
                                </div>
                                <div class="input">
                                    <input type="text" placeholder="Write a comment" name="content">
                                    <input type="hidden" name="idPost" value="${post.id}">
                                    <input type="hidden" name="idUser" value="${account.id}">
                                    <button class="btn btn-primary btn-sm">Đăng</button>
                                </div>
                            </div>
                        </form>
                        <c:forEach var="comment" items="${comments}">
                            <c:if test="${comment.post.id == post.id}">
                                <div class="write-comment">
                                    <div class="user">
                                        <div class="profile">
                                            <img src="${comment.user.image}" alt="">
                                        </div>
                                    </div>
                                    <div class="input">
                                        <p>${comment.user.name} <br> ${comment.content}</p>
                                    </div>
                                </div>
                            </c:if>
                        </c:forEach>
                    </div>
                </div>
            </c:forEach>

            <!--people you may know-->
            <div class="view friends smaller-margin">
                <div class="upper">
                    <h6>people you may know</h6>
                    <div class="dots">
                        <div class="dot"></div>
                    </div>
                </div>

                <div class="owl-carousel owl-theme people">
                    <div class="item">
                        <div class="person-img">
                            <div class="icon">
                                &times;
                            </div>
                            <img src="<c:url value='/home/img/avatar/1.jpg'/>" alt="">
                        </div>

                        <div class="info">
                            <h4>
                                rosie pie
                            </h4>
                            <span>4 mutual friend</span>
                            <button>
                                add friend
                            </button>
                        </div>
                    </div>
                    <!---->

                    <div class="item">
                        <div class="person-img">
                            <div class="icon">
                                &times;
                            </div>
                            <img src="<c:url value='/home/img/avatar/4.jpg'/>" alt="">
                        </div>

                        <div class="info">
                            <h4>
                                sarah jones
                            </h4>
                            <span>4 mutual friend</span>
                            <button>
                                add friend
                            </button>
                        </div>
                    </div>
                    <!---->

                    <div class="item">
                        <div class="person-img">
                            <div class="icon">
                                &times;
                            </div>
                            <img src="<c:url value='/home/img/avatar/3.jpg'/>" alt="">
                        </div>

                        <div class="info">
                            <h4>
                                chris doe
                            </h4>
                            <span>4 mutual friend</span>
                            <button>
                                add friend
                            </button>
                        </div>
                    </div>
                    <!---->

                    <div class="item">
                        <div class="person-img">
                            <div class="icon">
                                &times;
                            </div>
                            <img src="<c:url value='/home/img/avatar/2.jpg'/>" alt="">
                        </div>

                        <div class="info">
                            <h4>
                                katie adam
                            </h4>
                            <span>4 mutual friend</span>
                            <button>
                                add friend
                            </button>
                        </div>
                    </div>
                    <!---->
                </div>
            </div>
        </div>
    </div>

    <!--shortcuts 2 -events and chat- -->
    <div class="shortcuts shortcuts-2">
        <div class="second-col first-col">
            <div class="menu-item">
                <div class="upper">
                    <h6>Your pages</h6>
                </div>
            </div>

            <div class="menu-item">
                <div class="item-row">
                    <div class="icon">
                        <img src="<c:url value='/home/img/stories/st-2.jpeg'/>" alt="">
                    </div>
                    <h4>Script house </h4>
                </div>
            </div>

            <div class="menu-item">
                <div class="item-row">
                    <div class="icon">
                        <img src="<c:url value='/home/img/stories/st-1.jpeg'/>" alt="">
                    </div>
                    <h4>Bibs ui design </h4>
                </div>
            </div>

            <div class="menu-item">
                <div class="item-row">
                    <div class="icon more">
                        <img src="<c:url value='/home/img/icons/arrow-down.svg'/>" alt="">
                    </div>
                    <h4>see more </h4>
                </div>
            </div>
        </div>
        <div class="second-col">

            <h6 class="title">
                birthdays
            </h6>
            <div class="menu-item">
                <div class="item-row">
                    <div class="icon not-rounded">
                        <img src="<c:url value='/home/img/icons/gift.svg'/>" alt="">
                    </div>
                    <h4>It's Diana Berry's birthday </h4>
                </div>
            </div>
            <div class="online">
                <h6 class="title">
                    contact
                </h6>
                <c:forEach var="friendShip" items="${friendShips}">
                    <c:if test="${account.id == friendShip.user1.id}">
                        <div class="user">
                            <div class="profile">
                                <img src="${friendShip.user2.image}" alt="">
                            </div>
                            <h4>${friendShip.user2.name}</h4>
                        </div>
                    </c:if>
                </c:forEach>
            </div>
        </div>
    </div>
</div>


<script src="<c:url value='js/jquery.min.js'/>"></script>
<script src="<c:url value='js/owl.carousel.min.js'/>"></script>
<script src="<c:url value='js/index.js'/>"></script>
</body>

</html>