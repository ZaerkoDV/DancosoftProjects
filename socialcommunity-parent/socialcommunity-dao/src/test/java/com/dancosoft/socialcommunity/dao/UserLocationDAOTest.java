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
import com.dancosoft.socialcommunity.model.User;
import com.dancosoft.socialcommunity.model.UserLocation;

/**
 * @author Zaerko_DV
 *
 */
public class UserLocationDAOTest extends TestStarter {

	private static final Logger logger = LoggerFactory.getLogger(UserLocationDAOTest.class);

	@Autowired
	@Qualifier("userLocationDAO")
	private UserLocationDAO userLocationDAO;

	@Autowired
	@Qualifier("testObjectDAOCreator")
	private TestObjectDAOCreator testObjectDAOCreator;

	public void setUserLocationDAO(UserLocationDAO userLocationDAO) {
		this.userLocationDAO = userLocationDAO;
	}

	public void setTestObjectDAOCreator(TestObjectDAOCreator testObjectDAOCreator) {
		this.testObjectDAOCreator = testObjectDAOCreator;
	}

	public User user;
	public UserLocation userLocation;

	@Before
	public void initObjectsBeforeTest() {
		this.userLocation = testObjectDAOCreator.createUserLocationForTest();
		this.user = userLocation.getUser();
	}
	
	@Transactional
	@Rollback(true)
	@Test
	public void testGettingUserLocationByIdUser() {

		logger.info("UserLocationDAOTest: test method GetUserLocationByIdUser");
		Assert.assertNotNull(userLocationDAO.getUserLocationByIdUser(user.getIdUser()));
	}
	
	@Transactional
	@Rollback(true)
	@Test
	public void testGettingUserLanguageByIdUser() {

		logger.info("UserLocationDAOTest: test method GetUserLanguageByIdUser");
		Assert.assertNotNull(userLocationDAO.getUserLanguageByIdUser(user.getIdUser()));
	}
	
	@Transactional
	@Rollback(true)
	@Test
	public void testGettingUserCityByIdUser() {

		logger.info("UserLocationDAOTest: test method GetUserCityByIdUser");
		Assert.assertNotNull(userLocationDAO.getUserCityByIdUser(user.getIdUser()));
	}
	
	@Transactional
	@Rollback(true)
	@Test
	public void testGettingUserCountryByIdUser() {

		logger.info("UserLocationDAOTest: test method GetUserCountryByIdUser");
		Assert.assertNotNull(userLocationDAO.getUserCountryByIdUser(user.getIdUser()));
	}
}
