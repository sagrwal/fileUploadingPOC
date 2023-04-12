package com.primesoft.controller;

import java.io.File;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class SpringFileUploadController {
	
	
	
	@GetMapping("/index")
	public String hello() {
		return "uploader";
	}
	
	@PostMapping(value="/upload",consumes= MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<?> handleFileUpload(@RequestParam("file") MultipartFile file){
		
		
		String fileName = file.getOriginalFilename();
		
	    try {
	    	file.transferTo(new File("C:\\upload\\" +fileName));
	    }catch(Exception e) {
	    	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    	
	    }
	    return ResponseEntity.ok("File upload Successfully...");
	
	}
	
	
	
}
