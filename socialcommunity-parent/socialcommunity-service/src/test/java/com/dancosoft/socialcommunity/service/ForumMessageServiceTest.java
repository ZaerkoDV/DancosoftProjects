/**
 * 
 */
package com.dancosoft.socialcommunity.service;

import java.time.LocalDateTime;
import java.util.Date;
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
import com.dancosoft.socialcommunity.model.ForumMessage;
import com.dancosoft.socialcommunity.model.ForumTopic;
import com.dancosoft.socialcommunity.service.testsupport.TestObjectServiceCreator;
import com.dancosoft.socialcommunity.service.testsupport.TestStarter;

/**
 * @author Zaerko_DV
 *
 */
public class ForumMessageServiceTest extends TestStarter {

	private static final Logger logger = LoggerFactory.getLogger(ForumMessageServiceTest.class);

	@Autowired
	@Qualifier("forumMessageService")
	private ForumMessageService forumMessageService;

	@Autowired
	@Qualifier("testObjectServiceCreator")
	private TestObjectServiceCreator testObjectServiceCreator;

	public void setForumMessageService(ForumMessageService forumMessageService) {
		this.forumMessageService = forumMessageService;
	}

	public void setTestObjectServiceCreator(TestObjectServiceCreator testObjectServiceCreator) {
		this.testObjectServiceCreator = testObjectServiceCreator;
	}
	
	TimeConverter converter = new TimeConverter();

	public ForumMessage forumMessage;
	public ForumTopic forumTopic;
	public Account authorAccount;

	@Before
	public void initObjectsBeforeTest() {
		this.forumMessage = testObjectServiceCreator.createForumMessageForTest();
		this.forumTopic = forumMessage.getForumTopic();
		this.authorAccount = forumMessage.getAuthorAccount();
	}

	@Transactional
	@Rollback(true)
	@Test
	public void testGettingAccountAuthorMessageByIdForumMessage() {

		logger.info("ForumMessageServiceTest: test method GetAccountAuthorMessageByIdForumMessage");
		Account account = forumMessageService
				.getAccountAuthorMessageByIdForumMessage(forumMessage.getIdForumMessage());
		Assert.assertNotNull(account);
	}

	@Transactional
	@Rollback(true)
	@Test
	public void testGettingListForumMessageByIdForumTopic() {

		logger.info("ForumMessageServiceTest: test method GetListForumMessageByIdForumTopic");
		List<ForumMessage> list = forumMessageService
				.getListForumMessageByIdForumTopic(forumTopic.getIdForumTopic());
		Assert.assertFalse(list.isEmpty());
	}

	@Transactional
	@Rollback(true)
	@Test
	public void testGettingListForumMessageBetweenDateByIdForumTopic() {

		logger.info("ForumMessageServiceTest: test method GetListForumMessageBetweenDateByIdForumTopic");
		LocalDateTime minDateLDT = LocalDateTime.of(2015, 12, 17, 00, 00);
		LocalDateTime maxDateLDT = LocalDateTime.of(2015, 12, 20, 00, 00);
		Date minDateD = converter.convertLocalDateTimeToDate(minDateLDT);
		Date maxDateD = converter.convertLocalDateTimeToDate(maxDateLDT);

		List<ForumMessage> list = forumMessageService
				.getListForumMessageBetweenDateByIdForumTopic(forumTopic.getIdForumTopic(), minDateD, maxDateD);
		Assert.assertFalse(list.isEmpty());
	}

	@Transactional
	@Rollback(true)
	@Test
	public void testGettingListForumMessageByIdAccount() {
		
		logger.info("ForumMessageServiceTest: test method GetListForumMessagetByIdAccount");
		List<ForumMessage> list = forumMessageService
				.getListForumMessagetByIdAccount(authorAccount.getIdAccount());
		Assert.assertFalse(list.isEmpty());	
	}
}
