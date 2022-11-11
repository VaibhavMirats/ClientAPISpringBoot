package com.system.api.controller;


import java.util.Arrays;
import java.util.Random;

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
import com.system.api.model.SalesOrders;
import com.system.api.model.Survey;
import com.system.api.service.SystemServiceImpl;

@RestController
@RequestMapping(value = "/api/v1/suppliers")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SalesOrderController {
	@Autowired
	SystemServiceImpl systemservice;
	
	
	@RequestMapping(value="/createSalesOrders",
			method = RequestMethod.POST,
			produces = {MediaType.APPLICATION_JSON_VALUE},
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	public SalesOrders createSalesOrders(@RequestBody SalesOrders sales_orders ) {
		System.out.println("Sales Orders ="+ sales_orders );
		sales_orders.setId(new Random().nextInt());
		return sales_orders;
	}
	
	 @RequestMapping(value = "/getClientAndSaleaOrderList/{id}",produces = {MediaType.APPLICATION_JSON_VALUE})
	   public String getClientAndSaleaOrderList(@PathVariable("id") String id) {
	      HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity <String> entity = new HttpEntity<String>(headers);
	      RestTemplate restTemplate = new RestTemplate();
	      return restTemplate.exchange("http://192.168.1.39:7000/api/v1/get-salesorders/"+id, HttpMethod.GET, entity, String.class).getBody();
	   }
	
	  @RequestMapping(value = "/updateSalesByClient/{id}", method = RequestMethod.PUT,produces = {MediaType.APPLICATION_JSON_VALUE})
	   public String updateSalesByClient(@PathVariable("id") String id, @RequestBody Survey survey) {
	      HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<Survey> entity = new HttpEntity<Survey>(survey,headers);
	      RestTemplate restTemplate = new RestTemplate();
	      return restTemplate.exchange(
	         "http://192.168.1.39:4000/api/v1/suppliers/update//"+id, HttpMethod.PUT, entity, String.class).getBody();
	   }
	
	
	   @RequestMapping(value = "/deleteSalesOrderUsingClient/{id}", method = RequestMethod.DELETE,produces = {MediaType.APPLICATION_JSON_VALUE})
	   public String deleteSalesOrderUsingClient(@PathVariable("id") String id) {
	      HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<SalesOrders> entity = new HttpEntity<SalesOrders>(headers);
	      RestTemplate restTemplate = new RestTemplate();
	      return restTemplate.exchange(
	         "http://192.168.1.39:7000/api/v1/salesorders/salesorders-delete/"+id, HttpMethod.DELETE, entity, String.class).getBody();
	   }
	
	   
	   

	
	
}
