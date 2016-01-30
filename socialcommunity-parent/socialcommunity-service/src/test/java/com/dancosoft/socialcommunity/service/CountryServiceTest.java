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

import com.dancosoft.socialcommunity.model.City;
import com.dancosoft.socialcommunity.model.Country;
import com.dancosoft.socialcommunity.model.Language;
import com.dancosoft.socialcommunity.model.User;
import com.dancosoft.socialcommunity.model.UserLocation;
import com.dancosoft.socialcommunity.service.testsupport.TestStarter;

/**
 * @author Zaerko_DV
 *
 */
public class CountryServiceTest {//extends TestStarter {

//	private static final Logger logger = LoggerFactory.getLogger(CountryServiceTest.class);
//	
//	@Autowired
//	@Qualifier(value="userService")
//	private UserService userService;
//
//	public void setUserService(UserService userService) {
//		this.userService = userService;
//	}
//	
//	@Autowired
//	@Qualifier(value="userLocationService")
//	private UserLocationService userLocationService;
//
//	public void setUserLocationService(UserLocationService userLocationService) {
//		this.userLocationService = userLocationService;
//	}
//	
//	@Autowired 
//	@Qualifier(value="languageService")
//	private LanguageService languageService;
//
//	public void setLanguageService(LanguageService languageService) {
//		this.languageService = languageService;
//	}
//
//	@Autowired
//	@Qualifier("cityService")
//	private CityService cityService;
//
//	public void setCityService(CityService cityService) {
//		this.cityService = cityService;
//	}
//	
//	@Autowired
//	@Qualifier(value="countryService")
//	private CountryService countryService;
//
//	public void setCountry(Country country) {
//		this.country = country;
//	}
//
//	public User user;
//	public UserLocation userLocation;
//	public City city;
//	public Country country;
//
//	public User createUserForTest() {
//		User testUser = new User();
//		testUser.setFirstName("testFirstName");
//		testUser.setLastName("testLastName");
//		testUser.setMiddleName("testMiddleName");
//		testUser.setSex("F");
//		userService.saveUser(testUser);
//
//		return testUser;
//	}
//	
//	public Country createCountryForTest() {
//		Country testCountry = new Country();
//		testCountry.setCountryName("UK");
//		countryService.saveCountry(testCountry);
//
//		return testCountry;
//	}
//	
//	public City createCityForTest() {
//		Country testCountry = createCountryForTest();
//		City testCity = new City();
//		testCity.setCityName("London");
//		testCity.setCountry(testCountry);
//		cityService.saveCity(testCity);
//
//		return testCity;
//	}
//	
//	public Language createLanguageForTest() {
//		Language testLanguage = new Language();
//		testLanguage.setLanguageName("English");
//		languageService.saveLanguage(testLanguage);
//		
//		return testLanguage;
//	}
//
//	@Before
//	public void initObjectsBeforeTest() {
//		this.country = createCountryForTest();
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testSearchingCountryByCountryName() {
//
//		logger.info("CountryServiceTest: test method SearchCountryByCountryName");
//		Assert.assertNotNull(countryService.searchCountryByCountryName(country.getCountryName()));
//	}
}
