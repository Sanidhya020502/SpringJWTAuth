package com.Authentication.SpringJWT.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.Authentication.SpringJWT.filter.JwtRequestFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfiguration {
	
	@Autowired
	private JwtRequestFilter requestFilter;
	

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
//		return httpSecurity.csrf().disable()
//				.authorizeHttpRequests()
//				.requestMatchers("/register").permitAll()
//				.and()
//				.authorizeHttpRequests().requestMatchers("/api/**")
//				.authenticated().and()
//				.sessionManagement()
//				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//				.and().build();
		  http.csrf(csrf -> csrf.disable())
  		.cors(cors->cors.disable())
  		.authorizeHttpRequests(auth->auth.requestMatchers("/api/**").authenticated()
  				.requestMatchers("/sign-up","/authentication").permitAll()
  				.anyRequest().authenticated())
  		.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
  		.addFilterBefore(requestFilter, UsernamePasswordAuthenticationFilter.class)
         ;
  return http.build();
	}
	
	@Bean
	public AuthenticationManager authenticatoinManager(AuthenticationConfiguration configuration) throws Exception {
		return configuration.getAuthenticationManager();
	}
}
