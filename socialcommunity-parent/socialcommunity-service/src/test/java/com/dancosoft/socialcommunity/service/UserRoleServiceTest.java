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

import com.dancosoft.socialcommunity.dao.UserRoleDAOTest;
import com.dancosoft.socialcommunity.model.User;
import com.dancosoft.socialcommunity.model.UserSecurity;
import com.dancosoft.socialcommunity.service.testsupport.TestObjectServiceCreator;
import com.dancosoft.socialcommunity.service.testsupport.TestStarter;

/**
 * @author Zaerko_DV
 *
 */
public class UserRoleServiceTest extends TestStarter {

	private static final Logger logger = LoggerFactory.getLogger(UserRoleDAOTest.class);

	@Autowired
	@Qualifier("userRoleService")
	private UserRoleService userRoleService;

	@Autowired
	@Qualifier("testObjectServiceCreator")
	private TestObjectServiceCreator testObjectServiceCreator;

	public void setUserRoleService(UserRoleService userRoleService) {
		this.userRoleService = userRoleService;
	}

	public void setTestObjectServiceCreator(TestObjectServiceCreator testObjectServiceCreator) {
		this.testObjectServiceCreator = testObjectServiceCreator;
	}
	
	public User user;
	public UserSecurity userSecurity;

	@Before
	public void initObjectsBeforeTest() {
		this.userSecurity = testObjectServiceCreator.createUserSecurityForTest();
		this.user = userSecurity.getUser();
	}
	
	@Transactional
	@Rollback(true)
	@Test
	public void testGettingListUserWithRole() {
		logger.info("UserRoleServiceTest: test method testGettingListUserWithRole");
		List<User> listUser = userRoleService.getListUserByRole("User");
		Assert.assertFalse(listUser.isEmpty());
	}
	
	@Transactional
	@Rollback(true)
	@Test
	public void testGettingCountUserByRole() {
		logger.info("UserRoleServiceTest: test method testGettingCountUserByRole");
		int countUser = userRoleService.getCountUserByRole("User");
		Assert.assertEquals(1,countUser);
	}
}
