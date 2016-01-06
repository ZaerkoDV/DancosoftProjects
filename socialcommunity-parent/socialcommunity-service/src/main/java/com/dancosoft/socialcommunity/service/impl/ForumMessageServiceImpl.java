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

import com.dancosoft.socialcommunity.dao.ForumMessageDAO;
import com.dancosoft.socialcommunity.dao.support.TimeConverter;
import com.dancosoft.socialcommunity.model.Account;
import com.dancosoft.socialcommunity.model.ForumMessage;
import com.dancosoft.socialcommunity.service.ForumMessageService;

/**
 * @author Zaerko_DV
 *
 */
@Service(value="forumMessageService")
public class ForumMessageServiceImpl extends CommonEntityServiceImpl implements ForumMessageService {
	
	private static final Logger logger = LoggerFactory.getLogger(ForumMessageServiceImpl.class);
	
	TimeConverter converter = new TimeConverter();
	
	@Autowired
	@Qualifier(value="forumMessageDAO")
	private ForumMessageDAO forumMessageDAO;

	public void setForumMessageDAO(ForumMessageDAO forumMessageDAO) {
		this.forumMessageDAO = forumMessageDAO;
	}
	
	public Account getAccountAuthorMessageByIdForumMessage(Long idForumMessage) {
		
		Account account= null;
		if (idForumMessage.equals(null) || idForumMessage.equals("")) {
			throw new RuntimeException("ForumMessageService:Id Forum messages must not null");
		} else{
			try {
				logger.info("ForumMessageService:Author account which create message load by id forum message");
				account=forumMessageDAO.getAccountAuthorMessageByIdForumMessage(idForumMessage);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("ForumMessageService: Operation search is completed."
						+ " Not found account by id user message on forum" + rf);
				
			} catch (DataAccessException da) {
				logger.error("ForumMessageService:Exeption connect with data base or other error= "+da);
			}
		}
		return account;
	}
	
	public List<ForumMessage> getListForumMessageByIdForumTopic(Long idForumTopic) {
		
		List<ForumMessage> list=Collections.emptyList();
		if (idForumTopic.equals(null) || idForumTopic.equals("")) {
			throw new RuntimeException("ForumMessageService:Id Forum messages must not null");
		} else{
			try {
				logger.info("ForumMessageService: List of forum message load by id forum topic.");
				list=forumMessageDAO.getListForumMessageByIdForumTopic(idForumTopic);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("ForumMessageService: List of forum messages for forum topic load. List is empty." + rf);
				
			} catch (DataAccessException da) {
				logger.error("ForumMessageService:Exeption connect with data base or other error= "+da);
			}
		}
		return list;
	}

	public List<ForumMessage> getListForumMessageBetweenDateByIdForumTopic(Long idForumTopic,
			LocalDateTime minDateLDT, LocalDateTime maxDateLDT) {
		
		List<ForumMessage> list=Collections.emptyList();
		Date minDateD;
		Date maxDateD;
		
		if (idForumTopic.equals(null) || idForumTopic.equals("")) {
			throw new RuntimeException("ForumMessageService:Id Forum messages must not null!");
			
		} else if(maxDateLDT.isBefore(minDateLDT)){
			throw new RuntimeException("ForumMessageService: Max date must not before min date!");
			
		}else{
			try {
				minDateD = converter.convertLocalDateTimeToDate(minDateLDT);
				maxDateD = converter.convertLocalDateTimeToDate(maxDateLDT);
				logger.info("ForumMessageService: List of forum message"
						+ " which create between date load by id forum topic.");
				list=forumMessageDAO.getListForumMessageBetweenDateByIdForumTopic(idForumTopic, minDateD, maxDateD);
				
			}catch (DataRetrievalFailureException rf) {
				logger.warn("ForumMessageService: List of forum messages load but list is empty=" + rf);
				
			}catch (DataAccessException da) {
				logger.error("ForumMessageService:Exeption connect with data base or other error= "+da);
			}
		}
		return list;
	}
	
	public List<ForumMessage> getListForumMessagetByIdAccount(Long idAccount) {
		
		List<ForumMessage> list=Collections.emptyList();
		if (idAccount.equals(null)) {
			throw new RuntimeException("ForumMessageService:Id Forum messages must not null!");
			
		} else{
			try {
				logger.info("ForumMessageService: List of forum message"
						+ " which user(account) create load by id account.");
				list=forumMessageDAO.getListForumMessagetByIdAccount(idAccount);
				
			}catch (DataRetrievalFailureException rf) {
				logger.warn("ForumMessageService: List of forum messages load but list is empty=" + rf);
				
			}catch (DataAccessException da) {
				logger.error("ForumMessageService:Exeption connect with data base or other error= "+da);
			}
		}
		return list;
	}
}
