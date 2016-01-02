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
import com.dancosoft.socialcommunity.model.UserEmail;
import com.dancosoft.socialcommunity.service.testsupport.TestObjectServiceCreator;
import com.dancosoft.socialcommunity.service.testsupport.TestStarter;

/**
 * @author Zaerko_DV
 *
 */
public class UserEmailServiceTest extends TestStarter {

	private static final Logger logger = LoggerFactory.getLogger(UserEmailServiceTest.class);

	@Autowired
	@Qualifier("userEmailService")
	private UserEmailService userEmailService;

	@Autowired
	@Qualifier("testObjectServiceCreator")
	private TestObjectServiceCreator testObjectServiceCreator;

	public void setUserEmailService(UserEmailService userEmailService) {
		this.userEmailService = userEmailService;
	}

	public void setTestObjectServiceCreator(TestObjectServiceCreator testObjectServiceCreator) {
		this.testObjectServiceCreator = testObjectServiceCreator;
	}
	
	public User user;
	public UserCorespondence userCorespondence;
	public UserEmail userEmail;
	
	@Before
	public void initObjectsBeforeTest() {
		this.userEmail=testObjectServiceCreator.createUserEmailForTest();
		this.userCorespondence = userEmail.getUserCorespondence();
		this.user = userCorespondence.getUser();
	}
	
	@Transactional
	@Rollback(true)
	@Test
	public void  testGettingListEmailWithStatusByIdUser() {
		logger.info("UserEmailServiceTest: test method GetListEmailWithStatusByIdUser");
		List<UserEmail> list=userEmailService.getListEmailWithStatusByIdUser(user.getIdUser(), "public");
		Assert.assertFalse(list.isEmpty());
	}
	
	@Transactional
	@Rollback(true)
	@Test
	public void  testGettingListEmailByIdUser() {
		logger.info("UserEmailServiceTest: test method GetListEmailByIdUser");
		List<UserEmail> list=userEmailService.getListEmailByIdUser(user.getIdUser());
		Assert.assertFalse(list.isEmpty());
	}
	
	@Transactional
	@Rollback(true)
	@Test
	public void  testOnUniqueEmail() {
		
		logger.info("UserEmailServiceTest: test method isUniqueEmail");
		Boolean unique=userEmailService.isUniqueEmail(userEmail.getUserEmail());
		Assert.assertFalse(unique);
		
		unique=userEmailService.isUniqueEmail("user@gmail.com");
		Assert.assertTrue(unique);
	}
	
	@Transactional
	@Rollback(true)
	@Test
	public void  testGettingIdUserByEmail() {
		
		logger.info("UserEmailServiceTest: test method GetIdUserByEmail");
		Long idUser=userEmailService.getIdUserByEmail(userEmail.getUserEmail());
		Assert.assertEquals(user.getIdUser(), idUser);
		
		idUser=userEmailService.getIdUserByEmail("user@gmail.com");
		Assert.assertNull(idUser);
	}
}
