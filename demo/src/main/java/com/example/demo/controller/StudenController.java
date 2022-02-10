package com.example.demo.controller;


import java.util.List;

import com.example.demo.bean.Student;
import com.example.demo.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StudenController {
    
@Autowired
private StudentService service;
	

//GET ALL STUDENTS
@RequestMapping(method =RequestMethod.GET,value ="/dell")
public List<Student> getAllStudents() {
   return service.getStudents();
}

//GET STUDENT BY SPECIFIC ID

@RequestMapping(method =RequestMethod.GET,value ="/dell/{id}")
public Student getStudent(@PathVariable Long id) {
   return service.getStudentById(id);

}
// ADD STUDENT using POST
@RequestMapping(method =RequestMethod.POST,value ="/dell")
public Student addStudents(@RequestBody Student students) {
      return service.saveStudent(students);

}

// UPDATE STUDENT using PUT
@RequestMapping(method =RequestMethod.PUT,value ="/dell/{id}")
public Student updateStudents(@PathVariable Long id,@RequestBody Student student) {
    return service.updateStudent(id,student);
}

// REMOVE STUDENT using DELETE
@RequestMapping(method =RequestMethod.DELETE,value ="/dell/{id}")
public String deleteStudents(@PathVariable Long id) {
    return service.deleteStudent(id);
}
}


