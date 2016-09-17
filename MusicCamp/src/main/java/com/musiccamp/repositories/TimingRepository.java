package com.musiccamp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.musiccamp.entities.Timings;

public interface TimingRepository extends JpaRepository<Timings, Integer> {

}
