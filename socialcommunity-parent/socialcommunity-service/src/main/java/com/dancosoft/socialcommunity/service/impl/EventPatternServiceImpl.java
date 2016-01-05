/**
 * 
 */
package com.dancosoft.socialcommunity.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.dancosoft.socialcommunity.dao.EventPatternDAO;
import com.dancosoft.socialcommunity.service.EventPatternService;

/**
 * @author Zaerko_DV
 *
 */
@Service(value="eventPatternService")
public class EventPatternServiceImpl extends CommonEntityServiceImpl implements EventPatternService {

	private static final Logger logger = LoggerFactory.getLogger(EventPatternServiceImpl.class);
	
	@Autowired
	@Qualifier(value="eventPatternDAO")
	private EventPatternDAO eventPatternDAO;

	public void setEventPatternDAO(EventPatternDAO eventPatternDAO) {
		this.eventPatternDAO = eventPatternDAO;
	}
}
