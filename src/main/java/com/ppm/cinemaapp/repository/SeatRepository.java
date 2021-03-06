package com.ppm.cinemaapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ppm.cinemaapp.model.Seat;
import com.ppm.cinemaapp.model.SeatShowKey;

@Repository
public interface SeatRepository extends JpaRepository<Seat, SeatShowKey> {

}
