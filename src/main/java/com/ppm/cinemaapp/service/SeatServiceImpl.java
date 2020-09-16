package com.ppm.cinemaapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ppm.cinemaapp.dto.MessageResponse;
import com.ppm.cinemaapp.model.Seat;
import com.ppm.cinemaapp.model.SeatShowKey;
import com.ppm.cinemaapp.repository.SeatRepository;

@Service
public class SeatServiceImpl implements SeatService {
	
	@Autowired
	private SeatRepository seatRepository;

	@Override
	public Seat createSeat(Seat seat) {
		return this.seatRepository.saveAndFlush(seat);
	}

	@Override
	public List<Seat> getAllSeats() {
		return this.seatRepository.findAll();
	}

	@Override
	public Seat updateSeat(Seat seat) {
		SeatShowKey key = new SeatShowKey(seat.getKey().getId(), seat.getKey().getShowId());
		return this.seatRepository.getOne(key);
	}

	@Override
	public ResponseEntity<?> deleteSeat(SeatShowKey key) {
		this.seatRepository.deleteById(key);
		return ResponseEntity.ok(new MessageResponse("Successfully deleted."));
		
	}

}
