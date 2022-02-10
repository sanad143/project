package com.example.demo2.service;

import java.util.List;

import com.example.demo2.bean.Student;
import com.example.demo2.exception.ResourceNotfoundException;
import com.example.demo2.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class StudentServiceImpl implements StudentService{


    @Autowired
    private StudentRepository studentRepository;
  
    @Override
    public List<Student> getAllStudents(){
        return studentRepository.findAll(); 
        }

    @Override
    public Student saveStudent(Student student){
        return studentRepository.save(student);
        }


    @Override
    public Student getStudentById(Long id){
        java.util.Optional<Student> optional = studentRepository.findById(id);
        Student student = null;
        if(optional.isPresent()){
            student=optional.get();
        }else{
            throw new ResourceNotfoundException("Student not found:"+id);
        }

        return student; 
    }

    @Override
    public Student updateStudent(Long id,Student student){
        return studentRepository.save(student);
        }

    @Override
    public void deleteStudentById(Long id){
        this.studentRepository.deleteById(id);
        }
}
