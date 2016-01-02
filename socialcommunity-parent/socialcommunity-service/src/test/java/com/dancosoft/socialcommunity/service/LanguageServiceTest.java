/**
 * 
 */
package com.dancosoft.socialcommunity.service;

import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.dancosoft.socialcommunity.dao.LanguageDAOTest;
import com.dancosoft.socialcommunity.model.Language;
import com.dancosoft.socialcommunity.service.testsupport.TestObjectServiceCreator;
import com.dancosoft.socialcommunity.service.testsupport.TestStarter;

/**
 * @author Zaerko_DV
 *
 */
public class LanguageServiceTest extends TestStarter {

	private static final Logger logger = LoggerFactory.getLogger(LanguageDAOTest.class);

	@Autowired
	@Qualifier("languageService")
	private LanguageService languageService;

	@Autowired
	@Qualifier("testObjectServiceCreator")
	private TestObjectServiceCreator testObjectServiceCreator;

	public void setLanguageService(LanguageService languageService) {
		this.languageService = languageService;
	}

	public void setTestObjectServiceCreator(TestObjectServiceCreator testObjectServiceCreator) {
		this.testObjectServiceCreator = testObjectServiceCreator;
	}

	public Language language;
	
	@Before
	public void initObjectsBeforeTest() {
		this.language = testObjectServiceCreator.createLanguageForTest();
	}
}
