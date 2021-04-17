package com.example.assignment;

import com.example.assignment.Dao.CourseDao;
import com.example.assignment.Dao.StudentDao;
import com.example.assignment.models.Course;
import com.example.assignment.models.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@WebServlet(name = "EditCourseServlet", value = "/editCourse")
public class EditCourseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int Id = Integer.parseInt(request.getParameter("id"));
        CourseDao cDao = new CourseDao();
        Course c = cDao.getCourseById(Id);



        request.setAttribute("course", c);
        request.setAttribute("action", "editCourse");

        RequestDispatcher rd=request.getRequestDispatcher("/editCourse.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String courseName = request.getParameter("courseName");
        int courseId = Integer.parseInt(request.getParameter("courseId"));




        Course newC = new Course(courseName);
        newC.setId(courseId);
        CourseDao cDao = new CourseDao();
        cDao.updateCourse(newC);

        response.sendRedirect(request.getContextPath() + "/courses");
    }
}
