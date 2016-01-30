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
import com.dancosoft.socialcommunity.model.AccountGroup;
import com.dancosoft.socialcommunity.model.User;
import com.dancosoft.socialcommunity.service.testsupport.TestStarter;

/**
 * @author Zaerko_DV
 *
 */
public class AccountGroupServiceTest {//extends TestStarter {

//	private static final Logger logger = LoggerFactory.getLogger(AccountGroupServiceTest.class);
//
//	@Autowired
//	@Qualifier(value="userService")
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
//	@Autowired
//	@Qualifier(value="accountGroupService")
//	private AccountGroupService accountGroupService;
//
//	public void setAccountGroup(AccountGroup accountGroup) {
//		this.accountGroup = accountGroup;
//	}
//
//	public User user;
//	public Account account;
//	public AccountGroup accountGroup;
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
//	public Account createAccountForTest() {
//		
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
//	public AccountGroup createAccountGroupForTest() {
//
//		Account testAccount = createAccountForTest();
//		AccountGroup testAccountGroup = new AccountGroup();
//		testAccountGroup.setGroupName("TestAccountGroup");
//		testAccountGroup.setViewStatus("private");
//		testAccountGroup.setAccountGroupBlockStatus("unblock");
//		testAccountGroup.setAccount(testAccount);
//		accountGroupService.saveAccountGroup(testAccountGroup);
//
//		return testAccountGroup;
//	}
//	
//	@Before
//	public void initObjectsBeforeTest() {
//		this.accountGroup = createAccountGroupForTest();
//		this.account = accountGroup.getAccount();
//	}
//
//	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testOnBlockAccountGroup() {
//
//		logger.info("AccountGroupServiceTest: test method isBlockAccountGroup");
//		Assert.assertFalse(accountGroupService.isBlockAccountGroup(account.getIdAccount()));
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingAccountGroupBlockStatus() {
//
//		logger.info("AccountGroupServiceTest: test method isBlockAccountGroup");
//		String actual = accountGroupService.getAccountGroupBlockStatus(account.getIdAccount());
//		String expected = accountGroup.getAccountGroupBlockStatus();
//		Assert.assertEquals(expected, actual);
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingListAccountGroupWithBlockStatusByIdAccount() {
//
//		logger.info("AccountGroupServiceTest: test method GetListAccountGroupWithBlockStatusByIdAccount");
//		List<AccountGroup> list = accountGroupService
//				.getListAccountGroupWithBlockStatusByIdAccount(account.getIdAccount(), "unblock");
//		Assert.assertFalse(list.isEmpty());
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testSearchingAccountGroupByGroupNameAccountName() {
//
//		logger.info("AccountGroupServiceTest: test method SearchAccountGroupByGroupNameAccountName");
//		String accountGroupName = accountGroup.getGroupName();
//		String accountName = account.getAccountName();
//		List<AccountGroup> list = accountGroupService
//				.searchAccountGroupByGroupNameAccountName(accountGroupName,accountName);
//		Assert.assertFalse(list.isEmpty());
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingListAccountGroupWithViewStatusByIdAccount() {
//
//		logger.info("AccountGroupServiceTest: test method GetListAccountGroupWithViewStatusByIdAccount");
//		List<AccountGroup> list = accountGroupService
//				.getListAccountGroupWithViewStatusByIdAccount(account.getIdAccount(), "public");
//		Assert.assertTrue(list.isEmpty());
//
//		list = accountGroupService
//				.getListAccountGroupWithViewStatusByIdAccount(account.getIdAccount(), "private");
//		Assert.assertFalse(list.isEmpty());
//	}
}
