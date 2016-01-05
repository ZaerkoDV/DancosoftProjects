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
import com.dancosoft.socialcommunity.model.UserPhoto;
import com.dancosoft.socialcommunity.service.testsupport.TestObjectServiceCreator;
import com.dancosoft.socialcommunity.service.testsupport.TestStarter;

/**
 * @author Zaerko_DV
 *
 */
public class UserPhotoServiceTest {//extends TestStarter {

//	private static final Logger logger = LoggerFactory.getLogger(UserPhotoServiceTest.class);
//
//	@Autowired
//	@Qualifier("userPhotoService")
//	private UserPhotoService userPhotoService;
//
//	@Autowired
//	@Qualifier("testObjectServiceCreator")
//	private TestObjectServiceCreator testObjectServiceCreator;
//
//	public void setUserPhotoService(UserPhotoService userPhotoService) {
//		this.userPhotoService = userPhotoService;
//	}
//
//	public void setTestObjectServiceCreator(TestObjectServiceCreator testObjectServiceCreator) {
//		this.testObjectServiceCreator = testObjectServiceCreator;
//	}
//	
//	public UserPhoto userPhoto;
//	public User user;
//
//	@Before
//	public void initObjectsBeforeTest() {
//		this.userPhoto= testObjectServiceCreator.createUserPhotoForTest();
//		this.user = userPhoto.getUser();
//	}
//
//	@Transactional
//	@Rollback(false)
//	@Test
//	public void testGettingUserPhotoByIdUser() {
//		logger.info("UserPhotoServiceTest: test method GetUserPhotoByIdUser");
//		Assert.assertNotNull(userPhotoService.getUserPhotoByIdUser(user.getIdUser()));	
//	}
//	
//	@Transactional
//	@Rollback(false)
//	@Test
//	public void testGettingPhotoNameByIdUser() {
//		logger.info("UserPhotoServiceTest: test method GetPhotoNameByIdUser");
//		Assert.assertNotNull(userPhotoService.getPhotoNameByIdUser(user.getIdUser()));	
//	}	
}
