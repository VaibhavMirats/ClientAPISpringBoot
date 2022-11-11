package com.system.api.payload;

public class JwtResponse {
	private String token;
	private String type = "Bearer";
	private Integer id;
	private String email_id;
	
	
	public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public JwtResponse(Integer id, String email_id) {
		super();
		this.id = id;
		this.email_id = email_id;
	}

	public JwtResponse(String token, Integer id, String email_id) {
		super();
		this.token = token;
		this.id = id;
		this.email_id = email_id;
	}

	
	

	

}
