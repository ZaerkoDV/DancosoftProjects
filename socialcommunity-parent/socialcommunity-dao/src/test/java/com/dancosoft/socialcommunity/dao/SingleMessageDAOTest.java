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
import com.dancosoft.socialcommunity.model.Account;
import com.dancosoft.socialcommunity.model.SingleMessage;
import com.dancosoft.socialcommunity.model.User;

/**
 * @author Zaerko_DV
 *
 */
public class SingleMessageDAOTest {//extends TestStarter {

//	private static final Logger logger = LoggerFactory.getLogger(SingleMessageDAOTest.class);
//
//	@Autowired
//	@Qualifier("singleMessageDAO")
//	private SingleMessageDAO singleMessageDAO;
//
//	public void setSingleMessageDAO(SingleMessageDAO singleMessageDAO) {
//		this.singleMessageDAO = singleMessageDAO;
//	}
//	
//	@Autowired
//	@Qualifier("accountDAO")
//	private AccountDAO accountDAO; 
//
//	public void setAccountDAO(AccountDAO accountDAO) {
//		this.accountDAO = accountDAO;
//	}
//
//	@Autowired
//	@Qualifier("userDAO")
//	private UserDAO userDAO;
//	
//	public void setUserDAO(UserDAO userDAO) {
//		this.userDAO = userDAO;
//	}
//
//	public SingleMessage singleMessage;
//	public Account account;
//	public User user;
//
//	TimeConverter converter = new TimeConverter();
//
//	public User createUserForTest() {
//
//		User testUser = new User();
//		testUser.setFirstName("testFirstName");
//		testUser.setLastName("testLastName");
//		testUser.setMiddleName("testMiddleName");
//		testUser.setSex("F");
//		userDAO.saveEntity(testUser);
//
//		return testUser;
//	}
//	
//	public Account createAccountForTest() {
//
//		User testUser = createUserForTest();
//		Account testAccount = new Account();
//
//		testAccount.setAccountName("TestAccount");
//		testAccount.setAccountBlockStatus("unblock");
//		testAccount.setUser(testUser);
//		accountDAO.saveEntity(testAccount);
//
//		return testAccount;
//	}
//	
//	public SingleMessage createSingleMessageForTest() {
//
//		Account testAccount = createAccountForTest();
//		SingleMessage testSingleMessage = new SingleMessage();
//		testSingleMessage.setSingleMessage("Same test message");
//		testSingleMessage.setDateCreateSingleMessage(LocalDateTime.of(2015, 12,	17, 00, 00));
//		testSingleMessage.setAccount(testAccount);
//		testSingleMessage.setInterlocutorAccount(testAccount);
//		singleMessageDAO.saveEntity(testSingleMessage);
//
//		return testSingleMessage;
//	}
//	
//	@Before
//	public void initObjectsBeforeTest() {
//	
//		this.singleMessage = createSingleMessageForTest();
//		this.account = singleMessage.getAccount();
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingListSingleMessageBeetweenDateByIdAccount() {
//
//		logger.info("SingleMessageDAOTest: test method GetListSingleMessageBeetweenDateByIdAccounte");
//		LocalDateTime minDateLDT = LocalDateTime.of(2015, 12, 17, 00, 00);
//		LocalDateTime maxDateLDT = LocalDateTime.of(2015, 12, 20, 00, 00);
//		Date minDateD = converter.convertLocalDateTimeToDate(minDateLDT);
//		Date maxDateD = converter.convertLocalDateTimeToDate(maxDateLDT);
//
//		List<SingleMessage> list = singleMessageDAO.getListSingleMessageBeetweenDateByIdAccount(
//						account.getIdAccount(), minDateD, maxDateD);
//		Assert.assertFalse(list.isEmpty());
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingListInterlocutorAccountByIdAccount() {
//
//		logger.info("SingleMessageDAOTest: test method GetListInterlocutorAccountByIdAccount");
//		List<Account> list = singleMessageDAO
//				.getListInterlocutorAccountByIdAccount(account.getIdAccount());
//		Assert.assertFalse(list.isEmpty());
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingListIntrlocutorSingleMessageBeetweenDateByIdAccount() {
//
//		logger.info("SingleMessageDAOTest: test method GetListIntrlocutorSingleMessageBeetweenDateByIdAccount");
//		LocalDateTime minDateLDT = LocalDateTime.of(2015, 12, 17, 00, 00);
//		LocalDateTime maxDateLDT = LocalDateTime.of(2015, 12, 20, 00, 00);
//		Date minDateD = converter.convertLocalDateTimeToDate(minDateLDT);
//		Date maxDateD = converter.convertLocalDateTimeToDate(maxDateLDT);
//
//		List<SingleMessage> list = singleMessageDAO
//				.getListIntrlocutorSingleMessageBeetweenDateByIdAccount(account
//						.getIdAccount(), singleMessage.getInterlocutorAccount()
//						.getIdAccount(), minDateD, maxDateD);
//		Assert.assertFalse(list.isEmpty());
//	}
}
