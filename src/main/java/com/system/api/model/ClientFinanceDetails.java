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
@Table(name = "client_finance_details")
public class ClientFinanceDetails {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;
	
	@Column(name = "account_number")
	@JsonProperty("account_number")
	private String account_number;
;
	
	@Column(name = "bank_name")
	@JsonProperty("bank_name")
	private String bank_name;
	
	@Column(name = "contact_person_name")
	@JsonProperty("contact_person_name")
	private String contact_person_name;
	
	@Column(name = "ifsc")
	@JsonProperty("ifsc")
	private String ifsc;

	public ClientFinanceDetails(String account_number, String bank_name, String contact_person_name, String ifsc) {
		super();
		this.account_number = account_number;
		this.bank_name = bank_name;
		this.contact_person_name = contact_person_name;
		this.ifsc = ifsc;
	}
	
	public ClientFinanceDetails() {
		super();
	}

	public ClientFinanceDetails(Integer id, Client client, String account_number, String bank_name,
			String contact_person_name, String ifsc) {
		super();
		this.id = id;
		this.client = client;
		this.account_number = account_number;
		this.bank_name = bank_name;
		this.contact_person_name = contact_person_name;
		this.ifsc = ifsc;
	}

	@Override
	public String toString() {
		return "ClientFinanceDetails [id=" + id + ", client=" + client + ", account_number=" + account_number
				+ ", bank_name=" + bank_name + ", contact_person_name=" + contact_person_name + ", ifsc=" + ifsc + "]";
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

	public String getAccount_number() {
		return account_number;
	}

	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}

	public String getBank_name() {
		return bank_name;
	}

	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}

	public String getContact_person_name() {
		return contact_person_name;
	}

	public void setContact_person_name(String contact_person_name) {
		this.contact_person_name = contact_person_name;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	
	
	
}
