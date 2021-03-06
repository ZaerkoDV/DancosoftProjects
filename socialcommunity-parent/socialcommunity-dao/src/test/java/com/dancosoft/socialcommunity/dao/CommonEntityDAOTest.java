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

/**
 * @author Zaerko_DV
 *
 */
public class CommonEntityDAOTest {//extends TestStarter {

//	private static final Logger logger = LoggerFactory.getLogger(CommonEntityDAOTest.class);
//	
//	@Autowired
//	@Qualifier("commonEntityDAO")
//	private CommonEntityDAO commonEntityDAO;
//
//	@Autowired
//	@Qualifier("testObjectDAOCreator")								
//	private TestObjectDAOCreator testObjectDAOCreator;
//	
//	public void setCommonEntityDAO(CommonEntityDAO commonEntityDAO) {
//		this.commonEntityDAO = commonEntityDAO;
//	}
//
//	public void setTestObjectDAOCreator(TestObjectDAOCreator testObjectDAOCreator) {
//		this.testObjectDAOCreator = testObjectDAOCreator;
//	}
//	
//	public User user;
//	
//	@Before
//	public void initObjectsBeforeTest(){
//		this.user=testObjectDAOCreator.createUserForTest();
//	}
//	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testSaveEntity(){
//		logger.info("EntityDAOTest:Test entity save sucessfully.");
//		Assert.assertNotNull(commonEntityDAO.getEntityById(User.class,user.getIdUser()));
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingEntityById(){
//		Object entity=commonEntityDAO.getEntityById(User.class,user.getIdUser());
//		logger.info("EntityDAOTest:Test entity loaded sucessfully.");
//		Assert.assertNotNull(entity);
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testUpdateEntity(){
//
//		user.setFirstName("testFirstName2");
//		commonEntityDAO.updateEntity(user);
//		
//		final User updatedUser =(User) commonEntityDAO.getEntityById(User.class,user.getIdUser());	
//		logger.info("EntityDAOTest:Test entity update sucessfully.");
//		Assert.assertTrue(updatedUser.getFirstName().equals("testFirstName2"));
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testDeleteEntityById(){
//		commonEntityDAO.deleteEntityById(User.class,user.getIdUser());
//		logger.info("EntityDAOTest:Test entity delete by id sucessfully.");
//		Assert.assertNull(commonEntityDAO.getEntityById(User.class,user.getIdUser()));
//	}
//	
//	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testDeleteEntity(){
//		commonEntityDAO.deleteEntity(user);
//		logger.info("EntityDAOTest:Test entity delete sucessfully.");
//		Assert.assertNull(commonEntityDAO.getEntityById(User.class,user.getIdUser()));
//	}
//	
//	@SuppressWarnings("unchecked")
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingAllEntity(){
//		List<User> list = (List)commonEntityDAO.getListEntity(User.class);
//		logger.info("EntityDAOTest:List test entity loaded sucessfully.");
//		Assert.assertFalse(list.isEmpty());
//	}
}
