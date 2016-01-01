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

import com.dancosoft.socialcommunity.model.AccountGroup;
import com.dancosoft.socialcommunity.model.AccountGroupHistory;
import com.dancosoft.socialcommunity.service.testsupport.TestObjectServiceCreator;
import com.dancosoft.socialcommunity.service.testsupport.TestStarter;

/**
 * @author Zaerko_DV
 *
 */
public class AccountGroupHistoryServiceTest extends TestStarter {

	private static final Logger logger = LoggerFactory.getLogger(AccountGroupHistoryServiceTest.class);
	
	@Autowired
	@Qualifier("accountGroupHistoryService")
	private AccountGroupHistoryService accountGroupHistoryService;

	@Autowired
	@Qualifier("testObjectServiceCreator")
	private TestObjectServiceCreator testObjectServiceCreator;

	public void setAccountGroupHistoryService(AccountGroupHistoryService accountGroupHistoryService) {
		this.accountGroupHistoryService = accountGroupHistoryService;
	}

	public void setTestObjectServiceCreator(TestObjectServiceCreator testObjectServiceCreator) {
		this.testObjectServiceCreator = testObjectServiceCreator;
	}
	
	public AccountGroupHistory accountGroupHistory;
	public AccountGroup accountGroup;

	@Before
	public void initObjectsBeforeTest() {
		this.accountGroupHistory = testObjectServiceCreator.createAccountGroupHistoryForTest();
		this.accountGroup = accountGroupHistory.getAccountGroup();
	}

	@Transactional
	@Rollback(true)
	@Test
	public void testGettingAccountGroupHistoryByIdAccountGroup() {
		logger.info("AccountGroupHistoryServiceTest: test method GetAccountGroupHistoryByIdAccountGroup");
		Assert.assertNotNull(accountGroupHistoryService
				.getAccountGroupHistoryByIdAccountGroup(accountGroup.getIdAccountGroup()));
	}
}
