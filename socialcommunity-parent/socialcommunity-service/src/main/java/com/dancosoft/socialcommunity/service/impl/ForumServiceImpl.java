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

import com.dancosoft.socialcommunity.dao.ForumDAO;
import com.dancosoft.socialcommunity.dao.support.TimeConverter;
import com.dancosoft.socialcommunity.model.Forum;
import com.dancosoft.socialcommunity.service.ForumService;

/**
 * @author Zaerko_DV
 *
 */
@Service(value="forumService")
public class ForumServiceImpl extends CommonEntityServiceImpl implements ForumService {
	
	private static final Logger logger = LoggerFactory.getLogger(ForumServiceImpl.class);
	
	TimeConverter converter = new TimeConverter();
	
	@Autowired
	@Qualifier(value="forumDAO")
	private ForumDAO forumDAO;

	public void setForumDAO(ForumDAO forumDAO) {
		this.forumDAO = forumDAO;
	}
	
	public List<Forum> getListForumCreatedBetweenDateByIdForum(LocalDateTime minDateLDT,LocalDateTime maxDateLDT) {
		
		Date minDateD = converter.convertLocalDateTimeToDate(minDateLDT);
		Date maxDateD = converter.convertLocalDateTimeToDate(maxDateLDT);
		logger.info("ForumService:List forum which create between date load.");
		
		return forumDAO.getListForumCreatedBetweenDateByIdForum(minDateD, maxDateD);
	}
	
	public int getCountForum() {
		logger.info("ForumService: Count of forums.");
		return forumDAO.getCountForum();
	}
	
	public List<Forum> searchForumByForumName(String forumName) {
		logger.info("ForumService:List forum load by name.");
		return forumDAO.searchForumByForumName(forumName);
	}
	
	public List<Forum> getListForumWithStatus(String viewStatus) {
		logger.info("ForumService:List forum load by view status.");
		return forumDAO.getListForumWithStatus(viewStatus);
	}
	
	public Boolean isPrivateForum(Long idForum) {
		logger.info("ForumService:Check forum on public status");
		return forumDAO.isPrivateForum(idForum);
	}
}
