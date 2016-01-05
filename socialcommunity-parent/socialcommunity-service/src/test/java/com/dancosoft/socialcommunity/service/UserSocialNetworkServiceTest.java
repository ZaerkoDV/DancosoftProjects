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
import com.dancosoft.socialcommunity.model.UserCorespondence;
import com.dancosoft.socialcommunity.model.UserSocialNetwork;
import com.dancosoft.socialcommunity.service.testsupport.TestObjectServiceCreator;
import com.dancosoft.socialcommunity.service.testsupport.TestStarter;

/**
 * @author Zaerko_DV
 *
 */
public class UserSocialNetworkServiceTest {//extends TestStarter{

//	private static final Logger logger = LoggerFactory.getLogger(UserSocialNetworkServiceTest.class);
//	
//	@Autowired
//	@Qualifier("userSocialNetworkService")
//	private UserSocialNetworkService userSocialNetworkService;
//
//	@Autowired
//	@Qualifier("testObjectServiceCreator")
//	private TestObjectServiceCreator testObjectServiceCreator;
//
//	public void setUserSocialNetworkService(UserSocialNetworkService userSocialNetworkService) {
//		this.userSocialNetworkService = userSocialNetworkService;
//	}
//
//	public void setTestObjectServiceCreator(TestObjectServiceCreator testObjectServiceCreator) {
//		this.testObjectServiceCreator = testObjectServiceCreator;
//	}
//	
//	public User user;
//	public UserCorespondence userCorespondence;
//	public UserSocialNetwork userSocialNetwork;
//
//	@Before
//	public void initObjectsBeforeTest() {
//		this.userSocialNetwork=testObjectServiceCreator.createUserSocialNetworkForTest();
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
//		List<UserSocialNetwork> list=userSocialNetworkService
//				.getListSocialNetworkWithStatusByIdUser(user.getIdUser(), "public");
//		Assert.assertFalse(list.isEmpty());
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
