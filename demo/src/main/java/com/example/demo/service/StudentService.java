package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.bean.Student;
import com.example.demo.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService
{

@Autowired
private StudentRepository studentRepository;

public Student saveStudent(Student student){
    return studentRepository.save(student); 
    }
    
    public List<Student> saveStudents(List<Student> students){
    return studentRepository.saveAll(students); 
    }
    
    public List<Student> getStudents(){
    return studentRepository.findAll(); 
    }
    public Student getStudentById(Long id){
    return studentRepository.getById(id); 
    }
    
    public String deleteStudent(long id){
    studentRepository.deleteById(id);
    return "student removed !! "+id;
    }
    
    public Student updateStudent(Long id,Student student){
    return studentRepository.save(student);
    
    }

    public Optional<Student> getId() {
        return null;
    }
    
    
    
    
    
    
    
    
    
    
    


    
    
}
