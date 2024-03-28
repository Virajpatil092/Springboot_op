package com.springboot.web.helper;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class fileUploadHelper {
	public final String UPLOAD_DIR="/Documents/springboot_op/springapi/src/main/resources/static/images";
	
	public boolean uploadfile(MultipartFile file) {
		boolean f = false;
		
		try {
			Files.copy(file.getInputStream(), Paths.get(UPLOAD_DIR + File.separator + file.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
			
			f = true;
		}
		catch(Exception e) {
			
		}
		
		return f;
	}
}