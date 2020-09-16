package com.ppm.cinemaapp.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ppm.cinemaapp.model.Hall;

public interface HallService {
	
	Hall createHall(Hall hall);
	Hall getHallById(Integer id);
	List<Hall> getAllHalls();
	Hall updateHall(Hall hall);
	ResponseEntity<?> deleteHall(Integer id);

}
