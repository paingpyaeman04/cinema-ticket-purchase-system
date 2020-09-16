package com.ppm.cinemaapp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class SeatShowKey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "id", nullable = false)
	private Integer id;

	@Column(name = "show_id", nullable = false)
	private Integer showId;

	public SeatShowKey() {
	}

	public SeatShowKey(Integer id, Integer showId) {
		super();
		this.id = id;
		this.showId = showId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getShowId() {
		return showId;
	}

	public void setShowId(Integer showId) {
		this.showId = showId;
	}

}
