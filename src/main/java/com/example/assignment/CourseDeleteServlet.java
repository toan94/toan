package com.example.assignment;

import com.example.assignment.Dao.CourseDao;
import com.example.assignment.Dao.StudentDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CourseDeleteServlet", value = "/deleteCourse")
public class CourseDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int Id = Integer.parseInt(request.getParameter("id"));
        CourseDao cDao = new CourseDao();
        cDao.deleteCourse(Id);

        response.sendRedirect(request.getContextPath() + "/courses");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
