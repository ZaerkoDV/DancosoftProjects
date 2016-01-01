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
import com.dancosoft.socialcommunity.model.UserPhoto;

/**
 * @author Zaerko_DV
 *
 */
public class UserPhotoDAOTest {//extends TestStarter {

//	private static final Logger logger = LoggerFactory.getLogger(UserPhotoDAOTest.class);
//
//	@Autowired
//	@Qualifier("userPhotoDAO")
//	private UserPhotoDAO userPhotoDAO;
//
//	@Autowired
//	@Qualifier("testObjectDAOCreator")
//	private TestObjectDAOCreator testObjectDAOCreator;
//
//	public void setUserPhotoDAO(UserPhotoDAO userPhotoDAO) {
//		this.userPhotoDAO = userPhotoDAO;
//	}
//
//	public void setTestObjectDAOCreator(TestObjectDAOCreator testObjectDAOCreator) {
//		this.testObjectDAOCreator = testObjectDAOCreator;
//	}
//
//	public UserPhoto userPhoto;
//	public User user;
//
//	@Before
//	public void initObjectsBeforeTest() {
//		this.userPhoto= testObjectDAOCreator.createUserPhotoForTest();
//		this.user = userPhoto.getUser();
//	}
//
//	@Transactional
//	@Rollback(false)
//	@Test
//	public void testGettingUserPhotoByIdUser() {
//		
//		logger.info("UserPhotoDAOTest: test method GetUserPhotoByIdUser");
//		Assert.assertNotNull(userPhotoDAO.getUserPhotoByIdUser(user.getIdUser()));	
//	}
//	
//	@Transactional
//	@Rollback(false)
//	@Test
//	public void testGettingPhotoNameByIdUser() {
//		
//		logger.info("UserPhotoDAOTest: test method GetPhotoNameByIdUser");
//		Assert.assertNotNull(userPhotoDAO.getPhotoNameByIdUser(user.getIdUser()));	
//	}
}
