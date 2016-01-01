/**
 * 
 */
package com.dancosoft.socialcommunity.dao;

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

import com.dancosoft.socialcommunity.dao.testsupport.TestObjectDAOCreator;
import com.dancosoft.socialcommunity.dao.testsupport.TestStarter;
import com.dancosoft.socialcommunity.model.Account;
import com.dancosoft.socialcommunity.model.AccountGroup;

/**
 * @author Zaerko_DV
 *
 */
public class AccountGroupDAOTest extends TestStarter {

	private static final Logger logger = LoggerFactory.getLogger(AccountGroupDAOTest.class);

	@Autowired
	@Qualifier("accountGroupDAO")
	private AccountGroupDAO accountGroupDAO;

	@Autowired
	@Qualifier("testObjectDAOCreator")
	private TestObjectDAOCreator testObjectDAOCreator;

	public void setAccountGroupDAO(AccountGroupDAO accountGroupDAO) {
		this.accountGroupDAO = accountGroupDAO;
	}

	public void setTestObjectCreator(TestObjectDAOCreator testObjectCreator) {
		this.testObjectDAOCreator = testObjectCreator;
	}

	public Account account;
	public AccountGroup accountGroup;

	@Before
	public void initObjectsBeforeTest() {
		this.accountGroup = testObjectDAOCreator.createAccountGroupForTest();
		this.account = accountGroup.getAccount();
	}

	@Transactional
	@Rollback(true)
	@Test
	public void testOnBlockAccountGroup() {

		logger.info("AccountGroupDAOTest: test method isBlockAccountGroup");
		Assert.assertFalse(accountGroupDAO.isBlockAccountGroup(account.getIdAccount()));
	}
	
	@Transactional
	@Rollback(true)
	@Test
	public void testGettingAccountGroupBlockStatus() {

		logger.info("AccountGroupDAOTest: test method isBlockAccountGroup");
		String actual=accountGroupDAO.getAccountGroupBlockStatus(account.getIdAccount());
		String expected = accountGroup.getAccountGroupBlockStatus();
		Assert.assertEquals(expected, actual);
	}

	@Transactional
	@Rollback(true)
	@Test
	public void testGettingListAccountGroupWithBlockStatusByIdAccount() {
		
		logger.info("AccountGroupDAOTest: test method GetListAccountGroupWithBlockStatusByIdAccount");
		List<AccountGroup> list=accountGroupDAO.getListAccountGroupWithBlockStatusByIdAccount(account.getIdAccount(), "unblock");
		Assert.assertFalse(list.isEmpty());
	}
	
	@Transactional
	@Rollback(true)
	@Test
	public void testSearchingAccountGroupByGroupNameAccountName() {
		
		logger.info("AccountGroupDAOTest: test method SearchAccountGroupByGroupNameAccountName");
		String accountGroupName= accountGroup.getGroupName();
		String accountName=account.getAccountName();
		List<AccountGroup> list=accountGroupDAO.searchAccountGroupByGroupNameAccountName(accountGroupName,accountName);
		Assert.assertFalse(list.isEmpty());
	}
	
	@Transactional
	@Rollback(true)
	@Test
	public void testGettingListAccountGroupWithViewStatusByIdAccount() {
	
		logger.info("AccountGroupDAOTest: test method GetListAccountGroupWithViewStatusByIdAccount");
		List<AccountGroup> list=accountGroupDAO.getListAccountGroupWithViewStatusByIdAccount(account.getIdAccount(), "public");
		Assert.assertTrue(list.isEmpty());
		
		list=accountGroupDAO.getListAccountGroupWithViewStatusByIdAccount(account.getIdAccount(), "private");
		Assert.assertFalse(list.isEmpty());
	}
}
