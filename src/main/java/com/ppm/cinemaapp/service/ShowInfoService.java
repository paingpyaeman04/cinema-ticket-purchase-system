package com.ppm.cinemaapp.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ppm.cinemaapp.model.ShowInfo;

public interface ShowInfoService {
	
	ShowInfo createShow(ShowInfo show);
	List<ShowInfo> getAllShows();
	ShowInfo getShowById(Integer id);
	ShowInfo updateShow(ShowInfo show);
	ResponseEntity<?> deleteShow(Integer id);

}
