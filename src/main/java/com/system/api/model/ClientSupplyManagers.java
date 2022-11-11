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
@Table(name = "client_supply_managers")
public class ClientSupplyManagers {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;

	@Column(name = "email")
	@JsonProperty("email")
	private String email;

	@Column(name = "name")
	@JsonProperty("name")
	private String name;

	@Column(name = "phone")
	@JsonProperty("phone")
	private String phone;

	public ClientSupplyManagers(String email, String name, String phone) {
		super();
		this.email = email;
		this.name = name;
		this.phone = phone;
	}

	public ClientSupplyManagers() {
		super();
	}

	public ClientSupplyManagers(Integer id, Client client, String email, String name, String phone) {
		super();
		this.id = id;
		this.client = client;
		this.email = email;
		this.name = name;
		this.phone = phone;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "ClientSupplyManagers [id=" + id + ", client=" + client + ", email=" + email + ", name=" + name
				+ ", phone=" + phone + "]";
	}

	
	
	

}
