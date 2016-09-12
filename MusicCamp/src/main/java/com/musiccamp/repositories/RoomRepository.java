package com.musiccamp.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.musiccamp.entities.Room;


@Repository
public interface RoomRepository extends JpaRepository<Room,String> {
	
	

}
