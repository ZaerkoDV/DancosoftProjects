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
		
		List<Forum> list=Collections.emptyList();
		Date minDateD;
		Date maxDateD;
		
		if(maxDateLDT.isBefore(minDateLDT)){
			throw new RuntimeException("ForumService: Max date must not before min date!");
			
		}else{
			try {
				minDateD = converter.convertLocalDateTimeToDate(minDateLDT);
				maxDateD = converter.convertLocalDateTimeToDate(maxDateLDT);
				logger.info("ForumService:List forum which create between date load.");
				list=forumDAO.getListForumCreatedBetweenDateByIdForum(minDateD, maxDateD);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("ForumService: No one forum created between date. List forum is empty=" + rf);
				
			}catch (DataAccessException da) {
				logger.error("ForumService:Exeption connect with data base or other error= "+da);
			}
		}
		return list;
	}
	
	public int getCountForum() {
		
		int count = 0;
		try {
			logger.info("ForumService: Count of forums.");
			count= forumDAO.getCountForum();
		} catch (DataAccessException da) {
			logger.error("ForumService:Exeption connect with data base or other error= "+da);
		}
		return count;
	}
	
	public List<Forum> searchForumByForumName(String forumName) {
		
		List<Forum> list=Collections.emptyList();
		if(forumName.equals(null) || forumName.equals("")){
			throw new RuntimeException("ForumService: Forum name must not null or empty!");
			
		}else{
			try {
				logger.info("ForumService:List forum load by name.");
				list= forumDAO.searchForumByForumName(forumName);
				
			}catch (DataRetrievalFailureException rf) {
				logger.warn("ForumService: Operation search forum by name completed. List forum is empty=" + rf);
				
			}catch (DataAccessException da) {
				logger.error("ForumService:Exeption connect with data base or other error= "+da);
			}
		}
		return list;
	}
	
	public List<Forum> getListForumWithStatus(String viewStatus) {
		
		List<Forum> list=Collections.emptyList();
		if(viewStatus.equals(null) || viewStatus.equals("")){
			throw new RuntimeException("ForumService: Forum view status must not null or empty!");
			
		}else{
			try {
				logger.info("ForumService:List forum load by view status "+viewStatus+" .");
				return forumDAO.getListForumWithStatus(viewStatus);
				
			}catch (DataRetrievalFailureException rf) {
				logger.warn("ForumService: Operation search forum by view status "+viewStatus+". List forum is empty=" + rf);
				
			}catch (DataAccessException da) {
				logger.error("ForumService:Exeption connect with data base or other error= "+da);
			}
		}
		return list;
	}
	
	public Boolean isPrivateForum(Long idForum) {
		
		Boolean isPrivateForum=null;
		if(idForum.equals(null) || idForum.equals("")){
			throw new RuntimeException("ForumService:Id forum must not null or empty!");
			
		}else{
			try {
				logger.info("ForumService:Check forum on private status");
				isPrivateForum= forumDAO.isPrivateForum(idForum);
				
			} catch (DataRetrievalFailureException rf) {
				logger.error("ForumService: Forum with id "+idForum+" not exist." + rf);
				
			}catch (DataAccessException da) {
				logger.error("ForumService:Exeption connect with data base or other error= "+da);
			}
		}
		return isPrivateForum;
	}
}
