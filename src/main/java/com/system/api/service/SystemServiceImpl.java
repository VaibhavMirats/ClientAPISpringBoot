package com.system.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.system.api.model.ClientAccountManagers;
import com.system.api.model.ClientBusinessContact;
import com.system.api.model.ClientCompanyDetails;
import com.system.api.model.Country;
import com.system.api.model.Client;
import com.system.api.model.ClientSupplyManagers;
import com.system.api.model.ClientFinanceDetails;
import com.system.api.model.ClientProjectManagers;
import com.system.api.model.ClientSalesAccount;
import com.system.api.payload.JwtResponse;
import com.system.api.model.ClientYourDetails;
import com.system.api.repository.AccountManagersRepository;
import com.system.api.repository.BusinessContactRepository;
import com.system.api.repository.ClientRepository;
import com.system.api.repository.CompanyDetailsRepository;
import com.system.api.repository.CountryRepository;
import com.system.api.repository.EmailRepository;
import com.system.api.repository.FinanceDetailsRepository;
import com.system.api.repository.ProjectManagersRepository;
import com.system.api.repository.SalesAccountRepository;
import com.system.api.repository.ClientSupplyManagersRepository;
import com.system.api.repository.YourDetailsRepository;
import com.system.api.security.JwtUtils;
import com.system.api.security.UserDetailsImpl;

@Service("systemservice")
@Transactional
public class SystemServiceImpl implements ISystemService {

	@Autowired
	EmailRepository emailrepository;
	
	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	JwtUtils jwtUtils;
	

	
	
