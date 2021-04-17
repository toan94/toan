package com.example.assignment.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "courses")
public class Course {

    private int Id;
    private String name;
    private Set<Student> Students = new HashSet<Student>();

    public Course() {
    }

    public Course(String name) {
        this.name = name;
    }

    public void addStudent(Student s) {
        this.Students.add(s);
    }

    public void setId(int id) {
        Id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStudents(Set<Student> students) {
        Students = students;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "course_Id")
    public int getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    @ManyToMany(mappedBy = "courses")
    public Set<Student> getStudents() {
        return Students;
    }
}
