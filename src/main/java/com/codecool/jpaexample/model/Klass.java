package com.codecool.jpaexample.model;

import com.codecool.jpaexample.CCLocation;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static com.codecool.jpaexample.model.Address_.student;

@Entity
public class Klass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @Enumerated(EnumType.STRING)
    private CCLocation location;
    @OneToMany(mappedBy = "klass")
    private Set<Student> students = new HashSet<>();

    public Klass() {
    }

    public Klass(String name, CCLocation location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
        student.setKlass(this);
    }

}
