package com.musiccamp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.musiccamp.entities.Room;

/**
 * 
 * @author Pavan Kumar Pedda Vakkalam
 *
 **/
public interface RoomRepository extends JpaRepository<Room, Integer> {

	
	@Query(value="select distinct(r.roomName) from Room r")
	List<String> findbyRoomName();
	
}
