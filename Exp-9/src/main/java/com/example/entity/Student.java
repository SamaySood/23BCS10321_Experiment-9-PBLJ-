package com.example.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "STUDENT")
public class Student implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    
    @Column(name = "STUDENT_NAME")
    private String studentName;
    
    @Column(name = "ROLL_NUMBER")
    private int rollNumber;
    
    @Column(name = "COURSE")
    private String course;
    
    public Student() {}
    
    public Student(String studentName, int rollNumber, String course) {
        this.studentName = studentName;
        this.rollNumber = rollNumber;
        this.course = course;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getStudentName() {
        return studentName;
    }
    
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    
    public int getRollNumber() {
        return rollNumber;
    }
    
    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }
    
    public String getCourse() {
        return course;
    }
    
    public void setCourse(String course) {
        this.course = course;
    }
    
    @Override
    public String toString() {
        return "Student [id=" + id + ", studentName=" + studentName + 
               ", rollNumber=" + rollNumber + ", course=" + course + "]";
    }
}
