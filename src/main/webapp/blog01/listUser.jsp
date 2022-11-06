<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 9/14/2022
  Time: 10:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="blog01/fontawesome/css/all.min.css"> <!-- https://fontawesome.com/ -->
<link href="https://fonts.googleapis.com/css2?family=Source+Sans+Pro&display=swap" rel="stylesheet"> <!-- https://fonts.google.com/ -->
<link href="blog01/css/bootstrap.min.css" rel="stylesheet">
<link href="blog01/css/templatemo-xtra-blog.css" rel="stylesheet">
<link rel="stylesheet" href="blog01/css/bootstrap.css">
<script src="blog01/js/bootstrap.js"></script>
<head>
    <title>Users List</title>
</head>
<body>
<header class="tm-header" id="tm-header">
    <div class="tm-header-wrapper">
        <button class="navbar-toggler" type="button" aria-label="Toggle navigation">
            <i class="fas fa-bars"></i>
        </button>
        <div class="tm-site-header">
            <div class="mb-0 mx-auto tm-site-logo"><i class="fas fa-times fa-2x"></i></div>
            <h1 class="text-center">Xtra Blog</h1>
        </div>
        <nav class="tm-nav" id="tm-nav">
            <ul>
                <li class="tm-nav-item active"><a href="index.html" class="tm-nav-link">
                    <i class="fas fa-home"></i>
                    Blog Home
                </a></li>
                <li class="tm-nav-item"><a href="post.html" class="tm-nav-link">
                    <i class="fas fa-pen"></i>
                    Single Post
                </a></li>
                <c:if test='${sessionScope.accountSession != null}'>
                    <li class="tm-nav-item"><a href="" class="tm-nav-link">
                        Hello ${sessionScope.accountSession.getUsername()}
                    </a></li>
                    <c:if test="${sessionScope.accountSession.getRole() == 0}">
                        <li class="tm-nav-item"><a href="/listUser" class="tm-nav-link">
                            List user
                        </a></li>
                    </c:if>
                    <li class="tm-nav-item"><a href="/Logout" class="tm-nav-link">
                        Log out
                    </a></li>
                </c:if>
                <c:if test='${sessionScope.accountSession == null}'>
                    <li class="tm-nav-item"><a href="/Login" class="tm-nav-link">
                        Log In
                    </a></li>
                    <li class="tm-nav-item"><a href="/SignUp" class="tm-nav-link">
                        Register
                    </a></li>
                </c:if>
                <li class="tm-nav-item"><a href="about.html" class="tm-nav-link">
                    <i class="fas fa-users"></i>
                    About Xtra
                </a></li>
                <li class="tm-nav-item"><a href="contact.html" class="tm-nav-link">
                    <i class="far fa-comments"></i>
                    Contact Us
                </a></li>
            </ul>
        </nav>
        <div class="tm-mb-65">
            <a rel="nofollow" href="https://fb.com/templatemo" class="tm-social-link">
                <i class="fab fa-facebook tm-social-icon"></i>
            </a>
            <a href="https://twitter.com" class="tm-social-link">
                <i class="fab fa-twitter tm-social-icon"></i>
            </a>
            <a href="https://instagram.com" class="tm-social-link">
                <i class="fab fa-instagram tm-social-icon"></i>
            </a>
            <a href="https://linkedin.com" class="tm-social-link">
                <i class="fab fa-linkedin tm-social-icon"></i>
            </a>
        </div>
        <p class="tm-mb-80 pr-5 text-white">
            Xtra Blog is a multi-purpose HTML template from TemplateMo website. Left side is a sticky menu bar. Right side content will scroll up and down.
        </p>
    </div>
</header>
<div class="container-fluid">
    <main class="tm-main">
        <div class="row tm-row">
            <div class="col-12">
                <form action="/Blog" method="GET" class="form-inline tm-mb-80 tm-search-form">
                    <input class="form-control tm-search-input" name="name" type="text" placeholder="Search..." aria-label="Search">
                    <button class="tm-search-button" type="submit">
                        <i class="fas fa-search tm-search-icon" aria-hidden="true"></i>
                    </button>
                </form>
            </div>
        </div>
        <center>
            <caption><h1>List of Users</h1></caption>
            <h3>
                <a href="">Create a new user</a>
            </h3>
        </center>
        <div style="width: 80%; margin-left: 10%">
            <table class="table table-hover" border="1">
                <thead>
                <tr class="table-dark">
                    <th class="max-width" style="text-align:center">ID</th>
                    <th class="max-width" style="text-align:center">Username</th>
                    <th class="max-width" style="text-align:center">Password</th>
                    <th class="max-width" style="text-align:center">Role</th>
                    <th style="text-align:center; width: 100px">Actions</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var = "i" begin="0" end="${accounts.size()-1}" >
                    <tr>
                        <td class="text-center align-middle">${accounts.get(i).id}</td>
                        <td class="text-center align-middle">${accounts.get(i).username}</td>
                        <td class="text-center align-middle">${accounts.get(i).password}</td>
                        <td class="text-center align-middle">${accounts.get(i).role}</td>
                        <td class="text-center align-middle">
                            <div class="btn-group align-top">
                                <a href="" class="btn btn-success">
                                    <span class="glyphicon glyphicon-edit"></span>
                                    <span style="color: white"><strong>Edit</strong></span>
                                </a>
                                <a href="" class="btn btn-danger"
                                   onclick="return confirm('Are you sure to delete this user?')">
                                    <span class="glyphicon glyphicon-remove"></span>
                                    <span style="color: white"><strong>Delete</strong></span>
                                </a>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </main>
</div>
</body>
</html>
