<%--
  Created by IntelliJ IDEA.
  User: justm
  Date: 4/16/2021
  Time: 3:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.example.assignment.models.Student"%>
<%@page import="java.util.List"%>

<html>
<head>
    <title>Student List</title>

</head>

<body>
    <c:set var="StudentList" scope="page" value="${requestScope.StudentList}" />
    <div class="container-fluid">
        <a class="btn btn-outline-secondary" href="createStudent">Create new student</a>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Id</th>
                <th scope="col">Name</th>
                <th scope="col">Ageaaa</th>
                <th scope="col">Phone</th>
                <th scope="col">Courses</th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>

            <c:forEach items="${StudentList}" var="student">
                <tr>
                    <th scope="row">${student.getId()}</th>
                    <td>${student.getName()}</td>
                    <td>${student.getAge()}</td>
                    <td>${student.getPhone()}</td>
                    <td>
                        <c:forEach items="${student.getCourses()}" var="course" varStatus="loop">
                            <span>${course.getName()}</span><c:if test="${!loop.last}">, </c:if>

                        </c:forEach>
                    </td>
                    <td>
                        <a class="btn btn-outline-secondary" href="editStudent?id=${student.getId()}">Edit</a>
                        <a class="studentDeleteBtn btn btn-outline-secondary" href="deleteStudent?id=${student.getId()}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            <script>
                $( document ).ready(function() {

                    $(".studentDeleteBtn").click(function(event) {
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
<%--            <script>--%>
<%--                $( document ).ready(function() {--%>
<%--                    var id = $(.stude)--%>
<%--                    $(".studentDeleteBtn").click(function(){--%>
<%--                        var r = window.confirm("delete yes or no?");--%>
<%--                        if (r == true) {--%>
<%--                            $.get("deleteStudent?id=${student.getId()}", function (data){--%>
<%--                                console.log("sdfasdfasdf");--%>
<%--                                location.reload();--%>
<%--                            });--%>
<%--                            &lt;%&ndash;$("#del_${student.getId()}").trigger("click");&ndash;%&gt;--%>
<%--                        }--%>
<%--                    });--%>
<%--                });--%>
<%--            </script>--%>



            </tbody>
        </table>
    </div>

</body>
</html>
