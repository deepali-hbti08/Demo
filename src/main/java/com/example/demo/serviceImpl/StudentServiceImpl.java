package com.example.demo.serviceImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.StudentDao;
import com.example.demo.exception.StudentExceptionEnum;
import com.example.demo.exception.StudentNotFoundException;
import com.example.demo.model.ResultObject;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDao studentDao;

	public Student saveStudent(Student std) {
		System.out.println("******save student****");
		Student student = studentDao.save(std);
		return student;
	}

	@Override
	public List<Student> getAllStudent() throws RuntimeException {
		List<Student> studentList = studentDao.findAll();
		try {
			String s = null;
			s.toString();
			if (studentList.isEmpty()) {
				throw new StudentNotFoundException("123", "Student not found");
			}
			return studentList;
		} catch (NullPointerException e) {
			// TODO: handle exception
			System.out.println("******Null pointer Exception in catch******");
			throw e;
		}
//		return new ArrayList<Student>();
	}

	@Override
	public Student getStudentById(Integer id) {
		Optional<Student> studentOpt = studentDao.findById(id);
		if (!studentOpt.isPresent()) {
			System.out.println("STUDENT NOT FOUND!!!!");
			throw new StudentNotFoundException("123", "Student not found");
			// throw new StudentNotFoundException("Student with id : " + id + " doesn't
			// exist.");
		}
		return studentOpt.get();
	}

	@Override
	public void deleteStudent(int id) {
		Student studentOpt = studentDao.findById(id)
				.orElseThrow(() -> new StudentNotFoundException(StudentExceptionEnum.STU_001));
		/*
		 * if (!studentOpt.isPresent()) { throw new
		 * StudentNotFoundException("Student with id : " + id + " doesn't exist."); }
		 */
		studentDao.delete(studentOpt);
	}

	@Override
	public Student updateStudent(Student student) {
//		Optional<Student> studentOpt = studentDao.findById(student.getId());
		Student studentOpt = studentDao.findById(student.getId())
				.orElseThrow(() -> new StudentNotFoundException(StudentExceptionEnum.STU_001));
//		studentOpt.get().setName(student.getName());
//		studentOpt.get().setAddress(student.getAddress());
//		studentOpt.get().setRollNo(student.getRollNo());
//		return studentDao.save(studentOpt.get());
		studentOpt.setName(student.getName());
		studentOpt.setAddress(student.getAddress());
		studentOpt.setRollNo(student.getRollNo());
		return studentDao.save(studentOpt);
	}

	@Override
	public double add(double d1, double d2) {
		// TODO Auto-generated method stub
		return d1+d2;
	}

	@Override
	public int getTotalRollNumOfStudent() {
		List<Student> std = null;
		try {
			std = studentDao.findallStudents();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new StudentNotFoundException("unable to read from data base due to --->"+e.getMessage());
		}
		int totalNo = 0;
		for(Student stds : std) {
			totalNo = totalNo+stds.getRollNo();
		}
		return totalNo;
	}

}
