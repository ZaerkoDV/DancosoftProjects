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

import com.dancosoft.socialcommunity.model.Account;
import com.dancosoft.socialcommunity.model.Forum;
import com.dancosoft.socialcommunity.model.ForumMessage;
import com.dancosoft.socialcommunity.model.ForumTopic;
import com.dancosoft.socialcommunity.model.User;
import com.dancosoft.socialcommunity.service.testsupport.TestStarter;

/**
 * @author Zaerko_DV
 *
 */
public class ForumMessageServiceTest {//extends TestStarter {

//	private static final Logger logger = LoggerFactory.getLogger(ForumMessageServiceTest.class);
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
//	@Autowired
//	@Qualifier("forumTopicService")
//	private ForumTopicService forumTopicService;
//
//	public void setForumTopicService(ForumTopicService forumTopicService) {
//		this.forumTopicService = forumTopicService;
//	}
//	
//	@Autowired
//	@Qualifier("forumMessageService")
//	private ForumMessageService forumMessageService;
//
//	public void setForumMessageService(ForumMessageService forumMessageService) {
//		this.forumMessageService = forumMessageService;
//	}
//
//	public ForumMessage forumMessage;
//	public ForumTopic forumTopic;
//	public Account authorAccount;
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
//		testForum.setDateCreateForum(LocalDateTime.of(2015, 12, 17,00, 00));
//		forumService.saveForum(testForum);
//
//		return testForum;
//	}
//	
//	public ForumTopic createForumTopicForTest() {
//
//		Forum testForum = createForumForTest();
//		Account testAuthorTopicAccount = createAccountForTest();
//		ForumTopic testForumTopic = new ForumTopic();
//		testForumTopic.setForumTopic("TestForumTopic");
//		testForumTopic.setDateCreateForumTopic(LocalDateTime.of(2015, 12, 17,00, 00));
//		testForumTopic.setForum(testForum);
//		testForumTopic.setAuthorAccount(testAuthorTopicAccount);
//		forumTopicService.saveForumTopic(testForumTopic);
//
//		return testForumTopic;
//	}
//
//	public ForumMessage createForumMessageForTest() {
//
//		ForumTopic testForumTopic = createForumTopicForTest();
//		Account testAuthorAccount = createAccountForTest();
//		ForumMessage testForumMessage = new ForumMessage();
//		testForumMessage.setForumMessage("TestForum Message");
//		testForumMessage.setDateCreateForumMessage(LocalDateTime.of(2015, 12,17, 00, 00));
//		testForumMessage.setForumTopic(testForumTopic);
//		testForumMessage.setAuthorAccount(testAuthorAccount);
//		forumMessageService.saveForumMessage(testForumMessage);
//
//		return testForumMessage;
//	}
//	
//	@Before
//	public void initObjectsBeforeTest() {
//		this.forumMessage = createForumMessageForTest();
//		this.forumTopic = forumMessage.getForumTopic();
//		this.authorAccount = forumMessage.getAuthorAccount();
//	}
//
//	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingAccountAuthorMessageByIdForumMessage() {
//
//		logger.info("ForumMessageServiceTest: test method GetAccountAuthorMessageByIdForumMessage");
//		Account account = forumMessageService
//				.getAccountAuthorMessageByIdForumMessage(forumMessage.getIdForumMessage());
//		Assert.assertNotNull(account);
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingListForumMessageByIdForumTopic() {
//
//		logger.info("ForumMessageServiceTest: test method GetListForumMessageByIdForumTopic");
//		List<ForumMessage> list = forumMessageService
//				.getListForumMessageByIdForumTopic(forumTopic.getIdForumTopic());
//		Assert.assertFalse(list.isEmpty());
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingListForumMessageBetweenDateByIdForumTopic() {
//
//		logger.info("ForumMessageServiceTest: test method GetListForumMessageBetweenDateByIdForumTopic");
//		LocalDateTime minDateLDT = LocalDateTime.of(2015, 12, 17, 00, 00);
//		LocalDateTime maxDateLDT = LocalDateTime.of(2015, 12, 20, 00, 00);
//
//		List<ForumMessage> list = forumMessageService
//				.getListForumMessageBetweenDateByIdForumTopic(forumTopic.getIdForumTopic(), minDateLDT, maxDateLDT);
//		Assert.assertFalse(list.isEmpty());
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingListForumMessageByIdAccount() {
//		
//		logger.info("ForumMessageServiceTest: test method GetListForumMessagetByIdAccount");
//		List<ForumMessage> list = forumMessageService
//				.getListForumMessagetByIdAccount(authorAccount.getIdAccount());
//		Assert.assertFalse(list.isEmpty());	
//	}
}
