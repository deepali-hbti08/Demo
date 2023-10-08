package com.example.demo.exception_handling;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.demo.dao.StudentDao;
import com.example.demo.exception.StudentNotFoundException;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@SpringBootTest
public class StudentExceptionTest {
	
	@Autowired
	StudentService studentService;
	
	@MockBean
	private StudentDao studentDao;
	

	@Test
	public void testTotalRollNoOfStudent() throws SQLException {
		when(studentDao.findallStudents()).thenThrow(SQLException.class);
		assertThrows(StudentNotFoundException.class, () -> studentService.getTotalRollNumOfStudent());
		
	}

}
