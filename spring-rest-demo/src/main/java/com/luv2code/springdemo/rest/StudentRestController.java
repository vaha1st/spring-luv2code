package com.luv2code.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student> theStudents;

	// define @PosConstruct to populate student list
	@PostConstruct
	public void loadData() {

		theStudents = new ArrayList<>();

		theStudents.add(new Student("Watson", "Cat"));
		theStudents.add(new Student("Ksyu", "Girl"));
		theStudents.add(new Student("Ruslan", "Boy"));
	}

	// define endpoint for /students
	@GetMapping("/students")
	public List<Student> students() {

		return theStudents;
	}

	// define endpoint for /students/{studentId}
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {

		// check the studentId against the list size
		if (studentId > theStudents.size() || studentId < 0) {
			throw new StudentNotFoundException("Student ID not found - " + studentId);
		}
		return theStudents.get(studentId);
	}

	
}
