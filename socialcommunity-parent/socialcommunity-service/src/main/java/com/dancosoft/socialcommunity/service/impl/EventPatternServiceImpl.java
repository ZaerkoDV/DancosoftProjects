/**
 * 
 */
package com.dancosoft.socialcommunity.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.dancosoft.socialcommunity.service.EventPatternService;

/**
 * @author Zaerko_DV
 *
 */
@Service(value="eventPatternService")
public class EventPatternServiceImpl extends CommonEntityServiceImpl implements EventPatternService {

	private static final Logger logger = LoggerFactory.getLogger(EventPatternServiceImpl.class);
	
}
