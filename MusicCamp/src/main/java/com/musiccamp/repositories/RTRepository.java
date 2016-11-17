package com.musiccamp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.musiccamp.entities.Room;
import com.musiccamp.entities.RoomTimings;
import com.musiccamp.entities.Timings;

/**
 * 
 * @author Pavan Kumar Pedda Vakkalam
 *
 **/
public interface RTRepository extends JpaRepository<RoomTimings, Integer> {
	
	
	@Query(value="select rt.rt_id from room_timings rt where rt.room_id=?1 and "
			+ "rt.time_id=?2 ",nativeQuery=true)
	public int findrtID(int roomID,int timeId);
	
	
	

}
