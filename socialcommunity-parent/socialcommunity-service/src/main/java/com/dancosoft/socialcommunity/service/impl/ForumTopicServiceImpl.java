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

import com.dancosoft.socialcommunity.dao.ForumTopicDAO;
import com.dancosoft.socialcommunity.dao.support.TimeConverter;
import com.dancosoft.socialcommunity.model.Account;
import com.dancosoft.socialcommunity.model.ForumTopic;
import com.dancosoft.socialcommunity.service.ForumTopicService;

/**
 * @author Zaerko_DV
 *
 */
@Service(value="forumTopicService")
public class ForumTopicServiceImpl extends CommonEntityServiceImpl implements ForumTopicService {

	private static final Logger logger = LoggerFactory.getLogger(ForumTopicServiceImpl .class);
	
	TimeConverter converter = new TimeConverter();
	
	@Autowired
	@Qualifier(value="forumTopicDAO")
	private ForumTopicDAO forumTopicDAO;

	public void setForumTopicDAO(ForumTopicDAO forumTopicDAO) {
		this.forumTopicDAO = forumTopicDAO;
	}
	
	public Account getAuthorAccountForumTopic(Long idForumTopic) {
		logger.info("ForumTopicService:Author account which create topic load by id forum topic");
		return forumTopicDAO.getAuthorAccountForumTopic(idForumTopic);
	}
	
	public List<ForumTopic> getListForumTopicByIdForum(Long idForum) {
		logger.info("ForumTopicService:List forum topic load by id forum");
		return forumTopicDAO.getListForumTopicByIdForum(idForum);
	}
	
	public List<ForumTopic> getListForumTopicCreateBetweenDateByIdForum(Long idForum, LocalDateTime minDateLDT,
			LocalDateTime maxDateLDT) {
		
		Date minDateD = converter.convertLocalDateTimeToDate(minDateLDT);
		Date maxDateD = converter.convertLocalDateTimeToDate(maxDateLDT);
		logger.info("ForumTopicService:List forum topic which create between dates load by id forum");
		
		return forumTopicDAO.getListForumTopicCreateBetweenDateByIdForum(idForum, minDateD, maxDateD);
	}
	
	public int getCountForumTopic(Long idForum) {
		logger.info("ForumTopicService:Count forum topic load by idforum");
		return forumTopicDAO.getCountForumTopic(idForum);
	}
}
