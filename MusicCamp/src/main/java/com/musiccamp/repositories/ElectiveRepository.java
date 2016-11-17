package com.musiccamp.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.musiccamp.entities.Electives;
import java.lang.Integer;
import java.util.List;


/**
 * 
 * @author Pavan Kumar Pedda Vakkalam
 *
 **/
public interface ElectiveRepository extends JpaRepository<Electives, Integer> {
	

	@Query(value="select e.electiveId from Electives e where e.electiveName=?1")
	public int findbyelectiveID(String electivenName);

}
