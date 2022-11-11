package com.system.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.system.api.model.ClientYourDetails;


public interface YourDetailsRepository extends JpaRepository<ClientYourDetails, Integer> {

}
