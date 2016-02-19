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
import com.dancosoft.socialcommunity.model.Account;
import com.dancosoft.socialcommunity.model.AccountGroup;
import com.dancosoft.socialcommunity.model.EventPattern;
import com.dancosoft.socialcommunity.model.GroupEvent;
import com.dancosoft.socialcommunity.model.GroupMember;
import com.dancosoft.socialcommunity.model.User;
import com.dancosoft.socialcommunity.service.testsupport.TestStarter;

/**
 * @author Zaerko_DV
 *
 */
public class GroupEventServiceTest {//extends TestStarter {

//	private static final Logger logger = LoggerFactory.getLogger(GroupEventServiceTest.class);
//	
//	public TimeConverter converter=new TimeConverter();
//
//	@Autowired
//	@Qualifier(value="userService")
//	private UserService userService;
//
//	public void setUserService(UserService userService) {
//		this.userService = userService;
//	}
//
//	@Autowired
//	@Qualifier(value="accountService")
//	private AccountService accountService; 
//
//	public void setAccountService(AccountService accountService) {
//		this.accountService = accountService;
//	}
//	
//	@Autowired
//	@Qualifier(value="accountGroupService")
//	private AccountGroupService accountGroupService;
//
//	public void setAccountGroup(AccountGroup accountGroup) {
//		this.accountGroup = accountGroup;
//	}
//
//	@Autowired
//	@Qualifier("groupMemberService")
//	private GroupMemberService groupMemberService;
//
//	public void setGroupMemberService(GroupMemberService groupMemberService) {
//		this.groupMemberService = groupMemberService;
//	}
//	
//	@Autowired
//	@Qualifier(value="eventPatternService")
//	private EventPatternService eventPatternService;
//
//	public void setEventPatternService(EventPatternService eventPatternService) {
//		this.eventPatternService = eventPatternService;
//	}
//
//	@Autowired
//	@Qualifier("groupEventService")
//	private GroupEventService groupEventService;
//
//	public void setGroupEventService(GroupEventService groupEventService) {
//		this.groupEventService = groupEventService;
//	}
//
//	public AccountGroup accountGroup;
//	public GroupMember groupMember;
//	public GroupEvent groupEvent;
//
//	public User createUserForTest() {
//		User testUser = new User();
//		testUser.setFirstName("testFirstName");
//		testUser.setLastName("testLastName");
//		testUser.setMiddleName("testMiddleName");
//		testUser.setSex("F");
//		userService.saveUser(testUser);
//		
//		return testUser;
//	}
//
//	public Account createAccountForTest() {
//		User testUser = createUserForTest();
//		Account testAccount = new Account();
//		testAccount.setAccountName("TestAccount");
//		testAccount.setAccountBlockStatus("unblock");
//		testAccount.setUser(testUser);
//		accountService.saveAccount(testAccount);
//
//		return testAccount;
//	}
//
//	public AccountGroup createAccountGroupForTest() {
//		Account testAccount = createAccountForTest();
//		AccountGroup testAccountGroup = new AccountGroup();
//		testAccountGroup.setGroupName("TestAccountGroup");
//		testAccountGroup.setViewStatus("private");
//		testAccountGroup.setAccountGroupBlockStatus("unblock");
//		testAccountGroup.setAccount(testAccount);
//		accountGroupService.saveAccountGroup(testAccountGroup);
//
//		return testAccountGroup;
//	}
//	
//	public GroupMember createGroupMemberForTest() {
//
//		AccountGroup testAccountGroup = createAccountGroupForTest();
//		GroupMember testGroupMember = new GroupMember();
//		testGroupMember.setMemberAccount(testAccountGroup.getAccount());
//		testGroupMember.setGroupMemberStatus("friend");
//		testGroupMember.setAccountGroup(testAccountGroup);
//		groupMemberService.saveGroupMember(testGroupMember);
//
//		return testGroupMember;
//	}
//	
//	public EventPattern createEventPatternForTest() {
//		EventPattern testEventPattern = new EventPattern();
//		testEventPattern.setEventPattern("TestEventPattern");
//		eventPatternService.saveEventPattern(testEventPattern);
//
//		return testEventPattern;
//	}
//	
//	public GroupEvent createGroupEventForTest() {
//
//		GroupMember testGroupMember = createGroupMemberForTest();
//		EventPattern testEventPattern = createEventPatternForTest();
//		GroupEvent testGroupEvent = new GroupEvent();
//		testGroupEvent.setEventPattern(testEventPattern);
//		testGroupEvent.setDateCreateGroupEvent(converter
//				.convertLocalDateTimeToDate(LocalDateTime.of(2015, 12, 17,00, 00)));
//		testGroupEvent.setGroupMember(testGroupMember);
//		groupEventService.saveGroupEvent(testGroupEvent);
//
//		return testGroupEvent;
//	}
//
//	@Before
//	public void initObjectsBeforeTest() {
//		this.groupEvent = createGroupEventForTest();
//		this.groupMember = groupEvent.getGroupMember();
//		this.accountGroup = groupMember.getAccountGroup();
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingAccountByIdGroupEvent() {
//		logger.info("GroupEventServiceTest: test method GetAccountByIdGroupEvent");
//		Assert.assertNotNull(groupEventService.getMemberAccountByIdGroupEvent(groupEvent.getIdGroupEvent()));
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingListGroupEventByIdAccountGroup() {
//		logger.info("GroupEventServiceTest: test method GetListGroupEventByIdAccountGroup");
//		List<GroupEvent> list = groupEventService.getListGroupEventByIdAccountGroup(accountGroup.getIdAccountGroup());
//		Assert.assertFalse(list.isEmpty());
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingListGroupEventBeetweenDateByIdAccountGroup() {
//
//		logger.info("GroupEventServiceTest: test method GetListGroupEventBeetweenDateByIdAccountGroup");
//		Date minDate = converter.convertLocalDateTimeToDate(LocalDateTime.of(2015, 12, 17, 00, 00));
//		Date maxDate = converter.convertLocalDateTimeToDate(LocalDateTime.of(2015, 12, 20, 00, 00));
//		
//		List<GroupEvent> list = groupEventService.getListGroupEventBeetweenDateByIdAccountGroup(
//						accountGroup.getIdAccountGroup(), minDate, maxDate);
//		Assert.assertFalse(list.isEmpty());
//	}
//	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingCountGroupEventByIdAccountGroup() {
//		
//		logger.info("GroupEventServiceTest: test method GetCountGroupEventByIdAccountGroup");
//		int actual=groupEventService.getCountGroupEventByIdAccountGroup(accountGroup.getIdAccountGroup());
//		int expected=1;
//		Assert.assertEquals(expected, actual);	
//	}	
}