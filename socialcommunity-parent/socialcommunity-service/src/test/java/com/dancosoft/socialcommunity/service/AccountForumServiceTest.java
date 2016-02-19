/**
 * 
 */
package com.dancosoft.socialcommunity.service;

import java.time.LocalDateTime;
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

import com.dancosoft.socialcommunity.dao.support.TimeConverter;
import com.dancosoft.socialcommunity.model.Account;
import com.dancosoft.socialcommunity.model.AccountForum;
import com.dancosoft.socialcommunity.model.Forum;
import com.dancosoft.socialcommunity.model.User;
import com.dancosoft.socialcommunity.service.testsupport.TestStarter;

/**
 * @author Zaerko_DV
 *
 */
public class AccountForumServiceTest {//extends TestStarter {

//	private static final Logger logger = LoggerFactory.getLogger(AccountForumServiceTest.class);
//	
//	public TimeConverter converter =new TimeConverter();
//	
//	@Autowired
//	@Qualifier("accountForumService")
//	private AccountForumService accountForumService;
//
//	public void setAccountForumService(AccountForumService accountForumService) {
//		this.accountForumService = accountForumService;
//	}
//
//	@Autowired
//	@Qualifier(value="accountService")
//	private AccountService accountService;
//	
//	public void setAccountService(AccountService accountService) {
//		this.accountService = accountService;
//	}
//
//	@Autowired
//	@Qualifier(value="forumService")
//	private ForumService forumService;
//	
//	public void setForumService(ForumService forumService) {
//		this.forumService = forumService;
//	}
//
//	@Autowired
//	@Qualifier(value="userService")
//	private UserService userService;
//	
//	public void setUserService(UserService userService) {
//		this.userService = userService;
//	}
//
//	public AccountForum accountForum;
//	public Account account;
//	public Forum forum;
//	public User user;
//
//	public User createUserForTest() {
//		User testUser = new User();
//		testUser.setFirstName("testFirstName");
//		testUser.setLastName("testLastName");
//		testUser.setMiddleName("testMiddleName");
//		testUser.setSex("F");
//		userService.saveUser(testUser);
//
//		return testUser;
//	}
//	
//	public Account createAccountForTest() {
//		User testUser = createUserForTest();
//		Account testAccount = new Account();
//		testAccount.setAccountName("TestAccount");
//		testAccount.setAccountBlockStatus("unblock");
//		testAccount.setUser(testUser);
//		accountService.saveAccount(testAccount);
//
//		return testAccount;
//	}
//	
//	public Forum createForumForTest() {
//		Forum testForum = new Forum();
//		testForum.setForumName("TestForum");
//		testForum.setViewStatus("public");
//		testForum.setDateCreateForum(converter.convertLocalDateTimeToDate(LocalDateTime.of(2015, 12, 17,00, 00)));
//		forumService.saveForum(testForum);
//
//		return testForum;
//	}
//	
//	public AccountForum createAccountForumForTest() {
//		Account testAccount = createAccountForTest();
//		Forum testForum = createForumForTest();
//		AccountForum accountForum=new AccountForum();
//		accountForum.setAccount(testAccount);
//		accountForum.setForum(testForum);
//		accountForumService.saveAccountForum(accountForum);
//		
//		return accountForum;
//	}
//	
//	@Before
//	public void initObjectsBeforeTest() {
//		this.accountForum = createAccountForumForTest();
//		this.account =accountForum.getAccount();
//		this.forum = accountForum.getForum();
//	}
//	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingListAccountByIdForum() {
//
//		logger.info("AccountForumServiceTest: test method GetListAccountByIdForum");
//		List<Account>list=accountForumService.getListAccountByIdForum(forum.getIdForum());
//		Assert.assertFalse(list.isEmpty());
//	}
//	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingListForumByIdAccount() {
//
//		logger.info("AccountForumServiceTest: test method GetListForumByIdAccount");
//		List<Forum>list=accountForumService.getListForumByIdAccount(account.getIdAccount());
//		Assert.assertFalse(list.isEmpty());
//	}
}
