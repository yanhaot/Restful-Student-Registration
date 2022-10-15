package com.wileyedge.Student;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity(name = "Student")
@Table(name = "students")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(
			name = "id",
			updatable = false
	 )
	private Long Id;
	
	@Column(name= "sname")
	@Size(min = 3 , message= "Name must consist of at least 3 chars")
	private String sname;
	
	@Column(name= "age")
	private Integer age;
	
	@Column(name= "mobile")
	@Size(min = 8 , message= "Number must consist of at least 8 chars")
	private String mobile;
	
	@Column(
			name= "email",
			nullable = false
	)
//	@NotBlank(message = "Please enter your email")
//	@Pattern(regexp = "^(.+)@(\\S+) $", message = "Invalid email ahs been entered")
	private String email;
	
	@Column(name= "address")
	private String address;
	
	public Student() {
		System.out.println("Student default constructor");
	}
	
	public Student(String sname, Integer age, String mobile, String email, String address) {
		super();
		this.sname = sname;
		this.age = age;
		this.mobile = mobile;
		this.email = email;
		this.address = address;
	}
	
	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public Integer getAge() {
		return age;
	}
	
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}
	
	
}
