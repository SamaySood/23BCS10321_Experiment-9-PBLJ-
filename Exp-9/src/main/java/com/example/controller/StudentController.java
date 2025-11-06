package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.entity.Student;
import com.example.service.StudentService;
import java.util.List;

@Controller
public class StudentController {
    
    @Autowired
    private StudentService studentService;
    
    @GetMapping("/")
    public String home() {
        return "forward:/static/index.html";
    }
    
    @GetMapping("/api/students")
    @ResponseBody
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }
    
    @PostMapping("/api/students")
    @ResponseBody
    public Student addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
        return student;
    }
    
    @GetMapping("/api/students/{id}")
    @ResponseBody
    public Student getStudent(@PathVariable int id) {
        return studentService.getStudentById(id);
    }
    
    @PutMapping("/api/students/{id}")
    @ResponseBody
    public Student updateStudent(@PathVariable int id, @RequestBody Student student) {
        student.setId(id);
        studentService.updateStudent(student);
        return student;
    }
    
    @DeleteMapping("/api/students/{id}")
    @ResponseBody
    public String deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
        return "Student deleted successfully";
    }
}
