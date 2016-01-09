/**
 * @package com.dancosoft.socialcommunity.service.support.url
 * 
 * Package com.dancosoft.socialcommunity.service.support contain set of classes which use
 * for support classes in service layer of SocialCommunity project.This project based on
 * MVC architecture.Service layer defines the boundary of the application and a set of
 * permitted operations. It encapsulates the business logic of the application and controls
 * the answers in the implementation of operations. Also this package user support classes:
 * for generate new passworl and login,for sending email to user and other.
 * 
 * Please contact with Zaerko Denis or send letter on zaerko1991@gmail.com if you need
 * to use information or have any questions.   
 */
package com.dancosoft.socialcommunity.service.support.url;

import org.apache.commons.validator.UrlValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>The class UrlCheckerl use for support special operaton in classes
 * of service layer and controller of SocialCommunity project. Class contain
 * only public methods. This methods use for special operation with url addresse.
 * For logging use fasade slf4j and framework log4j. Class contain also private,
 * static variable logger, which use to call log message. Class use Spring framework
 * anatations to work with service layer. 
 *  
 * @see slf4j framework
 * @see log4j framework
 * @see org.apache.commons.validator.UrlValidator
 * 
 * @version 1.0 05.01.2016
 * @author Zaerko Denis
 */
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
