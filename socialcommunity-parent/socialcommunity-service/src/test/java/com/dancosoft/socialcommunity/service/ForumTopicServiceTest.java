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
import com.dancosoft.socialcommunity.model.ForumTopic;
import com.dancosoft.socialcommunity.service.testsupport.TestObjectServiceCreator;
import com.dancosoft.socialcommunity.service.testsupport.TestStarter;

/**
 * @author Zaerko_DV
 *
 */
public class ForumTopicServiceTest extends TestStarter {

	private static final Logger logger = LoggerFactory.getLogger(ForumTopicServiceTest.class);

	@Autowired
	@Qualifier("forumTopicService")
	private ForumTopicService forumTopicService;

	@Autowired
	@Qualifier("testObjectServiceCreator")
	private TestObjectServiceCreator testObjectServiceCreator;

	public void setForumTopicService(ForumTopicService forumTopicService) {
		this.forumTopicService = forumTopicService;
	}

	public void setTestObjectServiceCreator(TestObjectServiceCreator testObjectServiceCreator) {
		this.testObjectServiceCreator = testObjectServiceCreator;
	}

	public ForumTopic forumTopic;
	public Forum forum;
	public Account authorAccount;

	@Before
	public void initObjectsBeforeTest() {
		this.forumTopic = testObjectServiceCreator.createForumTopicForTest();
		this.forum = forumTopic.getForum();
		this.authorAccount = forumTopic.getAuthorAccount();
	}

	@Transactional
	@Rollback(false)
	@Test
	public void testGettingAuthorAccountForumTopic() {
		logger.info("ForumTopicServiceTest: test method GetAuthorAccountForumTopic");
		Assert.assertNotNull(forumTopicService.getAuthorAccountForumTopic(forumTopic.getIdForumTopic()));
	}

	@Transactional
	@Rollback(true)
	@Test
	public void testGettingListForumTopicByIdForum() {
		logger.info("ForumTopicServiceTest: test method GetListForumTopicByIdForum");
		List<ForumTopic> list = forumTopicService.getListForumTopicByIdForum(forum.getIdForum());
		Assert.assertFalse(list.isEmpty());
	}

	@Transactional
	@Rollback(true)
	@Test
	public void testGettingListForumTopicCreateBetweenDateByIdForum() {

		logger.info("ForumTopicServiceTest: test method GetListForumTopicCreateBetweenDateByIdForum");
		LocalDateTime minDateLDT = LocalDateTime.of(2015, 12, 17, 00, 00);
		LocalDateTime maxDateLDT = LocalDateTime.of(2015, 12, 20, 00, 00);
		
		List<ForumTopic> list = forumTopicService.getListForumTopicCreateBetweenDateByIdForum(
						forum.getIdForum(), minDateLDT, maxDateLDT);
		Assert.assertFalse(list.isEmpty());
	}

	@Transactional
	@Rollback(true)
	@Test
	public void testGettingCountForumTopic() {
		
		logger.info("ForumTopicServiceTest: test method GetCountForumTopic");
		int expected=forumTopicService.getCountForumTopic(forum.getIdForum());
		int actual=1;		
		Assert.assertEquals(expected, actual);	
	}
}
