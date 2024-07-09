package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/api/students")
public class StudentController {
	@Autowired
	private StudentService studentService;

	// http://localhost:8082/api/student
	@PostMapping()
	public ResponseEntity<Student> saveEmployee(@RequestBody Student student) {
		return new ResponseEntity<Student>(studentService.saveStudent(student), HttpStatus.CREATED);
	}

	// http://localhost:8082/api/student
	@GetMapping
	public List<Student> getAllEmployees() {
		return studentService.getAllStudents();
	}

	// http://localhost:8082/api/student/1
	@GetMapping("{id}")
	public ResponseEntity<Student> getEmployeeById(@PathVariable("id") long id) {
		return new ResponseEntity<Student>(studentService.getStudentById(id), HttpStatus.OK);
	}

	// http://localhost:8082/api/student/1
	@PutMapping("{id}")
	public ResponseEntity<Student> updateEmployee(@PathVariable("id") long id, @RequestBody Student student) {
		return new ResponseEntity<Student>(studentService.updateStudent(student, id), HttpStatus.OK);
	}

	// http://localhost:8082/api/student/1
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable("id") long id) {
		studentService.deleteStudent(id);
		return new ResponseEntity<String>("sucessfully deleted", HttpStatus.OK);
	}

	@GetMapping("/search")
	public ResponseEntity<List<Student>> serchMobiles(String query) {
		return ResponseEntity.ok(studentService.serachMobiles(query));
	}

}
