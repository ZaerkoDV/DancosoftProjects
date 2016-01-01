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
import com.dancosoft.socialcommunity.model.Forum;

/**
 * @author Zaerko_DV
 *
 */
public class ForumDAOTest extends TestStarter {

	private static final Logger logger = LoggerFactory.getLogger(ForumDAOTest.class);

	@Autowired
	@Qualifier("forumDAO")
	private ForumDAO forumDAO;

	@Autowired
	@Qualifier("testObjectDAOCreator")
	private TestObjectDAOCreator testObjectDAOCreator;

	public void setForumDAO(ForumDAO forumDAO) {
		this.forumDAO = forumDAO;
	}

	public void setTestObjectDAOCreator(TestObjectDAOCreator testObjectDAOCreator) {
		this.testObjectDAOCreator = testObjectDAOCreator;
	}

	TimeConverter converter = new TimeConverter();
	public Forum forum;

	@Before
	public void initObjectsBeforeTest() {
		this.forum = testObjectDAOCreator.createForumForTest();
	}

	@Transactional
	@Rollback(true)
	@Test
	public void testGettingListForumCreatedBetweenDateByIdForum() {

		logger.info("ForumDAOTest: test method GetListForumCreatedBetweenDateByIdForum");

		LocalDateTime minDateLDT = LocalDateTime.of(2015, 12, 17, 00, 00);
		LocalDateTime maxDateLDT = LocalDateTime.of(2015, 12, 20, 00, 00);
		Date minDateD = converter.convertLocalDateTimeToDate(minDateLDT);
		Date maxDateD = converter.convertLocalDateTimeToDate(maxDateLDT);

		List<Forum> list = forumDAO.getListForumCreatedBetweenDateByIdForum(minDateD, maxDateD);
		Assert.assertFalse(list.isEmpty());
	}

	@Transactional
	@Rollback(true)
	@Test
	public void testGettingCountForum() {

		logger.info("ForumDAOTest: test method GetCountForum");
		int actual=forumDAO.getCountForum();
		int expected=1;
		Assert.assertEquals(expected, actual);	
	}

	@Transactional
	@Rollback(true)
	@Test
	public void testOnSearchForumByForumName() {

		logger.info("ForumDAOTest: test method SearchForumByForumName");
		
		List<Forum> list = forumDAO.searchForumByForumName(forum.getForumName());
		Assert.assertFalse(list.isEmpty());
		list = forumDAO.searchForumByForumName("ForumWhichNotExist");
		Assert.assertTrue(list.isEmpty());
	}
	
	@Transactional
	@Rollback(true)
	@Test
	public void testGettingListForumWithStatus() {
		
		logger.info("ForumDAOTest: test method GetListForumWithStatus");
		List<Forum> list = forumDAO.getListForumWithStatus(forum.getViewStatus());
		Assert.assertFalse(list.isEmpty());
	}
	
	@Transactional
	@Rollback(true)
	@Test
	public void testOnPrivateForum() {
		
		logger.info("ForumDAOTest: test method isPrivateForum");
		Assert.assertFalse(forumDAO.isPrivateForum(forum.getIdForum()));
	}
}
