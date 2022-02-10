package com.example.demo2.controller;

import com.example.demo2.bean.Student;
import com.example.demo2.service.StudentService;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.hibernate.annotations.common.util.impl.Log_.logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
public class StudenController {
    
	@Autowired
	private StudentService service;

	Logger logger= LoggerFactory.getLogger(StudenController.class);


	@GetMapping("/students")
	public String listStudents(Model model){
    	model.addAttribute("students",service.getAllStudents());
		logger.info("get all the students");
    	return "students";
	}

	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		logger.info("creating a student");
		return "new_student";		
	}

	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student, RedirectAttributes redirectattribute) {
		service.saveStudent(student);
		redirectattribute.addFlashAttribute("message","Student saved successfully");
		logger.info("saving the student");
		return "redirect:/students";
	}
	
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		model.addAttribute("student", service.getStudentById(id));
		logger.info("editing the student");
		return "update_student";
	}

	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id,
		@ModelAttribute("student") Student student, RedirectAttributes redirectattribute,
		Model model) {
		
		// get student from database by id
		Student existingStudent = service.getStudentById(id);
		existingStudent.setId(id);
		existingStudent.setName(student.getName());
		existingStudent.setAge(student.getAge());
		existingStudent.setEmail(student.getEmail());
		
		// save updated student object
		service.updateStudent(id, existingStudent);
		redirectattribute.addFlashAttribute("message","Student updated");
		logger.info("updating the student");
		return "redirect:/students";		
	}
	
	// handler method to handle delete student request
	
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id, RedirectAttributes redirectAttributes) {
		service.deleteStudentById(id);
		redirectAttributes.addFlashAttribute("message","Student deleted");
		logger.info("deleting the student");
		return "redirect:/students";
	}	
}
