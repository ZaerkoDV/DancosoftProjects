/**
 * 
 */
package com.dancosoft.socialcommunity.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.dancosoft.socialcommunity.dao.SecurityPromptDAOTest;
import com.dancosoft.socialcommunity.model.SecurityPrompt;
import com.dancosoft.socialcommunity.model.User;
import com.dancosoft.socialcommunity.model.UserSecurity;
import com.dancosoft.socialcommunity.service.testsupport.TestObjectServiceCreator;
import com.dancosoft.socialcommunity.service.testsupport.TestStarter;

/**
 * @author Zaerko_DV
 *
 */
public class SecurityPromptServiceTest extends TestStarter{

	private static final Logger logger = LoggerFactory.getLogger(SecurityPromptDAOTest.class);

	@Autowired
	@Qualifier("securityPromptService")
	private SecurityPromptService securityPromptService;

	@Autowired
	@Qualifier("testObjectServiceCreator")
	private TestObjectServiceCreator testObjectServiceCreator;

	public void setSecurityPromptService(SecurityPromptService securityPromptService) {
		this.securityPromptService = securityPromptService;
	}

	public void setTestObjectServiceCreator(
			TestObjectServiceCreator testObjectServiceCreator) {
		this.testObjectServiceCreator = testObjectServiceCreator;
	}
	
	public User user;
	public UserSecurity userSecurity;
	public SecurityPrompt securityPrompt;

	@Before
	public void initObjectsBeforeTest() {
		this.securityPrompt = testObjectServiceCreator.createSecurityPromptForTest();
		this.userSecurity = securityPrompt.getUserSecurity();
		this.user = userSecurity.getUser();
	}

	@Transactional
	@Rollback(true)
	@Test
	public void testGettingSecurityPromptByIdUser() {

		logger.info("SecurityPromptServiceTest: test method testGettingSecurityPromptByIdUser");
		Assert.assertNotNull(securityPromptService.getSecurityPromptByIdUser(user.getIdUser()));
	}
	
	@Transactional
	@Rollback(true)
	@Test
	public void testGettingSecurityPromptByLogin() {

		logger.info("SecurityPromptServiceTest: test method testGettingSecurityPromptByLogin");
		SecurityPrompt securityPromptByLogin = securityPromptService.getSecurityPromptByLogin(userSecurity.getUserLogin());
		Assert.assertEquals(securityPrompt, securityPromptByLogin);
	}

	@Transactional
	@Rollback(true)
	@Test
	public void testSignInUserByPromptAnswer() {

		logger.info("SecurityPromptServiceTest: test method testSignInUserByPromptAnswer");
		
		Boolean signIn = securityPromptService.signInUserByPromptAnswer(
				securityPrompt.getIdSecurityPrompt(),
				securityPrompt.getUserAnswer());
		Assert.assertTrue(signIn);

		signIn = securityPromptService.signInUserByPromptAnswer(securityPrompt.getIdSecurityPrompt(), "other");
		Assert.assertFalse(signIn);
	}

	@Transactional
	@Rollback(true)
	@Test
	public void testGettingIdUserByPromptAnswer() {

		logger.info("SecurityPromptServiceTest: test method testGettingIdUserByPromptAnswer");
		Long idUser = securityPromptService.getIdUserByPromptAnswer(
				securityPrompt.getIdSecurityPrompt(),
				securityPrompt.getUserAnswer());
		Assert.assertEquals(user.getIdUser(), idUser);

		idUser = securityPromptService.getIdUserByPromptAnswer(securityPrompt.getIdSecurityPrompt(), "other answer");
		Assert.assertNull(idUser);
	}

	@Transactional
	@Rollback(true)
	@Test
	public void testOnUniquePrompt() {

		logger.info("SecurityPromptServiceTest: test method testOnUniquePrompt");
		Boolean expected = securityPromptService.isUniquePrompt(
				securityPrompt.getSecurityPrompt(),
				securityPrompt.getUserAnswer());
		Assert.assertFalse(expected);
		
		expected = securityPromptService.isUniquePrompt("prompt", "answer");
		Assert.assertTrue(expected);
	}
}
