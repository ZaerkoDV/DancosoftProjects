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

import com.dancosoft.socialcommunity.dao.GroupMessageDAO;
import com.dancosoft.socialcommunity.dao.support.TimeConverter;
import com.dancosoft.socialcommunity.model.Account;
import com.dancosoft.socialcommunity.model.ForumMessage;
import com.dancosoft.socialcommunity.model.GroupMessage;
import com.dancosoft.socialcommunity.service.GroupMessageService;

/**
 * @author Zaerko_DV
 *
 */
@Service(value="groupMessageService")
public class GroupMessageServiceImpl extends CommonEntityServiceImpl implements GroupMessageService {

	private static final Logger logger = LoggerFactory.getLogger(GroupMessageServiceImpl.class);
	
	TimeConverter converter = new TimeConverter();
	
	@Autowired
	@Qualifier(value="groupMessageDAO")
	private GroupMessageDAO groupMessageDAO;

	public void setGroupMessageDAO(GroupMessageDAO groupMessageDAO) {
		this.groupMessageDAO = groupMessageDAO;
	}
	
	public Account getMemberAccountByIdGroupMessage(Long idGroupMessage) {
		
		Account account= null;
		if (idGroupMessage.equals(null) || idGroupMessage.equals("")) {
			throw new RuntimeException("GroupMessageService:Id group messages must not null or empty");
		} else{
			try {
				logger.info("GroupMessageService:User account load by id user group message");
				account=groupMessageDAO.getMemberAccountByIdGroupMessage(idGroupMessage);	
				
			}  catch (DataRetrievalFailureException rf) {
				logger.warn("GroupMessageService: Member account which create group"
						+ " message not exist with idGroupMessage." + rf);
				
			} catch (DataAccessException da) {
				logger.error("GroupMessageService:Exeption connect with data base or other error= "+da);
			}
		}
		return account;
	}
	
	public List<GroupMessage> getListGroupMessageByIdAccountGroup(Long idAccountGroup) {
		
		List<GroupMessage> list=Collections.emptyList();
		if (idAccountGroup.equals(null) || idAccountGroup.equals("")) {
			throw new RuntimeException("GroupMessageService:Id group messages must not null or empty");
			
		} else{
			try {
				logger.info("GroupMessageService:List group message load by id account group");
				list= groupMessageDAO.getListGroupMessageByIdAccountGroup(idAccountGroup);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("GroupMessageService: List group message load, but list is empty." + rf);
				
			} catch (DataAccessException da) {
				logger.error("GroupMessageService:Exeption connect with data base or other error= "+da);
			}
		}
		return list;
	}
	
	public List<GroupMessage> getListGroupMessageBeetweenDateByIdAccountGroup(
			Long idAccountGroup, LocalDateTime minDateLDT, LocalDateTime maxDateLDT) {

		List<GroupMessage> list = Collections.emptyList();
		Date minDateD;
		Date maxDateD;
		if (idAccountGroup.equals(null) || idAccountGroup.equals("")) {
			throw new RuntimeException("ForumMessageService:Id account group must not null or empty.");
			
		} else if (maxDateLDT.isBefore(minDateLDT)) {
			throw new RuntimeException("ForumMessageService: Max date must not before min date!");

		} else {
			try {
				minDateD = converter.convertLocalDateTimeToDate(minDateLDT);
				maxDateD = converter.convertLocalDateTimeToDate(maxDateLDT);
				logger.info("GroupMessageService:List group message which"
						+ " creete between date load by id account group");
				list = groupMessageDAO.getListGroupMessageBeetweenDateByIdAccountGroup(idAccountGroup, minDateD, maxDateD);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("GroupMessageService: List group message which create between"
						+ " date load, but list is empty." + rf);
				
			} catch (DataAccessException da) {
				logger.error("GroupMessageService:Exeption connect with data base or other error= "+da);
			}
		}
		return list;
	}
	
	public int getCountGroupMessageByIdAccountGroup(Long idAccountGroup) {
		
		int count=0;
		if (idAccountGroup.equals(null) || idAccountGroup.equals("")) {
			throw new RuntimeException("ForumMessageService:Id account group must not null or empty.");
		}else{
			try {
				logger.info("GroupMessageService:Count group message load for account group.");
				count=groupMessageDAO.getCountGroupMessageByIdAccountGroup(idAccountGroup);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("GroupMessageService: Count of group messages load for account group"
						+ ", but is equals zero." + rf);
				
			} catch (DataAccessException da) {
				logger.error("GroupMessageService:Exeption connect with data base or other error= "+da);
			}
		}
		return count;
	}
}
