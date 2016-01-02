/**
 * 
 */
package com.dancosoft.socialcommunity.service.impl;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.dancosoft.socialcommunity.dao.GroupEventDAO;
import com.dancosoft.socialcommunity.dao.support.TimeConverter;
import com.dancosoft.socialcommunity.model.Account;
import com.dancosoft.socialcommunity.model.GroupEvent;
import com.dancosoft.socialcommunity.service.GroupEventService;

/**
 * @author Zaerko_DV
 *
 */
@Service(value="groupEventService")
public class GroupEventServiceImpl extends CommonEntityServiceImpl implements GroupEventService {

	private static final Logger logger = LoggerFactory.getLogger(GroupEventServiceImpl.class);
	
	TimeConverter converter = new TimeConverter();
	
	@Autowired
	@Qualifier(value="groupEventDAO")
	private GroupEventDAO groupEventDAO;

	public void setGroupEventDAO(GroupEventDAO groupEventDAO) {
		this.groupEventDAO = groupEventDAO;
	}
	
	public Account getMemberAccountByIdGroupEvent(Long idGroupEvent) {
		logger.info("GroupEventService:User account load by id user group event");
		return groupEventDAO.getMemberAccountByIdGroupEvent(idGroupEvent);
	}
	
	public List<GroupEvent> getListGroupEventByIdAccountGroup(Long idAccountGroup) {
		logger.info("GroupEventService:List group event load by id account group");
		return groupEventDAO.getListGroupEventByIdAccountGroup(idAccountGroup);
	}
	
	public List<GroupEvent> getListGroupEventBeetweenDateByIdAccountGroup(
			Long idAccountGroup,LocalDateTime  minDateLDT, LocalDateTime maxDateLDT) {
		
		Date minDateD = converter.convertLocalDateTimeToDate(minDateLDT);
		Date maxDateD = converter.convertLocalDateTimeToDate(maxDateLDT);
		logger.info("GroupEventService:List group event which"
				+ " creete between date load by id account group");
		return groupEventDAO.getListGroupEventBeetweenDateByIdAccountGroup(idAccountGroup, minDateD, maxDateD);
	}
	
	public int getCountGroupEventByIdAccountGroup(Long idAccountGroup) {
		
		logger.info("GroupEventService:Count group event load for account group");
		return groupEventDAO.getCountGroupEventByIdAccountGroup(idAccountGroup);
	}
}
