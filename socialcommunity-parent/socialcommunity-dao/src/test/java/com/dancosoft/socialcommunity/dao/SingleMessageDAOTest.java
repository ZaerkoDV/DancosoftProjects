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

/**
 * @author Zaerko_DV
 *
 */
public class SingleMessageDAOTest extends TestStarter {

	private static final Logger logger = LoggerFactory.getLogger(SingleMessageDAOTest.class);

	@Autowired
	@Qualifier("singleMessageDAO")
	private SingleMessageDAO singleMessageDAO;

	@Autowired
	@Qualifier("testObjectDAOCreator")
	private TestObjectDAOCreator testObjectDAOCreator;

	public void setSingleMessageDAO(SingleMessageDAO singleMessageDAO) {
		this.singleMessageDAO = singleMessageDAO;
	}

	public void setTestObjectDAOCreator(TestObjectDAOCreator testObjectDAOCreator) {
		this.testObjectDAOCreator = testObjectDAOCreator;
	}

	TimeConverter converter = new TimeConverter();

	public SingleMessage singleMessage;
	public Account account;

	@Before
	public void initObjectsBeforeTest() {
		this.singleMessage = testObjectDAOCreator.createSingleMessageForTest();
		this.account = singleMessage.getAccount();
	}

	@Transactional
	@Rollback(true)
	@Test
	public void testGettingListSingleMessageBeetweenDateByIdAccount() {

		logger.info("SingleMessageDAOTest: test method GetListSingleMessageBeetweenDateByIdAccounte");
		LocalDateTime minDateLDT = LocalDateTime.of(2015, 12, 17, 00, 00);
		LocalDateTime maxDateLDT = LocalDateTime.of(2015, 12, 20, 00, 00);
		Date minDateD = converter.convertLocalDateTimeToDate(minDateLDT);
		Date maxDateD = converter.convertLocalDateTimeToDate(maxDateLDT);

		List<SingleMessage> list = singleMessageDAO
				.getListSingleMessageBeetweenDateByIdAccount(
						account.getIdAccount(), minDateD, maxDateD);
		Assert.assertFalse(list.isEmpty());
	}

	@Transactional
	@Rollback(true)
	@Test
	public void testGettingListInterlocutorAccountByIdAccount() {

		logger.info("SingleMessageDAOTest: test method GetListInterlocutorAccountByIdAccount");
		List<Account> list = singleMessageDAO
				.getListInterlocutorAccountByIdAccount(account.getIdAccount());
		Assert.assertFalse(list.isEmpty());
	}

	@Transactional
	@Rollback(true)
	@Test
	public void testGettingListIntrlocutorSingleMessageBeetweenDateByIdAccount() {

		logger.info("SingleMessageDAOTest: test method GetListIntrlocutorSingleMessageBeetweenDateByIdAccount");
		LocalDateTime minDateLDT = LocalDateTime.of(2015, 12, 17, 00, 00);
		LocalDateTime maxDateLDT = LocalDateTime.of(2015, 12, 20, 00, 00);
		Date minDateD = converter.convertLocalDateTimeToDate(minDateLDT);
		Date maxDateD = converter.convertLocalDateTimeToDate(maxDateLDT);

		List<SingleMessage> list = singleMessageDAO
				.getListIntrlocutorSingleMessageBeetweenDateByIdAccount(account
						.getIdAccount(), singleMessage.getInterlocutorAccount()
						.getIdAccount(), minDateD, maxDateD);
		Assert.assertFalse(list.isEmpty());
	}
}
