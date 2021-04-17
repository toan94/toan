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

@WebServlet(name = "CreateNewStudentServlet", value = "/createStudent")
public class CreateNewStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        Student s = new Student();
        s.setId(-1);
        s.setName("");
        s.setAge(0);
        s.setPhone("");

        CourseDao cDao = new CourseDao();
        List<Course> AllCourses = cDao.getAllCourses();

        request.setAttribute("AllCourses", AllCourses);
        request.setAttribute("Student", s);
        request.setAttribute("action", "createStudent");

        RequestDispatcher rd=request.getRequestDispatcher("/editStudent.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        boolean wrongStatus = request.getParameter("studentName").isEmpty()
                || request.getParameter("studentAge").isEmpty()
                || request.getParameter("studentId").isEmpty()
                || request.getParameter("studentPhone").isEmpty() ;


        if (wrongStatus) {
            request.setAttribute("wrongStatus", wrongStatus);
            doGet(request, response);
            return;
        }


        //DRY later
        String studentName = request.getParameter("studentName");
        int studentAge = Integer.parseInt(request.getParameter("studentAge"));
        String studentPhone = request.getParameter("studentPhone");
        String[] EnrolledCoursesId = request.getParameterValues("EnrolledCourses");

        int studentId = Integer.parseInt(request.getParameter("studentId"));
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
        newS.setCourses(newS_EnrolledCourses);
        StudentDao sDao = new StudentDao();
        sDao.createStudent(newS);

        response.sendRedirect(request.getContextPath() + "/students");
    }
}
