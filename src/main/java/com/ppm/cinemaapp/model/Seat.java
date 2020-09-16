package com.ppm.cinemaapp.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "seat")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Seat extends Auditable {

	@EmbeddedId
	private SeatShowKey key;

	private String name;

	private Boolean availability;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	public Seat() {
	}

	public Seat(SeatShowKey key, String name, Boolean availability, User user) {
		super();
		this.key = key;
		this.name = name;
		this.availability = availability;
		this.user = user;
	}

	public SeatShowKey getKey() {
		return key;
	}

	public void setKey(SeatShowKey key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getAvailability() {
		return availability;
	}

	public void setAvailability(Boolean availability) {
		this.availability = availability;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
