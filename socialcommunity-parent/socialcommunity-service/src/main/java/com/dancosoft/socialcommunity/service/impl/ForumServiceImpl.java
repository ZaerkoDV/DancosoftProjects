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

import com.dancosoft.socialcommunity.dao.ForumDAO;
import com.dancosoft.socialcommunity.model.Forum;
import com.dancosoft.socialcommunity.service.ForumService;

/**
 * @author Zaerko_DV
 *
 */
@Service(value="forumService")
public class ForumServiceImpl extends CommonEntityServiceImpl implements ForumService {
	
	private static final Logger logger = LoggerFactory.getLogger(ForumServiceImpl.class);
	
	@Autowired
	@Qualifier(value="forumDAO")
	private ForumDAO forumDAO;

	public void setForumDAO(ForumDAO forumDAO) {
		this.forumDAO = forumDAO;
	}
	
	public List<Forum> getListForumCreatedBetweenDateByIdForum(Date minDate,Date maxDate) {
		logger.info("ForumService:List forum which create between date load.");
		return forumDAO.getListForumCreatedBetweenDateByIdForum(minDate, maxDate);
	}
	
	public int getCountForum() {
		logger.info("ForumDAO: Count of forums.");
		return forumDAO.getCountForum();
	}
	
	public List<Forum> searchForumByForumName(String forumName) {
		logger.info("ForumDAO:List forum load by name.");
		return forumDAO.searchForumByForumName(forumName);
	}
	
	public List<Forum> getListForumWithStatus(String viewStatus) {
		logger.info("ForumDAO:List forum load by view status.");
		return forumDAO.getListForumWithStatus(viewStatus);
	}
	
	public Boolean isPrivateForum(Long idForum) {
		logger.info("ForumDAO:Check forum on public status");
		return forumDAO.isPrivateForum(idForum);
	}
}
