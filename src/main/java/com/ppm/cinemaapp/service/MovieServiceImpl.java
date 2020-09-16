package com.ppm.cinemaapp.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ppm.cinemaapp.dto.MessageResponse;
import com.ppm.cinemaapp.model.Movie;
import com.ppm.cinemaapp.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {
	
	@Autowired
	private MovieRepository movieRepository;

	@Override
	public Movie createMovie(Movie movie) {
		return this.movieRepository.saveAndFlush(movie);
	}

	@Override
	public List<Movie> getAllMovies() {
		return this.movieRepository.findAll();
	}

	@Override
	public Movie getMovieById(Integer id) {
		return this.movieRepository.getOne(id);
	}
	
	@Override
	public Movie updateMovie(Movie movie) {
		Movie existingMovie = this.movieRepository.getOne(movie.getId());
		BeanUtils.copyProperties(movie, existingMovie, "id");
		return this.movieRepository.saveAndFlush(existingMovie);
	}

	@Override
	public ResponseEntity<?> deleteMovie(Integer id) {
		this.movieRepository.deleteById(id);
		return ResponseEntity.ok(new MessageResponse("Successfully deleted."));
	}

	@Override
	public List<Movie> findMovieByTitle(String title) {
		title = "%" + title + "%";
		return this.movieRepository.findByTitleLike(title);
	}

}
