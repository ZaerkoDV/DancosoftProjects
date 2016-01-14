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

import com.dancosoft.socialcommunity.dao.ForumMessageDAO;
import com.dancosoft.socialcommunity.dao.support.TimeConverter;
import com.dancosoft.socialcommunity.model.Account;
import com.dancosoft.socialcommunity.model.ForumMessage;
import com.dancosoft.socialcommunity.service.ForumMessageService;

/**
 * <p>The class ForumMessageServiceImpl use Service pattern which describes
 * business logic SocialCommunity application. Service layer perform link
 * between, presentation layer and DAO layer(ForumMessageDAO).This layer is the
 * main role becouse layer contents(set of methods in classes) affect on
 * functionality of all application. This class contain methods which describes
 * specific operation for ForumMessage.This class perform service layer to
 * ForumMessage.Class extend base class CommonEntityServiceImpl and implement
 * ForumMessageService interface which perform all methods of this class. For
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
@Service(value="forumMessageService")
public class ForumMessageServiceImpl implements ForumMessageService {
	
	private static final Logger logger = LoggerFactory.getLogger(ForumMessageServiceImpl.class);
	
	TimeConverter converter = new TimeConverter();
	
	@Autowired
	@Qualifier(value="forumMessageDAO")
	private ForumMessageDAO forumMessageDAO;

	public void setForumMessageDAO(ForumMessageDAO forumMessageDAO) {
		this.forumMessageDAO = forumMessageDAO;
	}
	
	/**
	 * Method return Account of author which create message. If account is not
	 * exist return null;
	 * 
	 * @type Long
	 * @param idForumMessage
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException 
	 * 
	 * @return Account
	 */
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
	
	/**
	 * Method return list of forum message by id forum topic. If messages are
	 * not exist return empty list
	 * 
	 * @type Long
	 * @param idForumTopic
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return List<ForumMessage>
	 */
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

	/**
	 * Method return list of forum message which create between dates by id
	 * forum topic. If messages are not exist return empty list
	 * 
	 * @type Long
	 * @param idForumTopic
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return List<ForumMessage>
	 */
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
	
	/**
	 * Method return list of forum message by idAccount(user). If Account not
	 * exist retunr null.
	 * 
	 * @type Long
	 * @param idForumTopic
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return List<ForumMessage>
	 */
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
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method return entity by idEntity. If entity not exist return null(use
	 * hibernateTamplate method get)
	 * 
	 * @type Long
	 * @param idForumMessage
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return ForumMessage
	 */
	public ForumMessage getForumMessageById(Long idForumMessage) {
		
		ForumMessage forumMessage = null;
		if (idForumMessage.equals(null) || idForumMessage.equals("")) {
			throw new RuntimeException("ForumMessageService:Id entity is null");
		} else {
			try {
				forumMessage = (ForumMessage) forumMessageDAO.getEntityById(idForumMessage);
				logger.info("ForumMessageService:Entity loaded successfully id=" + idForumMessage);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("ForumMessageService:Not found entity in data base=" + rf);
			
			} catch (DataAccessException da) {
				logger.error("ForumMessageService:Exeption connect with data base or other error= "+da);
			}
		}
		return forumMessage;
	}
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method save entity if entity not null.
	 * 
	 * @type ForumMessage
	 * @param forumMessage
	 * 
	 * @exception TypeMismatchDataAccessException
	 * @exception DataAccessException
	 */
	public void saveForumMessage(ForumMessage forumMessage) {
		
		if(forumMessage.equals(null)){
			throw new RuntimeException("ForumMessageService: Entity not save becouse entity is null.");
		} else {
			try {
				forumMessageDAO.saveEntity(forumMessage);
				logger.info("ForumMessageService:Entity save successfully");
				
			} catch (TypeMismatchDataAccessException tm) {
				logger.error("ForumMessageService:New entity not save becouse mismatch field type "+tm);
				
			}catch (DataAccessException da) {
				logger.error("ForumMessageService:Exeption connect with data base or other error= "+da);
			}
		}
	}
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method update entity if entity not null.
	 * 
	 * @type ForumMessage
	 * @param forumMessage
	 * 
	 * @exception TypeMismatchDataAccessException
	 * @exception DataAccessException
	 */
	public void updateForumMessage(ForumMessage forumMessage) {
		
		if (forumMessage.equals(null)) {
			throw new RuntimeException("ForumMessageService: Entity not save becouse entity is null.");
		} else {
			try {
				logger.info("ForumMessageService:Entity update successfully");
				forumMessageDAO.updateEntity(forumMessage);
				
			} catch (TypeMismatchDataAccessException tm) {
				logger.error("ForumMessageService:New entity not update becouse mismatch field type "+ tm);
				
			} catch (DataAccessException da) {
				logger.error("ForumMessageService:Exeption connect with data base or other error= "+da);
			}
		}
	}
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method delete entity by id if entity not null.
	 * 
	 * @type Long
	 * @param idForumMessage
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 */
	public void deleteForumMessageById(Long idForumMessage) {
		
		if (idForumMessage.equals(null) || idForumMessage.equals("")) {
			throw new RuntimeException("ForumMessageService:Id entity is null");
		} else{
			try {
				logger.info("ForumMessageService: Entity delete successfully,id=" + idForumMessage);
				forumMessageDAO.deleteEntityById(idForumMessage);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("ForumMessageService: Operation delete is faled becouse"
						+ " not found entity in data base by id=" + rf);
				
			} catch (DataAccessException da) {
				logger.error("ForumMessageService:Exeption connect with data base or other error= "+da);
			}
		}
	}
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method delete entity if entity not null.
	 * 
	 * @type ForumMessage
	 * @param forumMessage
	 * 
	 * @exception DataAccessException
	 */
	public void deleteForumMessage(ForumMessage forumMessage) {
		
		if (forumMessage.equals(null)) {
			throw new RuntimeException("ForumMessageService: Object is "+forumMessage+ " yet and not delete again.");
		}else{
			try {
				logger.info("ForumMessageService:Entity " + forumMessage + " delete successfully");
				forumMessageDAO.deleteEntity(forumMessage);
				
			} catch (DataAccessException da) {
				logger.error("ForumMessageService:Exeption connect with data base or other error= "+da);
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
	public List<Object> getListForumMessage() {
		
		List<Object>list=Collections.emptyList();
		try {
			logger.info("ForumMessageService: List of entity load");
			list=forumMessageDAO.getListEntity();
			
		} catch (DataRetrievalFailureException rf) {
			logger.warn("ForumMessageService: List of entity not load becouse list is empty=" + rf);
			
		}catch (DataAccessException da) {
			logger.error("ForumMessageService:Exeption connect with data base or other error= "+da);
		}
		return list;
	}
}
