package com.example.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.entity.Student;
import java.util.List;

@Repository
public class StudentDao {
    
    @Autowired
    private SessionFactory sessionFactory;
    
    public void saveStudent(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.save(student);
        System.out.println("Student saved successfully");
    }
    
    public Student getStudent(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Student.class, id);
    }
    
    public List<Student> getAllStudents() {
        Session session = sessionFactory.getCurrentSession();
        Query<Student> query = session.createQuery("FROM Student", Student.class);
        return query.list();
    }
    
    public void updateStudent(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.update(student);
        System.out.println("Student updated successfully");
    }
    
    public void deleteStudent(int id) {
        Session session = sessionFactory.getCurrentSession();
        Student student = session.get(Student.class, id);
        if (student != null) {
            session.delete(student);
            System.out.println("Student deleted successfully");
        }
    }
}
