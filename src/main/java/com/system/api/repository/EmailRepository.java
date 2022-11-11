package com.system.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.system.api.model.Client;
import com.system.api.model.DBFile;


public interface EmailRepository extends JpaRepository<DBFile, Integer> {




//	Customer
	@Query("SELECT l FROM Client l WHERE id=:client_id")
	public List<Client> getCustomerbyUid(@Param("client_id")Integer client_id);

	@Modifying
	@Query("UPDATE Client u SET u.company_email=:company_email,u.company_name=:company_name WHERE u.id=:id")
	public void UpdateCustomerbyUid(@Param("id")Integer id,@Param("company_email") String company_email,@Param("company_name") String company_name);
}