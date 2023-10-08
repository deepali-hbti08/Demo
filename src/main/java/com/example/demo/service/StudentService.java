package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.ResultObject;
import com.example.demo.model.Student;


public interface StudentService {
	
	public Student saveStudent(Student std);

	List<Student> getAllStudent() ;
	
	Student getStudentById(Integer id);
	
	void deleteStudent(int id);
	
	Student updateStudent(Student student);
	
	double add(double d1, double d2);
	
	public int getTotalRollNumOfStudent();
}
