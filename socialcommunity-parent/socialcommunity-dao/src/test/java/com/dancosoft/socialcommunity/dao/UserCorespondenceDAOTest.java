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
import com.dancosoft.socialcommunity.model.User;
import com.dancosoft.socialcommunity.model.UserCorespondence;

/**
 * @author Zaerko_DV
 *
 */

public class UserCorespondenceDAOTest {//extends TestStarter {

//	private static final Logger logger = LoggerFactory.getLogger(UserCorespondenceDAOTest.class);
//
//	@Autowired
//	@Qualifier("userCorespondenceDAO")
//	private UserCorespondenceDAO userCorespondenceDAO;
//
//	@Autowired
//	@Qualifier("testObjectDAOCreator")
//	private TestObjectDAOCreator testObjectDAOCreator;
//
//	public void setUserCorespondenceDAO(UserCorespondenceDAO userCorespondenceDAO) {
//		this.userCorespondenceDAO = userCorespondenceDAO;
//	}
//
//	public void setTestObjectDAOCreator(TestObjectDAOCreator testObjectDAOCreator) {
//		this.testObjectDAOCreator = testObjectDAOCreator;
//	}
//
//	public User user;
//	public UserCorespondence userCorespondence;
//
//	@Before
//	public void initObjectsBeforeTest() {
//		this.userCorespondence = testObjectDAOCreator.createUserCorespondenceForTest();
//		this.user = userCorespondence.getUser();
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingCorespondViewStatusByIdUserCorespond() {
//
//		String viewStatus = userCorespondenceDAO.getCorespondViewStatusByIdUserCorespond(userCorespondence
//						.getIdUserCorespondence());
//		logger.info("UserCorespondenceDAOTest: test method GetCorespondViewStatusByIdUserCorespond");
//		Assert.assertEquals(userCorespondence.getCorespondenceViewStatus(), viewStatus);
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingListUserCorespondenceForBroadcastInfo() {
//		
//		logger.info("UserCorespondenceDAOTest: test method GetListUserCorespondenceForBroadcastInfo");
//		List<UserCorespondence> list=userCorespondenceDAO.getListUserCorespondenceForBroadcastInfo();
//		Assert.assertFalse(list.isEmpty());
//	}
}
