package com.ppm.cinemaapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ppm.cinemaapp.model.Hall;

@Repository
public interface HallRepository extends JpaRepository<Hall, Integer>{

}
