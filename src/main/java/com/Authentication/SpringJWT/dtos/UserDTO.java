package com.Authentication.SpringJWT.dtos;

public class UserDTO {

	private Long id;
	
	private String name;
	
	private String email;
	
	
	private String phone;
	
	
	
	
	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", name=" + name + ", email=" + email + ", phone="
				+ phone + "]";
	}




	public UserDTO(Long id, String name, String email, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}


	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}


	public UserDTO() {
		super();
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
