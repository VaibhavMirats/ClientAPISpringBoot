package com.system.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.system.api.model.Country;


public interface CountryRepository extends JpaRepository<Country, Integer> {

}
