package com.system.api.payload;

import javax.validation.constraints.NotBlank;

public class LoginRequest {
	
	@NotBlank
	private String email_id;

	@NotBlank
	private String password;

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
