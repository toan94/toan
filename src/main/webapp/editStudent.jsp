<%--
  Created by IntelliJ IDEA.
  User: justm
  Date: 4/17/2021
  Time: 3:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="student" scope="page" value="${requestScope.Student}" />
<c:set var="allCourses" scope="page" value="${requestScope.AllCourses}" />
<html>
<head>
    <title>Edit Student</title>
</head>
<body>


    <form action="${requestScope.action}" method="POST" class="w-50 ms-5">
        <c:if test="${requestScope.wrongStatus}">
            <span class="text-danger">Please fill out all the fields</span>
        </c:if>
        <h3>Student Id: ${student.getId()}</h3>
        <input type="text"  class="d-none" name="studentId" value="${student.getId()}">

        <div class="input-group mb-3">
            <span class="input-group-text">Name</span>
            <input type="text" aria-label="First name" class="form-control" name="studentName" value="${student.getName()}">
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text">Age</span>
            <input type="number" aria-label="First name" class="form-control" name="studentAge" value="${student.getAge()}">
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text">Phone</span>
            <input type="text" aria-label="First name" class="form-control" name="studentPhone" value="${student.getPhone()}">
        </div>
        <p>Enrolled Courses:</p>
        <c:forEach items="${allCourses}" var="course">
            <div class="form-check">
                <input class="form-check-input" type="checkbox" name="EnrolledCourses" value="${course.getId()}" id="c_${course.getName()}"
                <c:if test="${student.generateCourseNameList().contains(course.getName())}">
                    checked
                </c:if>
                />
                <label class="form-check-label" for="c_${course.getName()}">
                    ${course.getName()}
                </label>
            </div>
        </c:forEach>

        <input type="submit" class="form-control btn btn-outline-secondary"  value="Submit">


<%--        <div class="form-check"    >     ${student.getCourses().contains(course.getName())}    --%>
<%--            <input class="form-check-input" type="checkbox" value="" id="xx" <% if(1==2) { %> checked <% } %> />--%>
<%--            <label class="form-check-label" for="xx">--%>
<%--                Sciedddnce--%>
<%--            </label>--%>
<%--        </div>--%>
<%--        <c:forEach items="${student.getCourses()}" var="course">--%>
<%--            <div class="form-check">--%>
<%--                <input class="form-check-input" type="checkbox" name="EnrolledCourses" value="" id="flexCheckDefault" checked>--%>
<%--                <label class="form-check-label" for="flexCheckDefault">--%>
<%--                    Math--%>
<%--                </label>--%>
<%--            </div>--%>
<%--        </c:forEach>--%>

    </form>




</body>
</html>
