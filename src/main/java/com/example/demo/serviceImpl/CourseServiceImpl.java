package com.example.demo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CourseDao;
import com.example.demo.model.Course;
import com.example.demo.model.Employee;
import com.example.demo.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService{
	
	@Autowired
	CourseDao courseDao;
	
	public void saveCourse() {
		Course c = new Course(1, "MCA");
		Employee e1 = new Employee("ram",1,"Noida");
		Employee e2 = new Employee("daya",2,"Delhi");
		
//		c.getEmployeeList().add(e1);
//		c.getEmployeeList().add(e2);
		courseDao.save(c);
	}

}
