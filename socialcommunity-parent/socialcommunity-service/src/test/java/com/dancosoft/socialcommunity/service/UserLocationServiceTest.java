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

import com.dancosoft.socialcommunity.model.User;
import com.dancosoft.socialcommunity.model.UserLocation;
import com.dancosoft.socialcommunity.service.testsupport.TestObjectServiceCreator;
import com.dancosoft.socialcommunity.service.testsupport.TestStarter;

/**
 * @author Zaerko_DV
 *
 */
public class UserLocationServiceTest extends TestStarter {

	private static final Logger logger = LoggerFactory.getLogger(UserLocationServiceTest.class);

	@Autowired
	@Qualifier("userLocationService")
	private UserLocationService userLocationService;

	@Autowired
	@Qualifier("testObjectServiceCreator")
	private TestObjectServiceCreator testObjectServiceCreator;

	public void setUserLocationService(UserLocationService userLocationService) {
		this.userLocationService = userLocationService;
	}

	public void setTestObjectServiceCreator(TestObjectServiceCreator testObjectServiceCreator) {
		this.testObjectServiceCreator = testObjectServiceCreator;
	}
	
	public User user;
	public UserLocation userLocation;

	@Before
	public void initObjectsBeforeTest() {
		this.userLocation = testObjectServiceCreator.createUserLocationForTest();
		this.user = userLocation.getUser();
	}
	
	@Transactional
	@Rollback(true)
	@Test
	public void testGettingUserLocationByIdUser() {

		logger.info("UserLocationServiceTest: test method GetUserLocationByIdUser");
		Assert.assertNotNull(userLocationService.getUserLocationByIdUser(user.getIdUser()));
	}
	
	@Transactional
	@Rollback(true)
	@Test
	public void testGettingUserLanguageByIdUser() {
		logger.info("UserLocationServiceTest: test method GetUserLanguageByIdUser");
		Assert.assertNotNull(userLocationService.getUserLanguageByIdUser(user.getIdUser()));
	}
	
	@Transactional
	@Rollback(true)
	@Test
	public void testGettingUserCityByIdUser() {
		logger.info("UserLocationServiceTest: test method GetUserCityByIdUser");
		Assert.assertNotNull(userLocationService.getUserCityByIdUser(user.getIdUser()));
	}
	
	@Transactional
	@Rollback(true)
	@Test
	public void testGettingUserCountryByIdUser() {
		logger.info("UserLocationServiceTest: test method GetUserCountryByIdUser");
		Assert.assertNotNull(userLocationService.getUserCountryByIdUser(user.getIdUser()));
	}
}
