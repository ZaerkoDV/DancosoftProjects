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

import javax.persistence.NonUniqueResultException;

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
import com.dancosoft.socialcommunity.model.ForumTopic;
import com.dancosoft.socialcommunity.service.ForumTopicService;

/**
 * <p>
 * The class ForumTopicServiceImpl use Service pattern which describes business
 * logic SocialCommunity application. Service layer perform link between,
 * presentation layer and DAO layer(ForumTopicDAO).This layer is the main role
 * becouse layer contents(set of methods in classes) affect on functionality of
 * all application. This class contain methods which describes specific
 * operation for ForumTopic.This class perform service layer to ForumTopic.Class
 * extend base class CommonEntityServiceImpl and implement ForumTopicService
 * interface which perform all methods of this class. For logging use fasade
 * slf4j and framework log4j. Class contain also private, static variable
 * logger, which use to call log message. Class use Spring framework anatations
 * to work with service layer.
 * 
 * @see org.springframework.stereotype
 * @see slf4j framework
 * @see log4j framework
 * 
 * @version 1.0 05.01.2016
 * @author Zaerko Denis
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
	
	/**
	 * Method return account(author) which create forum topic by id forum topic.
	 * If author not exist return null  
	 * 
	 * @type Long
	 * @param idForumTopic
	 * 
	 * @exception DataRetrievalFailureException 
	 * @exception NonUniqueResultException
	 * @exception DataAccessException
	 * 
	 * @return Account
	 */
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
				
			} catch (NonUniqueResultException nu) {
				logger.error("ForumTopicService:Account load by id forum topic but is not unique." + nu);
				
			} catch (DataAccessException da) {
				logger.error("ForumTopicService:Exeption connect with data base or other error= "+da);
			}
		}
		return account;
	}
	
	/**
	 * Method return list of forum topic which belong forum. If forum
	 * topic not exist return empty list.
	 * 
	 * @type Long
	 * @param idForum
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return List<ForumTopic>
	 */
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
	
	/**
	 * Method return list of forum topic which created between minDate and maxDate by forum id.
	 * If forum topic not exist return empty list.
	 * 
	 * @type Long
	 * @type Date
	 * @param idForum
	 * @param minDate
	 * @param maxDate
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return List<ForumTopic>
	 */
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
				logger.info("ForumTopicService:List forum topic which create between date load by id forum");
				list= forumTopicDAO.getListForumTopicCreateBetweenDateByIdForum(idForum, minDateD, maxDateD);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("ForumTopicService: List of forum messages load but list is empty=" + rf);
				
			}catch (DataAccessException da) {
				logger.error("ForumTopicService:Exeption connect with data base or other error= "+da);
			}
		}
		return list;
	}
	
	/**
	 * Method return count of forum topic which belong to forum.
	 * 
	 * @type Long
	 * @param idForum
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return int
	 */
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
