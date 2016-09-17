package com.musiccamp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.musiccamp.entities.Room;

public interface RoomRepository extends JpaRepository<Room, Integer> {

}
