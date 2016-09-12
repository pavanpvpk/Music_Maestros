package com.musiccamp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.musiccamp.entities.Elective;;

@Repository
public interface CourseRepository extends JpaRepository<Elective,String> {
    
	
}
