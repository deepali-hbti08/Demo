package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Table(name="student")
@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@NotBlank(message = "Please add student name.")
	@Column(name = "name")
	private String name;

	@Column(name = "roll_num")
	private Integer rollNo;

	@Column(name = "address")
	private String address;

	public Student() {

	}

	public Student(String name, Integer rollNo, String address) {
		this.name = name;
		this.rollNo = rollNo;
		this.address = address;
	}

	
	public Student(Integer id, @NotBlank(message = "Please add student name.") String name, Integer rollNo,
			String address) {
		this.id = id;
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

	@Override
	public String toString() {
		return "StudentEntity [id=" + id + ", name=" + name + ", rollNo=" + rollNo + ", address=" + address + "]";
	}

}
