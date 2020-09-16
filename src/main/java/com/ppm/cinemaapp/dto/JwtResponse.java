package com.ppm.cinemaapp.dto;

import java.util.Set;

public class JwtResponse {
	
	private String firstName;
	
	private String lastName;
	
	private String username;
	
	private String jwtToken;
	
	private String type = "Bearer";
	
	private Set<String> roles;

	public JwtResponse(String firstName, String lastName, String username, String jwtToken, Set<String> roles) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.jwtToken = jwtToken;
		this.roles = roles;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getJwtToken() {
		return jwtToken;
	}

	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}

	public Set<String> getRoles() {
		return roles;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
