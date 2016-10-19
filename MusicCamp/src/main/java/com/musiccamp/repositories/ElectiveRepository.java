package com.musiccamp.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.musiccamp.entities.Electives;


/**
 * 
 * @author Pavan Kumar Pedda Vakkalam
 *
 **/
public interface ElectiveRepository extends JpaRepository<Electives, Integer> {
	
	

}
