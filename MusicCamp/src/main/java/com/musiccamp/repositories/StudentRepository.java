package com.musiccamp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.musiccamp.entities.Student;

/**
 * 
 * @author Manasa Bojja
 *
 **/
public interface StudentRepository extends JpaRepository<Student, Integer>{

	@Query("select s from Student s where s.studentId = ?1")
    Student find(Integer studentId);
	
	
	
	
}
