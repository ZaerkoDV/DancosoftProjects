/**
 * 
 */
package com.dancosoft.socialcommunity.service;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.dancosoft.socialcommunity.dao.support.TimeConverter;
import com.dancosoft.socialcommunity.model.Account;
import com.dancosoft.socialcommunity.model.AccountGroup;
import com.dancosoft.socialcommunity.model.AccountGroupHistory;
import com.dancosoft.socialcommunity.model.User;
import com.dancosoft.socialcommunity.service.testsupport.TestStarter;

/**
 * @author Zaerko_DV
 *
 */
public class AccountGroupHistoryServiceTest {//extends TestStarter {

//	private static final Logger logger = LoggerFactory.getLogger(AccountGroupHistoryServiceTest.class);
//	
//	public TimeConverter converter=new TimeConverter();
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
//	@Autowired
//	@Qualifier("accountGroupHistoryService")
//	private AccountGroupHistoryService accountGroupHistoryService;
//
//	public void setAccountGroupHistoryService(AccountGroupHistoryService accountGroupHistoryService) {
//		this.accountGroupHistoryService = accountGroupHistoryService;
//	}
//
//	private AccountGroup accountGroup;
//	private AccountGroupHistory accountGroupHistory;
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
//	public AccountGroupHistory createAccountGroupHistoryForTest() {
//
//		AccountGroup testAccountGroup = createAccountGroupForTest();
//		AccountGroupHistory testAccountGroupHistory = new AccountGroupHistory();
//		testAccountGroupHistory.setDateCreateGroup(converter
//				.convertLocalDateTimeToDate(LocalDateTime.of(2015, 12,16, 00, 00)));
//		testAccountGroupHistory.setLastVisit(converter
//				.convertLocalDateTimeToDate(LocalDateTime.of(2015, 12, 17, 00, 00)));
//		testAccountGroupHistory.setAccountGroup(testAccountGroup);
//		accountGroupHistoryService.saveAccountGroupHistory(testAccountGroupHistory);
//
//		return testAccountGroupHistory;
//	}
//	
//	@Before
//	public void initObjectsBeforeTest() {
//		this.accountGroupHistory = createAccountGroupHistoryForTest();
//		this.accountGroup = accountGroupHistory.getAccountGroup();
//	}
//	
//	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingAccountGroupHistoryByIdAccountGroup() {
//		logger.info("AccountGroupHistoryServiceTest: test method GetAccountGroupHistoryByIdAccountGroup");
//		Assert.assertNotNull(accountGroupHistoryService
//				.getAccountGroupHistoryByIdAccountGroup(accountGroup.getIdAccountGroup()));
//	}
}
