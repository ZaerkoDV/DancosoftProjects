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

import com.dancosoft.socialcommunity.model.User;
import com.dancosoft.socialcommunity.model.UserAutobiography;
import com.dancosoft.socialcommunity.service.testsupport.TestObjectServiceCreator;
import com.dancosoft.socialcommunity.service.testsupport.TestStarter;

/**
 * @author Zaerko_DV
 *
 */
public class UserAutobiographyServiceTest extends TestStarter {

	private static final Logger logger = LoggerFactory.getLogger(UserAutobiographyServiceTest.class);

	@Autowired
	@Qualifier("userAutobiographyService")
	private UserAutobiographyService userAutobiographyService;

	@Autowired
	@Qualifier("testObjectServiceCreator")
	private TestObjectServiceCreator testObjectServiceCreator;

	public void setUserAutobiographyService(UserAutobiographyService userAutobiographyService) {
		this.userAutobiographyService = userAutobiographyService;
	}

	public void setTestObjectServiceCreator(TestObjectServiceCreator testObjectServiceCreator) {
		this.testObjectServiceCreator = testObjectServiceCreator;
	}
	
	public User user;
	public UserAutobiography userAutobiography;

	@Before
	public void initObjectsBeforeTest() {
		this.userAutobiography = testObjectServiceCreator.createUserAutobiographyForTest();
		this.user = userAutobiography.getUser();
	}

	@Transactional
	@Rollback(true)
	@Test
	public void testGettingUserAutobiographyByIdUser() {
		logger.info("UserAutobiographyServiceTest: test method GetUserAutoboigraphyByIdUser");
		Assert.assertNotNull(userAutobiographyService.getUserAutobiographyByIdUser(user.getIdUser()));
	}
	
	@Transactional
	@Rollback(true)
	@Test
	public void testGettingListUserByHobby() {
		logger.info("UserAutobiographyServiceTest: test method GetListUserByHobby");
		List<User> list=userAutobiographyService.getListUserByHobby(userAutobiography.getHobby());
		Assert.assertFalse(list.isEmpty());
	}
	
	@Transactional
	@Rollback(true)
	@Test
	public void testOnUserAdult() {
		logger.info("UserAutobiographyServiceTest: test method isUserAdult");
		Boolean result=userAutobiographyService.isUserAdult(user.getIdUser(), (long)18);
		Assert.assertTrue(result);
	}
	
	@Transactional
	@Rollback(true)
	@Test
	public void testGettingListAdultUser() {
		logger.info("UserAutobiographyServiceTest: test method GetListAdultUser");
		List<User> list=userAutobiographyService.getListAdultUser((long)18);
		Assert.assertFalse(list.isEmpty());
	}
}
