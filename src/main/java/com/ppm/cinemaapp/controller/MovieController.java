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

import com.ppm.cinemaapp.model.Movie;
import com.ppm.cinemaapp.service.MovieService;

@RestController
@CrossOrigin("*")
@RequestMapping("movie")
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	@PostMapping
	public Movie createMovie(@RequestBody Movie movie) {
		return this.movieService.createMovie(movie);
	}
	
	@GetMapping("{id}")
	public Movie getMovieById(@PathVariable Integer id) {
		return this.movieService.getMovieById(id);
	}
	
	@GetMapping
	public List<Movie> getAllMoives() {
		return this.movieService.getAllMovies();
	}
	
	@GetMapping("/title/{title}")
	public List<Movie> findMovieByTitle(@PathVariable String title) {
		return this.movieService.findMovieByTitle(title);
	}
	
	@PutMapping
	public Movie updateMovie(@RequestBody Movie movie) {
		return this.movieService.updateMovie(movie);
		
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteMovie(@PathVariable Integer id) {
		return this.movieService.deleteMovie(id);
	}

}
