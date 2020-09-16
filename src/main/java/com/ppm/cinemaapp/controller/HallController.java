package com.ppm.cinemaapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ppm.cinemaapp.model.Hall;
import com.ppm.cinemaapp.service.HallService;

@RestController
@CrossOrigin("*")
@RequestMapping("hall")
public class HallController {
	
	@Autowired
	private HallService hallService;
	
	@PostMapping
	public Hall createHall(@RequestBody Hall hall) {
		return this.hallService.createHall(hall);
	}
	
	@GetMapping("{id}")
	public Hall getHallById(@PathVariable Integer id) {
		return this.hallService.getHallById(id);
	}
	
	@GetMapping
	public List<Hall> getAllHalls() {
		return this.hallService.getAllHalls();
	}
	
	@PutMapping
	public Hall updateHall(@RequestBody Hall hall) {
		return this.hallService.updateHall(hall);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteHall(@PathVariable Integer id) {
		return this.hallService.deleteHall(id);
	}
	
}

