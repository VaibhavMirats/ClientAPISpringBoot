package com.system.api.model;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name = "client")
public class Client {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "first_name")
	@JsonProperty("first_name")
	private String first_name;
	
	@Column(name = "email_id")
	@JsonProperty("email_id")
	private String email_id;
	
	@JsonIgnore
	@Column(name = "password")
	@JsonProperty("password")
	private String password;


	@Column(name = "last_name")
	@JsonProperty("last_name")
	private String last_name;

	@Column(name = "company_email")
	@JsonProperty("company_email")
	private String company_email;

	@Column(name = "company_name")
	@JsonProperty("company_name")
	private String company_name;


	@ManyToOne
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name = "country_id")
	@JsonIgnore
	private Country country;
	
	
	
	@OneToMany(mappedBy = "client", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonProperty("client_account_managers")
	@JsonIgnore
    private List<ClientAccountManagers> client_account_managers;

	@OneToMany(mappedBy = "client", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonProperty("client_project_managers")
	@JsonIgnore
    private List<ClientProjectManagers> client_project_managers;
	
	
	
	@OneToMany(mappedBy = "client", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonProperty("client_supply_managers")
	@JsonIgnore
    private List<ClientSupplyManagers> client_supply_managers;
	
	@OneToMany(mappedBy = "client", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonProperty("client_business_contact")
	@JsonIgnore
    private List<ClientBusinessContact> client_business_contact;
	
	
	@OneToMany(mappedBy = "client", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonProperty("client_company_details")
	@JsonIgnore
    private List<ClientCompanyDetails> client_company_details;

	@OneToMany(mappedBy = "client", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonProperty("client_finance_details")
	@JsonIgnore
    private List<ClientFinanceDetails> client_finance_details;
	
	@OneToMany(mappedBy = "client", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonProperty("client_sales_account")
	@JsonIgnore
    private List<ClientSalesAccount> client_sales_account;
	
	@OneToMany(mappedBy = "client", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonProperty("client_your_details")
	@JsonIgnore
    private List<ClientYourDetails> client_your_details;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getCompany_email() {
		return company_email;
	}

	public void setCompany_email(String company_email) {
		this.company_email = company_email;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public List<ClientAccountManagers> getClient_account_managers() {
		return client_account_managers;
	}

	public void setClient_account_managers(List<ClientAccountManagers> client_account_managers) {
		this.client_account_managers = client_account_managers;
	}

	public List<ClientProjectManagers> getClient_project_managers() {
		return client_project_managers;
	}

	public void setClient_project_managers(List<ClientProjectManagers> client_project_managers) {
		this.client_project_managers = client_project_managers;
	}

	public List<ClientSupplyManagers> getClient_supply_managers() {
		return client_supply_managers;
	}

	public void setClient_supply_managers(List<ClientSupplyManagers> client_supply_managers) {
		this.client_supply_managers = client_supply_managers;
	}

	public List<ClientBusinessContact> getClient_business_contact() {
		return client_business_contact;
	}

	public void setClient_business_contact(List<ClientBusinessContact> client_business_contact) {
		this.client_business_contact = client_business_contact;
	}

	public List<ClientCompanyDetails> getClient_company_details() {
		return client_company_details;
	}

	public void setClient_company_details(List<ClientCompanyDetails> client_company_details) {
		this.client_company_details = client_company_details;
	}

	public List<ClientFinanceDetails> getClient_finance_details() {
		return client_finance_details;
	}

	public void setClient_finance_details(List<ClientFinanceDetails> client_finance_details) {
		this.client_finance_details = client_finance_details;
	}

	public List<ClientSalesAccount> getClient_sales_account() {
		return client_sales_account;
	}

	public void setClient_sales_account(List<ClientSalesAccount> client_sales_account) {
		this.client_sales_account = client_sales_account;
	}

	public List<ClientYourDetails> getClient_your_details() {
		return client_your_details;
	}

	public void setClient_your_details(List<ClientYourDetails> client_your_details) {
		this.client_your_details = client_your_details;
	}



	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
	
	
	public Client(Integer id, String first_name, String email_id, String password, String last_name,
			String company_email, String company_name, Country country,
			List<ClientAccountManagers> client_account_managers, List<ClientProjectManagers> client_project_managers,
			List<ClientSupplyManagers> client_supply_managers, List<ClientBusinessContact> client_business_contact,
			List<ClientCompanyDetails> client_company_details, List<ClientFinanceDetails> client_finance_details,
			List<ClientSalesAccount> client_sales_account, List<ClientYourDetails> client_your_details) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.email_id = email_id;
		this.password = password;
		this.last_name = last_name;
		this.company_email = company_email;
		this.company_name = company_name;
		this.country = country;
		this.client_account_managers = client_account_managers;
		this.client_project_managers = client_project_managers;
		this.client_supply_managers = client_supply_managers;
		this.client_business_contact = client_business_contact;
		this.client_company_details = client_company_details;
		this.client_finance_details = client_finance_details;
		this.client_sales_account = client_sales_account;
		this.client_your_details = client_your_details;
	}
	
	
	

	@Override
	public String toString() {
		return "Client [id=" + id + ", first_name=" + first_name + ", email_id=" + email_id + ", password=" + password
				+ ", last_name=" + last_name + ", company_email=" + company_email + ", company_name=" + company_name
				+ ", country=" + country + ", client_account_managers=" + client_account_managers
				+ ", client_project_managers=" + client_project_managers + ", client_supply_managers="
				+ client_supply_managers + ", client_business_contact=" + client_business_contact
				+ ", client_company_details=" + client_company_details + ", client_finance_details="
				+ client_finance_details + ", client_sales_account=" + client_sales_account + ", client_your_details="
				+ client_your_details + "]";
	}

	public Client() {
		super();
	}


		
	


}
