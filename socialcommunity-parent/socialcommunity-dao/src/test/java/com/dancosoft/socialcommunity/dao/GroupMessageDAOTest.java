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
import com.dancosoft.socialcommunity.model.GroupMember;
import com.dancosoft.socialcommunity.model.GroupMessage;

/**
 * @author Zaerko_DV
 *
 */
public class GroupMessageDAOTest extends TestStarter {

	private static final Logger logger = LoggerFactory.getLogger(GroupMessageDAOTest.class);

	@Autowired
	@Qualifier("groupMessageDAO")
	private GroupMessageDAO groupMessageDAO;

	@Autowired
	@Qualifier("testObjectDAOCreator")
	private TestObjectDAOCreator testObjectDAOCreator;

	public void setGroupMessageDAO(GroupMessageDAO groupMessageDAO) {
		this.groupMessageDAO = groupMessageDAO;
	}

	public void setTestObjectDAOCreator(TestObjectDAOCreator testObjectDAOCreator) {
		this.testObjectDAOCreator = testObjectDAOCreator;
	}

	TimeConverter converter = new TimeConverter();

	public AccountGroup accountGroup;
	public GroupMember groupMember;
	public GroupMessage groupMessage;

	@Before
	public void initObjectsBeforeTest() {
		this.groupMessage = testObjectDAOCreator.createGroupMessageForTest();
		this.groupMember = groupMessage.getGroupMember();
		this.accountGroup = groupMember.getAccountGroup();
	}

	@Transactional
	@Rollback(true)
	@Test
	public void testGettingAccountByIdGroupMessage() {

		logger.info("GroupMessageDAOTest: test method GetAccountByIdGroupMessage");
		Assert.assertNotNull(groupMessageDAO
				.getMemberAccountByIdGroupMessage(groupMessage.getIdGroupMessage()));
	}

	@Transactional
	@Rollback(true)
	@Test
	public void testGettingListGroupMessageByIdAccountGroup() {

		logger.info("GroupMessageDAOTest: test method GetListGroupMessageByIdAccountGroup");
		List<GroupMessage> list = groupMessageDAO
				.getListGroupMessageByIdAccountGroup(accountGroup
						.getIdAccountGroup());
		Assert.assertFalse(list.isEmpty());
	}

	@Transactional
	@Rollback(true)
	@Test
	public void testGettingListGroupMessageBeetweenDateByIdAccountGroup() {

		logger.info("GroupMessageDAOTest: test method GetListGroupMessageBeetweenDateByIdAccountGroup");
		LocalDateTime minDateLDT = LocalDateTime.of(2015, 12, 17, 00, 00);
		LocalDateTime maxDateLDT = LocalDateTime.of(2015, 12, 20, 00, 00);
		Date minDateD = converter.convertLocalDateTimeToDate(minDateLDT);
		Date maxDateD = converter.convertLocalDateTimeToDate(maxDateLDT);

		List<GroupMessage> list = groupMessageDAO
				.getListGroupMessageBeetweenDateByIdAccountGroup(
						accountGroup.getIdAccountGroup(), minDateD, maxDateD);
		Assert.assertFalse(list.isEmpty());
	}
	
	@Transactional
	@Rollback(true)
	@Test
	public void testGettingCountGroupMessageByIdAccountGroup() {
		
		logger.info("GroupMessageDAOTest: test method GetCountGroupMessageByIdAccountGroup");
		int actual=groupMessageDAO.getCountGroupMessageByIdAccountGroup(accountGroup.getIdAccountGroup());
		int expected=1;
		Assert.assertEquals(expected, actual);	
	}
}
