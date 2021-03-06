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

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.dao.TypeMismatchDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dancosoft.socialcommunity.dao.EventPatternDAO;
import com.dancosoft.socialcommunity.model.EventPattern;
import com.dancosoft.socialcommunity.service.EventPatternService;

/**
 * <p> The class EventPatternServiceImpl use Service pattern which describes
 * business logic SocialCommunity application. Service layer perform link
 * between, presentation layer and DAO layer(EventPatternDAO).This layer is the
 * main role becouse layer contents(set of methods in classes) affect on
 * functionality of all application. This class contain methods which describes
 * specific operation for EventPattern.This class perform service layer to
 * EventPattern.Class extend base class CommonEntityServiceImpl and implement
 * EventPatternService interface which perform all methods of this class. For
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
@Service(value="eventPatternService")
public class EventPatternServiceImpl implements EventPatternService {

	private static final Logger logger = LoggerFactory.getLogger(EventPatternServiceImpl.class);
	
	@Autowired
	@Qualifier(value="eventPatternDAO")
	private EventPatternDAO eventPatternDAO;

	public void setEventPatternDAO(EventPatternDAO eventPatternDAO) {
		this.eventPatternDAO = eventPatternDAO;
	}
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method return entity by idEntity. If entity not exist return null(use
	 * hibernateTamplate method get)
	 * 
	 * @type Long
	 * @param idEventPattern
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return EventPattern
	 */
	@Transactional
	public EventPattern getEventPatternById(Long idEventPattern) {
		
		EventPattern eventPattern = null;
		if (idEventPattern.equals(null) || idEventPattern.equals("")) {
			throw new RuntimeException("EventPatternService:Id entity is null");
		} else {
			try {
				eventPattern = (EventPattern) eventPatternDAO.getEntityById(idEventPattern);
				logger.info("EventPatternService:Entity loaded successfully id=" + idEventPattern);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("EventPatternService:Not found entity in data base=" + rf);
			
			} catch (DataAccessException da) {
				logger.error("EventPatternService:Exeption connect with data base or other error= "+da);
			}
		}
		return eventPattern;
	}
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method save entity if entity not null.
	 * 
	 * @type EventPattern
	 * @param eventPattern
	 * 
	 * @exception TypeMismatchDataAccessException
	 * @exception DataAccessException
	 */
	@Transactional
	public void saveEventPattern(EventPattern eventPattern) {
		
		if(eventPattern.equals(null)){
			throw new RuntimeException("EventPatternService: Entity not save becouse entity is null.");
		} else {
			try {
				eventPatternDAO.saveEntity(eventPattern);
				logger.info("EventPatternService:Entity save successfully");
				
			} catch (TypeMismatchDataAccessException tm) {
				logger.error("EventPatternService:New entity not save becouse mismatch field type "+tm);
				
			}catch (DataAccessException da) {
				logger.error("EventPatternService:Exeption connect with data base or other error= "+da);
			}
		}
	}
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method update entity if entity not null.
	 * 
	 * @type EventPattern
	 * @param eventPattern
	 * 
	 * @exception TypeMismatchDataAccessException
	 * @exception DataAccessException
	 */
	@Transactional
	public void updateEventPattern(EventPattern eventPattern) {
		
		if (eventPattern.equals(null)) {
			throw new RuntimeException("EventPatternService: Entity not save becouse entity is null.");
		} else {
			try {
				logger.info("EventPatternService:Entity update successfully");
				eventPatternDAO.updateEntity(eventPattern);
				
			} catch (TypeMismatchDataAccessException tm) {
				logger.error("EventPatternService:New entity not update becouse mismatch field type "+ tm);
				
			} catch (DataAccessException da) {
				logger.error("EventPatternService:Exeption connect with data base or other error= "+da);
			}
		}
	}
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method delete entity by id if entity not null.
	 * 
	 * @type Long
	 * @param idEventPattern
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 */
	@Transactional
	public void deleteEventPatternById(Long idEventPattern) {
		
		if (idEventPattern.equals(null) || idEventPattern.equals("")) {
			throw new RuntimeException("EventPatternService: Id entity is null");
		} else{
			try {
				logger.info("EventPatternService: Entity delete successfully,id=" + idEventPattern);
				eventPatternDAO.deleteEntityById(idEventPattern);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("EventPatternService Operation delete is faled becouse"
						+ " not found entity in data base by id=" + rf);
				
			} catch (DataAccessException da) {
				logger.error("EventPatternService: Exeption connect with data base or other error= "+da);
			}
		}
	}
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method delete entity if entity not null.
	 * 
	 * @type EventPattern
	 * @param eventPattern
	 * 
	 * @exception DataAccessException
	 */
	@Transactional
	public void deleteEventPattern(EventPattern eventPattern) {
		
		if (eventPattern.equals(null)) {
			throw new RuntimeException("EventPatternService: Object is "+eventPattern+ " yet and not delete again.");
		}else{
			try {
				logger.info("EventPatternService:Entity " + eventPattern + " delete successfully");
				eventPatternDAO.deleteEntity(eventPattern);
				
			} catch (DataAccessException da) {
				logger.error("EventPatternService:Exeption connect with data base or other error= "+da);
			}
		}
	}
	
	/**
	 * This method is basic for all entities. Method return list of entity. If entity
	 * list not load return empty list.
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return List<Object>
	 */
	@Transactional
	public List<Object> getListEventPattern() {
		
		List<Object>list=Collections.emptyList();
		try {
			logger.info("EventPatternService: List of entity load");
			list=eventPatternDAO.getListEntity();
			
		} catch (DataRetrievalFailureException rf) {
			logger.warn("EventPatternService: List of entity not load becouse list is empty=" + rf);
			
		}catch (DataAccessException da) {
			logger.error("EventPatternService:Exeption connect with data base or other error= "+da);
		}
		return list;
	}
}
