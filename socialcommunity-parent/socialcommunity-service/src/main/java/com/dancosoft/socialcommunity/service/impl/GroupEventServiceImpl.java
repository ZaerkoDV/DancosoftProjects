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
import org.springframework.dao.TypeMismatchDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dancosoft.socialcommunity.dao.GroupEventDAO;
import com.dancosoft.socialcommunity.dao.support.TimeConverter;
import com.dancosoft.socialcommunity.model.Account;
import com.dancosoft.socialcommunity.model.GroupEvent;
import com.dancosoft.socialcommunity.service.GroupEventService;

/**
 * <p>The class GroupEventServiceImpl use Service pattern which describes business
 * logic SocialCommunity application. Service layer perform link between,
 * presentation layer and DAO layer(GroupEventDAO).This layer is the main role
 * becouse layer contents(set of methods in classes) affect on functionality of
 * all application. This class contain methods which describes specific
 * operation for GroupEvent.This class perform service layer to GroupEvent.Class
 * extend base class CommonEntityServiceImpl and implement GroupEventService
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
@Service(value="groupEventService")
public class GroupEventServiceImpl implements GroupEventService {

	private static final Logger logger = LoggerFactory.getLogger(GroupEventServiceImpl.class);
	
	TimeConverter converter = new TimeConverter();
	
	@Autowired
	@Qualifier(value="groupEventDAO")
	private GroupEventDAO groupEventDAO;

	public void setGroupEventDAO(GroupEventDAO groupEventDAO) {
		this.groupEventDAO = groupEventDAO;
	}
	
	/**
	 * Method return group member account by id group event. Account
	 * ovner create this group event. If member is not exist return null
	 * 
	 * @type Long
	 * @param idGroupEvent
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception NonUniqueResultException 
	 * @exception DataAccessException
	 * 
	 * @return Account
	 */
	@Transactional
	public Account getMemberAccountByIdGroupEvent(Long idGroupEvent) {
		
		Account account= null;
		if (idGroupEvent.equals(null) || idGroupEvent.equals("")) {
			throw new RuntimeException("GroupEventService:Id group event must not null or empty.");
			
		} else{
			try {
				logger.info("GroupEventService:User account load by id user group event.");
				account= groupEventDAO.getMemberAccountByIdGroupEvent(idGroupEvent);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("GroupEventService: GroupMember(account) which created"
						+ " group event not exist with idGroupEvent " + rf);
			
			}catch (NonUniqueResultException nu) {
					logger.error("GroupEventService:Account load by id group event but is not unique." + nu);
					
			}catch (DataAccessException da) {
				logger.error("GroupEventService:Exeption connect with data base or other error= "+da);
			}
		}
		return account;
	}
	
	/**
	 * Method return list of group event by id account group. If group event is
	 * not exist return empty list.
	 * 
	 * @type Long
	 * @param idAccountGroup
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return List<GroupEvent>
	 */
	@Transactional
	public List<GroupEvent> getListGroupEventByIdAccountGroup(Long idAccountGroup) {
		
		List<GroupEvent> list=Collections.emptyList();
		if (idAccountGroup.equals(null) || idAccountGroup.equals("")) {
			throw new RuntimeException("GroupEventService:Id account group must not null or empty.");
			
		} else{
			try {
				logger.info("GroupEventService:List group event load by id account group");
				list= groupEventDAO.getListGroupEventByIdAccountGroup(idAccountGroup);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("GroupEventService: List group event load by id account group. But list is empty" + rf);
				
			} catch (DataAccessException da) {
				logger.error("GroupEventService:Exeption connect with data base or other error= "+da);
			}
		}
		return list;
	}
	
	/**
	 * Method return list of group event which created berween min and max date by id
	 * account group. If group event is not exist return empty list.
	 * 
	 * @type Long
	 * @param idAccountGroup
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return List<GroupEvent>
	 */
	@Transactional
	public List<GroupEvent> getListGroupEventBeetweenDateByIdAccountGroup(Long idAccountGroup,Date  minDate, Date maxDate) {
		
		LocalDateTime minDateLTD=converter.convertDateToLocalDateTime(minDate);
		LocalDateTime maxDateLTD=converter.convertDateToLocalDateTime(maxDate);
		List<GroupEvent> list=Collections.emptyList();
		if (idAccountGroup.equals(null) || idAccountGroup.equals("")) {
			throw new RuntimeException("GroupEventService:Id account group must not null or empty.");
			
		} else if(maxDateLTD.isBefore(minDateLTD)){
			throw new RuntimeException("GroupEventService: Max date must not before min date!");
			
		} else {
			try {
				logger.info("GroupEventService:List group event which creete between date load by id account group");
				list= groupEventDAO.getListGroupEventBeetweenDateByIdAccountGroup(idAccountGroup, minDate, maxDate);

			} catch (DataRetrievalFailureException rf) {
				logger.warn("GroupEventService: List group event which created between date load for"
						+ " account group. But list is empty" + rf);
				
			} catch (DataAccessException da) {
				logger.error("GroupEventService:Exeption connect with data base or other error= "+da);
			}
		}
		return list;
	}
	
	/**
	 * Method return count of group event by id account group. If account group
	 * is not contain event return zero
	 * 
	 * @type Long
	 * @param idAccountGroup
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return int
	 */
	@Transactional
	public int getCountGroupEventByIdAccountGroup(Long idAccountGroup) {
		
		int count=0;
		if (idAccountGroup.equals(null) || idAccountGroup.equals("")) {
			throw new RuntimeException("GroupEventService:Id account group must not null or empty.");
		} else {
			try {
				logger.info("GroupEventService:Count group event load for account group");
				count= groupEventDAO.getCountGroupEventByIdAccountGroup(idAccountGroup);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("GroupEventService: Count of group event for group load. But count is equals zero." + rf);
				
			} catch (DataAccessException da) {
				logger.error("GroupEventService:Exeption connect with data base or other error= "+da);
			}
		}
		return count;
	}
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method return entity by idEntity. If entity not exist return null(use
	 * hibernateTamplate method get)
	 * 
	 * @type Long
	 * @param idGroupEvent
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return GroupEvent
	 */
	@Transactional
	public GroupEvent getGroupEventById(Long idGroupEvent) {
		
		GroupEvent groupEvent = null;
		if (idGroupEvent.equals(null) || idGroupEvent.equals("")) {
			throw new RuntimeException("GroupEventService:Id entity is null");
		} else {
			try {
				groupEvent = (GroupEvent) groupEventDAO.getEntityById(idGroupEvent);
				logger.info("GroupEventService:Entity loaded successfully id=" + idGroupEvent);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("GroupEventService:Not found entity in data base=" + rf);
				
			} catch (DataAccessException da) {
				logger.error("GroupEventService:Exeption connect with data base or other error= "+da);
			}
		}
		return groupEvent;
	}
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method save entity if entity not null.
	 * 
	 * @type GroupEvent
	 * @param groupEvent
	 * 
	 * @exception TypeMismatchDataAccessException
	 * @exception DataAccessException
	 */
	@Transactional
	public void saveGroupEvent(GroupEvent groupEvent) {
		
		if(groupEvent.equals(null)){
			throw new RuntimeException("GroupEventService: Entity not save becouse entity is null.");
		} else {
			try {
				groupEventDAO.saveEntity(groupEvent);
				logger.info("GroupEventService:Entity save successfully");
				
			} catch (TypeMismatchDataAccessException tm) {
				logger.error("GroupEventService:New entity not save becouse mismatch field type "+tm);
				
			}catch (DataAccessException da) {
				logger.error("GroupEventService:Exeption connect with data base or other error= "+da);
			}
		}
	}
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method update entity if entity not null.
	 * 
	 * @type GroupEvent
	 * @param groupEvent
	 * 
	 * @exception TypeMismatchDataAccessException
	 * @exception DataAccessException
	 */
	@Transactional
	public void updateGroupEvent(GroupEvent groupEvent) {
		
		if (groupEvent.equals(null)) {
			throw new RuntimeException("GroupEventService: Entity not save becouse entity is null.");
		} else {
			try {
				logger.info("GroupEventService:Entity update successfully");
				groupEventDAO.updateEntity(groupEvent);
				
			} catch (TypeMismatchDataAccessException tm) {
				logger.error("GroupEventService:New entity not update becouse mismatch field type "+ tm);
				
			} catch (DataAccessException da) {
				logger.error("GroupEventService:Exeption connect with data base or other error= "+da);
			}
		}
	}
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method delete entity by id if entity not null.
	 * 
	 * @type Long
	 * @param idGroupEvent
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 */
	@Transactional
	public void deleteGroupEventById(Long idGroupEvent) {
		
		if (idGroupEvent.equals(null) || idGroupEvent.equals("")) {
			throw new RuntimeException("GroupEventService:Id entity is null");
		} else{
			try {
				logger.info("EntityService:Entity  delete successfully,id=" + idGroupEvent);
				groupEventDAO.deleteEntityById(idGroupEvent);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("GroupEventService: Operation delete is faled becouse"
						+ " not found entity in data base by id=" + rf);
				
			} catch (DataAccessException da) {
				logger.error("GroupEventService:Exeption connect with data base or other error= "+da);
			}
		}
	}
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method delete entity if entity not null.
	 * 
	 * @type GroupEvent
	 * @param groupEvent
	 * 
	 * @exception DataAccessException
	 */
	@Transactional
	public void deleteGroupEvent(GroupEvent groupEvent) {
		
		if (groupEvent.equals(null)) {
			throw new RuntimeException("GroupEventService: Object is "+groupEvent+ " yet and not delete again.");
		}else{
			try {
				logger.info("GroupEventService:Entity " + groupEvent + " delete successfully");
				groupEventDAO.deleteEntity(groupEvent);
				
			} catch (DataAccessException da) {
				logger.error("GroupEventService:Exeption connect with data base or other error= "+da);
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
	@Transactional
	public List<Object> getListGroupEvent() {
		
		List<Object>list=Collections.emptyList();
		try {
			logger.info("GroupEventService: List of entity load");
			list=groupEventDAO.getListEntity();
			
		} catch (DataRetrievalFailureException rf) {
			logger.warn("GroupEventService: List of entity not load becouse list is empty=" + rf);
			
		}catch (DataAccessException da) {
			logger.error("GroupEventService:Exeption connect with data base or other error= "+da);
		}
		return list;
	}
}
