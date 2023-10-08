package com.example.demo.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import static org.junit.jupiter.api.Assertions.*;

import com.example.demo.model.Student;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class StudentDaoTest {
	
	@Autowired
	private StudentDao studentDao;

	@Autowired
	private TestEntityManager entityManager;

	@BeforeEach
	void setup() {
		Student studentEntity = new Student("abc", 4, "dlh");
		entityManager.persist(studentEntity);
	}

	@Test
	public void findByStudentId() {
		Student student = studentDao.findById(4).get();
		assertEquals("abc", student.getName());
	}

}
