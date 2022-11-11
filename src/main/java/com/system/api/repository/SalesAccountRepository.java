package com.system.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.system.api.model.ClientSalesAccount;


public interface SalesAccountRepository extends JpaRepository<ClientSalesAccount, Integer>{ 

}
