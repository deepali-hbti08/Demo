package com.example.demo.controller;

import java.net.URISyntaxException;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.http.utils.Base64Coder;

@RestController
@RequestMapping(value= {"/api"})
public class ApiController {
	
	@RequestMapping(value="/executeConfluence")
	public String getValue() {
		return "deepali";
	}
	
	@RequestMapping(value = "/executeCommand")
    public ResponseEntity<Object> getConfluenceContent() throws URISyntaxException, UnirestException{ 
       HttpResponse<String> response = Unirest.get("https://testingd.atlassian.net//wiki/rest/api/content/1081345?expand=body.view")
               .header("Authorization", "Basic "+ Base64Coder.encodeString("deepali.hbti08@gmail.com:ATATT3xFfGF0ogiVMIGUW-MtQdEY7_nE7suvc_ezIPyQ3vw4F6vwsyosRla1tK_xlet1YPwJhFbPcb9z4p1zOJTDglsMY68o9p_QXYmlAVFSm-5cSsx-d46YSjJOZf3JaWOSSJ5sSWoWzQQTF4b3fND_nA5u8lXGl4jzeRupa6JjlHAMh2FlRXY=4503F088"))
               .header("content-type", "application/json")
               .asString();
     System.out.println("response ==> "+response.getBody());
     return null;
    }
	
	@RequestMapping(value = "/executePostCommand")
    public ResponseEntity<Object> createConfluencePage() throws URISyntaxException, UnirestException{ 
		String req ="{\n" + 
				"         \"space\": {\n" + 
				"\"key\": \"~6422c09aaf3b93d8ecf4332e\"\n" + 
				"   },\n" + 
				"   \"type\": \"page\",\n" + 
				"   \"title\": \"Page created from API - 2\",\n" + 
				"   \"body\": {\n" + 
				"       \"storage\": {\n" + 
				"          \"value\": \"This is my page content\",\n" + 
				"      \"representation\": \"wiki\"\n" + 
				" }\n" + 
				"    }\n" + 
				"      }";
		HttpResponse<String> response = Unirest.post("https://testingd.atlassian.net//wiki/rest/api/content/")
				 .header("Authorization", "Basic "+ Base64Coder.encodeString("deepali.hbti08@gmail.com:ATATT3xFfGF0ogiVMIGUW-MtQdEY7_nE7suvc_ezIPyQ3vw4F6vwsyosRla1tK_xlet1YPwJhFbPcb9z4p1zOJTDglsMY68o9p_QXYmlAVFSm-5cSsx-d46YSjJOZf3JaWOSSJ5sSWoWzQQTF4b3fND_nA5u8lXGl4jzeRupa6JjlHAMh2FlRXY=4503F088"))
				 .header("content-type", "application/json")
				 .body(req)
				 .asString();
				System.out.println("response ==> "+response.getBody());

     return null;
    }

	

}
