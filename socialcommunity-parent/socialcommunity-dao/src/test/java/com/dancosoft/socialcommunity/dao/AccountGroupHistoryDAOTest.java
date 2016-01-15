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
import com.dancosoft.socialcommunity.model.AccountGroup;
import com.dancosoft.socialcommunity.model.AccountGroupHistory;

/**
 * @author Zaerko_DV
 *
 */
public class AccountGroupHistoryDAOTest {//extends TestStarter {

//	private static final Logger logger = LoggerFactory.getLogger(AccountGroupHistoryDAOTest.class);
//
//	@Autowired
//	@Qualifier("accountGroupHistoryDAO")
//	private AccountGroupHistoryDAO accountGroupHistoryDAO;
//
//	@Autowired
//	@Qualifier("testObjectDAOCreator")
//	private TestObjectDAOCreator testObjectDAOCreator;
//
//	public void setAccountGroupHistoryDAO(AccountGroupHistoryDAO accountGroupHistoryDAO) {
//		this.accountGroupHistoryDAO = accountGroupHistoryDAO;
//	}
//
//	public void setTestObjectDAOCreator(TestObjectDAOCreator testObjectDAOCreator) {
//		this.testObjectDAOCreator = testObjectDAOCreator;
//	}
//
//	public AccountGroupHistory accountGroupHistory;
//	public AccountGroup accountGroup;
//
//	@Before
//	public void initObjectsBeforeTest() {
//		this.accountGroupHistory = testObjectDAOCreator.createAccountGroupHistoryForTest();
//		this.accountGroup = accountGroupHistory.getAccountGroup();
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingAccountGroupHistoryByIdAccountGroup() {
//
//		logger.info("AccountGroupHistoryDAO: test method GetAccountGroupHistoryByIdAccountGroup");
//		Assert.assertNotNull(accountGroupHistoryDAO.getAccountGroupHistoryByIdAccountGroup(accountGroup
//						.getIdAccountGroup()));
//	}
}
