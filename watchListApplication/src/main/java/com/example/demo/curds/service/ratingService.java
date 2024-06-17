package com.example.demo.curds.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.node.ObjectNode;

@Service
public class ratingService {

	String apiUrl="https://www.omdbapi.com/?i=tt3896198&apikey=5993acb7&t=";
	public String getApi(String title) {
		
		RestTemplate restTemplate=new RestTemplate();
		
		try {
			
		ResponseEntity<ObjectNode> re=restTemplate.getForEntity(apiUrl+title, ObjectNode.class);	
		ObjectNode json=re.getBody();
		return json.path("imdbRating").asText();
		 
		
		} catch (Exception e) {
			System.out.println("either movie name not available or api is down"+e.getMessage());
			return null;
		}
	}
}
