package com.musiccamp.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

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
	public Integer findbyelectiveID(String electivenName);

	@Transactional
	@Modifying
	@Query(value="insert into electives(elective_name) values (?1)",nativeQuery=true)
	public Integer InsertnewElective(String newelectiveName);
	
}
