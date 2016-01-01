/**
 * 
 */
package com.dancosoft.socialcommunity.service;

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
import com.dancosoft.socialcommunity.service.testsupport.TestObjectServiceCreator;
import com.dancosoft.socialcommunity.service.testsupport.TestStarter;

/**
 * @author Zaerko_DV
 *
 */
public class AccountServiceTest extends TestStarter {

	private static final Logger logger = LoggerFactory.getLogger(AccountServiceTest.class);
	
	@Autowired
	@Qualifier("accountService")
	private AccountService accountService;

	@Autowired
	@Qualifier("testObjectServiceCreator")
	private TestObjectServiceCreator testObjectServiceCreator;

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	public void setTestObjectServiceCreator(TestObjectServiceCreator testObjectServiceCreator) {
		this.testObjectServiceCreator = testObjectServiceCreator;
	}

	public User user;
	public Account account;

	@Before
	public void initObjectsBeforeTest() {
		this.account = testObjectServiceCreator.createAccountForTest();
		this.user = account.getUser();
	}
	
	@Transactional
	@Rollback(true)
	@Test
	public void testSearchAccountByAccountNameUserLastName() {

		logger.info("AccountServiceTest: test method SearchAccountByAccountUserLastName");
		Assert.assertNotNull(accountService.searchAccountByAccountNameUserLastName(account.getAccountName(), user.getLastName()));
	}
	
	@Transactional
	@Rollback(true)
	@Test
	public void testGettingIdUserByIdAccount() {

		logger.info("AccountServiceTest: test method GetIdUserByIdAccount");
		Long actual=accountService.getIdUserByIdAccount(account.getIdAccount());
		Long expected= user.getIdUser();
		Assert.assertEquals(expected, actual);
	}
	
	@Transactional
	@Rollback(true)
	@Test
	public void testOnAccountBlock() {

		logger.info("AccountServiceTest: test method isAccountBlock");
		Assert.assertFalse(accountService.isAccountBlock(account.getIdAccount()));
	}
	
	@Transactional
	@Rollback(true)
	@Test
	public void testGettingAccountStatus() {

		logger.info("AccountServiceTest: test method GettingAccountStatus");
		Assert.assertEquals(account.getAccountBlockStatus(), accountService.getAccountStatus(account.getIdAccount()));
	}
}
