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

import com.dancosoft.socialcommunity.dao.GroupMessageDAO;
import com.dancosoft.socialcommunity.dao.support.TimeConverter;
import com.dancosoft.socialcommunity.model.Account;
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
		logger.info("GroupMessageService:User account load by id user group message");
		return groupMessageDAO.getMemberAccountByIdGroupMessage(idGroupMessage);
	}
	
	public List<GroupMessage> getListGroupMessageByIdAccountGroup(Long idAccountGroup) {
		logger.info("GroupMessageService:List group message load by id account group");
		return groupMessageDAO.getListGroupMessageByIdAccountGroup(idAccountGroup);
	}
	
	public List<GroupMessage> getListGroupMessageBeetweenDateByIdAccountGroup(
			Long idAccountGroup, LocalDateTime minDateLDT, LocalDateTime maxDateLDT) {
		
		Date minDateD = converter.convertLocalDateTimeToDate(minDateLDT);
		Date maxDateD = converter.convertLocalDateTimeToDate(maxDateLDT);
		logger.info("GroupMessageService:List group message which"
				+ " creete between date load by id account group");
		
		return groupMessageDAO.getListGroupMessageBeetweenDateByIdAccountGroup(idAccountGroup, minDateD, maxDateD);
	}
	
	public int getCountGroupMessageByIdAccountGroup(Long idAccountGroup) {
		logger.info("GroupMessageService:Count group message load for account group");
		return groupMessageDAO.getCountGroupMessageByIdAccountGroup(idAccountGroup);
	}
	
}
