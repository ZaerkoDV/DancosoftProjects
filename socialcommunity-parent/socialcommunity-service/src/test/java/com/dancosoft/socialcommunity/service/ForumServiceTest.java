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

import com.dancosoft.socialcommunity.model.Forum;
import com.dancosoft.socialcommunity.service.testsupport.TestObjectServiceCreator;
import com.dancosoft.socialcommunity.service.testsupport.TestStarter;

/**
 * @author Zaerko_DV
 *
 */
public class ForumServiceTest extends TestStarter{

	private static final Logger logger = LoggerFactory.getLogger(ForumServiceTest.class);

	@Autowired
	@Qualifier("forumService")
	private ForumService forumService;

	@Autowired
	@Qualifier("testObjectServiceCreator")
	private TestObjectServiceCreator testObjectServiceCreator;

	public void setForumService(ForumService forumService) {
		this.forumService = forumService;
	}

	public void setTestObjectServiceCreator(TestObjectServiceCreator testObjectServiceCreator) {
		this.testObjectServiceCreator = testObjectServiceCreator;
	}
	
	public Forum forum;

	@Before
	public void initObjectsBeforeTest() {
		this.forum = testObjectServiceCreator.createForumForTest();
	}

	@Transactional
	@Rollback(true)
	@Test
	public void testGettingListForumCreatedBetweenDateByIdForum() {

		logger.info("ForumServiceTest: test method GetListForumCreatedBetweenDateByIdForum");
		LocalDateTime minDateLDT = LocalDateTime.of(2015, 12, 17, 00, 00);
		LocalDateTime maxDateLDT = LocalDateTime.of(2015, 12, 20, 00, 00);

		List<Forum> list = forumService.getListForumCreatedBetweenDateByIdForum(minDateLDT, maxDateLDT);
		Assert.assertFalse(list.isEmpty());
	}

	@Transactional
	@Rollback(true)
	@Test
	public void testGettingCountForum() {

		logger.info("ForumServiceTest: test method GetCountForum");
		int actual=forumService.getCountForum();
		int expected=1;
		Assert.assertEquals(expected, actual);	
	}

	@Transactional
	@Rollback(true)
	@Test
	public void testOnSearchForumByForumName() {

		logger.info("ForumServiceTest: test method SearchForumByForumName");
		List<Forum> list = forumService.searchForumByForumName(forum.getForumName());
		Assert.assertFalse(list.isEmpty());
		list = forumService.searchForumByForumName("ForumWhichNotExist");
		Assert.assertTrue(list.isEmpty());
	}
	
	@Transactional
	@Rollback(true)
	@Test
	public void testGettingListForumWithStatus() {
		logger.info("ForumServiceTest: test method GetListForumWithStatus");
		List<Forum> list = forumService.getListForumWithStatus(forum.getViewStatus());
		Assert.assertFalse(list.isEmpty());
	}
	
	@Transactional
	@Rollback(true)
	@Test
	public void testOnPrivateForum() {
		logger.info("ForumServiceTest: test method isPrivateForum");
		Assert.assertFalse(forumService.isPrivateForum(forum.getIdForum()));
	}
	
}
