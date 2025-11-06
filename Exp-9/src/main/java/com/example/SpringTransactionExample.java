package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.example.config.HibernateConfig;
import com.example.entity.Student;
import com.example.service.StudentService;
import java.util.List;

public class SpringTransactionExample {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);
        StudentService studentService = context.getBean(StudentService.class);
        
        System.out.println("=== Adding Students ===");
        studentService.addStudent(new Student("Alice Johnson", 201, "Physics"));
        studentService.addStudent(new Student("Bob Williams", 202, "Chemistry"));
        
        System.out.println("\n=== Getting All Students ===");
        List<Student> students = studentService.getAllStudents();
        students.forEach(System.out::println);
        
        System.out.println("\n=== Updating Student ===");
        Student student = studentService.getStudentById(1);
        if (student != null) {
            student.setCourse("Mathematics");
            studentService.updateStudent(student);
        }
        
        System.out.println("\n=== Transfer Student ===");
        studentService.transferStudent(1, "Mechanical Engineering");
        
        System.out.println("\n=== Final List ===");
        students = studentService.getAllStudents();
        students.forEach(System.out::println);
        
        ((AnnotationConfigApplicationContext) context).close();
    }
}
