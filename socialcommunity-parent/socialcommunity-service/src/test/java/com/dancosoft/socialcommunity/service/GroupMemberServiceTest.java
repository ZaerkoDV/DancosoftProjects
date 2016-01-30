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
import com.dancosoft.socialcommunity.model.User;
import com.dancosoft.socialcommunity.service.testsupport.TestStarter;


public class GroupMemberServiceTest {//extends TestStarter{

//	private static final Logger logger = LoggerFactory.getLogger(GroupMemberServiceTest.class);
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
//	public AccountGroup accountGroup;
//	public GroupMember groupMember;
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
//	@Before
//	public void initObjectsBeforeTest() {
//		this.groupMember = createGroupMemberForTest();
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
