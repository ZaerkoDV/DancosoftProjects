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
import com.dancosoft.socialcommunity.model.AccountForum;
import com.dancosoft.socialcommunity.model.Forum;
/**
 * @author Zaerko_DV
 *
 */

public class AccountForumDAOTest extends TestStarter {

	private static final Logger logger = LoggerFactory.getLogger(AccountForumDAOTest.class);

	@Autowired
	@Qualifier("accountForumDAO")
	private AccountForumDAO accountForumDAO;

	@Autowired
	@Qualifier("testObjectDAOCreator")
	private TestObjectDAOCreator testObjectDAOCreator;

	public void setAccountForumDAO(AccountForumDAO accountForumDAO) {
		this.accountForumDAO = accountForumDAO;
	}

	public void setTestObjectDAOCreator(TestObjectDAOCreator testObjectDAOCreator) {
		this.testObjectDAOCreator = testObjectDAOCreator;
	}

	public AccountForum accountForum;
	public Account account;
	public Forum forum;

	@Before
	public void initObjectsBeforeTest() {
		this.accountForum = testObjectDAOCreator.createAccountForumForTest();
		this.account =accountForum.getAccount();
		this.forum = accountForum.getForum();
	}
	
	@Transactional
	@Rollback(true)
	@Test
	public void testGettingListAccountByIdForum() {

		logger.info("AccountForumDAOTest: test method GetListAccountByIdForum");
		List<Account>list=accountForumDAO.getListAccountByIdForum(forum.getIdForum());
		Assert.assertFalse(list.isEmpty());
	}
	
	@Transactional
	@Rollback(true)
	@Test
	public void testGettingListForumByIdAccount() {

		logger.info("AccountForumDAOTest: test method GetListForumByIdAccount");
		List<Forum>list=accountForumDAO.getListForumByIdAccount(account.getIdAccount());
		Assert.assertFalse(list.isEmpty());
	}
}
