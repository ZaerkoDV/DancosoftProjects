/**
 * 
 */
package com.dancosoft.socialcommunity.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.dancosoft.socialcommunity.dao.testsupport.TestObjectDAOCreator;
import com.dancosoft.socialcommunity.dao.testsupport.TestStarter;
import com.dancosoft.socialcommunity.model.Country;

/**
 * @author Zaerko_DV
 *
 */
public class CountryDAOTest {//extends TestStarter {

//	private static final Logger logger = LoggerFactory.getLogger(CountryDAOTest.class);
//
//	@Autowired
//	@Qualifier("countryDAO")
//	private CountryDAO countryDAO;
//
//	@Autowired
//	@Qualifier("testObjectDAOCreator")
//	private TestObjectDAOCreator testObjectDAOCreator;
//
//	public void setCountryDAO(CountryDAO countryDAO) {
//		this.countryDAO = countryDAO;
//	}
//
//	public void setTestObjectDAOCreator(TestObjectDAOCreator testObjectDAOCreator) {
//		this.testObjectDAOCreator = testObjectDAOCreator;
//	}
//
//	public Country country;
//
//	@Before
//	public void initObjectsBeforeTest() {
//		this.country = testObjectDAOCreator.createCountryForTest();
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testSearchingCountryByCountryName() {
//
//		logger.info("CountryDAOTest: test method SearchCountryByCountryName");
//		Assert.assertNotNull(countryDAO.searchCountryByCountryName(country.getCountryName()));
//	}
}
