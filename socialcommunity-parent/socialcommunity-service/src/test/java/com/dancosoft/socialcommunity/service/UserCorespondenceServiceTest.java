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
import com.dancosoft.socialcommunity.model.UserCorespondence;
import com.dancosoft.socialcommunity.service.testsupport.TestStarter;

/**
 * @author Zaerko_DV
 *
 */
public class UserCorespondenceServiceTest {//extends TestStarter{

//	private static final Logger logger = LoggerFactory.getLogger(UserCorespondenceServiceTest.class);
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
//	@Qualifier("userCorespondenceService")
//	private UserCorespondenceService userCorespondenceService;
//
//	public void setUserCorespondenceService(UserCorespondenceService userCorespondenceService) {
//		this.userCorespondenceService = userCorespondenceService;
//	}
//
//	public User user;
//	public UserCorespondence userCorespondence;
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
//	public UserCorespondence createUserCorespondenceForTest() {
//		User testUser = createUserForTest();
//		UserCorespondence testUserCorespondence = new UserCorespondence();
//		testUserCorespondence.setCorespondenceViewStatus("public");
//		testUserCorespondence.setUser(testUser);
//		userCorespondenceService.saveUserCorespondence(testUserCorespondence);
//
//		return testUserCorespondence;
//	}
//
//	@Before
//	public void initObjectsBeforeTest() {
//		this.userCorespondence = createUserCorespondenceForTest();
//		this.user = userCorespondence.getUser();
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingCorespondViewStatusByIdUserCorespond() {
//
//		String viewStatus = userCorespondenceService.getCorespondViewStatusByIdUserCorespond(userCorespondence
//						.getIdUserCorespondence());
//		logger.info("UserCorespondenceServiceTest: test method GetCorespondViewStatusByIdUserCorespond");
//		Assert.assertEquals(userCorespondence.getCorespondenceViewStatus(), viewStatus);
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingListUserCorespondenceForBroadcastInfo() {
//		logger.info("UserCorespondenceServiceTest: test method GetListUserCorespondenceForBroadcastInfo");
//		UserCorespondence userCorespondence=userCorespondenceService.getUserCorespondenceForBroadcastInfo();
//		Assert.assertNotNull(userCorespondence);
//	}
}
