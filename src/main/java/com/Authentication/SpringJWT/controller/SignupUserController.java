package com.Authentication.SpringJWT.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Authentication.SpringJWT.dtos.SignupRequest;
import com.Authentication.SpringJWT.dtos.UserDTO;
import com.Authentication.SpringJWT.service.AuthService;

@RestController
public class SignupUserController {
	
	 @Autowired
	  private AuthService authService;

	    @PostMapping("/sign-up")
	    public ResponseEntity<?> signupUser(@RequestBody SignupRequest signupRequest) {
	       UserDTO createdUser = authService.createUser(signupRequest);
	       if (createdUser == null){
	           return new ResponseEntity<>("User not created, come again later!", HttpStatus.BAD_REQUEST);
	       }
	       return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
	    }


}
