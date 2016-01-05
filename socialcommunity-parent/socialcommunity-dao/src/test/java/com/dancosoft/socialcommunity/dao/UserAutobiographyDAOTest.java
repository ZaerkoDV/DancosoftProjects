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
import com.dancosoft.socialcommunity.model.UserAutobiography;

/**
 * @author Zaerko_DV
 *
 */
public class UserAutobiographyDAOTest extends TestStarter {

	private static final Logger logger = LoggerFactory.getLogger(UserAutobiographyDAOTest.class);

	@Autowired
	@Qualifier("userAutobiographyDAO")
	private UserAutobiographyDAO userAutobiographyDAO;

	@Autowired
	@Qualifier("testObjectDAOCreator")
	private TestObjectDAOCreator testObjectDAOCreator;

	public void setUserAutobiographyDAO(UserAutobiographyDAO userAutobiographyDAO) {
		this.userAutobiographyDAO = userAutobiographyDAO;
	}

	public void setTestObjectDAOCreator(TestObjectDAOCreator testObjectDAOCreator) {
		this.testObjectDAOCreator = testObjectDAOCreator;
	}

	public User user;
	public UserAutobiography userAutobiography;

	@Before
	public void initObjectsBeforeTest() {
		this.userAutobiography = testObjectDAOCreator.createUserAutobiographyForTest();
		this.user = userAutobiography.getUser();
	}

	@Transactional
	@Rollback(true)
	@Test
	public void testGettingUserAutobiographyByIdUser() {

		logger.info("UserAutobiographyDAOTest: test method GetUserAutoboigraphyByIdUser");
		Assert.assertNotNull(userAutobiographyDAO.getUserAutobiographyByIdUser(user.getIdUser()));
	}
	
	@Transactional
	@Rollback(true)
	@Test
	public void testGettingListUserByHobby() {

		logger.info("UserAutobiographyDAOTest: test method GetListUserByHobby");
		List<User> list=userAutobiographyDAO.getListUserByHobby(userAutobiography.getHobby());
		Assert.assertFalse(list.isEmpty());
	}
	
	@Transactional
	@Rollback(true)
	@Test
	public void testOnUserAdult() {

		logger.info("UserAutobiographyDAOTest: test method isUserAdult");
		Boolean result=userAutobiographyDAO.isUserAdult(user.getIdUser(), (long)18);
		Assert.assertTrue(result);
	}
	
	@Transactional
	@Rollback(true)
	@Test
	public void testGettingListAdultUser() {

		logger.info("UserAutobiographyDAOTest: test method GetListAdultUser");
		List<User> list=userAutobiographyDAO.getListAdultUser((long)18);
		Assert.assertFalse(list.isEmpty());
	}
}
