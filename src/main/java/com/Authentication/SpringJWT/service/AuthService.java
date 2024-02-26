package com.Authentication.SpringJWT.service;


import com.Authentication.SpringJWT.dtos.SignupRequest;
import com.Authentication.SpringJWT.dtos.UserDTO;


public interface AuthService {
	
	UserDTO createUser(SignupRequest signupRequest);

}
