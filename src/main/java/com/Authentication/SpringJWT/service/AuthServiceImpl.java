package com.Authentication.SpringJWT.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.Authentication.SpringJWT.dtos.SignupRequest;
import com.Authentication.SpringJWT.dtos.UserDTO;
import com.Authentication.SpringJWT.model.User;
import com.Authentication.SpringJWT.repository.UserRepository;

@Service
public class AuthServiceImpl implements AuthService{

	@Autowired
	private UserRepository userRepo;

	@Override
	public UserDTO createUser(SignupRequest signupRequest) {
		User user = new User();
		user.setEmail(signupRequest.getEmail());
		user.setName(signupRequest.getName());
		user.setPhone(signupRequest.getPhone());
		user.setPassword(new BCryptPasswordEncoder().encode(signupRequest.getPassword()));
		User createdUser = userRepo.save(user);
		UserDTO userDTO = new UserDTO();
		userDTO.setId(createdUser.getId());
		userDTO.setEmail(createdUser.getEmail());
		userDTO.setName(createdUser.getName());
		userDTO.setPhone(createdUser.getPhone());
		return userDTO;
		
		
	}
}
