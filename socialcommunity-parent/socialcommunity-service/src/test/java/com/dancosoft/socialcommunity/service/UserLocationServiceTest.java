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
public class UserLocationServiceTest {//extends TestStarter {

//	private static final Logger logger = LoggerFactory.getLogger(UserLocationServiceTest.class);
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
//	public void setCountryService(CountryService countryService) {
//		this.countryService = countryService;
//	}
//
//	public User user;
//	public UserLocation userLocation;
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
//	public UserLocation createUserLocationForTest() {
//
//		User testUser = createUserForTest();
//		Language testLanguage = createLanguageForTest();
//		City testCity = createCityForTest();
//		UserLocation testUserLocation = new UserLocation();
//		testUserLocation.setUser(testUser);
//		testUserLocation.setLanguage(testLanguage);
//		testUserLocation.setCity(testCity);
//		userLocationService.saveUserLocation(testUserLocation);
//
//		return testUserLocation;
//	}
//	
//	@Before
//	public void initObjectsBeforeTest() {
//		this.userLocation = createUserLocationForTest();
//		this.user = userLocation.getUser();
//	}
//	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingUserLocationByIdUser() {
//
//		logger.info("UserLocationServiceTest: test method GetUserLocationByIdUser");
//		Assert.assertNotNull(userLocationService.getUserLocationByIdUser(user.getIdUser()));
//	}
//	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingUserLanguageByIdUser() {
//		logger.info("UserLocationServiceTest: test method GetUserLanguageByIdUser");
//		Assert.assertNotNull(userLocationService.getUserLanguageByIdUser(user.getIdUser()));
//	}
//	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingUserCityByIdUser() {
//		logger.info("UserLocationServiceTest: test method GetUserCityByIdUser");
//		Assert.assertNotNull(userLocationService.getUserCityByIdUser(user.getIdUser()));
//	}
//	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingUserCountryByIdUser() {
//		logger.info("UserLocationServiceTest: test method GetUserCountryByIdUser");
//		Assert.assertNotNull(userLocationService.getUserCountryByIdUser(user.getIdUser()));
//	}
}
