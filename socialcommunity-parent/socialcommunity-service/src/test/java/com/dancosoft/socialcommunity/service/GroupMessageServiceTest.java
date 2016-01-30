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
import com.dancosoft.socialcommunity.model.AccountGroup;
import com.dancosoft.socialcommunity.model.GroupMember;
import com.dancosoft.socialcommunity.model.GroupMessage;
import com.dancosoft.socialcommunity.model.User;
import com.dancosoft.socialcommunity.service.testsupport.TestStarter;

/**
 * @author Zaerko_DV
 *
 */
public class GroupMessageServiceTest {//extends TestStarter{

//	private static final Logger logger = LoggerFactory.getLogger(GroupMessageServiceTest.class);
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
//	@Qualifier("groupMessageService")
//	private GroupMessageService groupMessageService;
//
//	public void setGroupMessageService(GroupMessageService groupMessageService) {
//		this.groupMessageService = groupMessageService;
//	}
//
//	public AccountGroup accountGroup;
//	public GroupMember groupMember;
//	public GroupMessage groupMessage;
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
//	public GroupMessage createGroupMessageForTest() {
//
//		GroupMember testGroupMember = createGroupMemberForTest();
//		GroupMessage testGroupMessage = new GroupMessage();
//		testGroupMessage.setGroupMessage("Test Group Message");
//		testGroupMessage.setDateCreateGroupMessage(LocalDateTime.of(2015, 12, 17,00, 00));
//		testGroupMessage.setGroupMember(testGroupMember);
//		groupMessageService.saveGroupMessage(testGroupMessage);
//
//		return testGroupMessage;
//	}
//
//	@Before
//	public void initObjectsBeforeTest() {
//		this.groupMessage = createGroupMessageForTest();
//		this.groupMember = groupMessage.getGroupMember();
//		this.accountGroup = groupMember.getAccountGroup();
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingAccountByIdGroupMessage() {
//		logger.info("GroupMessageServiceTest: test method GetAccountByIdGroupMessage");
//		Assert.assertNotNull(groupMessageService.getMemberAccountByIdGroupMessage(groupMessage.getIdGroupMessage()));
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingListGroupMessageByIdAccountGroup() {
//
//		logger.info("GroupMessageServiceTest: test method GetListGroupMessageByIdAccountGroup");
//		List<GroupMessage> list = groupMessageService
//				.getListGroupMessageByIdAccountGroup(accountGroup.getIdAccountGroup());
//		Assert.assertFalse(list.isEmpty());
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingListGroupMessageBeetweenDateByIdAccountGroup() {
//
//		logger.info("GroupMessageServiceTest: test method GetListGroupMessageBeetweenDateByIdAccountGroup");
//		LocalDateTime minDateLDT = LocalDateTime.of(2015, 12, 17, 00, 00);
//		LocalDateTime maxDateLDT = LocalDateTime.of(2015, 12, 20, 00, 00);
//
//		List<GroupMessage> list = groupMessageService
//				.getListGroupMessageBeetweenDateByIdAccountGroup(accountGroup.getIdAccountGroup(),minDateLDT, maxDateLDT);
//		Assert.assertFalse(list.isEmpty());
//	}
//	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingCountGroupMessageByIdAccountGroup() {
//		logger.info("GroupMessageServiceTest: test method GetCountGroupMessageByIdAccountGroup");
//		int actual=groupMessageService.getCountGroupMessageByIdAccountGroup(accountGroup.getIdAccountGroup());
//		int expected=1;
//		Assert.assertEquals(expected, actual);	
//	}
}
