package com.musiccamp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.musiccamp.entities.Electives;

public interface ElectiveRepository extends JpaRepository<Electives, Integer> {

}
