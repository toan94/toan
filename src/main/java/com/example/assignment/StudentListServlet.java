package com.example.assignment;

import com.example.assignment.Dao.StudentDao;
import com.example.assignment.models.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentListServlet", value = "/students")
public class StudentListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        StudentDao stDao = new StudentDao();
        List<Student> allStudents = stDao.getAllStudents();

        //allStudents.forEach((s) -> System.out.println(s.getName()));
        request.setAttribute("StudentList", allStudents);

        RequestDispatcher rd=request.getRequestDispatcher("/studentList.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
