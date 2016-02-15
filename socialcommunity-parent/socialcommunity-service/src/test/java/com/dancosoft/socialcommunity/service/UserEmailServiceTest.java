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
import com.dancosoft.socialcommunity.model.UserEmail;
import com.dancosoft.socialcommunity.service.testsupport.TestStarter;

/**
 * @author Zaerko_DV
 *
 */
public class UserEmailServiceTest {//extends TestStarter {

//	private static final Logger logger = LoggerFactory.getLogger(UserEmailServiceTest.class);
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
//	@Qualifier("userEmailService")
//	private UserEmailService userEmailService;
//
//	public void setUserEmailService(UserEmailService userEmailService) {
//		this.userEmailService = userEmailService;
//	}
//
//	
//	public User user;
//	public UserCorespondence userCorespondence;
//	public UserEmail userEmail;
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
//	public UserEmail createUserEmailForTest() {
//
//		UserCorespondence testUserCorespondence = createUserCorespondenceForTest();
//		UserEmail testUserEmail = new UserEmail();
//
//		testUserEmail.setUserEmail("zaerko@mail.com");
//		testUserEmail.setUserCorespondence(testUserCorespondence);
//		userEmailService.saveUserEmail(testUserEmail);
//
//		return testUserEmail;
//	}
//	
//	@Before
//	public void initObjectsBeforeTest() {
//		this.userEmail=createUserEmailForTest();
//		this.userCorespondence = userEmail.getUserCorespondence();
//		this.user = userCorespondence.getUser();
//	}
//	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void  testGettingListEmailWithStatusByIdUser() {
//		logger.info("UserEmailServiceTest: test method GetListEmailWithStatusByIdUser");
//		UserEmail userEmail=userEmailService.getEmailWithStatusByIdUser(user.getIdUser(), "public");
//		Assert.assertNotNull(userEmail);
//	}
//	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void  testGettingListEmailByIdUser() {
//		logger.info("UserEmailServiceTest: test method GetListEmailByIdUser");
//		UserEmail userEmail=userEmailService.getEmailByIdUser(user.getIdUser());
//		Assert.assertNotNull(userEmail);
//	}
//	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void  testOnUniqueEmail() {
//		
//		logger.info("UserEmailServiceTest: test method isUniqueEmail");
//		Boolean unique=userEmailService.isUniqueEmail(userEmail.getUserEmail());
//		Assert.assertFalse(unique);
//		
//		unique=userEmailService.isUniqueEmail("user@gmail.com");
//		Assert.assertTrue(unique);
//	}
//	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void  testGettingIdUserByEmail() {
//		
//		logger.info("UserEmailServiceTest: test method GetIdUserByEmail");
//		Long idUser=userEmailService.getIdUserByEmail(userEmail.getUserEmail());
//		Assert.assertEquals(user.getIdUser(), idUser);
//		
//		idUser=userEmailService.getIdUserByEmail("user@gmail.com");
//		Assert.assertNull(idUser);
//	}
//	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testOnValidEmail(){
//		
//		Boolean isValidEmail;
//		isValidEmail=userEmailService.isValidEmail(userEmail.getUserEmail());
//		Assert.assertTrue(isValidEmail);
//		isValidEmail=userEmailService.isValidEmail("falsegmail.com");
//		Assert.assertFalse(isValidEmail);
//		
//		logger.info("UserEmailServiceTest:Cheack email on valid value completed.");
//	}
}
