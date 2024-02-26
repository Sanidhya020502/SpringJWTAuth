package com.Authentication.SpringJWT.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Authentication.SpringJWT.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	public User findFirstByEmail(String email);
}
