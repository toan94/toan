package com.example.assignment;

import com.example.assignment.Dao.CourseDao;
import com.example.assignment.Dao.StudentDao;
import com.example.assignment.models.Course;
import com.example.assignment.models.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CourseListServlet", value = "/courses")
public class CourseListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CourseDao cDao = new CourseDao();
        List<Course> allCourses = cDao.getAllCourses();

        //allStudents.forEach((s) -> System.out.println(s.getName()));
        request.setAttribute("courseList", allCourses);

        RequestDispatcher rd=request.getRequestDispatcher("/courseList.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
