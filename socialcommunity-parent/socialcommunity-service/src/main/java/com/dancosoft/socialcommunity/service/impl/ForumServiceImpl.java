/**
 * @package com.dancosoft.socialcommunity.service.impl
 * 
 * Package com.dancosoft.socialcommunity.service.impl contain set of class which description
 * service layer(modul) in SocialCommunity project. This project based on MVC architecture.
 * This class is part of service layer in MVC architecture.This layer defines the boundary
 * of the application and a set of permitted operations. It encapsulates the business logic
 * of the application and controls the answers in the implementation of operations.All classes
 * which contain postfix “Service” provide to work Service for SocialCommunity application.
 * Also this package user support classes: for generate new passworl and login,for sending
 * email to user and other from com.dancosoft.socialcommunity.service.support package.
 * 
 * Please contact with Zaerko Denis or send letter on zaerko1991@gmail.com if you need
 * to use information or have any questions.   
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
import org.springframework.dao.TypeMismatchDataAccessException;
import org.springframework.stereotype.Service;

import com.dancosoft.socialcommunity.dao.ForumDAO;
import com.dancosoft.socialcommunity.dao.support.TimeConverter;
import com.dancosoft.socialcommunity.model.Forum;
import com.dancosoft.socialcommunity.service.ForumService;

/**
 * <p>The class ForumServiceImpl use Service pattern which describes
 * business logic SocialCommunity application. Service layer perform link
 * between, presentation layer and DAO layer(ForumDAO).This layer is the
 * main role becouse layer contents(set of methods in classes) affect on
 * functionality of all application. This class contain methods which describes
 * specific operation for Forum.This class perform service layer to
 * Forum.Class extend base class CommonEntityServiceImpl and implement
 * ForumService interface which perform all methods of this class. For
 * logging use fasade slf4j and framework log4j. Class contain also private,
 * static variable logger, which use to call log message. Class use Spring
 * framework anatations to work with service layer.
 * 
 * @see org.springframework.stereotype
 * @see slf4j framework
 * @see log4j framework
 * 
 * @version 1.0 05.01.2016
 * @author Zaerko Denis
 */
@Service(value="forumService")
public class ForumServiceImpl implements ForumService {
	
	private static final Logger logger = LoggerFactory.getLogger(ForumServiceImpl.class);
	
	TimeConverter converter = new TimeConverter();
	
	@Autowired
	@Qualifier(value="forumDAO")
	private ForumDAO forumDAO;

	public void setForumDAO(ForumDAO forumDAO) {
		this.forumDAO = forumDAO;
	}
	
	/**
	 * Method return list forum which crated between dates. If forums
	 * are not exist return empty list.
	 * 
	 * @type Date
	 * @param minDate
	 * @param maxDate
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return List<Forum>
	 */
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
	
	/**
	 * Method return total count of forums. If forums are not exist return zero. 
	 * 
	 * @type int
	 * @exception DataAccessException
	 * 
	 * @return int
	 */
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
	
	/**
	 * Method return list forum by forum name. If forums are not
	 * exist return empty list
	 * 
	 * @type String 
	 * @param forumName
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return List<Forum>
	 */
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
	
	/**
	 * Method return list forum with view status. If forums are not
	 * exist return empty list.
	 * 
	 * @type String 
	 * @param viewStatus
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return List<Forum>
	 */
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
	
	/**
	 * Method return result of check forum on private view status.
	 * 
	 * @type Long
	 * @type Boolean
	 * @param idForum
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return Boolean
	 */
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
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method return entity by idEntity. If entity not exist return null(use
	 * hibernateTamplate method get)
	 * 
	 * @type Long
	 * @param idForum
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return Forum
	 */
	public Forum getForumById(Long idForum) {
		
		Forum forum = null;
		if (idForum.equals(null) || idForum.equals("")) {
			throw new RuntimeException("ForumService:Id entity is null");
		} else {
			try {
				forum = (Forum) forumDAO.getEntityById(idForum);
				logger.info("ForumService:Entity loaded successfully id=" + idForum);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("ForumService:Not found entity in data base=" + rf);
				
			} catch (DataAccessException da) {
				logger.error("ForumService:Exeption connect with data base or other error= "+da);
			}
		}
		return forum;
	}
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method save entity if entity not null.
	 * 
	 * @type Forum
	 * @param forum
	 * 
	 * @exception TypeMismatchDataAccessException
	 * @exception DataAccessException
	 */
	public void saveForum(Forum forum) {
		
		if(forum.equals(null)){
			throw new RuntimeException("ForumService: Entity not save becouse entity is null.");
		} else {
			try {
				forumDAO.saveEntity(forum);
				logger.info("ForumService:Entity save successfully");
				
			} catch (TypeMismatchDataAccessException tm) {
				logger.error("ForumService:New entity not save becouse mismatch field type "+tm);
				
			}catch (DataAccessException da) {
				logger.error("ForumService:Exeption connect with data base or other error= "+da);
			}
		}
	}
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method update entity if entity not null.
	 * 
	 * @type Forum
	 * @param forum
	 * 
	 * @exception TypeMismatchDataAccessException
	 * @exception DataAccessException
	 */
	public void updateForum(Forum forum) {
		
		if (forum.equals(null)) {
			throw new RuntimeException("ForumService: Entity not save becouse entity is null.");
		} else {
			try {
				logger.info("ForumService:Entity update successfully");
				forumDAO.updateEntity(forum);
				
			} catch (TypeMismatchDataAccessException tm) {
				logger.error("ForumService:New entity not update becouse mismatch field type "+ tm);
				
			} catch (DataAccessException da) {
				logger.error("ForumService:Exeption connect with data base or other error= "+da);
			}
		}
	}
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method delete entity by id if entity not null.
	 * 
	 * @type Long
	 * @param idForum
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 */
	public void deleteForumById(Long idForum) {
		
		if (idForum.equals(null) || idForum.equals("")) {
			throw new RuntimeException("ForumService:Id entity is null");
		} else{
			try {
				logger.info("ForumService:Entity  delete successfully,id=" + idForum);
				forumDAO.deleteEntityById(idForum);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("ForumService: Operation delete is faled becouse"
						+ " not found entity in data base by id=" + rf);
				
			} catch (DataAccessException da) {
				logger.error("ForumService:Exeption connect with data base or other error= "+da);
			}
		}
	}
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method delete entity if entity not null.
	 * 
	 * @type Forum
	 * @param forum
	 * @exception DataAccessException
	 */
	public void deleteForum(Forum forum) {
		
		if (forum.equals(null)) {
			throw new RuntimeException("ForumService: Object is "+forum+ " yet and not delete again.");
		}else{
			try {
				logger.info("ForumService:Entity " + forum + " delete successfully");
				forumDAO.deleteEntity(forum);
				
			} catch (DataAccessException da) {
				logger.error("ForumService:Exeption connect with data base or other error= "+da);
			}
		}
	}
	
	/**
	 * This method is basic for all entities. Method return list of entity. If entyty
	 * list not load return empty list.
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return List<Object>
	 */
	public List<Object> getListForum() {
		
		List<Object>list=Collections.emptyList();
		try {
			logger.info("ForumService: List of entity load");
			list=forumDAO.getListEntity();
			
		} catch (DataRetrievalFailureException rf) {
			logger.warn("ForumService: List of entity not load becouse list is empty=" + rf);
			
		}catch (DataAccessException da) {
			logger.error("ForumService: Exeption connect with data base or other error= "+da);
		}
		return list;
	}
}
