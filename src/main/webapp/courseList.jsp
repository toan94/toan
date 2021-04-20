<%--
  Created by IntelliJ IDEA.
  User: justm
  Date: 4/17/2021
  Time: 8:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Course List</title>
</head>
<body>
<c:set var="courseList" scope="page" value="${requestScope.courseList}" />
<div class="container-fluid">
    <a class="btn btn-outline-secondary" href="createCourse">Create new course</a>
    <table class="table">

        <thead>
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Name</th>
            <th scope="col"></th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${courseList}" var="course">
            <tr>
                <th scope="row">${course.getId()}</th>
                <td>${course.getName()}</td>
                <td>
                    <a class="btn btn-outline-secondary" href="editCourse?id=${course.getId()}">Edit</a>
                    <a class="courseDeleteBtn btn btn-outline-secondary" href="deleteCourse?id=${course.getId()}">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
        <script>
            $( document ).ready(function() {

                $(".courseDeleteBtn").click(function(event) {
                    var ans = window.confirm("DELETE?");
                    if (!ans) {
                        // var href = $(this).attr('href');
                        // console.log(href);
                        return false;
                    }
                    var href = $(this).attr('href');
                    // alert(href);
                    event.preventDefault();
                    location.href = href;
                });

            });
        </script>
    </table>
</div>
</body>
</html>
