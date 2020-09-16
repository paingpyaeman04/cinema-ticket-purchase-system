package com.ppm.cinemaapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ppm.cinemaapp.model.ShowInfo;

@Repository
public interface ShowInfoRepository extends JpaRepository<ShowInfo, Integer> {

}
