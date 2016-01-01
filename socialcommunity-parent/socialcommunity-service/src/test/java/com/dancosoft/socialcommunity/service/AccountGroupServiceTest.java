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
import com.dancosoft.socialcommunity.service.testsupport.TestObjectServiceCreator;
import com.dancosoft.socialcommunity.service.testsupport.TestStarter;

/**
 * @author Zaerko_DV
 *
 */
public class AccountGroupServiceTest extends TestStarter {

	private static final Logger logger = LoggerFactory.getLogger(AccountGroupServiceTest.class);

	@Autowired
	@Qualifier("accountGroupService")
	private AccountGroupService accountGroupService;

	@Autowired
	@Qualifier("testObjectServiceCreator")
	private TestObjectServiceCreator testObjectServiceCreator;

	public void setAccountGroupService(AccountGroupService accountGroupService) {
		this.accountGroupService = accountGroupService;
	}

	public void setTestObjectServiceCreator(TestObjectServiceCreator testObjectServiceCreator) {
		this.testObjectServiceCreator = testObjectServiceCreator;
	}

	public Account account;
	public AccountGroup accountGroup;

	@Before
	public void initObjectsBeforeTest() {
		this.accountGroup = testObjectServiceCreator.createAccountGroupForTest();
		this.account = accountGroup.getAccount();
	}

	@Transactional
	@Rollback(true)
	@Test
	public void testOnBlockAccountGroup() {

		logger.info("AccountGroupServiceTest: test method isBlockAccountGroup");
		Assert.assertFalse(accountGroupService.isBlockAccountGroup(account.getIdAccount()));
	}

	@Transactional
	@Rollback(true)
	@Test
	public void testGettingAccountGroupBlockStatus() {

		logger.info("AccountGroupServiceTest: test method isBlockAccountGroup");
		String actual = accountGroupService.getAccountGroupBlockStatus(account.getIdAccount());
		String expected = accountGroup.getAccountGroupBlockStatus();
		Assert.assertEquals(expected, actual);
	}

	@Transactional
	@Rollback(true)
	@Test
	public void testGettingListAccountGroupWithBlockStatusByIdAccount() {

		logger.info("AccountGroupServiceTest: test method GetListAccountGroupWithBlockStatusByIdAccount");
		List<AccountGroup> list = accountGroupService
				.getListAccountGroupWithBlockStatusByIdAccount(account.getIdAccount(), "unblock");
		Assert.assertFalse(list.isEmpty());
	}

	@Transactional
	@Rollback(true)
	@Test
	public void testSearchingAccountGroupByGroupNameAccountName() {

		logger.info("AccountGroupServiceTest: test method SearchAccountGroupByGroupNameAccountName");
		String accountGroupName = accountGroup.getGroupName();
		String accountName = account.getAccountName();
		List<AccountGroup> list = accountGroupService
				.searchAccountGroupByGroupNameAccountName(accountGroupName,accountName);
		Assert.assertFalse(list.isEmpty());
	}

	@Transactional
	@Rollback(true)
	@Test
	public void testGettingListAccountGroupWithViewStatusByIdAccount() {

		logger.info("AccountGroupServiceTest: test method GetListAccountGroupWithViewStatusByIdAccount");
		List<AccountGroup> list = accountGroupService
				.getListAccountGroupWithViewStatusByIdAccount(account.getIdAccount(), "public");
		Assert.assertTrue(list.isEmpty());

		list = accountGroupService
				.getListAccountGroupWithViewStatusByIdAccount(account.getIdAccount(), "private");
		Assert.assertFalse(list.isEmpty());
	}
}
