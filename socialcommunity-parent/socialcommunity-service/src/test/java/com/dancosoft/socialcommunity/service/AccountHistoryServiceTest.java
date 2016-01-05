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
import com.dancosoft.socialcommunity.model.AccountHistory;
import com.dancosoft.socialcommunity.service.testsupport.TestObjectServiceCreator;
import com.dancosoft.socialcommunity.service.testsupport.TestStarter;

/**
 * @author Zaerko_DV
 *
 */
public class AccountHistoryServiceTest {//extends TestStarter {

//	private static final Logger logger = LoggerFactory.getLogger(AccountHistoryServiceTest.class);
//	
//	@Autowired
//	@Qualifier("accountHistoryService")
//	private AccountHistoryService accountHistoryService;
//
//	@Autowired
//	@Qualifier("testObjectServiceCreator")
//	private TestObjectServiceCreator testObjectServiceCreator;
//
//	public void setAccountHistoryService(AccountHistoryService accountHistoryService) {
//		this.accountHistoryService = accountHistoryService;
//	}
//
//	public void setTestObjectServiceCreator(TestObjectServiceCreator testObjectServiceCreator) {
//		this.testObjectServiceCreator = testObjectServiceCreator;
//	}
//	
//	public Account account;
//	public AccountHistory accountHistory;
//	
//	TimeConverter converter=new TimeConverter();
//
//	@Before
//	public void initObjectsBeforeTest() {
//		this.accountHistory = testObjectServiceCreator.createAccountHistoryForTest();
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
//		LocalDateTime actual = accountHistoryService.getLastVisitAccountByIdAccount(account.getIdAccount());
//		LocalDateTime expected= converter.convertDateToLocalDateTime(accountHistory.getLastVisit());
//		Assert.assertEquals(expected, actual);
//	}
}
