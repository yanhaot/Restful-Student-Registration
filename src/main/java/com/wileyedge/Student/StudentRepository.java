package com.wileyedge.Student;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import org.springframework.data.repository.query.Param;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	
	Optional<Student> findStudentByEmail(String email);	

	@Query(value = "SELECT * FROM students WHERE BINARY sname LIKE BINARY CONCAT('%',:keyword,'%')", nativeQuery = true)
	public List<Student> findAll(@Param("keyword") String keyword);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE Student s SET s.sname = ?2, s.age = ?3, s.mobile = ?4, s.email = ?5, s.address = ?6 WHERE s.id = ?1")
	public void updateById(Long Id, String sname, Integer age, String mobile, String email, String address);
	
	@Query(value = "SELECT * FROM students WHERE BINARY sname LIKE BINARY CONCAT('%',:letter,'%')", nativeQuery = true)
    public List<Student> findByName( @Param("letter") String letter);
}
