package com.wileyedge.Student;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	
	public StudentService() {
		System.out.println("Inside default constructor of StudentService class");
	}
	
	public Student getOneStudent(Long id) {
		System.out.println("Inside getOneUser method of StudentService class");
		Optional<Student> student = studentRepository.findById(id);
		if(student.isPresent()) {
			return student.get();
		} 
		else {
			return null;
		}
	}
	
	public List<Student> getAllStudents(String keyword){
		System.out.println("Inside getAllStudents constructor of StudentService class");
		if (keyword != null) {
			return studentRepository.findAll(keyword);
		}
		return studentRepository.findAll();
	}
	
	public Student addNewStudent(Student student) {
		return studentRepository.save(student);
	}
	
	public void deleteStudent(Long id) {
		studentRepository.deleteById(id);
	}
	
	public List<Student> findUserByName(String name) {
		System.out.println("Inside findUserByName method of UserService class");
		return studentRepository.findByName(name);
	}
	
	@Transactional
	public void updateExistingStudent(Student student){
		System.out.println("Inside updateExistingStudent method of StudentService class");
		Long id = student.getId();
		String name = student.getSname();
		Integer age = student.getAge();
		String mobile = student.getMobile();
		String email = student.getEmail();
		String address = student.getAddress();

		studentRepository.updateById(
				id, 
				name, 
				age, 
				mobile, 
				email, 
				address
		);	
		
	} // End of updateStudent
}
