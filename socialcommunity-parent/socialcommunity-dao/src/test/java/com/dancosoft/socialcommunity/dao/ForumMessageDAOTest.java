/**
 * 
 */
package com.dancosoft.socialcommunity.dao;

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
import com.dancosoft.socialcommunity.dao.testsupport.TestObjectDAOCreator;
import com.dancosoft.socialcommunity.dao.testsupport.TestStarter;
import com.dancosoft.socialcommunity.model.Account;
import com.dancosoft.socialcommunity.model.ForumMessage;
import com.dancosoft.socialcommunity.model.ForumTopic;

/**
 * @author Zaerko_DV
 *
 */
public class ForumMessageDAOTest {//extends TestStarter {

//	private static final Logger logger = LoggerFactory.getLogger(ForumMessageDAOTest.class);
//
//	@Autowired
//	@Qualifier("forumMessageDAO")
//	private ForumMessageDAO forumMessageDAO;
//
//	@Autowired
//	@Qualifier("testObjectDAOCreator")
//	private TestObjectDAOCreator testObjectDAOCreator;
//
//	public void setForumMessageDAO(ForumMessageDAO forumMessageDAO) {
//		this.forumMessageDAO = forumMessageDAO;
//	}
//
//	public void setTestObjectCreator(TestObjectDAOCreator testObjectDAOCreator) {
//		this.testObjectDAOCreator = testObjectDAOCreator;
//	}
//
//	TimeConverter converter = new TimeConverter();
//
//	public ForumMessage forumMessage;
//	public ForumTopic forumTopic;
//	public Account authorAccount;
//
//	@Before
//	public void initObjectsBeforeTest() {
//		this.forumMessage = testObjectDAOCreator.createForumMessageForTest();
//		this.forumTopic = forumMessage.getForumTopic();
//		this.authorAccount = forumMessage.getAuthorAccount();
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingAccountAuthorMessageByIdForumMessage() {
//
//		logger.info("ForumMessageDAOTest: test method GetAccountAuthorMessageByIdForumMessage");
//		Account account = forumMessageDAO
//				.getAccountAuthorMessageByIdForumMessage(forumMessage
//						.getIdForumMessage());
//		Assert.assertNotNull(account);
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingListForumMessageByIdForumTopic() {
//
//		logger.info("ForumMessageDAOTest: test method GetListForumMessageByIdForumTopic");
//		List<ForumMessage> list = forumMessageDAO
//				.getListForumMessageByIdForumTopic(forumTopic.getIdForumTopic());
//		Assert.assertFalse(list.isEmpty());
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingListForumMessageBetweenDateByIdForumTopic() {
//
//		logger.info("ForumMessageDAOTest: test method GetListForumMessageBetweenDateByIdForumTopic");
//		LocalDateTime minDateLDT = LocalDateTime.of(2015, 12, 17, 00, 00);
//		LocalDateTime maxDateLDT = LocalDateTime.of(2015, 12, 20, 00, 00);
//		Date minDateD = converter.convertLocalDateTimeToDate(minDateLDT);
//		Date maxDateD = converter.convertLocalDateTimeToDate(maxDateLDT);
//
//		List<ForumMessage> list = forumMessageDAO
//				.getListForumMessageBetweenDateByIdForumTopic(
//						forumTopic.getIdForumTopic(), minDateD, maxDateD);
//		Assert.assertFalse(list.isEmpty());
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingListForumMessageByIdAccount() {
//		
//		logger.info("ForumTopicDAOTest: test method GetListForumMessagetByIdAccount");
//		List<ForumMessage> list = forumMessageDAO.getListForumMessagetByIdAccount(authorAccount.getIdAccount());
//		Assert.assertFalse(list.isEmpty());	
//	}
}
