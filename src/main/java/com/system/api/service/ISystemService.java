package com.system.api.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.system.api.model.ClientAccountManagers;
import com.system.api.model.ClientBusinessContact;
import com.system.api.model.ClientCompanyDetails;
import com.system.api.model.Country;
import com.system.api.model.Client;
import com.system.api.model.ClientFinanceDetails;
import com.system.api.model.ClientProjectManagers;
import com.system.api.model.ClientSalesAccount;
import com.system.api.model.ClientSupplyManagers;
import com.system.api.model.ClientYourDetails;


public interface ISystemService {
	

//	Customer 

	public Client AddCustomer(Client client, Integer country_id);
	public ResponseEntity<?> loginCompany(Client client);
	
	
	public List<Client> getCustomerbyUid(Integer client_id);

	public void UpdateCustomerbyUid(Integer client_id, String company_email, String company_name);
	
	public void deleteCustomer(int client_id);
	
	public List<Client> listAllcustomer();
	
//	AccountManagers
	public ClientAccountManagers AddAccountManagers(ClientAccountManagers account_managers, Integer client_id);
	public List<ClientAccountManagers> getAccountManagersbyid(Integer client_id);

	public void UpdateAccountManagersbyUid(Integer id, String email, String name,String phone);
	
	public void deleteAccountManagers(int id);
	
//	ProjectManagers
	public ClientProjectManagers AddProjectManagers(ClientProjectManagers project_managers, Integer client_id);
	public List<ClientProjectManagers> getProjectManagersbyid(Integer client_id);

	public void UpdateProjectManagersbyUid(Integer id, String email, String name,String phone);
	
	public void deleteProjectManagers(int id);
	
	
//	SupplyManagers
	public ClientSupplyManagers AddSupplyManagers(ClientSupplyManagers customer_supply_managers, Integer client_id);
	public List<ClientSupplyManagers> getSupplyManagersbyid(Integer client_id);

	public void UpdateSupplyManagersbyUid(Integer id, String email, String name,String phone);
	
	public void deleteSupplyManagers(int id);
	
//	BusinessContact
	public ClientBusinessContact AddBusinessContact(ClientBusinessContact business_contact, Integer client_id);
	public List<ClientBusinessContact> getBusinessContactbyid(Integer client_id);

	public void UpdateBusinessContactbyUid(Integer id, String email, String name,String phone);
	
	public void deleteBusinessContact(int id);
	
	
//	CompanyDetails
	public ClientCompanyDetails AddCompanyDetails(ClientCompanyDetails company_details, Integer client_id);
	public List<ClientCompanyDetails> getCompanyDetailsbyid(Integer client_id);

	public void UpdateCompanyDetailsbyUid(Integer id, String company_employee_size, String company_name,String company_registred_number);
	
	public void deleteCompanyDetails(int id);
	
	
//	FinanceDetails
	public ClientFinanceDetails AddFinanceDetails(ClientFinanceDetails finance_details, Integer client_id);
	public List<ClientFinanceDetails> getFinanceDetailsbyid(Integer client_id);

	public void UpdateFinanceDetailsbyUid(Integer id, String account_number, String bank_name,String contact_person_name, String ifsc);
	
	public void deleteFinanceDetails(int id);
	
	
//	SalesAccount
	public ClientSalesAccount AddSalesAccount(ClientSalesAccount sales_account, Integer client_id);
	public List<ClientSalesAccount> getSalesAccountbyid(Integer client_id);

	public void UpdateSalesAccountbyUid(Integer id, String email, String name,String phone);
	
	public void deleteSalesAccount(int id);
	
//	YourDetails
	public ClientYourDetails AddYourDetails(ClientYourDetails your_details, Integer client_id);
	public List<ClientYourDetails> getYourDetailsbyid(Integer client_id);

	public void UpdateYourDetailsbyUid(Integer id, String job_function, String official_email_address,String your_job_title);
	
	public void deleteYourDetails(int id);
	
//	Country
	public Country AddCountry(Country country);
	public List<Country> listAllcountry();
	
//	Supplier
	

//	public List<Supplier> getSupplierbyid(Integer supplier_id);
//	
//	public Supplier createSupplier(Supplier supplier,Integer supplier_id);
	


}
