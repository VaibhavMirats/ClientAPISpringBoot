package com.system.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.system.api.model.ClientProjectManagers;


public interface ProjectManagersRepository extends JpaRepository<ClientProjectManagers, Integer> {

}
