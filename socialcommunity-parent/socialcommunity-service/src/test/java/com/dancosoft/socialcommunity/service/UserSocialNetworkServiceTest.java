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
import com.dancosoft.socialcommunity.model.UserSocialNetwork;
import com.dancosoft.socialcommunity.service.testsupport.TestStarter;

/**
 * @author Zaerko_DV
 *
 */
public class UserSocialNetworkServiceTest {//extends TestStarter{

//	private static final Logger logger = LoggerFactory.getLogger(UserSocialNetworkServiceTest.class);
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
//	@Autowired
//	@Qualifier("userSocialNetworkService")
//	private UserSocialNetworkService userSocialNetworkService;
//
//	public void setUserSocialNetworkService(UserSocialNetworkService userSocialNetworkService) {
//		this.userSocialNetworkService = userSocialNetworkService;
//	}
//	
//	public User user;
//	public UserCorespondence userCorespondence;
//	public UserSocialNetwork userSocialNetwork;
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
//	public UserSocialNetwork createUserSocialNetworkForTest() {
//
//		UserCorespondence testUserCorespondence = createUserCorespondenceForTest();
//		UserSocialNetwork testUserSocialNetwork = new UserSocialNetwork();
//		testUserSocialNetwork.setSkypeAddress("test.skype");
//		testUserSocialNetwork.setFacebookAddress("Test User");
//		testUserSocialNetwork.setUserCorespondence(testUserCorespondence);
//		userSocialNetworkService.saveUserSocialNetwork(testUserSocialNetwork);
//
//		return testUserSocialNetwork;
//	}
//	
//	@Before
//	public void initObjectsBeforeTest() {
//		this.userSocialNetwork=createUserSocialNetworkForTest();
//		this.userCorespondence = userSocialNetwork.getUserCorespondence();
//		this.user = userCorespondence.getUser();
//	}
//	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void  testGettingListUserSocialNetworkWithStatusByIdUser() {
//
//		logger.info("UserSocialNetworkServiceTest: test method GetListUserSocialNetworkWithStatusByIdUser");
//		UserSocialNetwork userSocialNetwork=userSocialNetworkService.getSocialNetworkWithStatusByIdUser(user.getIdUser(), "public");
//		Assert.assertNotNull( userSocialNetwork);
//	}
//	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void  testOnUniqueSkype() {
//		
//		logger.info("UserSocialNetworkServiceTest: test method isUniqueSkype");
//		Boolean unique=userSocialNetworkService.isUniqueSkype(userSocialNetwork.getSkypeAddress());
//		Assert.assertFalse(unique);
//		
//		unique=userSocialNetworkService.isUniqueSkype("test.skype.address");
//		Assert.assertTrue(unique);
//	}
//	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void  testOnUniqueFacebook() {
//		
//		logger.info("UserSocialNetworkServiceTest: test method isUniqueFacebook");
//		Boolean unique=userSocialNetworkService.isUniqualFaceBook(userSocialNetwork.getFacebookAddress());
//		Assert.assertFalse(unique);
//		
//		unique=userSocialNetworkService.isUniqualFaceBook("MyFacebook");;
//		Assert.assertTrue(unique);
//	}
//	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void  testGettingIdUserByFacebookAddress() {
//		
//		logger.info("UserSocialNetworkServiceTest: test method GetIdUserByFacebookAddress");
//		Long idUser=userSocialNetworkService.getIdUserByFacebookAddress(userSocialNetwork.getFacebookAddress());
//		Assert.assertEquals(user.getIdUser(), idUser);
//		
//		idUser=userSocialNetworkService.getIdUserByFacebookAddress("AnyFacebook");
//		Assert.assertNull(idUser);
//	}
}
