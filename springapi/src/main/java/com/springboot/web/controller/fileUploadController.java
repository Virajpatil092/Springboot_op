package com.springboot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.springboot.web.helper.fileUploadHelper;

@RestController
public class fileUploadController {
	
	@Autowired
	private fileUploadHelper fileuploadhelper;
	
	@PostMapping("/upload-file")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file){
		try {
			
			if(file.isEmpty()) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contain file");
			}
		
			// upload file to directory
			
			boolean f = this.fileuploadhelper.uploadfile(file);
			
			if(f) {
				return ResponseEntity.ok("Successfully uploaded");
			}
			else {
				return ResponseEntity.ok("can't upload");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
		
		
	}
}