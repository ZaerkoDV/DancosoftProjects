/**
 * 
 */
package com.dancosoft.socialcommunity.dao;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.dancosoft.socialcommunity.dao.testsupport.TestObjectDAOCreator;
import com.dancosoft.socialcommunity.dao.testsupport.TestStarter;
import com.dancosoft.socialcommunity.model.Account;
import com.dancosoft.socialcommunity.model.User;

/**
 * @author Zaerko_DV
 *
 */
public class AccountDAOTest extends TestStarter {

	private static final Logger logger = LoggerFactory.getLogger(AccountDAOTest.class);

	@Autowired
	@Qualifier("accountDAO")
	private AccountDAO accountDAO;

	@Autowired
	@Qualifier("testObjectDAOCreator")
	private TestObjectDAOCreator testObjectDAOCreator;

	public void setAccountDAO(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}

	public void setTestObjectDAOCreator(TestObjectDAOCreator testObjectDAOCreator) {
		this.testObjectDAOCreator = testObjectDAOCreator;
	}

	public User user;
	public Account account;

	@Before
	public void initObjectsBeforeTest() {
		this.account = testObjectDAOCreator.createAccountForTest();
		this.user = account.getUser();
	}
	
	@Transactional
	@Rollback(true)
	@Test
	public void testSearchAccountByAccountNameUserLastName() {

		logger.info("AccountDAOTest: test method SearchAccountByAccountUserLastName");
		Assert.assertNotNull(accountDAO.searchAccountByAccountNameUserLastName(account.getAccountName(), user.getLastName()));
	}
	
	@Transactional
	@Rollback(true)
	@Test
	public void testGettingIdUserByIdAccount() {

		logger.info("AccountDAOTest: test method GetIdUserByIdAccount");
		Long actual=accountDAO.getIdUserByIdAccount(account.getIdAccount());
		Long expected= user.getIdUser();
		Assert.assertEquals(expected, actual);
	}
	
	@Transactional
	@Rollback(true)
	@Test
	public void testOnAccountBlock() {

		logger.info("AccountDAOTest: test method isAccountBlock");
		Assert.assertFalse(accountDAO.isAccountBlock(account.getIdAccount()));
	}
	
	@Transactional
	@Rollback(true)
	@Test
	public void testGettingAccountStatus() {

		logger.info("AccountDAOTest: test method GettingAccountStatus");
		Assert.assertEquals(account.getAccountBlockStatus(), accountDAO.getAccountStatus(account.getIdAccount()));
	}
}
