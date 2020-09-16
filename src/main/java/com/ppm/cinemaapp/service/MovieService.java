package com.ppm.cinemaapp.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ppm.cinemaapp.model.Movie;

public interface MovieService {
	
	Movie createMovie(Movie movie);
	List<Movie> getAllMovies();
	Movie getMovieById(Integer id);
	Movie updateMovie(Movie movie);
	ResponseEntity<?> deleteMovie(Integer id);
	List<Movie> findMovieByTitle(String title);

}
