package com.Authentication.SpringJWT.dtos;

public class SignupRequest {

	private String name;
	
	private String email;
	
	private String password;
	
	private String phone;
	
	

	

	@Override
	public String toString() {
		return "SignupRequest [name=" + name + ", email=" + email + ", password=" + password + ", phone=" + phone + "]";
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public SignupRequest() {
		super();
	}

	public SignupRequest(String name, String email, String password, String phone) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
