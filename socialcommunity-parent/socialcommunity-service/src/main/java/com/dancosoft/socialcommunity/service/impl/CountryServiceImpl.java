/**
 * 
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
 * @author Zaerko_DV
 *
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
