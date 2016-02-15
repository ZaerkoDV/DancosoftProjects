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
import com.dancosoft.socialcommunity.service.testsupport.TestStarter;

/**
 * @author Zaerko_DV
 *
 */
public class UserPhotoServiceTest {//extends TestStarter {

//	private static final Logger logger = LoggerFactory.getLogger(UserPhotoServiceTest.class);
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
//	@Qualifier("userPhotoService")
//	private UserPhotoService userPhotoService;
//
//	public void setUserPhotoService(UserPhotoService userPhotoService) {
//		this.userPhotoService = userPhotoService;
//	}
//	
//	public UserPhoto userPhoto;
//	public User user;
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
//	public UserPhoto createUserPhotoForTest() {
//
//		User testUser = createUserForTest();
//		UserPhoto testUserPhoto = new UserPhoto();
//		String idUser=testUser.getIdUser().toString();
//		
//		testUserPhoto.setPhotoName(idUser+".jsp");
//		testUserPhoto.setPhotoNote("testPhoto");
//		testUserPhoto.setUser(testUser);
//		userPhotoService.saveUserPhoto(testUserPhoto);
//		
//		return testUserPhoto;
//	}
//	
//	@Before
//	public void initObjectsBeforeTest() {
//		this.userPhoto= createUserPhotoForTest();
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
//	public void testSavePhotoAsFormat() {
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
