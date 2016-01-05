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
import com.dancosoft.socialcommunity.model.UserEmail;

/**
 * @author Zaerko_DV
 *
 */
public class UserEmailDAOTest extends TestStarter {
	
	private static final Logger logger = LoggerFactory.getLogger(UserEmailDAOTest.class);

	@Autowired
	@Qualifier("userEmailDAO")
	private UserEmailDAO userEmailDAO;

	@Autowired
	@Qualifier("testObjectDAOCreator")
	private TestObjectDAOCreator testObjectDAOCreator;

	public void setUserEmailDAO(UserEmailDAO userEmailDAO) {
		this.userEmailDAO = userEmailDAO;
	}

	public void setTestObjectDAOCreator(TestObjectDAOCreator testObjectDAOCreator) {
		this.testObjectDAOCreator = testObjectDAOCreator;
	}

	public User user;
	public UserCorespondence userCorespondence;
	public UserEmail userEmail;
	
	@Before
	public void initObjectsBeforeTest() {
		this.userEmail=testObjectDAOCreator.createUserEmailForTest();
		this.userCorespondence = userEmail.getUserCorespondence();
		this.user = userCorespondence.getUser();
	}
	
	@Transactional
	@Rollback(true)
	@Test
	public void  testGettingListEmailWithStatusByIdUser() {

		logger.info("UserEmailDAOTest: test method GetListEmailWithStatusByIdUser");
		List<UserEmail> list=userEmailDAO.getListEmailWithStatusByIdUser(user.getIdUser(), "public");
		Assert.assertFalse(list.isEmpty());
	}
	
	@Transactional
	@Rollback(true)
	@Test
	public void  testGettingListEmailByIdUser() {

		logger.info("UserEmailDAOTest: test method GetListEmailByIdUser");
		List<UserEmail> list=userEmailDAO.getListEmailByIdUser(user.getIdUser());
		Assert.assertFalse(list.isEmpty());
	}
	
	@Transactional
	@Rollback(true)
	@Test
	public void  testOnUniqueEmail() {
		
		logger.info("UserEmailDAOTest: test method isUniqueEmail");
		Boolean unique=userEmailDAO.isUniqueEmail(userEmail.getUserEmail());
		Assert.assertFalse(unique);
		
		unique=userEmailDAO.isUniqueEmail("user@gmail.com");
		Assert.assertTrue(unique);
	}
	
	@Transactional
	@Rollback(true)
	@Test
	public void  testGettingIdUserByEmail() {
		
		logger.info("UserEmailDAOTest: test method GetIdUserByEmail");
		Long idUser=userEmailDAO.getIdUserByEmail(userEmail.getUserEmail());
		Assert.assertEquals(user.getIdUser(), idUser);
		
		idUser=userEmailDAO.getIdUserByEmail("user@gmail.com");
		Assert.assertNull(idUser);
	}
}
