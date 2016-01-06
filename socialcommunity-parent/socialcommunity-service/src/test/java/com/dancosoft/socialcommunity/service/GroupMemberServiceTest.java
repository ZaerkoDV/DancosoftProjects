package com.dancosoft.socialcommunity.service;

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
import com.dancosoft.socialcommunity.model.AccountGroup;
import com.dancosoft.socialcommunity.model.GroupMember;
import com.dancosoft.socialcommunity.service.testsupport.TestObjectServiceCreator;
import com.dancosoft.socialcommunity.service.testsupport.TestStarter;


public class GroupMemberServiceTest {//extends TestStarter{

//	private static final Logger logger = LoggerFactory.getLogger(GroupMemberServiceTest.class);
//
//	@Autowired
//	@Qualifier("groupMemberService")
//	private GroupMemberService groupMemberService;
//
//	@Autowired
//	@Qualifier("testObjectServiceCreator")
//	private TestObjectServiceCreator testObjectServiceCreator;
//
//	public void setGroupMemberService(GroupMemberService groupMemberService) {
//		this.groupMemberService = groupMemberService;
//	}
//
//	public void setTestObjectServiceCreator(
//			TestObjectServiceCreator testObjectServiceCreator) {
//		this.testObjectServiceCreator = testObjectServiceCreator;
//	}
//	
//	public AccountGroup accountGroup;
//	public GroupMember groupMember;
//
//	@Before
//	public void initObjectsBeforeTest() {
//		this.groupMember = testObjectServiceCreator.createGroupMemberForTest();
//		this.accountGroup = groupMember.getAccountGroup();
//	}
//	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingListGroupMemberByIdAccountGroup() {
//
//		logger.info("GroupMemberServiceTest: test method GetListGroupMemberByIdAccountGroup");
//		List<GroupMember> list= groupMemberService.getListGroupMemberByIdAccountGroup(accountGroup.getIdAccountGroup());
//		Assert.assertFalse(list.isEmpty());
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingListAccountWithStatusByIdAccountGroup() {
//
//		logger.info("GroupMemberServiceTest: test method GetListAccountWithStatusByIdAccountGroup");
//		Long idAccountGroup=accountGroup.getIdAccountGroup();
//		String status=groupMember.getGroupMemberStatus();
//		List<Account> list= groupMemberService.getListAccountWithStatusByIdAccountGroup(idAccountGroup,status);
//		Assert.assertFalse(list.isEmpty());
//	}
}
