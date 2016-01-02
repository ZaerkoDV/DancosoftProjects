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

import com.dancosoft.socialcommunity.dao.GroupEventDAOTest;
import com.dancosoft.socialcommunity.model.AccountGroup;
import com.dancosoft.socialcommunity.model.GroupEvent;
import com.dancosoft.socialcommunity.model.GroupMember;
import com.dancosoft.socialcommunity.service.testsupport.TestObjectServiceCreator;
import com.dancosoft.socialcommunity.service.testsupport.TestStarter;

/**
 * @author Zaerko_DV
 *
 */
public class GroupEventServiceTest extends TestStarter {

	private static final Logger logger = LoggerFactory.getLogger(GroupEventDAOTest.class);

	@Autowired
	@Qualifier("groupEventService")
	private GroupEventService groupEventService;

	@Autowired
	@Qualifier("testObjectServiceCreator")
	private TestObjectServiceCreator testObjectServiceCreator;

	public void setGroupEventService(GroupEventService groupEventService) {
		this.groupEventService = groupEventService;
	}

	public void setTestObjectServiceCreator(TestObjectServiceCreator testObjectServiceCreator) {
		this.testObjectServiceCreator = testObjectServiceCreator;
	}

	public AccountGroup accountGroup;
	public GroupMember groupMember;
	public GroupEvent groupEvent;

	@Before
	public void initObjectsBeforeTest() {
		this.groupEvent = testObjectServiceCreator.createGroupEventForTest();
		this.groupMember = groupEvent.getGroupMember();
		this.accountGroup = groupMember.getAccountGroup();
	}

	@Transactional
	@Rollback(true)
	@Test
	public void testGettingAccountByIdGroupEvent() {
		logger.info("GroupEventServiceTest: test method GetAccountByIdGroupEvent");
		Assert.assertNotNull(groupEventService.getMemberAccountByIdGroupEvent(groupEvent.getIdGroupEvent()));
	}

	@Transactional
	@Rollback(true)
	@Test
	public void testGettingListGroupEventByIdAccountGroup() {
		logger.info("GroupEventServiceTest: test method GetListGroupEventByIdAccountGroup");
		List<GroupEvent> list = groupEventService.getListGroupEventByIdAccountGroup(accountGroup.getIdAccountGroup());
		Assert.assertFalse(list.isEmpty());
	}

	@Transactional
	@Rollback(true)
	@Test
	public void testGettingListGroupEventBeetweenDateByIdAccountGroup() {

		logger.info("GroupEventServiceTest: test method GetListGroupEventBeetweenDateByIdAccountGroup");
		LocalDateTime minDateLDT = LocalDateTime.of(2015, 12, 17, 00, 00);
		LocalDateTime maxDateLDT = LocalDateTime.of(2015, 12, 20, 00, 00);
		
		List<GroupEvent> list = groupEventService.getListGroupEventBeetweenDateByIdAccountGroup(
						accountGroup.getIdAccountGroup(), minDateLDT, maxDateLDT);
		Assert.assertFalse(list.isEmpty());
	}
	
	@Transactional
	@Rollback(true)
	@Test
	public void testGettingCountGroupEventByIdAccountGroup() {
		
		logger.info("GroupEventServiceTest: test method GetCountGroupEventByIdAccountGroup");
		int actual=groupEventService.getCountGroupEventByIdAccountGroup(accountGroup.getIdAccountGroup());
		int expected=1;
		Assert.assertEquals(expected, actual);	
	}	
}