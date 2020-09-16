package com.ppm.cinemaapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ppm.cinemaapp.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
	
	List<Movie> findByTitleLike(String title);

}
