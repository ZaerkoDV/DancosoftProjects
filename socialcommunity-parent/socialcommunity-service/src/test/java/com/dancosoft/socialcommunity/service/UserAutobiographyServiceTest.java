/**
 * 
 */
package com.dancosoft.socialcommunity.service;

import java.time.LocalDateTime;
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
import com.dancosoft.socialcommunity.service.testsupport.TestStarter;

/**
 * @author Zaerko_DV
 *
 */
public class UserAutobiographyServiceTest {//extends TestStarter {

//	private static final Logger logger = LoggerFactory.getLogger(UserAutobiographyServiceTest.class);
//
//	@Autowired
//	@Qualifier("userService")
//	private UserService userService;
//	
//	public void setUserService(UserService userService) {
//		this.userService = userService;
//	}
//	
//	@Autowired
//	@Qualifier("userAutobiographyService")
//	private UserAutobiographyService userAutobiographyService;
//
//	public void setUserAutobiographyService(UserAutobiographyService userAutobiographyService) {
//		this.userAutobiographyService = userAutobiographyService;
//	}
//
//	public User user;
//	public UserAutobiography userAutobiography;
//
//	public User createUserForTest() {
//
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
//	public UserAutobiography createUserAutobiographyForTest() {
//
//		User testUser = createUserForTest();
//		UserAutobiography testUserAutobiography = new UserAutobiography();
//		testUserAutobiography.setBirth(LocalDateTime.of(1990, 12, 31, 0, 0));
//		testUserAutobiography.setHobby("Test Hobby");
//		testUserAutobiography.setAutobiography("Test User Autobiography");
//		testUserAutobiography.setUser(testUser);
//		userAutobiographyService.saveUserAutobiographyService(testUserAutobiography);
//
//		return testUserAutobiography;
//	}
//	
//	@Before
//	public void initObjectsBeforeTest() {
//		this.userAutobiography = createUserAutobiographyForTest();
//		this.user = userAutobiography.getUser();
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingUserAutobiographyByIdUser() {
//		logger.info("UserAutobiographyServiceTest: test method GetUserAutoboigraphyByIdUser");
//		Assert.assertNotNull(userAutobiographyService.getUserAutobiographyByIdUser(user.getIdUser()));
//	}
//	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingListUserByHobby() {
//		logger.info("UserAutobiographyServiceTest: test method GetListUserByHobby");
//		List<User> list=userAutobiographyService.getListUserByHobby(userAutobiography.getHobby());
//		Assert.assertFalse(list.isEmpty());
//	}
//	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testOnUserAdult() {
//		logger.info("UserAutobiographyServiceTest: test method isUserAdult");
//		Boolean result=userAutobiographyService.isUserAdult(user.getIdUser(), (long)18);
//		Assert.assertTrue(result);
//	}
//	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingListAdultUser() {
//		logger.info("UserAutobiographyServiceTest: test method GetListAdultUser");
//		List<User> list=userAutobiographyService.getListAdultUser((long)18);
//		Assert.assertFalse(list.isEmpty());
//	}
}
