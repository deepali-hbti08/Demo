package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "course_id")
	private Integer id;
	
	@Column(name = "course")
	private String course;
	
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name = "pc_fid", referencedColumnName = "id")
//     List<Employee> employeeList = new ArrayList<>();
	
	public Course() {
		
	}
	
	public Course( Integer id,String course) {
		super();
		this.course = course;
		this.id = id;
	}

//	public List<Employee> getEmployeeList() {
//		return employeeList;
//	}
//
//	public void setEmployeeList(List<Employee> employeeList) {
//		this.employeeList = employeeList;
//	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	
}
