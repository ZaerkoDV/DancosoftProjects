/**
 * @package com.dancosoft.socialcommunity.service
 * 
 * Package com.dancosoft.socialcommunity.service contain set of interfaces which
 * description service layer of SocialCommunity project.Also this package contain
 * realization of interfaces in package com.dancosoft.socialcommunity.service.impl
 * and support classes in com.dancosoft.socialcommunity.service.support.This project
 * is based on MVC architecture.This inerface perform class which is part of service
 * layer in MVC architecture.This layer defines the boundary of the application and
 * a set of permitted operations. It encapsulates the business logic of the application
 * and controls the answers in the implementation of operations. All classes which
 * contain postfix “Service” provide to work Service for SocialCommunity application.
 * 
 * Please contact with Zaerko Denis or send letter on zaerko1991@gmail.com if you need
 * to use information or have any questions.   
 */
package com.dancosoft.socialcommunity.service;

import javax.persistence.NonUniqueResultException;

import org.springframework.dao.DataRetrievalFailureException;

import com.dancosoft.socialcommunity.model.Country;

/**
 * <p>The interface CountryService contain methods ads which realize in class
 * CountryServiceImpl. Class CountryServiceImpl use Service pattern which
 * describes service layer of application. This class contain general operation
 * to all classes.This interface contain ads methods which perform busness logic
 * all application. Interface extend CommonEntityService interface which contain
 * ads base operation of any entity.
 * 
 * @version 1.0 08.10.2015
 * @author Zaerko Denis
 */
public interface CountryService extends CommonEntityService {

	/**
	 * Search country by his attribute countryName. If country
	 * is not exist return null.
	 * 
	 * @type String
	 * @param countryName
	 * @exception DataRetrievalFailureException
	 * @exception NonUniqueResultException
	 * @exception DataAccessExceptio
	 * 
	 * @return Country
	 */
	public Country searchCountryByCountryName(String countryName);
}
