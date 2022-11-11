package com.system.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "client_your_details")
public class ClientYourDetails {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;
	
	@Column(name = "job_function")
	@JsonProperty("job_function")
	private String job_function;
	
	@Column(name = "official_email_address")
	@JsonProperty("official_email_address")
	private String official_email_address;

	@Column(name = "your_job_title")
	@JsonProperty("your_job_title")
	private String your_job_title;

	public ClientYourDetails(String job_function, String official_email_address, String your_job_title) {
		super();
		this.job_function = job_function;
		this.official_email_address = official_email_address;
		this.your_job_title = your_job_title;
	}

	public ClientYourDetails() {
		super();
	}

	public ClientYourDetails(Integer id, Client client, String job_function, String official_email_address,
			String your_job_title) {
		super();
		this.id = id;
		this.client = client;
		this.job_function = job_function;
		this.official_email_address = official_email_address;
		this.your_job_title = your_job_title;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getJob_function() {
		return job_function;
	}

	public void setJob_function(String job_function) {
		this.job_function = job_function;
	}

	public String getOfficial_email_address() {
		return official_email_address;
	}

	public void setOfficial_email_address(String official_email_address) {
		this.official_email_address = official_email_address;
	}

	public String getYour_job_title() {
		return your_job_title;
	}

	public void setYour_job_title(String your_job_title) {
		this.your_job_title = your_job_title;
	}

	@Override
	public String toString() {
		return "ClientYourDetails [id=" + id + ", client=" + client + ", job_function=" + job_function
				+ ", official_email_address=" + official_email_address + ", your_job_title=" + your_job_title + "]";
	}

	

	
	

}
