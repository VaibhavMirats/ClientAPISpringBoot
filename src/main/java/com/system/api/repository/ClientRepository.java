package com.system.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.system.api.model.ClientAccountManagers;
import com.system.api.model.ClientBusinessContact;
import com.system.api.model.ClientCompanyDetails;
import com.system.api.model.Client;
import com.system.api.model.ClientSupplyManagers;
import com.system.api.model.ClientFinanceDetails;
import com.system.api.model.ClientProjectManagers;
import com.system.api.model.ClientSalesAccount;
import com.system.api.model.ClientYourDetails;


public interface ClientRepository extends JpaRepository<Client, Integer>{

//	ClientAccountManagers
	@Query("SELECT l FROM ClientAccountManagers l WHERE client_id=:client_id")
	public List<ClientAccountManagers> getAccountManagersbyid(@Param("client_id")Integer client_id);

	@Modifying
	@Query("UPDATE ClientAccountManagers u SET u.email=:email,u.name=:name,u.phone=:phone WHERE u.id=:id")
	public void UpdateAccountManagersbyUid(@Param("id")Integer id, @Param("email")String email,@Param("name") String name,@Param("phone") String phone);

//	ProjectManagers
	@Query("SELECT l FROM ClientProjectManagers l WHERE client_id=:client_id")
	public List<ClientProjectManagers> getProjectManagersbyid(@Param("client_id")Integer client_id);

	@Modifying
	@Query("UPDATE ClientProjectManagers u SET u.email=:email,u.name=:name,u.phone=:phone WHERE u.id=:id")
	public void UpdateProjectManagersbyUid(@Param("id")Integer id, @Param("email")String email,@Param("name") String name,@Param("phone") String phone);

	
//	SupplyManagers
	@Query("SELECT l FROM ClientSupplyManagers l WHERE client_id=:client_id")
	public List<ClientSupplyManagers> getSupplyManagersbyid(@Param("client_id")Integer client_id);

	@Modifying
	@Query("UPDATE ClientSupplyManagers u SET u.email=:email,u.name=:name,u.phone=:phone WHERE u.id=:id")
	public void UpdateSupplyManagersbyUid(@Param("id")Integer id, @Param("email")String email,@Param("name") String name,@Param("phone") String phone);

//	BusinessContact
	@Query("SELECT l FROM ClientBusinessContact l WHERE client_id=:client_id")
	public List<ClientBusinessContact> getBusinessContactbyid(@Param("client_id")Integer client_id);

	@Modifying
	@Query("UPDATE ClientBusinessContact u SET u.email=:email,u.name=:name,u.phone=:phone WHERE u.id=:id")
	public void UpdateBusinessContactbyUid(@Param("id")Integer id, @Param("email")String email,@Param("name") String name,@Param("phone") String phone);

//	CompanyDetails
	
	@Query("SELECT l FROM ClientCompanyDetails l WHERE client_id=:client_id")
	public List<ClientCompanyDetails> getCompanyDetailsbyid(@Param("client_id")Integer client_id);

	@Modifying
	@Query("UPDATE ClientCompanyDetails u SET u.company_employee_size=:company_employee_size,u.company_name=:company_name,u.company_registred_number=:company_registred_number WHERE u.id=:id")
	public void UpdateCompanyDetailsbyUid(@Param("id")Integer id, @Param("company_employee_size")String company_employee_size,@Param("id") String company_name,
			@Param("company_registred_number")String company_registred_number);

	
//	FinanceDetails
	@Query("SELECT l FROM ClientFinanceDetails l WHERE client_id=:client_id")
	public List<ClientFinanceDetails> getFinanceDetailsbyid(Integer client_id);

	@Modifying
	@Query("UPDATE ClientFinanceDetails u SET u.account_number=:account_number,u.bank_name=:bank_name,u.contact_person_name=:contact_person_name, u.ifsc=:ifsc WHERE u.id=:id")
	public void UpdateFinanceDetailsbyUid(@Param("id")Integer id,@Param("account_number") String account_number,@Param("bank_name") String bank_name,
			@Param("contact_person_name")String contact_person_name, @Param("ifsc")String ifsc);

	
//	SalesAccount
	@Query("SELECT l FROM ClientSalesAccount l WHERE client_id=:client_id")
	public List<ClientSalesAccount> getSalesAccountbyid(@Param("client_id")Integer client_id);

	
	@Modifying
	@Query("UPDATE ClientSalesAccount u SET u.email=:email,u.name=:name,u.phone=:phone WHERE u.id=:id")
	public void UpdateSalesAccountbyUid(@Param("id")Integer id, @Param("email")String email,@Param("name") String name,@Param("phone") String phone);

//	YourDetails
	@Query("SELECT l FROM ClientYourDetails l WHERE client_id=:client_id")
	public List<ClientYourDetails> getYourDetailsbyid(@Param("client_id")Integer client_id);

	@Modifying
	@Query("UPDATE ClientYourDetails u SET u.job_function=:job_function,u.job_function=:job_function,u.official_email_address=:official_email_address, u.your_job_title=:your_job_title WHERE u.id=:id")
	public void UpdateYourDetailsbyUid(@Param("id")Integer id,@Param("job_function") String job_function, @Param("official_email_address")String official_email_address,@Param("your_job_title")String your_job_title);

	

	
	@Query("SELECT u FROM Client u WHERE u.email_id=:email_id")
	public Optional<Client> findByEmail(@Param("email_id") String email_id);
	
	

}
