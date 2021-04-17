package com.example.assignment.Dao;

import com.example.assignment.models.Course;
import com.example.assignment.models.Student;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class CourseDao extends BaseDao{

    public List<Course> getAllCourses(){
        Session session = getSession();

        String hql = "FROM Course";
        Query query = session.createQuery(hql);
        List<Course> results = query.list();


        session.close();
        return results;
    }

    public void createCourse(Course c){
        Session session = getSession();
        session.beginTransaction();

        session.save(c);

        session.getTransaction().commit();
        session.close();
    }

    public Course getCourseById(int Id) {
        Session session = getSession();

        String hql = "FROM Course WHERE course_Id = :Id";
        Query query = session.createQuery(hql);
        query.setParameter("Id", Id);
        List<Course> results = query.list();

        if (results.size() == 0) {return null;}
        session.close();
        return results.get(0);
    }

    public void updateCourse(Course c){
        Session session = getSession();
        session.beginTransaction();

        session.update(c);

        session.getTransaction().commit();
        session.close();
    }

    public int deleteCourse(int Id){
        Session session = getSession();
        session.beginTransaction();

        String hql = "DELETE FROM Course "  +
                "WHERE course_Id = :Id";
        Query query = session.createQuery(hql);
        query.setParameter("Id", Id);

        int result = query.executeUpdate();
        System.out.println("Rows affected: " + result);

        session.getTransaction().commit();
        session.close();
        return result;

    }
}
