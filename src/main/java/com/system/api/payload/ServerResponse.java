package com.system.api.payload;

public class ServerResponse {

	 private Integer id;
	 private String useremail;
	 private Integer foreign_key;
	 
	public ServerResponse(Integer id, String useremail) {
		super();
		this.id = id;
		this.useremail = useremail;
	}

	public ServerResponse() {
		super();
	}

	
	public ServerResponse(Integer id, Integer foreign_key) {
		super();
		this.id = id;
		this.foreign_key = foreign_key;
	}

	@Override
	public String toString() {
		return "ServerResponse [id=" + id + ", useremail=" + useremail + ", foreign_key=" + foreign_key + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public Integer getForeign_key() {
		return foreign_key;
	}

	public void setForeign_key(Integer foreign_key) {
		this.foreign_key = foreign_key;
	}
	 
	
	
	 
	 
}

