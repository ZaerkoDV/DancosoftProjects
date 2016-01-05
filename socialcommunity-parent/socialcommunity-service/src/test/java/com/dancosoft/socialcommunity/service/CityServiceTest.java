/**
 * 
 */
package com.dancosoft.socialcommunity.service;

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

import com.dancosoft.socialcommunity.model.City;
import com.dancosoft.socialcommunity.model.Country;
import com.dancosoft.socialcommunity.service.testsupport.TestObjectServiceCreator;
import com.dancosoft.socialcommunity.service.testsupport.TestStarter;

/**
 * @author Zaerko_DV
 *
 */
public class CityServiceTest {//extends TestStarter {

//	private static final Logger logger = LoggerFactory.getLogger(CityServiceTest.class);
//	
//	@Autowired
//	@Qualifier("cityService")
//	private CityService cityService;
//
//	@Autowired
//	@Qualifier("testObjectServiceCreator")
//	private TestObjectServiceCreator testObjectServiceCreator;
//
//	public void setCityService(CityService cityService) {
//		this.cityService = cityService;
//	}
//
//	public void setTestObjectServiceCreator(
//			TestObjectServiceCreator testObjectServiceCreator) {
//		this.testObjectServiceCreator = testObjectServiceCreator;
//	}
//	
//	public City city;
//	public Country country;
//
//	@Before
//	public void initObjectsBeforeTest() {
//		this.city = testObjectServiceCreator.createCityForTest();
//		this.country = city.getCountry();
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingListCityByIdCountry() {
//		logger.info("CityServiceTest: test method GetListCityByIdCountry");
//		List<City> list=cityService.getListCityByIdCountry(country.getIdCountry());
//		Assert.assertFalse(list.isEmpty());
//	}
//	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingCountryByIdCity() {
//		logger.info("CityServiceTest: test method GetCountryByIdCity");
//		Assert.assertNotNull(cityService.getCountryByIdCity(city.getIdCity()));
//	}
//	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testSearchingCityByCityName() {
//		logger.info("CityServiceTest: test method SearchCityByCityName");
//		List<City>list=cityService.searchCityByCityName(city.getCityName());
//		Assert.assertFalse(list.isEmpty());
//	}
}
