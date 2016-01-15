/**
 * 
 */
package com.dancosoft.socialcommunity.dao;

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

import com.dancosoft.socialcommunity.dao.testsupport.TestObjectDAOCreator;
import com.dancosoft.socialcommunity.dao.testsupport.TestStarter;
import com.dancosoft.socialcommunity.model.User;
import com.dancosoft.socialcommunity.model.UserCorespondence;
import com.dancosoft.socialcommunity.model.UserSocialNetwork;

/**
 * @author Zaerko_DV
 *
 */
public class UserSocialNetworkDAOTest {//extends TestStarter {

//	private static final Logger logger = LoggerFactory.getLogger(UserSocialNetworkDAOTest.class);
//
//	@Autowired
//	@Qualifier("userSocialNetworkDAO")
//	private UserSocialNetworkDAO userSocialNetworkDAO;
//
//	@Autowired
//	@Qualifier("testObjectDAOCreator")
//	private TestObjectDAOCreator testObjectDAOCreator;
//
//	public void setUserSocialNetworkDAO(UserSocialNetworkDAO userSocialNetworkDAO) {
//		this.userSocialNetworkDAO = userSocialNetworkDAO;
//	}
//
//	public void setTestObjectDAOCreator(TestObjectDAOCreator testObjectDAOCreator) {
//		this.testObjectDAOCreator = testObjectDAOCreator;
//	}
//
//	public User user;
//	public UserCorespondence userCorespondence;
//	public UserSocialNetwork userSocialNetwork;
//
//	@Before
//	public void initObjectsBeforeTest() {
//		this.userSocialNetwork=testObjectDAOCreator.createUserSocialNetworkForTest();
//		this.userCorespondence = userSocialNetwork.getUserCorespondence();
//		this.user = userCorespondence.getUser();
//	}
//	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void  testGettingListUserSocialNetworkWithStatusByIdUser() {
//
//		logger.info("UserSocialNetworkDAOTest: test method GetListUserSocialNetworkWithStatusByIdUser");
//		List<UserSocialNetwork> list=userSocialNetworkDAO
//				.getListSocialNetworkWithStatusByIdUser(user.getIdUser(), "public");
//		Assert.assertFalse(list.isEmpty());
//	}
//	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void  testOnUniqueSkype() {
//		
//		logger.info("UserSocialNetworkDAOTest: test method isUniqueSkype");
//		Boolean unique=userSocialNetworkDAO.isUniqueSkype(userSocialNetwork.getSkypeAddress());
//		Assert.assertFalse(unique);
//		
//		unique=userSocialNetworkDAO.isUniqueSkype("test.skype.address");
//		Assert.assertTrue(unique);
//	}
//	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void  testOnUniqueFacebook() {
//		
//		logger.info("UserSocialNetworkDAOTest: test method isUniqueFacebook");
//		Boolean unique=userSocialNetworkDAO.isUniqualFaceBook(userSocialNetwork.getFacebookAddress());
//		Assert.assertFalse(unique);
//		
//		unique=userSocialNetworkDAO.isUniqualFaceBook("MyFacebook");;
//		Assert.assertTrue(unique);
//	}
//	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void  testGettingIdUserByFacebookAddress() {
//		
//		logger.info("UserSocialNetworkDAOTest: test method GetIdUserByFacebookAddress");
//		Long idUser=userSocialNetworkDAO.getIdUserByFacebookAddress(userSocialNetwork.getFacebookAddress());
//		Assert.assertEquals(user.getIdUser(), idUser);
//		
//		idUser=userSocialNetworkDAO.getIdUserByFacebookAddress("AnyFacebook");
//		Assert.assertNull(idUser);
//	}
}
