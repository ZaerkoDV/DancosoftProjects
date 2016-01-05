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

import com.dancosoft.socialcommunity.service.testsupport.TestObjectServiceCreator;
import com.dancosoft.socialcommunity.model.User;
import com.dancosoft.socialcommunity.service.testsupport.TestStarter;


public class CommonEntityServiceTest {//extends TestStarter {

//	private static final Logger logger = LoggerFactory.getLogger(CommonEntityServiceTest.class);
//	
//	@Autowired
//	@Qualifier("commonEntityService")
//	private CommonEntityService commonEntityService;
//
//	@Autowired
//	@Qualifier("testObjectServiceCreator")								
//	private TestObjectServiceCreator testObjectServiceCreator;
//
//	public void setCommonEntityService(CommonEntityService commonEntityService) {
//		this.commonEntityService = commonEntityService;
//	}
//
//	public void setTestObjectServiceCreator(TestObjectServiceCreator testObjectServiceCreator) {
//		this.testObjectServiceCreator = testObjectServiceCreator;
//	}
//
//	public User user;
//	
//	@Before
//	public void initObjectsBeforeTest(){
//		this.user=testObjectServiceCreator.createUserForTest();
//	}
//	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testSaveEntity(){
//		logger.info("EntityServiceTest:Test entity save sucessfully.");
//		Assert.assertNotNull(commonEntityService.getEntityById(User.class,user.getIdUser()));
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingEntityById(){
//		Object entity=commonEntityService.getEntityById(User.class,user.getIdUser());
//		logger.info("EntityServiceTest:Test entity loaded sucessfully.");
//		Assert.assertNotNull(entity);
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testUpdateEntity(){
//
//		user.setFirstName("testFirstName2");
//		commonEntityService.updateEntity(user);
//		
//		final User updatedUser =(User) commonEntityService.getEntityById(User.class,user.getIdUser());	
//		logger.info("EntityServiceTest:Test entity update sucessfully.");
//		Assert.assertTrue(updatedUser.getFirstName().equals("testFirstName2"));
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testDeleteEntityById(){
//		commonEntityService.deleteEntityById(User.class,user.getIdUser());
//		logger.info("EntityServiceTest:Test entity delete by id sucessfully.");
//		Assert.assertNull(commonEntityService.getEntityById(User.class,user.getIdUser()));
//	}
//	
//	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testDeleteEntity(){
//		commonEntityService.deleteEntity(user);
//		logger.info("EntityServiceTest:Test entity delete sucessfully.");
//		Assert.assertNull(commonEntityService.getEntityById(User.class,user.getIdUser()));
//	}
//	
//	@SuppressWarnings("unchecked")
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingAllEntity(){
//		List<User> list = (List)commonEntityService.getListEntity(User.class);
//		logger.info("EntityServiceTest:List test entity loaded sucessfully.");
//		Assert.assertFalse(list.isEmpty());
//	}
}
