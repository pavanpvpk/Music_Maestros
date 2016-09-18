package com.musiccamp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.musiccamp.entities.RoomTimings;
import com.musiccamp.entities.RoomTimingsId;

public interface RoomTimingsRepository extends JpaRepository<RoomTimings, RoomTimingsId>{

	
}
