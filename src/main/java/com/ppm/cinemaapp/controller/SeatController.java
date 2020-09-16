package com.ppm.cinemaapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ppm.cinemaapp.dto.MessageResponse;
import com.ppm.cinemaapp.model.Seat;
import com.ppm.cinemaapp.model.SeatShowKey;
import com.ppm.cinemaapp.service.SeatService;

@RestController
@CrossOrigin("*")
@RequestMapping("seat")
public class SeatController {

	@Autowired
	private SeatService seatService;

	@PostMapping
	public Seat createSeat(@RequestBody Seat seat) {
		return this.seatService.createSeat(seat);
	}

	@GetMapping
	public List<Seat> getAllSeats() {
		return this.seatService.getAllSeats();
	}

	@PutMapping
	public Seat updateSeat(@RequestBody Seat seat) {
		return this.seatService.updateSeat(seat);
	}

	@DeleteMapping
	public ResponseEntity<?> deleteSeat(@RequestBody SeatShowKey key) {
		this.seatService.deleteSeat(key);
		return ResponseEntity.ok(new MessageResponse("Successfully deleted"));
	}

}
