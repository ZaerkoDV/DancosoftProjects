/**
 * 
 */
package com.dancosoft.socialcommunity.service;

import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.dancosoft.socialcommunity.model.EventPattern;
import com.dancosoft.socialcommunity.service.testsupport.TestObjectServiceCreator;
import com.dancosoft.socialcommunity.service.testsupport.TestStarter;

/**
 * @author Zaerko_DV
 *
 */
public class EventPatternServiceTest extends TestStarter {

	private static final Logger logger = LoggerFactory.getLogger(EventPatternServiceTest.class);
	
	@Autowired
	@Qualifier("eventPatternService")
	private EventPatternService eventPatternService;

	@Autowired
	@Qualifier("testObjectServiceCreator")
	private TestObjectServiceCreator testObjectServiceCreator;

	public void setEventPatternService(EventPatternService eventPatternService) {
		this.eventPatternService = eventPatternService;
	}

	public void setTestObjectServiceCreator(TestObjectServiceCreator testObjectServiceCreator) {
		this.testObjectServiceCreator = testObjectServiceCreator;
	}

	public EventPattern eventPattern;

	@Before
	public void initObjectsBeforeTest() {
		this.eventPattern = testObjectServiceCreator.createEventPatternForTest();
	}
	
}
