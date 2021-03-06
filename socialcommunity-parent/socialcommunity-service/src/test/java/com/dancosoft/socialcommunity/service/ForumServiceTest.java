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
import com.dancosoft.socialcommunity.model.Forum;
import com.dancosoft.socialcommunity.service.testsupport.TestStarter;

/**
 * @author Zaerko_DV
 *
 */
public class ForumServiceTest {//extends TestStarter{

//	private static final Logger logger = LoggerFactory.getLogger(ForumServiceTest.class);
//	
//	public TimeConverter converter=new TimeConverter();
//
//	@Autowired
//	@Qualifier(value="forumService")
//	private ForumService forumService;
//	
//	public void setForumService(ForumService forumService) {
//		this.forumService = forumService;
//	}
//	
//	public Forum forum;
//	
//	public Forum createForumForTest() {
//		Forum testForum = new Forum();
//		testForum.setForumName("TestForum");
//		testForum.setViewStatus("public");
//		testForum.setDateCreateForum(converter
//				.convertLocalDateTimeToDate(LocalDateTime.of(2015, 12, 17,00, 00)));
//		forumService.saveForum(testForum);
//
//		return testForum;
//	}
//	
//	@Before
//	public void initObjectsBeforeTest() {
//		this.forum = createForumForTest();
//	}
//	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingListForumCreatedBetweenDateByIdForum() {
//
//		logger.info("ForumServiceTest: test method GetListForumCreatedBetweenDateByIdForum");
//		Date minDate = converter.convertLocalDateTimeToDate(LocalDateTime.of(2015, 12, 17, 00, 00));
//		Date maxDate = converter.convertLocalDateTimeToDate(LocalDateTime.of(2015, 12, 20, 00, 00));
//
//		List<Forum> list = forumService.getListForumCreatedBetweenDateByIdForum(minDate, maxDate);
//		Assert.assertFalse(list.isEmpty());
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingCountForum() {
//
//		logger.info("ForumServiceTest: test method GetCountForum");
//		int actual=forumService.getCountForum();
//		//int expected=1;
//		//Assert.assertEquals(expected, actual);	
//		Assert.assertTrue(actual>0);
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testOnSearchForumByForumName() {
//
//		logger.info("ForumServiceTest: test method SearchForumByForumName");
//		List<Forum> list = forumService.searchForumByForumName(forum.getForumName());
//		Assert.assertFalse(list.isEmpty());
//		list = forumService.searchForumByForumName("ForumWhichNotExist");
//		Assert.assertTrue(list.isEmpty());
//	}
//	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingListForumWithStatus() {
//		logger.info("ForumServiceTest: test method GetListForumWithStatus");
//		List<Forum> list = forumService.getListForumWithStatus(forum.getViewStatus());
//		Assert.assertFalse(list.isEmpty());
//	}
//	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testOnPrivateForum() {
//		logger.info("ForumServiceTest: test method isPrivateForum");
//		Assert.assertFalse(forumService.isPrivateForum(forum.getIdForum()));
//	}
}
