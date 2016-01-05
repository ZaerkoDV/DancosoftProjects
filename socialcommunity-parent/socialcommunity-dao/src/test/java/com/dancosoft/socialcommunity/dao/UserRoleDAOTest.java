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
import com.dancosoft.socialcommunity.model.UserSecurity;

/**
 * @author Zaerko_DV
 *
 */
public class UserRoleDAOTest extends TestStarter {

	private static final Logger logger = LoggerFactory.getLogger(UserRoleDAOTest.class);

	@Autowired
	@Qualifier("userRoleDAO")
	private UserRoleDAO userRoleDAO;

	@Autowired
	@Qualifier("testObjectDAOCreator")
	private TestObjectDAOCreator testObjectDAOCreator;

	public void setUserRoleDAO(UserRoleDAO userRoleDAO) {
		this.userRoleDAO = userRoleDAO;
	}

	public void setTestObjectDAOCreator(TestObjectDAOCreator testObjectDAOCreator) {
		this.testObjectDAOCreator = testObjectDAOCreator;
	}

	public User user;
	public UserSecurity userSecurity;

	@Before
	public void initObjectsBeforeTest() {
		this.userSecurity = testObjectDAOCreator.createUserSecurityForTest();
		this.user = userSecurity.getUser();
	}
	
	@Transactional
	@Rollback(true)
	@Test
	public void testGettingListUserWithRole() {

		logger.info("UserSecurityDAOTest: test method testGettingListUserWithRole");
		List<User> listUser = userRoleDAO.getListUserByRole("User");
		Assert.assertFalse(listUser.isEmpty());
	}
	
	@Transactional
	@Rollback(true)
	@Test
	public void testGettingCountUserByRole() {

		logger.info("UserSecurityDAOTest: test method testGettingCountUserByRole");
		int countUser = userRoleDAO.getCountUserByRole("User");
		Assert.assertEquals(1,countUser);
	}
}
