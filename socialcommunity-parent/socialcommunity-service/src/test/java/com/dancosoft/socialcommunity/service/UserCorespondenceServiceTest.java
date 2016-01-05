/**
 * 
 */
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

import com.dancosoft.socialcommunity.model.User;
import com.dancosoft.socialcommunity.model.UserCorespondence;
import com.dancosoft.socialcommunity.service.testsupport.TestObjectServiceCreator;
import com.dancosoft.socialcommunity.service.testsupport.TestStarter;

/**
 * @author Zaerko_DV
 *
 */
public class UserCorespondenceServiceTest {//extends TestStarter{

//	private static final Logger logger = LoggerFactory.getLogger(UserCorespondenceServiceTest.class);
//
//	@Autowired
//	@Qualifier("userCorespondenceService")
//	private UserCorespondenceService userCorespondenceService;
//
//	@Autowired
//	@Qualifier("testObjectServiceCreator")
//	private TestObjectServiceCreator testObjectServiceCreator;
//
//	public void setUserCorespondenceService(UserCorespondenceService userCorespondenceService) {
//		this.userCorespondenceService = userCorespondenceService;
//	}
//
//	public void setTestObjectServiceCreator(TestObjectServiceCreator testObjectServiceCreator) {
//		this.testObjectServiceCreator = testObjectServiceCreator;
//	}
//	
//	public User user;
//	public UserCorespondence userCorespondence;
//
//	@Before
//	public void initObjectsBeforeTest() {
//		this.userCorespondence = testObjectServiceCreator.createUserCorespondenceForTest();
//		this.user = userCorespondence.getUser();
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingCorespondViewStatusByIdUserCorespond() {
//
//		String viewStatus = userCorespondenceService.getCorespondViewStatusByIdUserCorespond(userCorespondence
//						.getIdUserCorespondence());
//		logger.info("UserCorespondenceServiceTest: test method GetCorespondViewStatusByIdUserCorespond");
//		Assert.assertEquals(userCorespondence.getCorespondenceViewStatus(), viewStatus);
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingListUserCorespondenceForBroadcastInfo() {
//		logger.info("UserCorespondenceServiceTest: test method GetListUserCorespondenceForBroadcastInfo");
//		List<UserCorespondence> list=userCorespondenceService.getListUserCorespondenceForBroadcastInfo();
//		Assert.assertFalse(list.isEmpty());
//	}
}
