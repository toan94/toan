package com.example.assignment;

import com.example.assignment.Dao.CourseDao;
import com.example.assignment.Dao.StudentDao;
import com.example.assignment.models.Course;
import com.example.assignment.models.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.*;

@WebServlet(name = "EditStudentServlet", value = "/editStudent")
public class EditStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int Id = Integer.parseInt(request.getParameter("id"));
        StudentDao stDao = new StudentDao();
        Student s = stDao.getStudentById(Id);

        CourseDao cDao = new CourseDao();
        List<Course> AllCourses = cDao.getAllCourses();

        request.setAttribute("AllCourses", AllCourses);
        request.setAttribute("Student", s);
        request.setAttribute("action", "editStudent");


        RequestDispatcher rd=request.getRequestDispatcher("/editStudent.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        boolean wrongStatus = request.getParameter("studentName").isEmpty()
                || request.getParameter("studentAge").isEmpty()
                || request.getParameter("studentId").isEmpty()
                || request.getParameter("studentPhone").isEmpty() ;

        int studentId = Integer.parseInt(request.getParameter("studentId"));
        if (wrongStatus) {
            request.setAttribute("wrongStatus", wrongStatus);
            StudentDao stDao = new StudentDao();
            Student s = stDao.getStudentById(studentId);

            CourseDao cDao = new CourseDao();
            List<Course> AllCourses = cDao.getAllCourses();

            request.setAttribute("AllCourses", AllCourses);
            request.setAttribute("Student", s);
            request.setAttribute("action", "editStudent");

            RequestDispatcher rd=request.getRequestDispatcher("/editStudent.jsp");
            rd.forward(request, response);
            return;
        }

        String studentName = request.getParameter("studentName");
        int studentAge = Integer.parseInt(request.getParameter("studentAge"));
        String studentPhone = request.getParameter("studentPhone");
        String[] EnrolledCoursesId = request.getParameterValues("EnrolledCourses");

        CourseDao cDao = new CourseDao();
        Set<Course> newS_EnrolledCourses = new HashSet<>();
        if (EnrolledCoursesId != null) {
            List<String> EnrolledCoursesIdList = Arrays.asList(EnrolledCoursesId);
            EnrolledCoursesIdList.forEach(courseName -> {
                int Id = Integer.parseInt(courseName);
                Course c = cDao.getCourseById(Id);
                newS_EnrolledCourses.add(c);
            });
        }

        Student newS = new Student(studentName, studentAge, studentPhone);
        newS.setId(studentId);
        newS.setCourses(newS_EnrolledCourses);
        StudentDao sDao = new StudentDao();
        sDao.updateStudent(newS);

        response.sendRedirect(request.getContextPath() + "/students");

    }
}
