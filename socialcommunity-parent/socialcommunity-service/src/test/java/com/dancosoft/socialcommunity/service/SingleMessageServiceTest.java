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
import com.dancosoft.socialcommunity.model.SingleMessage;
import com.dancosoft.socialcommunity.service.testsupport.TestObjectServiceCreator;
import com.dancosoft.socialcommunity.service.testsupport.TestStarter;

/**
 * @author Zaerko_DV
 *
 */
public class SingleMessageServiceTest {//extends TestStarter {

//	private static final Logger logger = LoggerFactory.getLogger(SingleMessageServiceTest.class);
//
//	@Autowired
//	@Qualifier("singleMessageService")
//	private SingleMessageService singleMessageService;
//
//	@Autowired
//	@Qualifier("testObjectServiceCreator")
//	private TestObjectServiceCreator testObjectServiceCreator;
//
//	public void setSingleMessageService(SingleMessageService singleMessageService) {
//		this.singleMessageService = singleMessageService;
//	}
//
//	public void setTestObjectServiceCreator(TestObjectServiceCreator testObjectServiceCreator) {
//		this.testObjectServiceCreator = testObjectServiceCreator;
//	}
//	
//	public SingleMessage singleMessage;
//	public Account account;
//
//	@Before
//	public void initObjectsBeforeTest() {
//		this.singleMessage = testObjectServiceCreator.createSingleMessageForTest();
//		this.account = singleMessage.getAccount();
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingListSingleMessageBeetweenDateByIdAccount() {
//
//		logger.info("SingleMessageServiceTest: test method GetListSingleMessageBeetweenDateByIdAccounte");
//		LocalDateTime minDateLDT = LocalDateTime.of(2015, 12, 17, 00, 00);
//		LocalDateTime maxDateLDT = LocalDateTime.of(2015, 12, 20, 00, 00);
//
//		List<SingleMessage> list = singleMessageService.getListSingleMessageBeetweenDateByIdAccount(
//						account.getIdAccount(), minDateLDT, maxDateLDT);
//		Assert.assertFalse(list.isEmpty());
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingListInterlocutorAccountByIdAccount() {
//
//		logger.info("SingleMessageServiceTest: test method GetListInterlocutorAccountByIdAccount");
//		List<Account> list = singleMessageService
//				.getListInterlocutorAccountByIdAccount(account.getIdAccount());
//		Assert.assertFalse(list.isEmpty());
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingListIntrlocutorSingleMessageBeetweenDateByIdAccount() {
//
//		logger.info("SingleMessageServiceTest: test method GetListIntrlocutorSingleMessageBeetweenDateByIdAccount");
//		LocalDateTime minDateLDT = LocalDateTime.of(2015, 12, 17, 00, 00);
//		LocalDateTime maxDateLDT = LocalDateTime.of(2015, 12, 20, 00, 00);
//
//		List<SingleMessage> list = singleMessageService.getListIntrlocutorSingleMessageBeetweenDateByIdAccount(account
//						.getIdAccount(), singleMessage.getInterlocutorAccount().getIdAccount(), minDateLDT, maxDateLDT);
//		Assert.assertFalse(list.isEmpty());
//	}
}
