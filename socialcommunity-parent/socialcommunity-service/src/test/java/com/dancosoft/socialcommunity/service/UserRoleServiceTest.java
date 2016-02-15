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
import com.dancosoft.socialcommunity.model.UserRole;
import com.dancosoft.socialcommunity.model.UserSecurity;
import com.dancosoft.socialcommunity.service.testsupport.TestStarter;

/**
 * @author Zaerko_DV
 *
 */
public class UserRoleServiceTest {//extends TestStarter {

//	private static final Logger logger = LoggerFactory.getLogger(UserRoleServiceTest.class);
//
//	@Autowired
//	@Qualifier("userService")
//	private UserService userService;
//	
//	public void setUserService(UserService userService) {
//		this.userService = userService;
//	}
//	
//	@Autowired
//	@Qualifier("userSecurityService")
//	private UserSecurityService userSecurityService;
//
//	public void setUserSecurityService(UserSecurityService userSecurityService) {
//		this.userSecurityService = userSecurityService;
//	}
//	
//	@Autowired
//	@Qualifier("userRoleService")
//	private UserRoleService userRoleService;
//
//	public void setUserRoleService(UserRoleService userRoleService) {
//		this.userRoleService = userRoleService;
//	}
//
//	public User user;
//	public UserSecurity userSecurity;
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
//	public UserRole createUserRoleForTest() {
//		UserRole testUserRole = new UserRole();
//		testUserRole.setUserRoleName("User");
//		userRoleService.saveUserRole(testUserRole);
//		return testUserRole;
//	}
//
//	public UserSecurity createUserSecurityForTest() {
//
//		User testUser = createUserForTest();
//		UserRole userRole = createUserRoleForTest();
//		UserSecurity testUserSecurity = new UserSecurity();
//		testUserSecurity.setUserLogin("testLogin");
//		testUserSecurity.setUserPassword("testPassword");
//		testUserSecurity.setUser(testUser);
//		testUserSecurity.setUserRole(userRole);
//		userSecurityService.saveUserSecurity(testUserSecurity);
//
//		return testUserSecurity;
//	}
//	
//	@Before
//	public void initObjectsBeforeTest() {
//		this.userSecurity = createUserSecurityForTest();
//		this.user = userSecurity.getUser();
//	}
//	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingListUserWithRole() {
//		logger.info("UserRoleServiceTest: test method testGettingListUserWithRole");
//		List<User> listUser = userRoleService.getListUserByRole("User");
//		Assert.assertFalse(listUser.isEmpty());
//	}
//	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingCountUserByRole() {
//		logger.info("UserRoleServiceTest: test method testGettingCountUserByRole");
//		int countUser = userRoleService.getCountUserByRole("User");
//		//Assert.assertEquals(1,countUser);
//		Assert.assertTrue(countUser>0);
//	}
}
