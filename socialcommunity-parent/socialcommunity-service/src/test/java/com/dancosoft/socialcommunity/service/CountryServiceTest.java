/**
 * 
 */
package com.dancosoft.socialcommunity.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.dancosoft.socialcommunity.model.Country;
import com.dancosoft.socialcommunity.service.testsupport.TestObjectServiceCreator;
import com.dancosoft.socialcommunity.service.testsupport.TestStarter;

/**
 * @author Zaerko_DV
 *
 */
public class CountryServiceTest extends TestStarter {

	private static final Logger logger = LoggerFactory.getLogger(CountryServiceTest.class);
	
	@Autowired
	@Qualifier("countryService")
	private CountryService countryService;

	@Autowired
	@Qualifier("testObjectServiceCreator")								
	private TestObjectServiceCreator testObjectServiceCreator;

	public void setCountryService(CountryService countryService) {
		this.countryService = countryService;
	}

	public void setTestObjectServiceCreator(TestObjectServiceCreator testObjectServiceCreator) {
		this.testObjectServiceCreator = testObjectServiceCreator;
	}
	
	public Country country;

	@Before
	public void initObjectsBeforeTest() {
		this.country = testObjectServiceCreator.createCountryForTest();
	}

	@Transactional
	@Rollback(true)
	@Test
	public void testSearchingCountryByCountryName() {

		logger.info("CountryServiceTest: test method SearchCountryByCountryName");
		Assert.assertNotNull(countryService.searchCountryByCountryName(country.getCountryName()));
	}
}
