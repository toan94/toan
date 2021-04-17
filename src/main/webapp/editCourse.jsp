<%--
  Created by IntelliJ IDEA.
  User: justm
  Date: 4/17/2021
  Time: 8:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Course</title>
</head>
<body>


<form action="${requestScope.action}" method="POST" class="w-50 ms-5">
    <h4>Course Id: ${course.getId()}</h4>
    <c:set var="course" scope="page" value="${requestScope.course}" />
    <input type="text"  class="d-none" name="courseId" value="${course.getId()}">

    <div class="input-group mb-3">
        <span class="input-group-text">Name</span>
        <input type="text" aria-label="First name" class="form-control" name="courseName" value="${course.getName()}">
    </div>

    <input type="submit" class="form-control btn btn-outline-secondary"  value="Submit">


</form>

</body>
</html>
