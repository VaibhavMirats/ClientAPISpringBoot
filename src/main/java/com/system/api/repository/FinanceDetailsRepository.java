package com.system.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.system.api.model.ClientFinanceDetails;

public interface FinanceDetailsRepository extends JpaRepository<ClientFinanceDetails, Integer>{

}