	@Override
	public ResponseEntity<?> loginCompany(@Valid @RequestBody Client client) {
		System.out.println("loginCompany login test with email: " + client.getEmail_id());
		
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(client.getEmail_id(), client.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		System.out.println("Company login successful with email: " + client.getEmail_id());
		return ResponseEntity.ok(
				new JwtResponse(jwt, userDetails.getId(), userDetails.getEmail_id()));
	}
	
	
//	Customer

	@Autowired
	ClientRepository clientrepository;

	
//	@Override
	public Client AddCustomer(Client client, Integer country_id) {
		// TODO Auto-generated method stub

		/// for ClientAccountManagers
		client.setPassword(bCryptPasswordEncoder.encode(client.getPassword()));
		List<ClientAccountManagers> cam = new ArrayList<>();

		for (ClientAccountManagers account_managers : client.getClient_account_managers()) {
			account_managers.setClient(client);
			accountmanagersrepository.save(account_managers);
			Optional<ClientAccountManagers> opt = accountmanagersrepository.findById(account_managers.getId());
			ClientAccountManagers b = opt.get();
			cam.add(b);
		}

		/// for ClientProjectManagers
		List<ClientProjectManagers> cpm = new ArrayList<>();

		for (ClientProjectManagers client_project_managers : client.getClient_project_managers()) {
			client_project_managers.setClient(client);
			projectmanagersrepository.save(client_project_managers);
			Optional<ClientProjectManagers> opt = projectmanagersrepository.findById(client_project_managers.getId());
			ClientProjectManagers b = opt.get();
			cpm.add(b);
		}

		/// for ClientSupplyManagers
		List<ClientSupplyManagers> csum = new ArrayList<>();

		for (ClientSupplyManagers client_supply_managers : client.getClient_supply_managers()) {
			client_supply_managers.setClient(client);
			supplymanagersrepository.save(client_supply_managers);
			Optional<ClientSupplyManagers> opt = supplymanagersrepository.findById(client_supply_managers.getId());
			ClientSupplyManagers b = opt.get();
			csum.add(b);
		}

		/// for ClientBusinessContact
		List<ClientBusinessContact> cbm = new ArrayList<>();

		for (ClientBusinessContact client_business_contact : client.getClient_business_contact()) {
			client_business_contact.setClient(client);
			businesscontactrepository.save(client_business_contact);
			Optional<ClientBusinessContact> opt = businesscontactrepository.findById(client_business_contact.getId());
			ClientBusinessContact b = opt.get();
			cbm.add(b);
		}

		/// for ClientCompanyDetails
		List<ClientCompanyDetails> ccd = new ArrayList<>();

		for (ClientCompanyDetails client_company_details : client.getClient_company_details()) {
			client_company_details.setClient(client);
			companydetailsrepository.save(client_company_details);
			Optional<ClientCompanyDetails> opt = companydetailsrepository.findById(client_company_details.getId());
			ClientCompanyDetails b = opt.get();
			ccd.add(b);
		}

		/// for ClientFinanceDetails
		List<ClientFinanceDetails> cfd = new ArrayList<>();

		for (ClientFinanceDetails client_finance_details : client.getClient_finance_details()) {
			client_finance_details.setClient(client);
			financedetailsrepository.save(client_finance_details);
			Optional<ClientFinanceDetails> opt = financedetailsrepository.findById(client_finance_details.getId());
			ClientFinanceDetails b = opt.get();
			cfd.add(b);
		}

		/// for ClientSalesAccount
		List<ClientSalesAccount> csa = new ArrayList<>();

		for (ClientSalesAccount client_sales_account : client.getClient_sales_account()) {
			client_sales_account.setClient(client);
			salesaccountrepository.save(client_sales_account);
			Optional<ClientSalesAccount> opt = salesaccountrepository.findById(client_sales_account.getId());
			ClientSalesAccount b = opt.get();
			csa.add(b);
		}

		/// for ClientYourDetails
		List<ClientYourDetails> cyd = new ArrayList<>();

		for (ClientYourDetails client_your_details : client.getClient_your_details()) {
			client_your_details.setClient(client);
			yourdetailsrepository.save(client_your_details);
			Optional<ClientYourDetails> opt = yourdetailsrepository.findById(client_your_details.getId());
			ClientYourDetails b = opt.get();
			cyd.add(b);
		}

//		for Country

		Country country = countryRepository.findById(country_id).get();
		client.setCountry(country);

		////
		client.setClient_account_managers(cam);
		client.setClient_project_managers(cpm);
		client.setClient_supply_managers(csum);
		client.setClient_business_contact(cbm);
		client.setClient_company_details(ccd);
		client.setClient_finance_details(cfd);
		client.setClient_sales_account(csa);

		//
		return clientrepository.save(client);
	}

	@Override
	public List<Client> getCustomerbyUid(Integer client_id) {
		// TODO Auto-generated method stub
		
		return emailrepository.getCustomerbyUid(client_id);
	}

	@Override
	public void UpdateCustomerbyUid(Integer id, String company_email, String company_name) {
		// TODO Auto-generated method stub
		emailrepository.UpdateCustomerbyUid(id, company_email, company_name);

	}

	@Override
	public void deleteCustomer(int id) {
		// TODO Auto-generated method stub
		clientrepository.deleteById(id);
	}

	@Override
	public List<Client> listAllcustomer() {
		// TODO Auto-generated method stub
		return clientrepository.findAll();
	}

//	AccountManagers

	@Autowired
	AccountManagersRepository accountmanagersrepository;

	@Override
	public ClientAccountManagers AddAccountManagers(ClientAccountManagers account_managers, Integer client_id) {
		// TODO Auto-generated method stub
		account_managers = new ClientAccountManagers(account_managers.getEmail(), account_managers.getName(),
				account_managers.getPhone());
		Client client = clientrepository.findById(client_id).get();
		account_managers.setClient(client);
		return accountmanagersrepository.save(account_managers);
	}

	@Override
	public List<ClientAccountManagers> getAccountManagersbyid(Integer client_id) {
		// TODO Auto-generated method stub
		return clientrepository.getAccountManagersbyid(client_id);
	}

	@Override
	public void UpdateAccountManagersbyUid(Integer id, String email, String name, String phone) {
		// TODO Auto-generated method stub
		clientrepository.UpdateAccountManagersbyUid(id, email, name, phone);
	}

	@Override
	public void deleteAccountManagers(int id) {
		// TODO Auto-generated method stub
		accountmanagersrepository.deleteById(id);
	}

//	ProjectManagers
	@Autowired
	ProjectManagersRepository projectmanagersrepository;

	@Override
	public ClientProjectManagers AddProjectManagers(ClientProjectManagers project_managers, Integer client_id) {
		// TODO Auto-generated method stub
		project_managers = new ClientProjectManagers(project_managers.getEmail(), project_managers.getName(),
				project_managers.getPhone());
		Client client = clientrepository.findById(client_id).get();
		project_managers.setClient(client);
		return projectmanagersrepository.save(project_managers);
	}

	@Override
	public List<ClientProjectManagers> getProjectManagersbyid(Integer client_id) {
		// TODO Auto-generated method stub
		return clientrepository.getProjectManagersbyid(client_id);
	}

	@Override
	public void UpdateProjectManagersbyUid(Integer id, String email, String name, String phone) {
		// TODO Auto-generated method stub
		clientrepository.UpdateProjectManagersbyUid(id, email, name, phone);
	}

	@Override
	public void deleteProjectManagers(int id) {
		// TODO Auto-generated method stub
		projectmanagersrepository.deleteById(id);
	}

//	SupplyManagers

	@Autowired
	ClientSupplyManagersRepository supplymanagersrepository;

	@Override
	public ClientSupplyManagers AddSupplyManagers(ClientSupplyManagers customer_supply_managers, Integer client_id) {
		// TODO Auto-generated method stub
		customer_supply_managers = new ClientSupplyManagers(customer_supply_managers.getEmail(),
				customer_supply_managers.getName(), customer_supply_managers.getPhone());
		Client client = clientrepository.findById(client_id).get();
		customer_supply_managers.setClient(client);
		return supplymanagersrepository.save(customer_supply_managers);
	}

	@Override
	public List<ClientSupplyManagers> getSupplyManagersbyid(Integer client_id) {
		// TODO Auto-generated method stub
		return clientrepository.getSupplyManagersbyid(client_id);
	}

	@Override
	public void UpdateSupplyManagersbyUid(Integer id, String email, String name, String phone) {
		// TODO Auto-generated method stub
		clientrepository.UpdateSupplyManagersbyUid(id, email, name, phone);
	}

	@Override
	public void deleteSupplyManagers(int id) {
		// TODO Auto-generated method stub
		supplymanagersrepository.deleteById(id);
	}

//	BusinessContact
	@Autowired
	BusinessContactRepository businesscontactrepository;

	@Override
	public ClientBusinessContact AddBusinessContact(ClientBusinessContact business_contact, Integer client_id) {
		// TODO Auto-generated method stub
		business_contact = new ClientBusinessContact(business_contact.getEmail(), business_contact.getName(),
				business_contact.getPhone());
		Client client = clientrepository.findById(client_id).get();
		business_contact.setClient(client);
		return businesscontactrepository.save(business_contact);
	}

	@Override
	public List<ClientBusinessContact> getBusinessContactbyid(Integer client_id) {
		// TODO Auto-generated method stub
		return clientrepository.getBusinessContactbyid(client_id);
	}

	@Override
	public void UpdateBusinessContactbyUid(Integer id, String email, String name, String phone) {
		// TODO Auto-generated method stub
		clientrepository.UpdateBusinessContactbyUid(id, email, name, phone);
	}

	@Override
	public void deleteBusinessContact(int id) {
		// TODO Auto-generated method stub
		businesscontactrepository.deleteById(id);
	}

//	CompanyDetails
	@Autowired
	CompanyDetailsRepository companydetailsrepository;

	@Override
	public ClientCompanyDetails AddCompanyDetails(ClientCompanyDetails company_details, Integer client_id) {
		// TODO Auto-generated method stub
		company_details = new ClientCompanyDetails(company_details.getCompany_employee_size(),
				company_details.getCompany_name(), company_details.getCompany_registred_number(),
				company_details.getCompany_start_date());
		Client client = clientrepository.findById(client_id).get();
		company_details.setClient(client);
		return companydetailsrepository.save(company_details);
	}

	@Override
	public List<ClientCompanyDetails> getCompanyDetailsbyid(Integer client_id) {
		// TODO Auto-generated method stub
		return clientrepository.getCompanyDetailsbyid(client_id);
	}

	@Override
	public void UpdateCompanyDetailsbyUid(Integer id, String company_employee_size, String company_name,
			String company_registred_number) {
		// TODO Auto-generated method stub
		clientrepository.UpdateCompanyDetailsbyUid(id, company_employee_size, company_name, company_registred_number);
	}

	@Override
	public void deleteCompanyDetails(int id) {
		// TODO Auto-generated method stub
		companydetailsrepository.deleteById(id);
	}

//	FinanceDetails
	@Autowired
	FinanceDetailsRepository financedetailsrepository;

	@Override
	public ClientFinanceDetails AddFinanceDetails(ClientFinanceDetails finance_details, Integer client_id) {
		// TODO Auto-generated method stub
		finance_details = new ClientFinanceDetails(finance_details.getAccount_number(), finance_details.getBank_name(),
				finance_details.getContact_person_name(), finance_details.getIfsc());
		Client client = clientrepository.findById(client_id).get();
		finance_details.setClient(client);
		return financedetailsrepository.save(finance_details);
	}

	@Override
	public List<ClientFinanceDetails> getFinanceDetailsbyid(Integer client_id) {
		// TODO Auto-generated method stub
		return clientrepository.getFinanceDetailsbyid(client_id);
	}

	@Override
	public void UpdateFinanceDetailsbyUid(Integer id, String account_number, String bank_name,
			String contact_person_name, String ifsc) {
		// TODO Auto-generated method stub
		clientrepository.UpdateFinanceDetailsbyUid(id, account_number, bank_name, contact_person_name, ifsc);
	}

	@Override
	public void deleteFinanceDetails(int id) {
		// TODO Auto-generated method stub
		financedetailsrepository.deleteById(id);
	}

//	SalesAccount
	@Autowired
	SalesAccountRepository salesaccountrepository;

	@Override
	public ClientSalesAccount AddSalesAccount(ClientSalesAccount sales_account, Integer client_id) {
		// TODO Auto-generated method stub
		sales_account = new ClientSalesAccount(sales_account.getEmail(), sales_account.getName(),
				sales_account.getPhone());
		Client client = clientrepository.findById(client_id).get();
		sales_account.setClient(client);
		return salesaccountrepository.save(sales_account);
	}

	@Override
	public List<ClientSalesAccount> getSalesAccountbyid(Integer client_id) {
		// TODO Auto-generated method stub
		return clientrepository.getSalesAccountbyid(client_id);
	}

	@Override
	public void UpdateSalesAccountbyUid(Integer id, String email, String name, String phone) {
		// TODO Auto-generated method stub
		clientrepository.UpdateSalesAccountbyUid(id, email, name, phone);
	}

	@Override
	public void deleteSalesAccount(int id) {
		// TODO Auto-generated method stub
		salesaccountrepository.deleteById(id);
	}

//	YourDetails 
	@Autowired
	YourDetailsRepository yourdetailsrepository;

	@Override
	public ClientYourDetails AddYourDetails(ClientYourDetails your_details, Integer client_id) {
		// TODO Auto-generated method stub
		your_details = new ClientYourDetails(your_details.getJob_function(), your_details.getOfficial_email_address(),
				your_details.getYour_job_title());
		Client client = clientrepository.findById(client_id).get();
		your_details.setClient(client);
		return yourdetailsrepository.save(your_details);
	}

	@Override
	public List<ClientYourDetails> getYourDetailsbyid(Integer client_id) {
		// TODO Auto-generated method stub
		return clientrepository.getYourDetailsbyid(client_id);
	}

	@Override
	public void UpdateYourDetailsbyUid(Integer id, String job_function, String official_email_address,
			String your_job_title) {
		// TODO Auto-generated method stub
		clientrepository.UpdateYourDetailsbyUid(id, job_function, official_email_address, your_job_title);
	}

	@Override
	public void deleteYourDetails(int id) {
		// TODO Auto-generated method stub
		yourdetailsrepository.deleteById(id);
	}

//	Country
	@Autowired
	CountryRepository countryRepository;

	@Override
	public Country AddCountry(Country country) {
		// TODO Auto-generated method stub
		return countryRepository.save(country);
	}

	@Override
	public List<Country> listAllcountry() {
		// TODO Auto-generated method stub
		return countryRepository.findAll();
	}

//	Supplier

//	@Override
//	public List<Supplier> getSupplierbyid(Integer supplier_id) {
//		// TODO Auto-generated method stub
//		return clientrepository.getSupplierbyid(supplier_id);
//	}
//
//	@Autowired
//	SupplierRepository supplierRepository;
//
//	@Autowired
//	SupplyManagersRepository supplymanagersRepository;
//
//	@Autowired
//	SupplyProjectManagersRepository supplyprojectmanagersRepository;
//
//	@Autowired
//	SupplyPanelsRepository supplyPanelsRepository;
//
//	@Autowired
//	SupplierGlobalredirectsRepository supplier_globalredirectsRepository;
//
//	@Autowired
//	SupplyFeasibiltiesRepository supplyfeasibiltiesRepository;
//
//	@Autowired
//	SupplierBidemailsRepository supplierBidemailsRepository;
//
//	@Autowired
//	SupplierAccountManagersRepository supplierAccountManagersRepository;
//
//	@Autowired
//	SupplierContactInfosRepository supplierContactInfosRepository;
//
//	public Supplier createSupplier(Supplier supplier, Integer supplier_id) {
//
//		// create an empty arrayList to stock the entities B retrieveed from the DB
//		List<SupplyManagers> lst = new ArrayList<>();
//
//		// get the entities B from the JSON and sabe it to the DB
//		for (SupplyManagers supply_managers : supplier.getSupply_managers()) {
//			supply_managers.setSupplier(supplier);
//			supplymanagersRepository.save(supply_managers); // you should save entities B to the DataBase before
//			Optional<SupplyManagers> opt = supplymanagersRepository.findById(supply_managers.getId());
//			SupplyManagers b = opt.get();
//
//			// add the entities B retrieved from the DB to the arrayList
//			lst.add(b);
//		}
//
//		//////////////////////
//		List<SupplyProjectManagers> spm = new ArrayList<>();
//
//		for (SupplyProjectManagers supply_project_managers : supplier.getSupply_project_managers()) {
//			supply_project_managers.setSupplier(supplier);
//			supplyprojectmanagersRepository.save(supply_project_managers);
//			Optional<SupplyProjectManagers> opt = supplyprojectmanagersRepository
//					.findById(supply_project_managers.getId());
//			SupplyProjectManagers b = opt.get();
//
//			spm.add(b);
//		}
//
//		////////////////////
//
//		List<SupplyPanels> sp = new ArrayList<>();
//
//		for (SupplyPanels supply_panels : supplier.getSupply_panels()) {
//			supply_panels.setSupplier(supplier);
//			supplyPanelsRepository.save(supply_panels);
//			Optional<SupplyPanels> opt = supplyPanelsRepository.findById(supply_panels.getId());
//			SupplyPanels b = opt.get();
//			sp.add(b);
//		}
//
//		///////////////////
//
//		List<SupplierGlobalredirects> sgr = new ArrayList<>();
//
//		for (SupplierGlobalredirects supplier_globalredirects : supplier.getSupplier_global_redirects()) {
//			supplier_globalredirects.setSupplier(supplier);
//			supplier_globalredirectsRepository.save(supplier_globalredirects);
//			Optional<SupplierGlobalredirects> opt = supplier_globalredirectsRepository
//					.findById(supplier_globalredirects.getId());
//			SupplierGlobalredirects b = opt.get();
//			sgr.add(b);
//		}
//
/////////////////////
//
//		List<SupplierBidemails> sbe = new ArrayList<>();
//
//		for (SupplierBidemails supplier_bidemails : supplier.getSupplier_bidemails()) {
//			supplier_bidemails.setSupplier(supplier);
//			supplierBidemailsRepository.save(supplier_bidemails);
//			Optional<SupplierBidemails> opt = supplierBidemailsRepository.findById(supplier_bidemails.getId());
//			SupplierBidemails b = opt.get();
//			sbe.add(b);
//		}
//
//////////////////////
//
//		List<SupplyFeasibilties> sf = new ArrayList<>();
//
//		for (SupplyFeasibilties supply_feasibilties : supplier.getSupply_feasibilties()) {
//			supply_feasibilties.setSupplier(supplier);
//			supplyfeasibiltiesRepository.save(supply_feasibilties);
//			Optional<SupplyFeasibilties> opt = supplyfeasibiltiesRepository.findById(supply_feasibilties.getId());
//			SupplyFeasibilties b = opt.get();
//			sf.add(b);
//		}
//
//////////////////////
//
//		List<SupplierAccountManagers> sam = new ArrayList<>();
//
//		for (SupplierAccountManagers supplier_account_managers : supplier.getSupplier_account_managers()) {
//			supplier_account_managers.setSupplier(supplier);
//			supplierAccountManagersRepository.save(supplier_account_managers);
//			Optional<SupplierAccountManagers> opt = supplierAccountManagersRepository
//					.findById(supplier_account_managers.getId());
//			SupplierAccountManagers b = opt.get();
//			sam.add(b);
//		}
//
/////////////////////
//
//		List<SupplierContactInfos> sci = new ArrayList<>();
//
//		for (SupplierContactInfos supplier_contact_infos : supplier.getSupplier_contact_infos()) {
//			supplier_contact_infos.setSupplier(supplier);
//			supplierContactInfosRepository.save(supplier_contact_infos);
//			Optional<SupplierContactInfos> opt = supplierContactInfosRepository
//					.findById(supplier_contact_infos.getId());
//			SupplierContactInfos b = opt.get();
//			sci.add(b);
//		}
//
/////////////////////
//
//		//////////
//
//		supplier.setSupply_managers(lst);
//		supplier.setSupply_project_managers(spm);
//		supplier.setSupply_panels(sp);
//		supplier.setSupplier_global_redirects(sgr);
//		supplier.setSupply_feasibilties(sf);
//		supplier.setSupplier_bidemails(sbe);
//		supplier.setSupplier_account_managers(sam);
//		supplier.setSupplier_contact_infos(sci);
//
//		// save the supplier to the DB
//		return supplierRepository.save(supplier);
//	}

}
