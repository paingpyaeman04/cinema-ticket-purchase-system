package com.ppm.cinemaapp.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ppm.cinemaapp.dto.MessageResponse;
import com.ppm.cinemaapp.model.Hall;
import com.ppm.cinemaapp.repository.HallRepository;

@Service
public class HallServiceImpl implements HallService {
	
	@Autowired
	private HallRepository hallRepository;

	@Override
	public Hall createHall(Hall hall) {
		return this.hallRepository.saveAndFlush(hall);
	}

	@Override
	public Hall getHallById(Integer id) {
		return this.hallRepository.getOne(id);
	}

	@Override
	public List<Hall> getAllHalls() {
		return this.hallRepository.findAll();
	}

	@Override
	public Hall updateHall(Hall hall) {
		Hall existingHall = this.hallRepository.getOne(hall.getId());
		BeanUtils.copyProperties(hall, existingHall, "id");
		return this.hallRepository.saveAndFlush(existingHall);
	}

	@Override
	public ResponseEntity<?> deleteHall(Integer id) {
		this.hallRepository.deleteById(id);
		return ResponseEntity.ok(new MessageResponse("Successfully deleted."));
	}

}
