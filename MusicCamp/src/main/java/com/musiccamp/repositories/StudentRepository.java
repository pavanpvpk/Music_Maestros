package com.musiccamp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.musiccamp.entities.Student;

/**
 * 
 * @author Manasa Bojja
 *
 **/
public interface StudentRepository extends JpaRepository<Student, Integer>{

}
