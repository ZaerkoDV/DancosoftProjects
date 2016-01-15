/**
 * 
 */
package com.dancosoft.socialcommunity.dao;

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
import com.dancosoft.socialcommunity.dao.testsupport.TestObjectDAOCreator;
import com.dancosoft.socialcommunity.dao.testsupport.TestStarter;
import com.dancosoft.socialcommunity.model.Account;
import com.dancosoft.socialcommunity.model.AccountHistory;

/**
 * @author Zaerko_DV
 *
 */
public class AccountHistoryDAOTest {//extends TestStarter {

//	private static final Logger logger = LoggerFactory.getLogger(AccountHistoryDAOTest.class);
//
//	@Autowired
//	@Qualifier("accountHistoryDAO")
//	private AccountHistoryDAO accountHistoryDAO;
//
//	@Autowired
//	@Qualifier("testObjectDAOCreator")
//	private TestObjectDAOCreator testObjectDAOCreator;
//
//	public void setAccountHistoryDAO(AccountHistoryDAO accountHistoryDAO) {
//		this.accountHistoryDAO = accountHistoryDAO;
//	}
//
//	public void setTestObjectDAOCreator(TestObjectDAOCreator testObjectDAOCreator) {
//		this.testObjectDAOCreator = testObjectDAOCreator;
//	}
//
//	public Account account;
//	public AccountHistory accountHistory;
//	
//	TimeConverter converter=new TimeConverter();
//
//	@Before
//	public void initObjectsBeforeTest() {
//		this.accountHistory = testObjectDAOCreator.createAccountHistoryForTest();
//		this.account = accountHistory.getAccount();
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingAccountHistoryByIdAccount() {
//
//		logger.info("AccountHistoryDAOTest: test method GetAccountHistoryByIdAccount");
//		Assert.assertNotNull(accountHistoryDAO.getAccountHistoryByIdAccount(account.getIdAccount()));
//	}
//	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingLastVisitAccountByIdAccount() {
//
//		logger.info("AccountHistoryDAOTest: test method GetLastVisitAccountByIdAccount");
//		LocalDateTime actual = accountHistoryDAO.getLastVisitAccountByIdAccount(account.getIdAccount());
//		LocalDateTime expected= converter.convertDateToLocalDateTime(accountHistory.getLastVisit());
//		Assert.assertEquals(expected, actual);
//	}
}
