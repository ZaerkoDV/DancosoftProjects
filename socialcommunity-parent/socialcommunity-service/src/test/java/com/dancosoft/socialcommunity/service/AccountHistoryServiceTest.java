/**
 * 
 */
package com.dancosoft.socialcommunity.service;

import java.time.LocalDateTime;
import java.util.Date;

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
import com.dancosoft.socialcommunity.model.AccountHistory;
import com.dancosoft.socialcommunity.model.User;
import com.dancosoft.socialcommunity.service.testsupport.TestStarter;

/**
 * @author Zaerko_DV
 *
 */
public class AccountHistoryServiceTest {//extends TestStarter {

//	private static final Logger logger = LoggerFactory.getLogger(AccountHistoryServiceTest.class);
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
//	@Qualifier("accountHistoryService")
//	private AccountHistoryService accountHistoryService;
//
//	public void setAccountHistoryService(AccountHistoryService accountHistoryService) {
//		this.accountHistoryService = accountHistoryService;
//	}
//
//	public User user;
//	public Account account;
//	public AccountHistory accountHistory;
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
//	public AccountHistory createAccountHistoryForTest() {
//
//		Account testAccount = createAccountForTest();
//		AccountHistory testAccountHistory = new AccountHistory();
//		
//		testAccountHistory.setDateCreateAccount(converter
//				.convertLocalDateTimeToDate(LocalDateTime.of(2015, 12, 16,00, 00)));
//		testAccountHistory.setLastVisit(converter
//				.convertLocalDateTimeToDate(LocalDateTime.of(2015, 12, 17, 00, 00)));
//		testAccountHistory.setAccount(testAccount);
//		accountHistoryService.saveAccountHistory(testAccountHistory);
//
//		return testAccountHistory;
//	}
//	
//	
//	@Before
//	public void initObjectsBeforeTest() {
//		this.accountHistory = createAccountHistoryForTest();
//		this.account = accountHistory.getAccount();
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingAccountHistoryByIdAccount() {
//
//		logger.info("AccountHistoryServiceTest: test method GetAccountHistoryByIdAccount");
//		Assert.assertNotNull(accountHistoryService.getAccountHistoryByIdAccount(account.getIdAccount()));
//	}
//	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingLastVisitAccountByIdAccount() {
//
//		logger.info("AccountHistoryServiceTest: test method GetLastVisitAccountByIdAccount");
//		Date actual = accountHistoryService.getLastVisitAccountByIdAccount(account.getIdAccount());
//		Date expected= accountHistory.getLastVisit();
//		Assert.assertEquals(expected, actual);
//	}
}
