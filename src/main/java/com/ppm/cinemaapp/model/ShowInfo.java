package com.ppm.cinemaapp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "showinfo")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class ShowInfo extends Auditable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "start_time")
	private String startTime;

	@Column(name = "start_date")
	private Date startDate;

	@Column(name = "end_date")
	private Date endDate;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "movie_id")
	private Movie movie;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "hall_id")
	private Hall hall;

	public ShowInfo() {
	}

	public ShowInfo(Integer id, String startTime, Date startDate, Date endDate, Movie movie, Hall hall) {
		super();
		this.id = id;
		this.startTime = startTime;
		this.startDate = startDate;
		this.endDate = endDate;
		this.movie = movie;
		this.hall = hall;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Hall getHall() {
		return hall;
	}

	public void setHall(Hall hall) {
		this.hall = hall;
	}

}
