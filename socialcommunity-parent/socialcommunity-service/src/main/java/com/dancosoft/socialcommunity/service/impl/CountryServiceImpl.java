/**
 * 
 */
package com.dancosoft.socialcommunity.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
		logger.info("CountryService: Country load by country name.");
		return countryDAO.searchCountryByCountryName(countryName);
	}
}
