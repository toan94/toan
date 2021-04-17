package com.example.assignment;

import com.example.assignment.Dao.CourseDao;
import com.example.assignment.Dao.StudentDao;
import com.example.assignment.models.Course;
import com.example.assignment.models.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@WebServlet(name = "TestServlet", value = "/TestServlet")
public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        SessionFactory sessionFactory;

        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
//            Student s1 = new Student("tssssssssssoan", 133, "777ssss77");
//            Student s2 = new Student("boy", 233, "55ddd555");
//
//            Course c1 = new Course("newshit");
//            //Course c2 = new Course("ccccc");

//            s1.addCourse(c1);
//            s1.addCourse(c2);
//            c1.addStudent(s1);
//            c2.addStudent(s1);
            //s2.addCourse(c1);
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            StudentDao stDao = new StudentDao();
            Student s10 = stDao.getStudentById(10);
            CourseDao cDao = new CourseDao();
            Course c7 = cDao.getCourseById(7);
            Course c5 = cDao.getCourseById(5);
            Set<Course> setC= new HashSet<>();
            setC.add(c5);
            setC.add(c7);
            s10.setCourses(setC);
            session.update(s10);
            //session.save(c1);
            //session.save(c2);
            //session.save(s2);

            session.getTransaction().commit();
            session.close();
            response.getWriter().write("yessss");
        } catch (Exception ex) {
            StandardServiceRegistryBuilder.destroy(registry);
            response.getWriter().write("nooooooooooooo");
        }





    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
