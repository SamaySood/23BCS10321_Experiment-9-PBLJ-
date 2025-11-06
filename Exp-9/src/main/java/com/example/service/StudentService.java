package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.dao.StudentDao;
import com.example.entity.Student;
import java.util.List;

@Service
@Transactional
public class StudentService {
    
    @Autowired
    private StudentDao studentDao;
    
    public void addStudent(Student student) {
        studentDao.saveStudent(student);
    }
    
    @Transactional(readOnly = true)
    public Student getStudentById(int id) {
        return studentDao.getStudent(id);
    }
    
    @Transactional(readOnly = true)
    public List<Student> getAllStudents() {
        return studentDao.getAllStudents();
    }
    
    public void updateStudent(Student student) {
        studentDao.updateStudent(student);
    }
    
    public void deleteStudent(int id) {
        studentDao.deleteStudent(id);
    }
    
    public void transferStudent(int studentId, String newCourse) {
        Student student = studentDao.getStudent(studentId);
        if (student != null) {
            student.setCourse(newCourse);
            studentDao.updateStudent(student);
        }
    }
}
