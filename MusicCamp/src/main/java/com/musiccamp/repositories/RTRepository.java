package com.musiccamp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.musiccamp.entities.RoomTimings;

public interface RTRepository extends JpaRepository<RoomTimings, Integer> {

}
