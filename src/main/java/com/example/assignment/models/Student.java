package com.example.assignment.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "students")
public class Student {

    private int Id;
    private String name;
    private int age;
    private String phone;
    private Set<Course> Courses = new HashSet<Course>();

    public Student() {
    }

    public Student(String name, int age, String phone) {
        this.name = name;
        this.age = age;
        this.phone = phone;
    }

    public void addCourse(Course c) {
        this.Courses.add(c);
    }

    public void setCourses(Set<Course> courses) {
        Courses = courses;
    }


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "students_courses",
            joinColumns = @JoinColumn(name = "student_Id"),
            inverseJoinColumns = @JoinColumn(name = "course_Id")
    )
    public Set<Course> getCourses() {
        return Courses;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "student_Id")
    public int getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }



    public ArrayList<String> generateCourseNameList(){
        ArrayList<String> names = new ArrayList<>();
        getCourses().forEach(c-> names.add(c.getName()));
        return names;
    }
}
