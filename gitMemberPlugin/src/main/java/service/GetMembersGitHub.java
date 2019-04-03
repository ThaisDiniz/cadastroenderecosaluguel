package service;


import java.io.Serializable;
import java.util.Base64;
import java.util.Collections;
import java.util.Properties;
import java.util.logging.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import vo.Quote;

@SpringBootApplication
public class GetMembersGitHub implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Properties PROPERTIES = new Properties();
	private static final String PROPERTY_CONSUMER_KEY = "consumerKey";
	private static int HTTP_COD_SUCESSO = 200;
 //   private static final Logger log = LoggerFactory.getLogger(GetMembersGitHub.class);

	 
	

    private void obterListaMembros(String URI) 
	 { 
		 	RestTemplate restTemplate = new RestTemplate();
		    String requestJson = getRequetJson();

		    //
		    HttpHeaders headers = new HttpHeaders();
		    String userPass = "SERID" + ":" +" PWORD";
		    String authHeaderValue = "Basic " + Base64.getEncoder().encodeToString(userPass.getBytes());
		    headers.set(HttpHeaders.AUTHORIZATION, authHeaderValue);
		    headers.setContentType(MediaType.APPLICATION_JSON);
		    headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		    HttpEntity<String> request = new HttpEntity<String>(requestJson, headers);
		    //
		    ResponseEntity<Quote> responseEntity =restTemplate.exchange(URI, HttpMethod.POST, request, Quote.class);

		    responseEntity.getBody();
	 }
	 
	 private String getRequetJson() {
		 	String token ="this is token";
	        ObjectMapper mapper = new ObjectMapper();
	        JsonNode rootNode = mapper.createObjectNode();

	        ((ObjectNode) rootNode).put("token", token);
	        String jsonString = null;
	        try {
	            jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(rootNode);
	        } catch (JsonProcessingException e) {

	            e.printStackTrace();
	        }
	        return jsonString;

	    }
	 

}
