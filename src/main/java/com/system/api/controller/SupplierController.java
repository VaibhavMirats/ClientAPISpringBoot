package com.system.api.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.system.api.model.Supplier;
import com.system.api.model.Survey;
import com.system.api.service.SystemServiceImpl;

@RestController
@RequestMapping(value = "/api/v1")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SupplierController {
	
	
	@Autowired
	SystemServiceImpl systemservice;

	@RequestMapping(value = "/getsuppliersListByClient",produces = {MediaType.APPLICATION_JSON_VALUE})
	public String getsuppliersListByClient() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate
				.exchange("http://192.168.1.39:7000/api/v1/get-suppliers-details", HttpMethod.GET, entity, String.class)
				.getBody();
	}
	
	@RequestMapping(value = "/getsuppliersListById/{id}",produces = {MediaType.APPLICATION_JSON_VALUE})
	public String getsuppliersListById(@PathVariable("id") String id) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate
				.exchange("http://192.168.1.39:7000/api/v1/get-supplier/" + id, HttpMethod.GET, entity, String.class)
				.getBody();
	}

	  @RequestMapping(value = "/updateSupplierByClient/{id}", method = RequestMethod.PUT,produces = {MediaType.APPLICATION_JSON_VALUE})
	   public String updateSupplierByClient(@PathVariable("id") String id, @RequestBody Supplier supplier) {
	      HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<Supplier> entity = new HttpEntity<Supplier>(supplier,headers);
	      RestTemplate restTemplate = new RestTemplate();
	      return restTemplate.exchange(
	         "http://192.168.1.39:4000/api/v1/suppliers/update/"+id, HttpMethod.PUT, entity, String.class).getBody();
	   }
	
	
	@RequestMapping(value = "/deleteSupplierByClient/{id}", method = RequestMethod.DELETE,produces = {MediaType.APPLICATION_JSON_VALUE})
	public String deleteSupplierByClient(@PathVariable("id") String id) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Survey> entity = new HttpEntity<Survey>(headers);
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.exchange("http://192.168.1.39:4000/api/v1/suppliers/delete/" + id,
				HttpMethod.DELETE, entity, String.class).getBody();
	}

}
