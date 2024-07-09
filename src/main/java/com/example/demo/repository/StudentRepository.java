package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	@Query("SELECT p FROM Student p WHERE " + 
			 "p.name LIKE CONCAT('%',:query, '%')"
		+ "Or p.email LIKE CONCAT('%', :query, '%')")
List<Student> searchProducts(String query);

}
