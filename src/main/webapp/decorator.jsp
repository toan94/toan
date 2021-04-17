<%--
  Created by IntelliJ IDEA.
  User: justm
  Date: 4/16/2021
  Time: 4:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title><sitemesh:write property='title'/></title>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <style>

        </style>
        <sitemesh:write property='head'/>
    </head>
    <body class="bg-dark">

        <div class="container bg-light" style="height: 100%;">

            <h1 class='title text-center'>Students & Courses Management</h1>
            <nav>
                <ul class="nav justify-content-center">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="students">Students</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="courses">Courses</a>
                    </li>
                </ul>
            </nav>
            <div class='mainBody'>
                <sitemesh:write property='body'/>
            </div>

            <footer class='disclaimer mt-5'>@Copyright 2021.</footer>
        </div>




    </body>
</html>