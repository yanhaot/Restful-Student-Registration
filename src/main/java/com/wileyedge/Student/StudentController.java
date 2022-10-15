package com.wileyedge.Student;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	public StudentController() {
		System.out.println("Inside default constructor of StudentController class");
	}
	
//	@GetMapping(value = "/students")
//	public ResponseEntity<List<Student>> displayAllStudents() {
//		System.out.println("Inside retrieveAllUser method of displayAllStudents class");
//		List<Student> studentList = studentService.getAllStudents();
//		return new ResponseEntity<>(studentList, HttpStatus.OK);
//	}
	
	@GetMapping(value = "/students")
	public ModelAndView displayFilterStudents(@Param("keyword") String keyword) {
		System.out.println("Inside displayAllStudents method of StudentController class");
		
		List<Student> studentList = studentService.getAllStudents(keyword);

		ModelAndView mav = new ModelAndView("index");
		mav.addObject("students", studentList);
		
		return mav;
	}
	
//	@GetMapping(value = "/students")
//	public String displayAllStudents(Model model) {
//		System.out.println("Inside retrieveAllUser method of displayAllStudents class");
//		List<Student> studentList = studentService.generalGetAllStudent();
//		model.addAttribute("students", studentList);
//		return "index";
//	}
	
	@GetMapping(path = "/students/{id}")
	public ResponseEntity<Student> retrieveUser(@PathVariable Long id) {
		System.out.println("Inside retrieveUser method of UserResource class");
		Student stud = studentService.getOneStudent(id);
		if(stud == null) {
			System.out.println("Custom exception is thrown");
			throw new UserNotFoundException("Invalid Id has been entered: " + id);
		}
		System.out.println("RESULT: " + stud);
		return new ResponseEntity<>(stud, HttpStatus.OK);
	}
	
	@PostMapping(value = "/students") 
	public ResponseEntity<Student> registerNewStudent(@Valid @RequestBody Student student, BindingResult result) {
		System.out.println("Inside retrieveAllUser method of StudentController class");
		return new ResponseEntity<Student>(studentService.addNewStudent(student), HttpStatus.CREATED);
	}
	
	@DeleteMapping(path = "/students/{id}")
	public void deleteUser(@PathVariable Long id) {
		
		System.out.println("Inside deleteUser method of StudentController class");
		studentService.deleteStudent(id);
		
	}
	
	
	@GetMapping(path = "/students/name/{name}")
	public List<Student> getUsersbyName(@RequestBody @PathVariable String name){
		
		System.out.println("Inside getUsersbyName method of StudentController class");
		List<Student> userList = studentService.findUserByName(name);
		System.out.println("RESULT: " + userList);
		return userList;
		
	}
	
	@PutMapping(path = "/students/{id}")
	public void updateStudent(@PathVariable Long id, @RequestBody Student student) {
		System.out.println("Inside updateStudent method of StudentController class");
		studentService.updateExistingStudent(student);
	}
	
}
