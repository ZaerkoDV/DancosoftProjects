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
import com.dancosoft.socialcommunity.model.AccountGroup;
import com.dancosoft.socialcommunity.model.GroupEvent;
import com.dancosoft.socialcommunity.model.GroupMember;
/**
 * @author Zaerko_DV
 *
 */
public class GroupEventDAOTest extends TestStarter {

	private static final Logger logger = LoggerFactory.getLogger(GroupEventDAOTest.class);

	@Autowired
	@Qualifier("groupEventDAO")
	private GroupEventDAO groupEventDAO;

	@Autowired
	@Qualifier("testObjectDAOCreator")
	private TestObjectDAOCreator testObjectDAOCreator;

	public void setGroupEventDAO(GroupEventDAO groupEventDAO) {
		this.groupEventDAO = groupEventDAO;
	}

	public void setTestObjectDAOCreator(TestObjectDAOCreator testObjectDAOCreator) {
		this.testObjectDAOCreator = testObjectDAOCreator;
	}

	TimeConverter converter = new TimeConverter();

	public AccountGroup accountGroup;
	public GroupMember groupMember;
	public GroupEvent groupEvent;

	@Before
	public void initObjectsBeforeTest() {
		this.groupEvent = testObjectDAOCreator.createGroupEventForTest();
		this.groupMember = groupEvent.getGroupMember();
		this.accountGroup = groupMember.getAccountGroup();
	}

	
	@Transactional
	@Rollback(true)
	@Test
	public void testGettingAccountByIdGroupEvent() {

		logger.info("GroupEventDAOTest: test method GetAccountByIdGroupEvent");
		Assert.assertNotNull(groupEventDAO.getMemberAccountByIdGroupEvent(groupEvent.getIdGroupEvent()));
	}

	@Transactional
	@Rollback(true)
	@Test
	public void testGettingListGroupEventByIdAccountGroup() {

		logger.info("GroupEventDAOTest: test method GetListGroupEventByIdAccountGroup");
		List<GroupEvent> list = groupEventDAO.getListGroupEventByIdAccountGroup(accountGroup.getIdAccountGroup());
		Assert.assertFalse(list.isEmpty());
	}

	@Transactional
	@Rollback(true)
	@Test
	public void testGettingListGroupEventBeetweenDateByIdAccountGroup() {

		logger.info("GroupEventDAOTest: test method GetListGroupEventBeetweenDateByIdAccountGroup");
		LocalDateTime minDateLDT = LocalDateTime.of(2015, 12, 17, 00, 00);
		LocalDateTime maxDateLDT = LocalDateTime.of(2015, 12, 20, 00, 00);
		Date minDateD = converter.convertLocalDateTimeToDate(minDateLDT);
		Date maxDateD = converter.convertLocalDateTimeToDate(maxDateLDT);

		List<GroupEvent> list = groupEventDAO.getListGroupEventBeetweenDateByIdAccountGroup(
						accountGroup.getIdAccountGroup(), minDateD, maxDateD);
		Assert.assertFalse(list.isEmpty());
	}
	
	@Transactional
	@Rollback(true)
	@Test
	public void testGettingCountGroupEventByIdAccountGroup() {
		
		logger.info("GroupEventDAOTest: test method GetCountGroupEventByIdAccountGroup");
		int actual=groupEventDAO.getCountGroupEventByIdAccountGroup(accountGroup.getIdAccountGroup());
		int expected=1;
		Assert.assertEquals(expected, actual);	
	}	
}
