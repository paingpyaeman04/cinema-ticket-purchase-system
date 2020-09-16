package com.ppm.cinemaapp.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;

import com.ppm.cinemaapp.dto.JwtResponse;
import com.ppm.cinemaapp.dto.LoginRequest;
import com.ppm.cinemaapp.dto.RegistrationRequest;
import com.ppm.cinemaapp.model.User;

public interface UserService {
	
	JwtResponse authenticateUser(LoginRequest loginRequest);
	
	ResponseEntity<?> registerUser(RegistrationRequest registrationRequest);
	
	void delete(String username);
	
	List<User> getAllUser();
	
	User findByUsername(String username);
	
	ResponseEntity<?> update(String username, RegistrationRequest user, HttpServletRequest request);

}
