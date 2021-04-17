package com.example.assignment;

import com.example.assignment.Dao.StudentDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "StudentDeleteServlet", value = "/deleteStudent")
public class StudentDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int Id = Integer.parseInt(request.getParameter("id"));
        StudentDao stDao = new StudentDao();
        stDao.deleteStudent(Id);

        response.sendRedirect(request.getContextPath() + "/students");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
