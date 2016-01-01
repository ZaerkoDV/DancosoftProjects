/**
 * 
 */
package com.dancosoft.socialcommunity.dao;

import java.util.List;





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
import com.dancosoft.socialcommunity.model.City;
import com.dancosoft.socialcommunity.model.Country;

/**
 * @author Zaerko_DV
 *
 */
public class CityDAOTest extends TestStarter {

	private static final Logger logger = LoggerFactory.getLogger(CityDAOTest.class);

	@Autowired
	@Qualifier("cityDAO")
	private CityDAO cityDAO;

	@Autowired
	@Qualifier("testObjectDAOCreator")
	private TestObjectDAOCreator testObjectDAOCreator;

	public void setCityDAO(CityDAO cityDAO) {
		this.cityDAO = cityDAO;
	}

	public void setTestObjectDAOCreator(TestObjectDAOCreator testObjectDAOCreator) {
		this.testObjectDAOCreator = testObjectDAOCreator;
	}

	public City city;
	public Country country;

	@Before
	public void initObjectsBeforeTest() {
		this.city = testObjectDAOCreator.createCityForTest();
		this.country = city.getCountry();
	}

	@Transactional
	@Rollback(true)
	@Test
	public void testGettingListCityByIdCountry() {

		logger.info("CityDAOTest: test method GetListCityByIdCountry");
		List<City> list=cityDAO.getListCityByIdCountry(country.getIdCountry());
		Assert.assertFalse(list.isEmpty());
	}
	
	@Transactional
	@Rollback(true)
	@Test
	public void testGettingCountryByIdCity() {

		logger.info("CityDAOTest: test method GetCountryByIdCity");
		Assert.assertNotNull(cityDAO.getCountryByIdCity(city.getIdCity()));
	}
	
	@Transactional
	@Rollback(true)
	@Test
	public void testSearchingCityByCityName() {

		logger.info("CountryDAOTest: test method SearchCityByCityName");
		Assert.assertNotNull(cityDAO.searchCityByCityName(city.getCityName()));
	}
}
