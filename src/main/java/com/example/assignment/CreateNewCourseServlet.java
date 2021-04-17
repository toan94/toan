package com.example.assignment;

import com.example.assignment.Dao.CourseDao;
import com.example.assignment.models.Course;
import com.example.assignment.models.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@WebServlet(name = "CreateNewCourseServlet", value = "/createCourse")
public class CreateNewCourseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Course c = new Course("");
        c.setId(-1);
        request.setAttribute("course", c);
        request.setAttribute("action", "createCourse");

        RequestDispatcher rd=request.getRequestDispatcher("/editCourse.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("courseName");

        Course newC = new Course(name);
//        Set<Student> EnrolledStudents = new HashSet<>();
//        newC.setStudents(EnrolledStudents);
        CourseDao cDao = new CourseDao();
        cDao.createCourse(newC);

        response.sendRedirect(request.getContextPath() + "/courses");
    }
}
