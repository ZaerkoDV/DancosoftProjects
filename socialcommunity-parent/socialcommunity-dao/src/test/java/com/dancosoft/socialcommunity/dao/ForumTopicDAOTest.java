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
import com.dancosoft.socialcommunity.model.Forum;
import com.dancosoft.socialcommunity.model.ForumTopic;

/**
 * @author Zaerko_DV
 *
 */
public class ForumTopicDAOTest {//extends TestStarter {

//	private static final Logger logger = LoggerFactory.getLogger(ForumTopicDAOTest.class);
//
//	@Autowired
//	@Qualifier("forumTopicDAO")
//	private ForumTopicDAO forumTopicDAO;
//
//	@Autowired
//	@Qualifier("testObjectDAOCreator")
//	private TestObjectDAOCreator testObjectDAOCreator;
//
//	public void setForumTopicDAO(ForumTopicDAO forumTopicDAO) {
//		this.forumTopicDAO = forumTopicDAO;
//	}
//
//	public void setTestObjectDAOCreator(TestObjectDAOCreator testObjectDAOCreator) {
//		this.testObjectDAOCreator = testObjectDAOCreator;
//	}
//
//	TimeConverter converter = new TimeConverter();
//
//	public ForumTopic forumTopic;
//	public Forum forum;
//	public Account authorAccount;
//
//	@Before
//	public void initObjectsBeforeTest() {
//		this.forumTopic = testObjectDAOCreator.createForumTopicForTest();
//		this.forum = forumTopic.getForum();
//		this.authorAccount = forumTopic.getAuthorAccount();
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingAuthorAccountForumTopic() {
//
//		logger.info("ForumTopicDAOTest: test method GetAuthorAccountForumTopic");
//		Assert.assertNotNull(forumTopicDAO.getAuthorAccountForumTopic(forumTopic.getIdForumTopic()));
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingListForumTopicByIdForum() {
//
//		logger.info("ForumTopicDAOTest: test method GetListForumTopicByIdForum");
//		List<ForumTopic> list = forumTopicDAO.getListForumTopicByIdForum(forum
//				.getIdForum());
//		Assert.assertFalse(list.isEmpty());
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingListForumTopicCreateBetweenDateByIdForum() {
//
//		logger.info("ForumTopicDAOTest: test method GetListForumTopicCreateBetweenDateByIdForum");
//
//		LocalDateTime minDateLDT = LocalDateTime.of(2015, 12, 17, 00, 00);
//		LocalDateTime maxDateLDT = LocalDateTime.of(2015, 12, 20, 00, 00);
//		Date minDateD = converter.convertLocalDateTimeToDate(minDateLDT);
//		Date maxDateD = converter.convertLocalDateTimeToDate(maxDateLDT);
//
//		List<ForumTopic> list = forumTopicDAO
//				.getListForumTopicCreateBetweenDateByIdForum(
//						forum.getIdForum(), minDateD, maxDateD);
//		Assert.assertFalse(list.isEmpty());
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingCountForumTopic() {
//		
//		logger.info("ForumTopicDAOTest: test method GetCountForumTopic");
//		int expected=forumTopicDAO.getCountForumTopic(forum.getIdForum());
//		int actual=1;		
//		Assert.assertEquals(expected, actual);	
//	}
}
