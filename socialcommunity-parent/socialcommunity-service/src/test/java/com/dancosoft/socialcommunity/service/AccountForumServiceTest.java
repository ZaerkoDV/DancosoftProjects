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
import com.dancosoft.socialcommunity.model.AccountForum;
import com.dancosoft.socialcommunity.model.Forum;
import com.dancosoft.socialcommunity.service.testsupport.TestObjectServiceCreator;
import com.dancosoft.socialcommunity.service.testsupport.TestStarter;

/**
 * @author Zaerko_DV
 *
 */
public class AccountForumServiceTest extends TestStarter {

	private static final Logger logger = LoggerFactory.getLogger(AccountForumServiceTest.class);
	
	@Autowired
	@Qualifier("accountForumService")
	private AccountForumService accountForumService;

	@Autowired
	@Qualifier("testObjectServiceCreator")
	private TestObjectServiceCreator testObjectServiceCreator;

	public void setAccountForumService(AccountForumService accountForumService) {
		this.accountForumService = accountForumService;
	}

	public void setTestObjectServiceCreator(
			TestObjectServiceCreator testObjectServiceCreator) {
		this.testObjectServiceCreator = testObjectServiceCreator;
	}
	
	public AccountForum accountForum;
	public Account account;
	public Forum forum;

	@Before
	public void initObjectsBeforeTest() {
		this.accountForum = testObjectServiceCreator.createAccountForumForTest();
		this.account =accountForum.getAccount();
		this.forum = accountForum.getForum();
	}
	
	@Transactional
	@Rollback(true)
	@Test
	public void testGettingListAccountByIdForum() {

		logger.info("AccountForumServiceTest: test method GetListAccountByIdForum");
		List<Account>list=accountForumService.getListAccountByIdForum(forum.getIdForum());
		Assert.assertFalse(list.isEmpty());
	}
	
	@Transactional
	@Rollback(true)
	@Test
	public void testGettingListForumByIdAccount() {

		logger.info("AccountForumServiceTest: test method GetListForumByIdAccount");
		List<Forum>list=accountForumService.getListForumByIdAccount(account.getIdAccount());
		Assert.assertFalse(list.isEmpty());
	}
}
