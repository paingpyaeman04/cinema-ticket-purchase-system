package com.ppm.cinemaapp.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ppm.cinemaapp.dto.MessageResponse;
import com.ppm.cinemaapp.model.ShowInfo;
import com.ppm.cinemaapp.repository.ShowInfoRepository;

@Service
public class ShowInfoServiceImpl implements ShowInfoService {

	@Autowired
	private ShowInfoRepository showRepository;

	@Override
	public ShowInfo createShow(ShowInfo show) {
		return this.showRepository.saveAndFlush(show);
	}

	@Override
	public ShowInfo getShowById(Integer id) {
		return this.showRepository.getOne(id);
	}

	@Override
	public List<ShowInfo> getAllShows() {
		return this.showRepository.findAll();
	}

	@Override
	public ShowInfo updateShow(ShowInfo show) {
		ShowInfo existingShow = this.showRepository.getOne(show.getId());
		BeanUtils.copyProperties(show, existingShow, "id");
		return this.showRepository.saveAndFlush(existingShow);
	}

	@Override
	public ResponseEntity<?> deleteShow(Integer id) {
		this.showRepository.deleteById(id);
		return ResponseEntity.ok(new MessageResponse("Successfully deleted."));
	}

}
