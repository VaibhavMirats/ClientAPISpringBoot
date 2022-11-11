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

import com.system.api.model.Survey;
import com.system.api.service.SystemServiceImpl;

@RestController
@RequestMapping(value = "/api/v1")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SurveyController {

	@Autowired
	SystemServiceImpl systemservice;

	@RequestMapping(value = "/getSurveyListByClient/{id}")
	public String getSurveyListByClient(@PathVariable("id") String id) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate
				.exchange("http://192.168.1.41:3031/api/v1/survey/get/" + id, HttpMethod.GET, entity, String.class)
				.getBody();
	}

	  @RequestMapping(value = "/updateSurveyByClient/{id}", method = RequestMethod.PUT)
	   public String updateSurveyByClient(@PathVariable("id") String id, @RequestBody Survey survey) {
	      HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<Survey> entity = new HttpEntity<Survey>(survey,headers);
	      RestTemplate restTemplate = new RestTemplate();
	      return restTemplate.exchange(
	         "http://192.168.1.41:3031/api/v1/survey/update/basicInfo/"+id, HttpMethod.PUT, entity, String.class).getBody();
	   }
	
	
	@RequestMapping(value = "/deleteSurveyByClient/{id}", method = RequestMethod.DELETE)
	public String deleteSurveyByClient(@PathVariable("id") String id) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Survey> entity = new HttpEntity<Survey>(headers);
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.exchange("http://192.168.1.41:3031/api/v1/survey/delete/" + id,
				HttpMethod.DELETE, entity, String.class).getBody();
	}

}
