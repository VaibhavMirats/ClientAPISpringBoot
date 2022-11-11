package com.system.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.system.api.model.ClientCompanyDetails;


public interface CompanyDetailsRepository extends JpaRepository<ClientCompanyDetails, Integer>{

}
