package com.ppm.cinemaapp.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ppm.cinemaapp.dto.JwtResponse;
import com.ppm.cinemaapp.dto.LoginRequest;
import com.ppm.cinemaapp.dto.MessageResponse;
import com.ppm.cinemaapp.dto.RegistrationRequest;
import com.ppm.cinemaapp.jwt.JwtUtils;
import com.ppm.cinemaapp.model.Role;
import com.ppm.cinemaapp.model.User;
import com.ppm.cinemaapp.repository.RoleRepository;
import com.ppm.cinemaapp.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private JwtUtils jwtUtils;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Override
	public JwtResponse authenticateUser(LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		String jwtToken = jwtUtils.generateJwtToken(authentication);
		SecurityContextHolder.getContext().setAuthentication(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

		Set<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toSet());

		return new JwtResponse(userDetails.getFirstName(), userDetails.getLastName(), userDetails.getUsername(),
				jwtToken, roles);
	}

	@Override
	public ResponseEntity<?> registerUser(RegistrationRequest registrationRequest) {
		if (userRepository.existsByUsername(registrationRequest.getUsername())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
		}
		if (!registrationRequest.getPassword().equals(registrationRequest.getMatchingPassword())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Password do not match!"));
		}

		Set<String> strRoles = registrationRequest.getRoles();
		Set<Role> roles = new HashSet<>();

		strRoles.forEach(role -> {
			roles.add(roleRepository.findByName("ROLE_" + role.toUpperCase())
					.orElseThrow(() -> new RuntimeException("Error: Role is not found.")));
		});

		User user = new User(registrationRequest.getFirstName(), registrationRequest.getLastName(),
				registrationRequest.getUsername(), passwordEncoder.encode(registrationRequest.getPassword()), roles);
		userRepository.saveAndFlush(user);

		return ResponseEntity.ok(new MessageResponse("Registration Success."));

	}

	@Override
	public void delete(String username) {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("Not found user with username: " + username));

		userRepository.delete(user);
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("Not found user with username: " + username));
	}

	@Override
	public ResponseEntity<?> update(String username, RegistrationRequest userInfo, HttpServletRequest request) {
		String jwtToken = jwtUtils.parseJwt(request);

		String tokenUsername = jwtUtils.getUsernameFromJwtToken(jwtToken);
		UserDetails tokenUserDetails = userDetailsService.loadUserByUsername(tokenUsername);

		Set<String> tokenRoles = tokenUserDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toSet());

		boolean hasAccessToUpdate = false;
		boolean isAdmin = false;

		if (tokenRoles.contains("ROLE_ADMIN")) {
			hasAccessToUpdate = true;
			isAdmin = true;
		} else if (username.equals(tokenUsername)) {
			hasAccessToUpdate = true;
		}

		Set<Role> userRoles = new HashSet<>();

		userInfo.getRoles().forEach(role -> {
			userRoles.add(roleRepository.findByName("ROLE_"+role)
					.orElseThrow(() -> new RuntimeException("Error: role is not found")));

		});

		User user = new User(userInfo.getFirstName(), userInfo.getLastName(), userInfo.getUsername(),
				passwordEncoder.encode(userInfo.getPassword()), userRoles);

		if (hasAccessToUpdate) {
			User existingUser = userRepository.findByUsername(username)
					.orElseThrow(() -> new UsernameNotFoundException("Not found user with username: " + username));
			BeanUtils.copyProperties(user, existingUser, "id", (!isAdmin ? "roles" : ""));
			return ResponseEntity.ok(userRepository.saveAndFlush(existingUser));
		}

		return ResponseEntity.badRequest().body(new MessageResponse("Error: not allowed to update"));
	}

}
