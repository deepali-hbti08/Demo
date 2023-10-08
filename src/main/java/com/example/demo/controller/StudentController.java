package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.StudentNotFoundException;
import com.example.demo.model.Student;
import com.example.demo.service.CourseService;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentService studentService;
	
//	@Autowired
//	CourseService courseService;

	@ResponseBody
	@PostMapping(value = "/saveStudent", headers = { "Content-type=application/json" })
	public Student addStudent(@Valid @RequestBody Student std) {
		return studentService.saveStudent(std);
	}

	@ResponseBody
	@GetMapping("/getAllStudent")
	public List<Student> getAllStudent() {
//		List<Student> studentList = new ArrayList<Student>();
		try {
			return studentService.getAllStudent();
		}catch (NullPointerException e) {
			System.out.println("*Null Pointer Exception in controller***");
			throw e;
		}
//		return new ArrayList<Student>();
	}

	@ResponseBody
	@GetMapping("/getstudent/{studentId}")
	public Student getStudentById(@PathVariable int studentId) {
		return studentService.getStudentById(studentId);
	}

	@ResponseBody
	@PostMapping("/updateStudent")
	public ResponseEntity<Object> updateStudent(@RequestBody Student student) {
		return ResponseEntity.status(HttpStatus.OK).body(studentService.updateStudent(student));
	}

	@ResponseBody
	@DeleteMapping("/deleteStudent/{studentId}")
	public ResponseEntity<Object> deleteStudent(HttpServletResponse res, @PathVariable int studentId) {
		studentService.deleteStudent(studentId);
		return ResponseEntity.status(HttpStatus.OK).body("Student deleted");
	}
	
//	@ResponseBody
//	@PostMapping("/saveCourse")
//	public void saveCourse() {
//		courseService.saveCourse();
////		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("student deleted.");
//	}

}
