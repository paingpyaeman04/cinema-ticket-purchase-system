package com.ppm.cinemaapp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Embeddable
public class SeatShowKey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "id", nullable = false)
	private Integer id;

	@OneToOne
	@JoinColumn(name = "show_id")
	private ShowInfo show;

	public SeatShowKey() {
	}

	public SeatShowKey(Integer id, ShowInfo show) {
		super();
		this.id = id;
		this.show = show;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ShowInfo getShow() {
		return show;
	}

	public void setShow(ShowInfo show) {
		this.show = show;
	}

}
