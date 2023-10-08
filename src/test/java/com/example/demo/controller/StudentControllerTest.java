package com.example.demo.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@WebMvcTest
public class StudentControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	StudentService studentService;
	
	private Student student;
	
	@BeforeEach
	void setup() {
		student = new Student(3,"fbc", 4, "Gurgaon");
	}
	
	@Test
	void testSaveStudent() throws Exception {
		Student studentEntity = new Student(4, "vghghg", 4, "Gurgaon");
		Mockito.when(studentService.saveStudent(studentEntity)).thenReturn(student);
		mockMvc.perform(MockMvcRequestBuilders.post("/student/saveStudent/")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\r\n" + 
						"  \"id\": 4,\r\n" + 
						"  \"name\": \"hghgh\",\r\n" + 
						"  \"rollNo\": 4,\r\n" + 
						"  \"address\": \"Gurgaon\"\r\n" + 
						"}"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	

}
