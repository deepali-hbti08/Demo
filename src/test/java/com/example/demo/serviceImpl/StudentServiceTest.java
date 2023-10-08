package com.example.demo.serviceImpl;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.demo.dao.StudentDao;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@SpringBootTest
public class StudentServiceTest {
	
	@Autowired
	StudentService studentService;
	
	@MockBean
	private StudentDao studentDao;
	
	@BeforeEach
	void setup() {
		Optional<Student> student = Optional.of(new Student(1, "abc", 100, "dlh"));
		Mockito.when(studentDao.findById(1)).thenReturn(student);
	}

	@Test
	public void testGetStudentById() {
		String student_name = "abc";
		Student student = studentService.getStudentById(1);
		assertEquals(student_name, student.getName());
	}

}
