/**
 * 
 */
package com.dancosoft.socialcommunity.service.impl;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataRetrievalFailureException;
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
		
		Account account= null;
		if (idGroupEvent.equals(null) || idGroupEvent.equals("")) {
			throw new RuntimeException("GroupEventService:Id group event must not null or empty.");
			
		} else{
			try {
				logger.info("GroupEventService:User account load by id user group event.");
				account= groupEventDAO.getMemberAccountByIdGroupEvent(idGroupEvent);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("GroupEventService: GroupMember(account) which created"
						+ " group event not exist with idGroupEvent " + rf);
				
			} catch (DataAccessException da) {
				logger.error("GroupEventService:Exeption connect with data base or other error= "+da);
			}
		}
		return account;
	}
	
	public List<GroupEvent> getListGroupEventByIdAccountGroup(Long idAccountGroup) {
		
		List<GroupEvent> list=Collections.emptyList();
		if (idAccountGroup.equals(null) || idAccountGroup.equals("")) {
			throw new RuntimeException("GroupEventService:Id account group must not null or empty.");
			
		} else{
			try {
				logger.info("GroupEventService:List group event load by id account group");
				list= groupEventDAO.getListGroupEventByIdAccountGroup(idAccountGroup);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("GroupEventService: List group event load by id account group. But list is empty" + rf);
				
			} catch (DataAccessException da) {
				logger.error("GroupEventService:Exeption connect with data base or other error= "+da);
			}
		}
		return list;
	}
	
	public List<GroupEvent> getListGroupEventBeetweenDateByIdAccountGroup(
			Long idAccountGroup,LocalDateTime  minDateLDT, LocalDateTime maxDateLDT) {
		
		Date minDateD;
		Date maxDateD;
		List<GroupEvent> list=Collections.emptyList();
		if (idAccountGroup.equals(null) || idAccountGroup.equals("")) {
			throw new RuntimeException("GroupEventService:Id account group must not null or empty.");
			
		} else if(maxDateLDT.isBefore(minDateLDT)){
			throw new RuntimeException("GroupEventService: Max date must not before min date!");
			
		} else {
			try {
				minDateD = converter.convertLocalDateTimeToDate(minDateLDT);
				maxDateD = converter.convertLocalDateTimeToDate(maxDateLDT);
				logger.info("GroupEventService:List group event which creete between date load by id account group");
				list= groupEventDAO.getListGroupEventBeetweenDateByIdAccountGroup(idAccountGroup, minDateD, maxDateD);

			} catch (DataRetrievalFailureException rf) {
				logger.warn("GroupEventService: List group event which created between date load for"
						+ " account group. But list is empty" + rf);
				
			} catch (DataAccessException da) {
				logger.error("GroupEventService:Exeption connect with data base or other error= "+da);
			}
		}
		return list;
	}
	
	public int getCountGroupEventByIdAccountGroup(Long idAccountGroup) {
		
		int count=0;
		if (idAccountGroup.equals(null) || idAccountGroup.equals("")) {
			throw new RuntimeException("GroupEventService:Id account group must not null or empty.");
		} else {
			try {
				logger.info("GroupEventService:Count group event load for account group");
				count= groupEventDAO.getCountGroupEventByIdAccountGroup(idAccountGroup);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("GroupEventService: Count of group event for group load. But count is equals zero." + rf);
				
			} catch (DataAccessException da) {
				logger.error("GroupEventService:Exeption connect with data base or other error= "+da);
			}
		}
		return count;
	}
}
