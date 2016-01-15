/**
 * 
 */
package com.dancosoft.socialcommunity.dao;

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

import com.dancosoft.socialcommunity.dao.testsupport.TestObjectDAOCreator;
import com.dancosoft.socialcommunity.dao.testsupport.TestStarter;
import com.dancosoft.socialcommunity.model.Account;
import com.dancosoft.socialcommunity.model.AccountGroup;
import com.dancosoft.socialcommunity.model.GroupMember;

/**
 * @author Zaerko_DV
 *
 */
public class GroupMemberDAOTest {//extends TestStarter {

//	private static final Logger logger = LoggerFactory.getLogger(GroupMemberDAOTest.class);
//
//	@Autowired
//	@Qualifier("groupMemberDAO")
//	private GroupMemberDAO groupMemberDAO;
//
//	@Autowired
//	@Qualifier("testObjectDAOCreator")
//	private TestObjectDAOCreator testObjectDAOCreator;
//
//	public void setGroupMemberDAO(GroupMemberDAO groupMemberDAO) {
//		this.groupMemberDAO = groupMemberDAO;
//	}
//
//	public void setTestObjectDAOCreator(TestObjectDAOCreator testObjectDAOCreator) {
//		this.testObjectDAOCreator = testObjectDAOCreator;
//	}
//
//	public AccountGroup accountGroup;
//	public GroupMember groupMember;
//
//	@Before
//	public void initObjectsBeforeTest() {
//		this.groupMember = testObjectDAOCreator.createGroupMemberForTest();
//		this.accountGroup = groupMember.getAccountGroup();
//	}
//	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingListGroupMemberByIdAccountGroup() {
//
//		logger.info("GroupMemberDAOTest: test method GetListGroupMemberByIdAccountGroup");
//		List<GroupMember> list= groupMemberDAO.getListGroupMemberByIdAccountGroup(accountGroup.getIdAccountGroup());
//		Assert.assertFalse(list.isEmpty());
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingListAccountWithStatusByIdAccountGroup() {
//
//		logger.info("GroupMemberDAOTest: test method GetListAccountWithStatusByIdAccountGroup");
//		Long idAccountGroup=accountGroup.getIdAccountGroup();
//		String status=groupMember.getGroupMemberStatus();
//		List<Account> list= groupMemberDAO.getListAccountWithStatusByIdAccountGroup(idAccountGroup,status);
//		Assert.assertFalse(list.isEmpty());
//	}
}
