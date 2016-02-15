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

public class UserSecurityServiceTest {//extends TestStarter {

//	private static final Logger logger = LoggerFactory.getLogger(UserSecurityServiceTest.class);
//
//	@Autowired
//	@Qualifier("userSecurityService")
//	private UserSecurityService userSecurityService;
//	
//	@Autowired
//	@Qualifier("userService")
//	private UserService userService;
//	
//	@Autowired
//	@Qualifier("userRoleService")
//	private UserRoleService userRoleService;
//
//	public void setUserSecurityService(UserSecurityService userSecurityService) {
//		this.userSecurityService = userSecurityService;
//	}
//	
//	public void setUserService(UserService userService) {
//		this.userService = userService;
//	}
//	
//	public void setUserRoleService(UserRoleService userRoleService) {
//		this.userRoleService = userRoleService;
//	}
//
//	public User user;
//	public UserRole userRole;
//	public UserSecurity userSecurity;
//	
//	public User createUserForTest() {
//
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
//
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
//		this.user=userSecurity.getUser();
//		this.userRole=userSecurity.getUserRole();
//	}
//	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingUserByLoginPassword() {
//
//		logger.info("UserSecurityServiceTest: test method testGettingUserByLoginPassword");
//		String login = userSecurity.getUserLogin();
//		String password = userSecurity.getUserPassword();
//
//		Assert.assertNotNull(userSecurityService.getUserByLoginPassword(login,password));
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingIdUserByLoginPassword() {
//		logger.info("UserSecurityServiceTest: test method testGettingIdUserByLoginPassword");
//		Assert.assertNotNull(userSecurityService.getIdUserByLoginPassword(
//				userSecurity.getUserLogin(), userSecurity.getUserPassword()));
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testOnSignInUserByLoginPassword() {
//		logger.info("UserSecurityServiceTest: test method testOnSignInUserByLoginPassword");
//		Assert.assertTrue(userSecurityService.signInUserByLoginPassword(
//				userSecurity.getUserLogin(), userSecurity.getUserPassword()));
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testUniqueLogin() {
//		logger.info("UserSecurityServiceTest: test method testUniqueLogin");
//		Assert.assertTrue(userSecurityService.isUniqueLogin("newLogin"));
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testUniquePassword() {
//		logger.info("UserSecurityServiceTest: test method testUniquePassword");
//		Assert.assertTrue(userSecurityService.isUniquePassword("newPassword"));
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingUserRoleByIdUser() {
//		logger.info("UserSecurityServiceTest: test method testGettingUserRoleByIdUser");
//		Long idUser = user.getIdUser();
//		String userRole=userSecurityService.getUserRoleByIdUser(idUser);
//		Assert.assertEquals("User", userRole);
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingListUserWithUserRole() {
//		logger.info("UserSecurityServiceTest: test method testGettingListUserWithUserRole");
//		List<User> listUser = userSecurityService.getListUserWithUserRole();
//		Assert.assertFalse(listUser.isEmpty());
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingListUserWithAdminRole() {
//		logger.info("UserSecurityServiceTest: test method testGettingListUserWithUserRole");
//		//List<User> listAdmin = userSecurityService.getListUserWithAdminRole();
//		//Assert.assertTrue(listAdmin.isEmpty());
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testOnUpdateLoginPasswordByIdUser() {
//		logger.info("UserSecurityServiceTest: test method testOnUpdateLoginPasswordByIdUser");
//		//Long idUser = userSecurity.getUser().getIdUser();
//		//Assert.assertTrue(userSecurityService.updateLoginPasswordByIdUser(idUser));
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingLoginPasswordByIdUser() {
//		logger.info("UserSecurityServiceTest: test method testGettingLoginPasswordByIdUser");
//		UserSecurity userSecurity = userSecurityService.getLoginPasswordByIdUser(user.getIdUser());
//		Assert.assertNotNull(userSecurity);
//	}
}
