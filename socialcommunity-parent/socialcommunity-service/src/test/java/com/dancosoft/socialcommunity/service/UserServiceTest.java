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

import com.dancosoft.socialcommunity.model.Account;
import com.dancosoft.socialcommunity.model.User;
import com.dancosoft.socialcommunity.service.testsupport.TestStarter;

/**
 * @author Zaerko_DV
 *
 */
public class UserServiceTest {//extends TestStarter {

//	private static final Logger logger = LoggerFactory.getLogger(UserServiceTest.class);
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
//	@Qualifier(value="accountService")
//	private AccountService accountService;
//
//	public void setAccountService(AccountService accountService) {
//		this.accountService = accountService;
//	}
//
//	public User user;
//	public Account account;
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
//	public Account createAccountForTest() {
//		User testUser = createUserForTest();
//		Account testAccount = new Account();
//		testAccount.setAccountName("TestAccount");
//		testAccount.setAccountBlockStatus("unblock");
//		testAccount.setUser(testUser);
//		accountService.saveAccount(testAccount);
//
//		return testAccount;
//	}
//
//	@Before
//	public void initObjectsBeforeTest(){
//		this.account=createAccountForTest();
//		this.user=account.getUser();
//	}
//	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingListAccountByUserId(){
//		Account account =userService.getAccountByUserId(user.getIdUser());
//		logger.info("UserServiceTest: test method testGettingListAccountByUserId");
//		Assert.assertNotNull(account);
//	}
//	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingListUserBySex(){
//		
//	//List<User> listUser;
//		logger.info("UserServiceTest: test method testGettingListUserBySex");
//		
//	//listUser =userService.getListUserBySex("F");
//	//Assert.assertFalse(listUser.isEmpty());
//	//listUser =userService.getListUserBySex("M");
//	//Assert.assertTrue(listUser.isEmpty());
//	}
//		
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testSearchUserByFirstLastMiddleName(){
//		
//		List<User> listUser;
//		logger.info("UserServiceTest: test method SearchUserByFirstLastMiddleName");
//		
//		listUser =userService.searchUserByFirstLastMiddleName(user.getFirstName(),"", "");
//		Assert.assertFalse(listUser.isEmpty());
//		
//		listUser =userService.searchUserByFirstLastMiddleName("",user.getLastName(),"");
//		Assert.assertFalse(listUser.isEmpty());
//		
//		listUser =userService.searchUserByFirstLastMiddleName("","",user.getMiddleName());
//		Assert.assertFalse(listUser.isEmpty());
//		
//		listUser =userService.searchUserByFirstLastMiddleName("","","");
//		Assert.assertFalse(listUser.isEmpty());
//	}
}
