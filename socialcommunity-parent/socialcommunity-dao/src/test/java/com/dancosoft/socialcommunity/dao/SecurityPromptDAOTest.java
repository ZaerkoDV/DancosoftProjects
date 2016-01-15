package com.dancosoft.socialcommunity.dao;


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
import com.dancosoft.socialcommunity.model.SecurityPrompt;
import com.dancosoft.socialcommunity.model.User;
import com.dancosoft.socialcommunity.model.UserSecurity;



public class SecurityPromptDAOTest {//extends TestStarter {

//	private static final Logger logger = LoggerFactory.getLogger(SecurityPromptDAOTest.class);
//
//	@Autowired
//	@Qualifier("securityPromptDAO")
//	private SecurityPromptDAO securityPromptDAO;
//
//	@Autowired
//	@Qualifier("testObjectDAOCreator")
//	private TestObjectDAOCreator testObjectDAOCreator;
//
//	public void setSecurityPromptDAO(SecurityPromptDAO securityPromptDAO) {
//		this.securityPromptDAO = securityPromptDAO;
//	}
//
//	public void setTestObjectDAOCreator(TestObjectDAOCreator testObjectDAOCreator) {
//		this.testObjectDAOCreator = testObjectDAOCreator;
//	}
//
//	public User user;
//	public UserSecurity userSecurity;
//	public SecurityPrompt securityPrompt;
//
//	@Before
//	public void initObjectsBeforeTest() {
//		this.securityPrompt = testObjectDAOCreator.createSecurityPromptForTest();
//		this.userSecurity = securityPrompt.getUserSecurity();
//		this.user = userSecurity.getUser();
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingSecurityPromptByIdUser() {
//
//		logger.info("SecurityPromptDAOTest: test method testGettingSecurityPromptByIdUser");
//		Assert.assertNotNull(securityPromptDAO.getSecurityPromptByIdUser(user.getIdUser()));
//	}
//	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingSecurityPromptByLogin() {
//
//		logger.info("SecurityPromptDAOTest: test method testGettingSecurityPromptByLogin");
//		SecurityPrompt securityPromptByLogin = securityPromptDAO
//				.getSecurityPromptByLogin(userSecurity.getUserLogin());
//		Assert.assertEquals(securityPrompt, securityPromptByLogin);
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testSignInUserByPromptAnswer() {
//
//		logger.info("SecurityPromptDAOTest: test method testSignInUserByPromptAnswer");
//		
//		Boolean signIn = securityPromptDAO.signInUserByPromptAnswer(
//				securityPrompt.getIdSecurityPrompt(),
//				securityPrompt.getUserAnswer());
//		Assert.assertTrue(signIn);
//
//		signIn = securityPromptDAO.signInUserByPromptAnswer(
//				securityPrompt.getIdSecurityPrompt(), "other");
//		Assert.assertFalse(signIn);
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingIdUserByPromptAnswer() {
//
//		logger.info("SecurityPromptDAOTest: test method testGettingIdUserByPromptAnswer");
//		Long idUser = securityPromptDAO.getIdUserByPromptAnswer(
//				securityPrompt.getIdSecurityPrompt(),
//				securityPrompt.getUserAnswer());
//		Assert.assertEquals(user.getIdUser(), idUser);
//
//		idUser = securityPromptDAO.getIdUserByPromptAnswer(
//				securityPrompt.getIdSecurityPrompt(), "other answer");
//		Assert.assertNull(idUser);
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testOnUniquePrompt() {
//
//		logger.info("SecurityPromptDAOTest: test method testOnUniquePrompt");
//		Boolean expected = securityPromptDAO.isUniquePrompt(
//				securityPrompt.getSecurityPrompt(),
//				securityPrompt.getUserAnswer());
//		Assert.assertFalse(expected);
//		
//		expected = securityPromptDAO.isUniquePrompt("prompt", "answer");
//		Assert.assertTrue(expected);
//	}
}
