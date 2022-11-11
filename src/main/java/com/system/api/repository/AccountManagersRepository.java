package com.system.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.system.api.model.ClientAccountManagers;


public interface AccountManagersRepository extends JpaRepository<ClientAccountManagers, Integer> {

}
