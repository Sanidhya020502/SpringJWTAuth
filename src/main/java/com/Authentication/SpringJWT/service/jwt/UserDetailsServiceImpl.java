package com.Authentication.SpringJWT.service.jwt;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Authentication.SpringJWT.model.User;
import com.Authentication.SpringJWT.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	//UserDetailsService interface comes under spring security

	@Autowired
	private UserRepository userRepo;
	
	//to get user from DB
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepo.findFirstByEmail(email);
		if(user==null) {
			throw new UsernameNotFoundException("User not found",null);
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), new ArrayList<>());
	}
	
	
}
