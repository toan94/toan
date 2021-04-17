package com.example.assignment.Dao;

import com.example.assignment.models.Course;
import com.example.assignment.models.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class StudentDao extends BaseDao{

    public List<Student> getAllStudents(){
        Session session = getSession();

        String hql = "FROM Student";
        Query query = session.createQuery(hql);
        List<Student> results = query.list();
        results.forEach((s)->{
            s.getCourses().forEach(c->c.getName());
        });

        session.close();
        return results;
    }

    public void createStudent(Student s){
        Session session = getSession();
        session.beginTransaction();

        session.save(s);

        session.getTransaction().commit();
        session.close();
    }

    public void updateStudent(Student s){
        Session session = getSession();
        session.beginTransaction();

        session.update(s);

        session.getTransaction().commit();
        session.close();
    }

    public Student getStudentById(int Id) {
        Session session = getSession();

        String hql = "FROM Student WHERE student_Id = :Id";
        Query query = session.createQuery(hql);
        query.setParameter("Id", Id);
        List<Student> results = query.list();

        if (results.size() == 0) {return null;}

        results.get(0).getCourses().forEach(c->c.getName());
        session.close();
        return results.get(0);
    }

    public int deleteStudent(int Id){
        Session session = getSession();
        session.beginTransaction();

        String hql = "DELETE FROM Student "  +
                "WHERE student_Id = :Id";
        Query query = session.createQuery(hql);
        query.setParameter("Id", Id);

        int result = query.executeUpdate();
        System.out.println("Rows affected: " + result);

        session.getTransaction().commit();
        session.close();
        return result;

    }
}
