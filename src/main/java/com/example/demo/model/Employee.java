package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.example.demo.model.Course;

@Table(name="employee")
@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@NotBlank(message = "Please add employee name.")
	@Column(name = "name")
	private String name;

	@Column(name = "emp_code")
	private Integer rollNo;

	@Column(name = "address")
	private String address;
	
//	@ManyToOne
//    @JoinColumn(name ="course_id", nullable = false)
//    private Course course;
	
	public Employee() {
		
	}

	public Employee(@NotBlank(message = "Please add employee name.") String name, Integer rollNo, String address) {
		super();
		this.name = name;
		this.rollNo = rollNo;
		this.address = address;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRollNo() {
		return rollNo;
	}

	public void setRollNo(Integer rollNo) {
		this.rollNo = rollNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

//	public Course getCourse() {
//		return course;
//	}
//
//	public void setCourse(Course course) {
//		this.course = course;
//	}

}
