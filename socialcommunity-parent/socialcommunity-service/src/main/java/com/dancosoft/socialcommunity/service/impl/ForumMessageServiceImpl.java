/**
 * 
 */
package com.dancosoft.socialcommunity.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.dancosoft.socialcommunity.dao.ForumMessageDAO;
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
	
	@Autowired
	@Qualifier(value="forumMessageDAO")
	private ForumMessageDAO forumMessageDAO;

	public void setForumMessageDAO(ForumMessageDAO forumMessageDAO) {
		this.forumMessageDAO = forumMessageDAO;
	}
	
	public Account getAccountAuthorMessageByIdForumMessage(Long idForumMessage) {
		logger.info("ForumMessageService:Author account which create message load by id forum message");
		return forumMessageDAO.getAccountAuthorMessageByIdForumMessage(idForumMessage);
	}
	
	public List<ForumMessage> getListForumMessageByIdForumTopic(Long idForumTopic) {
		logger.info("ForumMessageService: List forum message load by id forum topic.");
		return forumMessageDAO.getListForumMessageByIdForumTopic(idForumTopic);
	}

	public List<ForumMessage> getListForumMessageBetweenDateByIdForumTopic(Long idForumTopic, Date minDate, Date maxDate) {
		logger.info("ForumMessageService: List forum message which create between date load by id forum topic.");
		return forumMessageDAO.getListForumMessageBetweenDateByIdForumTopic(idForumTopic, minDate, maxDate);
	}
	
	public List<ForumMessage> getListForumMessagetByIdAccount(Long idAccount) {
		logger.info("ForumMessageService: List forum message which create account load by id account.");
		return forumMessageDAO.getListForumMessagetByIdAccount(idAccount);
	}
}
