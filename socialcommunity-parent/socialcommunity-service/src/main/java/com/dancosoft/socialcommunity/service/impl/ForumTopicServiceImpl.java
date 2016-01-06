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

import com.dancosoft.socialcommunity.dao.ForumTopicDAO;
import com.dancosoft.socialcommunity.dao.support.TimeConverter;
import com.dancosoft.socialcommunity.model.Account;
import com.dancosoft.socialcommunity.model.ForumMessage;
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
		
		Account account=null;
		if (idForumTopic.equals(null) || idForumTopic.equals("")) {
			throw new RuntimeException("ForumTopicService:Id Forum topic must not null");
		} else{
			try {
				logger.info("ForumTopicService:Author account which create topic load by id forum topic");
				account=forumTopicDAO.getAuthorAccountForumTopic(idForumTopic);
	
			} catch (DataRetrievalFailureException rf) {
				logger.warn("ForumTopicService: Author(account) which"
						+ " created forum topic not exist by id forum topic." + rf);
				
			} catch (DataAccessException da) {
				logger.error("ForumTopicService:Exeption connect with data base or other error= "+da);
			}
		}
		return account;
	}
	
	public List<ForumTopic> getListForumTopicByIdForum(Long idForum) {
		
		List<ForumTopic> list=Collections.emptyList();
		if (idForum.equals(null) || idForum.equals("")) {
			throw new RuntimeException("ForumTopicService:Id Forum must not null or empty.");
		} else{
			try {
				logger.info("ForumTopicService:List forum topic load by id forum");
				list=forumTopicDAO.getListForumTopicByIdForum(idForum);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("ForumTopicService: List forum topic for forum load, but list is empty." + rf);
				
			} catch (DataAccessException da) {
				logger.error("ForumTopicService:Exeption connect with data base or other error= "+da);
			}
		}
		return list;
	}
	
	public List<ForumTopic> getListForumTopicCreateBetweenDateByIdForum(Long idForum, LocalDateTime minDateLDT,
			LocalDateTime maxDateLDT) {
		Date minDateD;
		Date maxDateD;
		List<ForumTopic> list=Collections.emptyList();
		
		if (idForum.equals(null) || idForum.equals("")) {
			throw new RuntimeException("ForumTopicService:Id Forum must not null or empty");
			
		} else if(maxDateLDT.isBefore(minDateLDT)){
			throw new RuntimeException("ForumTopicService: Max date must not before min date!");
			
		}else{
			try {
				minDateD = converter.convertLocalDateTimeToDate(minDateLDT);
				maxDateD = converter.convertLocalDateTimeToDate(maxDateLDT);
				logger.info("ForumTopicService:List forum topic which create"
						+ " between date load by id forum");
				list= forumTopicDAO.getListForumTopicCreateBetweenDateByIdForum(idForum, minDateD, maxDateD);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("ForumTopicService: List of forum messages load but list is empty=" + rf);
				
			}catch (DataAccessException da) {
				logger.error("ForumTopicService:Exeption connect with data base or other error= "+da);
			}
		}
		return list;
	}
	
	public int getCountForumTopic(Long idForum) {

		int count = 0;
		if (idForum.equals(null) || idForum.equals("")) {
			throw new RuntimeException("ForumTopicService:Id Forum must not null or empty");
		} else {
			try {
				logger.info("ForumTopicService:Count forum topic load by idforum");
				count=forumTopicDAO.getCountForumTopic(idForum);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("ForumTopicService: Count forum topic load by id forum but is equals zero." + rf);
				
			}catch (DataAccessException da) {
				logger.error("ForumTopicService:Exeption connect with data base or other error= "+da);
			}
		}
		return count;
	}
}
