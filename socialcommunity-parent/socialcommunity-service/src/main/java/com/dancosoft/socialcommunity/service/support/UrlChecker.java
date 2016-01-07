package com.dancosoft.socialcommunity.service.support;

import org.apache.commons.validator.UrlValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class UrlChecker{

	private static final Logger logger = LoggerFactory.getLogger(UrlChecker.class);
	
	public Boolean isValidURL(String url){

		UrlValidator urlValidator;
		Boolean isValid;
		if(url.equals(null)){
			logger.info("Service:Validation url isn't finish. Url must not be null");
			throw new RuntimeException("UserPhotoService: Validation url isn't finish. Url must not be null");
			
		}else{
			urlValidator = new UrlValidator();
			isValid=urlValidator.isValid(url);
			logger.info("UserPhotoService: Cheack url on valid comleted.");
		}
		return isValid;	
	}
}
