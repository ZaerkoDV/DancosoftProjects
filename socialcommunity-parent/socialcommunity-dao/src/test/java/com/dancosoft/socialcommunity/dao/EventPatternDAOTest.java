/**
 * 
 */
package com.dancosoft.socialcommunity.dao;

import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.dancosoft.socialcommunity.dao.testsupport.TestObjectDAOCreator;
import com.dancosoft.socialcommunity.dao.testsupport.TestStarter;
import com.dancosoft.socialcommunity.model.EventPattern;

/**
 * @author Zaerko_DV
 *
 */
public class EventPatternDAOTest extends TestStarter {
	
	private static final Logger logger = LoggerFactory.getLogger(EventPatternDAOTest.class);
	
	@Autowired
	@Qualifier("eventPatternDAO")
	private EventPatternDAO eventPatternDAO;

	@Autowired
	@Qualifier("testObjectDAOCreator")
	private TestObjectDAOCreator testObjectDAOCreator;

	public void setEventPatternDAO(EventPatternDAO eventPatternDAO) {
		this.eventPatternDAO = eventPatternDAO;
	}

	public void setTestObjectDAOCreator(TestObjectDAOCreator testObjectDAOCreator) {
		this.testObjectDAOCreator = testObjectDAOCreator;
	}

	public EventPattern eventPattern;

	@Before
	public void initObjectsBeforeTest() {
		this.eventPattern = testObjectDAOCreator.createEventPatternForTest();
	}
}
