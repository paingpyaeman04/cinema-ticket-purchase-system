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

import com.ppm.cinemaapp.model.ShowInfo;
import com.ppm.cinemaapp.service.ShowInfoService;

@RestController
@CrossOrigin("*")
@RequestMapping("show")
public class ShowInfoController {

	@Autowired
	private ShowInfoService showService;

	@PostMapping
	public ShowInfo createShow(@RequestBody ShowInfo show) {
		return this.showService.createShow(show);

	}

	@GetMapping("{id}")
	public ShowInfo getShowById(@PathVariable Integer id) {
		return this.showService.getShowById(id);
	}

	@GetMapping
	public List<ShowInfo> getAllShows() {
		return this.showService.getAllShows();
	}

	@PutMapping
	public ShowInfo updateShow(@RequestBody ShowInfo show) {
		return this.showService.updateShow(show);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteShow(@PathVariable Integer id) {
		return this.showService.deleteShow(id);
	}

}
