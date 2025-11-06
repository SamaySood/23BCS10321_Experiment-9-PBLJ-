package com.example;

import com.example.dao.StudentDao;
import com.example.entity.Student;
import com.example.util.HibernateUtil;
import java.util.List;

public class HibernateCRUDExample {
    public static void main(String[] args) {
        StudentDao studentDao = new StudentDao();
        
        System.out.println("=== CREATE ===");
        Student student1 = new Student("John Doe", 101, "Computer Science");
        Student student2 = new Student("Jane Smith", 102, "Electronics");
        studentDao.saveStudent(student1);
        studentDao.saveStudent(student2);
        
        System.out.println("\n=== READ ALL ===");
        List<Student> students = studentDao.getAllStudents();
        students.forEach(System.out::println);
        
        System.out.println("\n=== READ BY ID ===");
        Student student = studentDao.getStudent(1);
        System.out.println(student);
        
        System.out.println("\n=== UPDATE ===");
        if (student != null) {
            student.setCourse("Information Technology");
            studentDao.updateStudent(student);
        }
        
        System.out.println("\n=== READ AFTER UPDATE ===");
        students = studentDao.getAllStudents();
        students.forEach(System.out::println);
        
        System.out.println("\n=== DELETE ===");
        studentDao.deleteStudent(2);
        
        System.out.println("\n=== READ AFTER DELETE ===");
        students = studentDao.getAllStudents();
        students.forEach(System.out::println);
        
        HibernateUtil.shutdown();
    }
}
