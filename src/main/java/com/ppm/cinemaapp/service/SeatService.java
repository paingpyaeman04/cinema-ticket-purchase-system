package com.ppm.cinemaapp.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ppm.cinemaapp.model.Seat;
import com.ppm.cinemaapp.model.SeatShowKey;

public interface SeatService {
	
	Seat createSeat(Seat seat);
	List<Seat> getAllSeats();
	Seat updateSeat(Seat seat);
	ResponseEntity<?> deleteSeat(SeatShowKey key);

}
