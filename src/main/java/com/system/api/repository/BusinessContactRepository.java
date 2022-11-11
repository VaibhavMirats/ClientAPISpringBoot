package com.system.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.system.api.model.ClientBusinessContact;

public interface BusinessContactRepository extends JpaRepository<ClientBusinessContact, Integer>{

}
