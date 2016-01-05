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
public class UserSecurityDAOTest extends TestStarter {

	private static final Logger logger = LoggerFactory.getLogger(UserSecurityDAOTest.class);

	@Autowired
	@Qualifier("userSecurityDAO")
	private UserSecurityDAO userSecurityDAO;

	@Autowired
	@Qualifier("testObjectDAOCreator")
	private TestObjectDAOCreator testObjectDAOCreator;

	public void setUserSecurityDAO(UserSecurityDAO userSecurityDAO) {
		this.userSecurityDAO = userSecurityDAO;
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
	public void testGettingUserByLoginPassword() {

		logger.info("UserSecurityDAOTest: test method testGettingUserByLoginPassword");
		String login = userSecurity.getUserLogin();
		String password = userSecurity.getUserPassword();

		Assert.assertNotNull(userSecurityDAO.getUserByLoginPassword(login,
				password));
	}

	@Transactional
	@Rollback(true)
	@Test
	public void testGettingIdUserByLoginPassword() {

		logger.info("UserSecurityDAOTest: test method testGettingIdUserByLoginPassword");
		Assert.assertNotNull(userSecurityDAO.getIdUserByLoginPassword(
				userSecurity.getUserLogin(), userSecurity.getUserPassword()));
	}

	@Transactional
	@Rollback(true)
	@Test
	public void testOnSignInUserByLoginPassword() {

		logger.info("UserSecurityDAOTest: test method testOnSignInUserByLoginPassword");
		Assert.assertTrue(userSecurityDAO.signInUserByLoginPassword(
				userSecurity.getUserLogin(), userSecurity.getUserPassword()));
	}

	@Transactional
	@Rollback(true)
	@Test
	public void testUniqueLogin() {

		logger.info("UserSecurityDAOTest: test method testUniqueLogin");
		Assert.assertTrue(userSecurityDAO.isUniqueLogin("newLogin"));
	}

	@Transactional
	@Rollback(true)
	@Test
	public void testUniquePassword() {

		logger.info("UserSecurityDAOTest: test method testUniquePassword");
		Assert.assertTrue(userSecurityDAO.isUniquePassword("newPassword"));
	}

	@Transactional
	@Rollback(true)
	@Test
	public void testGettingUserRoleByIdUser() {

		logger.info("UserSecurityDAOTest: test method testGettingUserRoleByIdUser");
		Long idUser = user.getIdUser();
		Assert.assertEquals("User", userSecurityDAO.getUserRoleByIdUser(idUser));
	}

	@Transactional
	@Rollback(true)
	@Test
	public void testGettingListUserWithUserRole() {

		logger.info("UserSecurityDAOTest: test method testGettingListUserWithUserRole");
		List<User> listUser = userSecurityDAO.getListUserWithUserRole();
		Assert.assertFalse(listUser.isEmpty());
	}

	@Transactional
	@Rollback(true)
	@Test
	public void testGettingListAdminWithUserRole() {

		logger.info("UserSecurityDAOTest: test method testGettingListUserWithUserRole");
		List<User> listAdmin = userSecurityDAO.getListUserWithAdminRole();
		Assert.assertTrue(listAdmin.isEmpty());
	}

	@Transactional
	@Rollback(true)
	@Test
	public void testOnUpdateLoginPasswordByIdUser() {

		logger.info("UserSecurityDAOTest: test method testOnUpdateLoginPasswordByIdUser");
		Long idUser = userSecurity.getUser().getIdUser();
		Assert.assertTrue(userSecurityDAO.updateLoginPasswordByIdUser(idUser));
	}

	@Transactional
	@Rollback(true)
	@Test
	public void testGettingLoginPasswordByIdUser() {

		logger.info("UserSecurityDAOTest: test method testGettingLoginPasswordByIdUser");
		UserSecurity userSecurity = userSecurityDAO.getLoginPasswordByIdUser(user.getIdUser());
		Assert.assertNotNull(userSecurity);
	}
}
