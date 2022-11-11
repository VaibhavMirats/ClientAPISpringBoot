package com.system.api.controller;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.system.api.model.ClientAccountManagers;
import com.system.api.model.ClientBusinessContact;
import com.system.api.model.ClientCompanyDetails;
import com.system.api.model.Country;
import com.system.api.model.Client;
import com.system.api.model.ClientSupplyManagers;
import com.system.api.model.ClientFinanceDetails;
import com.system.api.model.ClientProjectManagers;
import com.system.api.model.ClientSalesAccount;
import com.system.api.model.ClientYourDetails;
import com.system.api.payload.ServerResponse;
import com.system.api.service.SystemServiceImpl;

@RestController
@RequestMapping(value = "/api/v1")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CustomerController {

	@Autowired
	SystemServiceImpl systemservice;
	
	

	@PostMapping(value = "/login")
	public ResponseEntity<?> loginCompany(@Valid @RequestBody Client Client) {
		return systemservice.loginCompany(Client);
	}

	@PostMapping(value = "/addCustomer/{country_id}")
	public ServerResponse AddCustomer(@Valid @RequestBody Client Client, @PathVariable("country_id") Integer country_id) {

		Client dbFile = systemservice.AddCustomer(Client, country_id);
		return new ServerResponse(dbFile.getId(), Client.getCompany_email());
	}

	@GetMapping(value = "/getCustomerbyUid/{client_id}") // pathvariable
	public List<Client> getCustomerbyUid(@PathVariable("client_id") Integer client_id) {
		// System.out.println(prodName);
		return systemservice.getCustomerbyUid(client_id);
	}

	@PostMapping(value = "/updateCustomerbyUid")
	public void UpdateCustomerbyUid(@RequestParam("id") Integer id, @RequestParam("company_email") String company_email,
			@RequestParam("company_name") String company_name) {
		systemservice.UpdateCustomerbyUid(id, company_email, company_name);
	}
	
	@PostMapping(value = "/updateCustomerbyUidAndGetAll",produces = {MediaType.APPLICATION_JSON_VALUE})
	public String updateCustomerbyUidAndGetAll(@RequestParam("id") Integer id, @RequestParam("company_email") String company_email,
			@RequestParam("company_name") String company_name) {
		systemservice.UpdateCustomerbyUid(id, company_email, company_name);
		 HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity <String> entity = new HttpEntity<String>(headers);
	      RestTemplate restTemplate = new RestTemplate();
	      return restTemplate.exchange("http://localhost:9092/api/v1/suppliers/listAllcustomer", HttpMethod.GET, entity, String.class).getBody();
	 
		
	}

	@DeleteMapping("/deleteCustomer/{id}")
	public void deleteCustomer(@PathVariable("id") int id) {
		systemservice.deleteCustomer(id);
	}

	@GetMapping(value = "/listAllcustomer") // pathvariable
	public List<Client> listAllbank_mst() {
		// System.out.println(prodName);
		return systemservice.listAllcustomer();
	}

//	AccountManagers
	@PostMapping(value = "/addAccountManagers/{customer_id}")
	public ServerResponse AddAccountManagers(@RequestBody ClientAccountManagers account_managers,
			@PathVariable("customer_id") Integer customer_id) {

		ClientAccountManagers dbFile = systemservice.AddAccountManagers(account_managers, customer_id);
		return new ServerResponse(dbFile.getId(), account_managers.getEmail());
	}

	@GetMapping(value = "/getAccountManagersbyid/{customer_id}") // pathvariable
	public List<ClientAccountManagers> getAccountManagersbyid(@PathVariable("customer_id") Integer customer_id) {
		// System.out.println(prodName);
		return systemservice.getAccountManagersbyid(customer_id);
	}

	@PostMapping(value = "/updateAccountManagersbyUid")
	public void UpdateAccountManagersbyUid(@RequestParam("id") Integer id, @RequestParam("email") String email,
			@RequestParam("name") String name, @RequestParam("phone") String phone) {
		systemservice.UpdateAccountManagersbyUid(id, email, name, phone);
	}

	@DeleteMapping("/deleteAccountManagers/{id}")
	public void deleteAccountManagers(@PathVariable("id") int id) {
		systemservice.deleteAccountManagers(id);
	}

//	ProjectManagers
	@PostMapping(value = "/addProjectManagers/{customer_id}")
	public ServerResponse AddProjectManagers(@RequestBody ClientProjectManagers project_managers,
			@PathVariable("customer_id") Integer customer_id) {

		ClientProjectManagers dbFile = systemservice.AddProjectManagers(project_managers, customer_id);
		return new ServerResponse(dbFile.getId(), project_managers.getEmail());
	}

	@GetMapping(value = "/getProjectManagersbyid/{customer_id}") // pathvariable
	public List<ClientProjectManagers> getProjectManagersbyid(@PathVariable("customer_id") Integer customer_id) {
		// System.out.println(prodName);
		return systemservice.getProjectManagersbyid(customer_id);
	}

	@PostMapping(value = "/updateProjectManagersbyUid")
	public void UpdateProjectManagersbyUid(@RequestParam("id") Integer id, @RequestParam("email") String email,
			@RequestParam("name") String name, @RequestParam("phone") String phone) {
		systemservice.UpdateProjectManagersbyUid(id, email, name, phone);
	}

	@DeleteMapping("/deleteProjectManagers/{id}")
	public void deleteProjectManagers(@PathVariable("id") int id) {
		systemservice.deleteProjectManagers(id);
	}

//	SupplyManagers
	@PostMapping(value = "/addSupplyManagers/{customer_id}")
	public ServerResponse AddSupplyManagers(@RequestBody ClientSupplyManagers supply_managers,
			@PathVariable("customer_id") Integer customer_id) {

		ClientSupplyManagers dbFile = systemservice.AddSupplyManagers(supply_managers, customer_id);
		return new ServerResponse(dbFile.getId(), supply_managers.getEmail());
	}

	@GetMapping(value = "/getSupplyManagersbyid/{customer_id}") // pathvariable
	public List<ClientSupplyManagers> getSupplyManagersbyid(@PathVariable("customer_id") Integer customer_id) {
		// System.out.println(prodName);
		return systemservice.getSupplyManagersbyid(customer_id);
	}

	@PostMapping(value = "/updateSupplyManagersbyUid")
	public void UpdateSupplyManagersbyUid(@RequestParam("id") Integer id, @RequestParam("email") String email,
			@RequestParam("name") String name, @RequestParam("phone") String phone) {
		systemservice.UpdateSupplyManagersbyUid(id, email, name, phone);
	}

	@DeleteMapping("/deleteSupplyManagers/{id}")
	public void deleteSupplyManagers(@PathVariable("id") int id) {
		systemservice.deleteSupplyManagers(id);
	}

//	BusinessContact
	@PostMapping(value = "/addBusinessContact/{customer_id}")
	public ServerResponse AddBusinessContact(@RequestBody ClientBusinessContact business_contact,
			@PathVariable("customer_id") Integer customer_id) {

		ClientBusinessContact dbFile = systemservice.AddBusinessContact(business_contact, customer_id);
		return new ServerResponse(dbFile.getId(), business_contact.getEmail());
	}

	@GetMapping(value = "/getBusinessContactbyid/{customer_id}") // pathvariable
	public List<ClientBusinessContact> getBusinessContactbyid(@PathVariable("customer_id") Integer customer_id) {
		// System.out.println(prodName);
		return systemservice.getBusinessContactbyid(customer_id);
	}

	@PostMapping(value = "/updateBusinessContactbyUid")
	public void UpdateBusinessContactbyUid(@RequestParam("id") Integer id, @RequestParam("email") String email,
			@RequestParam("name") String name, @RequestParam("phone") String phone) {
		systemservice.UpdateBusinessContactbyUid(id, email, name, phone);
	}

	@DeleteMapping("/deleteBusinessContact/{id}")
	public void deleteBusinessContact(@PathVariable("id") int id) {
		systemservice.deleteBusinessContact(id);
	}

//	CompanyDetails

	@PostMapping(value = "/addCompanyDetails/{customer_id}")
	public ServerResponse AddCompanyDetails(@RequestBody ClientCompanyDetails company_details,
			@PathVariable("customer_id") Integer customer_id) {

		ClientCompanyDetails dbFile = systemservice.AddCompanyDetails(company_details, customer_id);
		return new ServerResponse(dbFile.getId(), company_details.getCompany_name());
	}

	@GetMapping(value = "/getCompanyDetailsbyid/{customer_id}") // pathvariable
	public List<ClientCompanyDetails> getCompanyDetailsbyid(@PathVariable("customer_id") Integer customer_id) {
		// System.out.println(prodName);
		return systemservice.getCompanyDetailsbyid(customer_id);
	}

	@PostMapping(value = "/updateCompanyDetailsbyUid")
	public void UpdateCompanyDetailsbyUid(@RequestParam("id") Integer id,
			@RequestParam("company_employee_size") String company_employee_size,
			@RequestParam("company_name") String company_name,
			@RequestParam("company_registred_number") String company_registred_number) {
		systemservice.UpdateBusinessContactbyUid(id, company_employee_size, company_name, company_registred_number);
	}

	@DeleteMapping("/deleteCompanyDetails/{id}")
	public void deleteCompanyDetails(@PathVariable("id") int id) {
		systemservice.deleteCompanyDetails(id);
	}

//	FinanceDetails

	@PostMapping(value = "/addFinanceDetails/{customer_id}")
	public ServerResponse AddFinanceDetails(@RequestBody ClientFinanceDetails finance_details,
			@PathVariable("customer_id") Integer customer_id) {

		ClientFinanceDetails dbFile = systemservice.AddFinanceDetails(finance_details, customer_id);
		return new ServerResponse(dbFile.getId(), finance_details.getBank_name());
	}

	@GetMapping(value = "/getFinanceDetailsbyid/{customer_id}") // pathvariable
	public List<ClientFinanceDetails> getFinanceDetailsbyid(@PathVariable("customer_id") Integer customer_id) {
		// System.out.println(prodName);
		return systemservice.getFinanceDetailsbyid(customer_id);
	}

	@PostMapping(value = "/updateFinanceDetailsbyUid")
	public void UpdateFinanceDetailsbyUid(@RequestParam("id") Integer id,
			@RequestParam("account_number") String account_number, @RequestParam("bank_name") String bank_name,
			@RequestParam("contact_person_name") String contact_person_name, @RequestParam("ifsc") String ifsc) {
		systemservice.UpdateFinanceDetailsbyUid(id, account_number, bank_name, contact_person_name, ifsc);
	}

	@DeleteMapping("/deleteFinanceDetails/{id}")
	public void deleteFinanceDetails(@PathVariable("id") int id) {
		systemservice.deleteFinanceDetails(id);
	}

//	SalesAccount

	@PostMapping(value = "/addSalesAccount/{customer_id}")
	public ServerResponse AddSalesAccount(@RequestBody ClientSalesAccount sales_account,
			@PathVariable("customer_id") Integer customer_id) {

		ClientSalesAccount dbFile = systemservice.AddSalesAccount(sales_account, customer_id);
		return new ServerResponse(dbFile.getId(), sales_account.getEmail());
	}

	@GetMapping(value = "/getSalesAccountbyid/{customer_id}") // pathvariable
	public List<ClientSalesAccount> getSalesAccountbyid(@PathVariable("customer_id") Integer customer_id) {
		// System.out.println(prodName);
		return systemservice.getSalesAccountbyid(customer_id);
	}

	@PostMapping(value = "/updateSalesAccountbyUid")
	public void UpdateSalesAccountbyUid(@RequestParam("id") Integer id, @RequestParam("email") String email,
			@RequestParam("name") String name, @RequestParam("phone") String phone) {
		systemservice.UpdateSalesAccountbyUid(id, email, name, phone);
	}

	@DeleteMapping("/deleteSalesAccount/{id}")
	public void deleteSalesAccount(@PathVariable("id") int id) {
		systemservice.deleteSalesAccount(id);
	}

//	YourDetails

	@PostMapping(value = "/addYourDetails/{customer_id}")
	public ServerResponse AddYourDetails(@RequestBody ClientYourDetails your_details,
			@PathVariable("customer_id") Integer customer_id) {

		ClientYourDetails dbFile = systemservice.AddYourDetails(your_details, customer_id);
		return new ServerResponse(dbFile.getId(), your_details.getOfficial_email_address());
	}

	@GetMapping(value = "/getYourDetailsbyid/{customer_id}") // pathvariable
	public List<ClientYourDetails> getYourDetailsbyid(@PathVariable("customer_id") Integer customer_id) {
		// System.out.println(prodName);
		return systemservice.getYourDetailsbyid(customer_id);
	}

	@PostMapping(value = "/updateYourDetailsbyUid")
	public void UpdateYourDetailsbyUid(@RequestParam("id") Integer id,
			@RequestParam("job_function") String job_function,
			@RequestParam("official_email_address") String official_email_address,
			@RequestParam("your_job_title") String your_job_title) {
		systemservice.UpdateYourDetailsbyUid(id, job_function, official_email_address, your_job_title);
	}

	@DeleteMapping("/deleteYourDetails/{id}")
	public void deleteYourDetails(@PathVariable("id") int id) {
		systemservice.deleteYourDetails(id);
	}

	@PostMapping(value = "/addCountry")
	public ServerResponse AddCountry(@RequestBody Country country) {

		Country dbFile = systemservice.AddCountry(country);
		return new ServerResponse(dbFile.getId(), country.getCountryName());
	}

	@GetMapping(value = "/listAllcountry") // pathvariable
	public List<Country> listAllcountry() {
		// System.out.println(prodName);
		return systemservice.listAllcountry();
	}

	@PostMapping(value = "/getClientAndSaleaOrder")
	private List<Object> getClientAndSaleaOrder(@RequestParam("client_id") Integer client_id,
			@RequestParam("sales_order_id") Integer sales_order_id) {

		String clienturl = "http://localhost:9092/api/v1/suppliers/getCustomerbyUid/" + client_id;
		RestTemplate restTemplate1 = new RestTemplate();
		Object[] result1 = restTemplate1.getForObject(clienturl, Object[].class);

		String sales_orderurl = "http://192.168.1.39:7000/api/v1/get-salesorders/" + sales_order_id;
		RestTemplate restTemplate2 = new RestTemplate();
		Object[] result2 = restTemplate2.getForObject(sales_orderurl, Object[].class);

		return Arrays.asList(result1, result2);

	}

	@PostMapping(value = "/getClientAndSurvey")
	private List<Object> getClientAndSurvey(@RequestParam("survey_id") Integer survey_id,
			@RequestParam("client_id") Integer client_id) {

		String clienturl = "http://localhost:9092/api/v1/suppliers/getCustomerbyUid/" + client_id;
		RestTemplate restTemplate1 = new RestTemplate();
		Object[] result1 = restTemplate1.getForObject(clienturl, Object[].class);

		String survey_url = "http://192.168.1.41:3031/api/v1/survey/get/"+survey_id;
		RestTemplate restTemplate2 = new RestTemplate();
		Object[] result2 = restTemplate2.getForObject(survey_url, Object[].class);

		return Arrays.asList(result1, result2);

	}
	
	


	
	
	

}
