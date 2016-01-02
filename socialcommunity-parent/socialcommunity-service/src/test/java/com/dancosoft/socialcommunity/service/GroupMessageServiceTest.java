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

import com.dancosoft.socialcommunity.model.AccountGroup;
import com.dancosoft.socialcommunity.model.GroupMember;
import com.dancosoft.socialcommunity.model.GroupMessage;
import com.dancosoft.socialcommunity.service.testsupport.TestObjectServiceCreator;
import com.dancosoft.socialcommunity.service.testsupport.TestStarter;

/**
 * @author Zaerko_DV
 *
 */
public class GroupMessageServiceTest extends TestStarter{

	private static final Logger logger = LoggerFactory.getLogger(GroupMessageServiceTest.class);

	@Autowired
	@Qualifier("groupMessageService")
	private GroupMessageService groupMessageService;

	@Autowired
	@Qualifier("testObjectServiceCreator")
	private TestObjectServiceCreator testObjectServiceCreator;

	public void setGroupMessageService(GroupMessageService groupMessageService) {
		this.groupMessageService = groupMessageService;
	}

	public void setTestObjectServiceCreator(TestObjectServiceCreator testObjectServiceCreator) {
		this.testObjectServiceCreator = testObjectServiceCreator;
	}
	
	public AccountGroup accountGroup;
	public GroupMember groupMember;
	public GroupMessage groupMessage;

	@Before
	public void initObjectsBeforeTest() {
		this.groupMessage = testObjectServiceCreator.createGroupMessageForTest();
		this.groupMember = groupMessage.getGroupMember();
		this.accountGroup = groupMember.getAccountGroup();
	}

	@Transactional
	@Rollback(true)
	@Test
	public void testGettingAccountByIdGroupMessage() {
		logger.info("GroupMessageServiceTest: test method GetAccountByIdGroupMessage");
		Assert.assertNotNull(groupMessageService.getMemberAccountByIdGroupMessage(groupMessage.getIdGroupMessage()));
	}

	@Transactional
	@Rollback(true)
	@Test
	public void testGettingListGroupMessageByIdAccountGroup() {

		logger.info("GroupMessageServiceTest: test method GetListGroupMessageByIdAccountGroup");
		List<GroupMessage> list = groupMessageService
				.getListGroupMessageByIdAccountGroup(accountGroup.getIdAccountGroup());
		Assert.assertFalse(list.isEmpty());
	}

	@Transactional
	@Rollback(true)
	@Test
	public void testGettingListGroupMessageBeetweenDateByIdAccountGroup() {

		logger.info("GroupMessageServiceTest: test method GetListGroupMessageBeetweenDateByIdAccountGroup");
		LocalDateTime minDateLDT = LocalDateTime.of(2015, 12, 17, 00, 00);
		LocalDateTime maxDateLDT = LocalDateTime.of(2015, 12, 20, 00, 00);

		List<GroupMessage> list = groupMessageService
				.getListGroupMessageBeetweenDateByIdAccountGroup(accountGroup.getIdAccountGroup(),minDateLDT, maxDateLDT);
		Assert.assertFalse(list.isEmpty());
	}
	
	@Transactional
	@Rollback(true)
	@Test
	public void testGettingCountGroupMessageByIdAccountGroup() {
		logger.info("GroupMessageServiceTest: test method GetCountGroupMessageByIdAccountGroup");
		int actual=groupMessageService.getCountGroupMessageByIdAccountGroup(accountGroup.getIdAccountGroup());
		int expected=1;
		Assert.assertEquals(expected, actual);	
	}
}
