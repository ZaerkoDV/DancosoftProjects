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
import com.dancosoft.socialcommunity.model.User;

/**
 * @author Zaerko_DV
 *
 */
public class UserDAOTest {//extends TestStarter {
	
//	private static final Logger logger = LoggerFactory.getLogger(UserDAOTest.class);
//
//	@Autowired
//	@Qualifier("userDAO")
//	private UserDAO userDAO;
//
//	@Autowired
//	@Qualifier("testObjectDAOCreator")								
//	private TestObjectDAOCreator testObjectDAOCreator;
//	
//	public void setUserDAO(UserDAO userDAO) {
//		this.userDAO = userDAO;
//	}
//
//	public void setTestObjectDAOCreator(TestObjectDAOCreator testObjectDAOCreator) {
//		this.testObjectDAOCreator = testObjectDAOCreator;
//	}
//	
//	public User user;
//	public Account account;
//	
//	@Before
//	public void initObjectsBeforeTest(){
//		this.account=testObjectDAOCreator.createAccountForTest();
//		this.user=account.getUser();
//	}
//	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingListAccountByUserId(){
//		
//		List<Account> listAccount =userDAO.getListAccountBuUserId(user.getIdUser());
//		logger.info("UserDAOTest: test method testGettingListAccountByUserId");
//		Assert.assertFalse(listAccount.isEmpty());
//	}
//	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingListUserBySex(){
//		
//		List<User> listUser;
//		logger.info("UserDAOTest: test method testGettingListUserBySex");
//		
//		listUser =userDAO.getListUserBySex("F");
//		Assert.assertFalse(listUser.isEmpty());
//		listUser =userDAO.getListUserBySex("M");
//		Assert.assertTrue(listUser.isEmpty());
//	}
//		
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testSearchUserByFirstLastMiddleName(){
//		
//		List<User> listUser;
//		logger.info("UserDAOTest: test method SearchUserByFirstLastMiddleName");
//		
//		listUser =userDAO.searchUserByFirstLastMiddleName(user.getFirstName(),"", "");
//		Assert.assertFalse(listUser.isEmpty());
//		
//		listUser =userDAO.searchUserByFirstLastMiddleName("",user.getLastName(),"");
//		Assert.assertFalse(listUser.isEmpty());
//		
//		listUser =userDAO.searchUserByFirstLastMiddleName("","",user.getMiddleName());
//		Assert.assertFalse(listUser.isEmpty());
//		
//		listUser =userDAO.searchUserByFirstLastMiddleName("","","");
//		Assert.assertFalse(listUser.isEmpty());
//	}
}
