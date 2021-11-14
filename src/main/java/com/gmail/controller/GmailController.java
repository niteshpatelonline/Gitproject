package com.gmail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gmail.model.Gmail;
import com.gmail.service.GmailService;

@RestController
@CrossOrigin("*")
public class GmailController {

	@Autowired
	private GmailService gmailService;
	
	@RequestMapping(method=RequestMethod.GET,value="/")
	public String welcome() {
		
		return "index.html";
	}
	
	@PostMapping(value="/sendEmail")
	public ResponseEntity<?> sendingEmail(@RequestBody Gmail gmailRequest){
		
		boolean result = gmailService.sendGmail(gmailRequest);
		if(result)
		{
			return   ResponseEntity.status(HttpStatus.OK).build();
		}
		else {
			return   ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
}
