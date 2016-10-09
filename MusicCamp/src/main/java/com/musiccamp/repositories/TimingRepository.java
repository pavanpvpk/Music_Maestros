package com.musiccamp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.musiccamp.entities.Timings;

public interface TimingRepository extends JpaRepository<Timings, Integer>  {
	

	@Query(value="select timeSlot from Timings")
	List<Timings> findOnlyTimings();
	
}
