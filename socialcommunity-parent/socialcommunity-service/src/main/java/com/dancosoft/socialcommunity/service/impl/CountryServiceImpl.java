/**
 * @package com.dancosoft.socialcommunity.service.impl
 * 
 * Package com.dancosoft.socialcommunity.service.impl contain set of class which description
 * service layer(modul) in SocialCommunity project. This project based on MVC architecture.
 * This class is part of service layer in MVC architecture.This layer defines the boundary
 * of the application and a set of permitted operations. It encapsulates the business logic
 * of the application and controls the answers in the implementation of operations.All classes
 * which contain postfix “Service” provide to work Service for SocialCommunity application.
 * Also this package user support classes: for generate new passworl and login,for sending
 * email to user and other from com.dancosoft.socialcommunity.service.support package.
 * 
 * Please contact with Zaerko Denis or send letter on zaerko1991@gmail.com if you need
 * to use information or have any questions.   
 */
package com.dancosoft.socialcommunity.service.impl;

import javax.persistence.NonUniqueResultException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.stereotype.Service;

import com.dancosoft.socialcommunity.dao.CountryDAO;
import com.dancosoft.socialcommunity.model.Country;
import com.dancosoft.socialcommunity.service.CountryService;

/**
 * <p>The class CountryServiceImpl use Service pattern which describes business
 * logic SocialCommunity application. Service layer perform link between,
 * presentation layer and DAO layer(CountryDAO).This layer is the main role
 * becouse layer contents(set of methods in classes) affect on functionality of
 * all application. This class contain methods which describes specific
 * operation for Country.This class perform service layer to Country.Class
 * extend base class CommonEntityServiceImpl and implement CountryService
 * interface which perform all methods of this class. For logging use fasade
 * slf4j and framework log4j. Class contain also private, static variable
 * logger, which use to call log message. Class use Spring framework anatations
 * to work with service layer.
 * 
 * @see org.springframework.stereotype
 * @see slf4j framework
 * @see log4j framework
 * 
 * @version 1.0 05.01.2016
 * @author Zaerko Denis
 */
@Service(value="countryService")
public class CountryServiceImpl extends CommonEntityServiceImpl implements CountryService {

	private static final Logger logger = LoggerFactory.getLogger(CountryServiceImpl.class);
	
	@Autowired
	@Qualifier(value="countryDAO")
	private CountryDAO countryDAO;

	public void setCountryDAO(CountryDAO countryDAO) {
		this.countryDAO = countryDAO;
	}
	
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
	public Country searchCountryByCountryName(String countryName) {
		
		Country country = null;
		if(countryName.equals(null) && countryName.equals("")){
			throw new RuntimeException("CountryService: Id Country must not null.");
		} else {
			try {
				logger.info("CountryService: Country load by country name.");
				country=countryDAO.searchCountryByCountryName(countryName);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("CountryService: Country with name "+countryName+" not exist in data base " + rf);
			
			}catch (NonUniqueResultException nu) {
				logger.error("CountryService: Data base contain more then one result search. " + nu);	
				
			} catch (DataAccessException da) {
				logger.error("CountryService: Exeption connect with data base or other error. "+da);
			}
		}
		 return country;
	}
}
