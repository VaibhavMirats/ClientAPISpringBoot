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
@Table(name = "client_company_details")
public class ClientCompanyDetails {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;
	
	@Column(name = "company_employee_size")
	@JsonProperty("company_employee_size")
	private String company_employee_size;
	
	@Column(name = "company_name")
	@JsonProperty("company_name")
	private String company_name;

	@Column(name = "company_registred_number")
	@JsonProperty("company_registred_number")
	private String company_registred_number;

	@Column(name = "company_start_date")
	@JsonProperty("company_start_date")
	private String company_start_date;



	public ClientCompanyDetails() {
		super();
	}



	public ClientCompanyDetails(String company_employee_size, String company_name, String company_registred_number,
			String company_start_date) {
		super();
		this.company_employee_size = company_employee_size;
		this.company_name = company_name;
		this.company_registred_number = company_registred_number;
		this.company_start_date = company_start_date;
	}



	public ClientCompanyDetails(Integer id, Client client, String company_employee_size, String company_name,
			String company_registred_number, String company_start_date) {
		super();
		this.id = id;
		this.client = client;
		this.company_employee_size = company_employee_size;
		this.company_name = company_name;
		this.company_registred_number = company_registred_number;
		this.company_start_date = company_start_date;
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



	public String getCompany_employee_size() {
		return company_employee_size;
	}



	public void setCompany_employee_size(String company_employee_size) {
		this.company_employee_size = company_employee_size;
	}



	public String getCompany_name() {
		return company_name;
	}



	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}



	public String getCompany_registred_number() {
		return company_registred_number;
	}



	public void setCompany_registred_number(String company_registred_number) {
		this.company_registred_number = company_registred_number;
	}



	public String getCompany_start_date() {
		return company_start_date;
	}



	public void setCompany_start_date(String company_start_date) {
		this.company_start_date = company_start_date;
	}



	@Override
	public String toString() {
		return "ClientCompanyDetails [id=" + id + ", client=" + client + ", company_employee_size="
				+ company_employee_size + ", company_name=" + company_name + ", company_registred_number="
				+ company_registred_number + ", company_start_date=" + company_start_date + "]";
	}



	
	
}
