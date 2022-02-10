package com.example.demo2.service;

import java.util.List;

import com.example.demo2.bean.Student;


public interface StudentService{
   
    List<Student> getAllStudents();
    Student saveStudent(Student student);
    Student updateStudent(Long id, Student student);
    Student getStudentById(Long id);
    void deleteStudentById(Long id);
}