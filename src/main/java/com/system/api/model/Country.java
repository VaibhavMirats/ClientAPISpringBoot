package com.system.api.model;

import java.util.Collection;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "country")
public class Country {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;


	
	@OneToMany(mappedBy = "country")
	@Fetch(FetchMode.SUBSELECT)
	@JsonIgnore
	private Collection<Client> client;

	@Column(name = "countryName")
	private String countryName;

	@Column(name = "countryCode")
	private String countryCode;
	
	@Column(name = "countryFlag")
	private String countryFlag;
	
	@Column(name = "countryF")
	private String countryF;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryFlag() {
		return countryFlag;
	}

	public void setCountryFlag(String countryFlag) {
		this.countryFlag = countryFlag;
	}


	public Collection<Client> getClient() {
		return client;
	}

	public void setClient(Collection<Client> client) {
		this.client = client;
	}

	public Country() {
		super();
	}

	public Country(Integer id, List<Client> client, String countryName, String countryCode, String countryFlag) {
		super();
		this.id = id;
		this.client = client;
		this.countryName = countryName;
		this.countryCode = countryCode;
		this.countryFlag = countryFlag;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", client=" + client + ", countryName=" + countryName + ", countryCode="
				+ countryCode + ", countryFlag=" + countryFlag + "]";
	}

	
	
	

	
	
}
