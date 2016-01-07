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
//	@Rollback(true)
//	@Test
//	public void testGettingUserPhotoByIdUser() {
//		logger.info("UserPhotoServiceTest: test method GetUserPhotoByIdUser");
//		Assert.assertNotNull(userPhotoService.getUserPhotoByIdUser(user.getIdUser()));	
//	}
//	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingPhotoNameByIdUser() {
//		logger.info("UserPhotoServiceTest: test method GetPhotoNameByIdUser");
//		Assert.assertNotNull(userPhotoService.getPhotoNameByIdUser(user.getIdUser()));	
//	}	
//	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testSavePhotoAsJPG() {
//		
//		String testPhotoPath="http://www.mkyong.com/image/mypic.jpg";
//		String format="jpg";
//		Boolean result=userPhotoService.savePhotoAsFormat(user.getIdUser(),format,testPhotoPath);
//		Assert.assertTrue(result);
//	}
//	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testLoadPathToUserPhoto() {
//		
//		String testPhotoPath="http://www.mkyong.com/image/mypic.jpg";
//		String format="jpg";
//		userPhotoService.savePhotoAsFormat(user.getIdUser(),format,testPhotoPath);
//		Assert.assertNotNull(userPhotoService.loadPathToUserPhoto(user.getIdUser()));
//	}
}
