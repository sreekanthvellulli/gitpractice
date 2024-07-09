package com.example.demo.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student getStudentById(long id) {
		Optional<Student> optionalEmployee = studentRepository.findById(id);
		return optionalEmployee.get();
	}

	@Override
	public Student updateStudent(Student student, long id) {
		Student st = studentRepository.findById(id).get();
		st.setName(student.getName());
		st.setEmail(student.getEmail());
		st.setAge(student.getAge());
		studentRepository.save(st);
		return st;
	}

	@Override
	public void deleteStudent(long id) {
		studentRepository.findById(id).get();
		studentRepository.deleteById(id);
	}

	@Override
	public List<Student> serachMobiles(String query) {
		List<Student> students = studentRepository.searchProducts(query);
		return students;
	}
}
