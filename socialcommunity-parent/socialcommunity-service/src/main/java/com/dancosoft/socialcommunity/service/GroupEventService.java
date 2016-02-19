/**
 * @package com.dancosoft.socialcommunity.service
 * 
 * Package com.dancosoft.socialcommunity.service contain set of interfaces which
 * description service layer of SocialCommunity project.Also this package contain
 * realization of interfaces in package com.dancosoft.socialcommunity.service.impl
 * and support classes in com.dancosoft.socialcommunity.service.support.This project
 * is based on MVC architecture.This inerface perform class which is part of service
 * layer in MVC architecture.This layer defines the boundary of the application and
 * a set of permitted operations. It encapsulates the business logic of the application
 * and controls the answers in the implementation of operations. All classes which
 * contain postfix “Service” provide to work Service for SocialCommunity application.
 * 
 * Please contact with Zaerko Denis or send letter on zaerko1991@gmail.com if you need
 * to use information or have any questions.   
 */
package com.dancosoft.socialcommunity.service;

import java.util.Date;
import java.util.List;

import javax.persistence.NonUniqueResultException;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.dao.TypeMismatchDataAccessException;

import com.dancosoft.socialcommunity.model.Account;
import com.dancosoft.socialcommunity.model.GroupEvent;

/**
 * <p>The interface GroupEventService contain methods ads which realize in class
 * GroupEventServiceImpl. Class GroupEventServiceImpl use Service pattern which
 * describes service layer of application. This class contain general operation
 * to all classes.This interface contain ads methods which perform busness logic
 * all application. Interface extend CommonEntityService interface which contain
 * ads base operation of any entity.
 * 
 * @version 1.0 08.10.2015
 * @author Zaerko Denis
 */
public interface GroupEventService {

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
	public Account getMemberAccountByIdGroupEvent(Long idGroupEvent);

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
	public List<GroupEvent> getListGroupEventByIdAccountGroup(
			Long idAccountGroup);

	/**
	 * Method return list of group event which created berween min and max date by id
	 * account group. If group event is not exist return empty list.
	 * 
	 * @type Long
	 * @type Date
	 * @param idAccountGroup
	 * @param minDate
	 * @param maxDate
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return List<GroupEvent>
	 */
	public List<GroupEvent> getListGroupEventBeetweenDateByIdAccountGroup(Long idAccountGroup,Date minDate, Date maxDate); 

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
	public int getCountGroupEventByIdAccountGroup(Long idAccountGroup);
	
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
	public GroupEvent getGroupEventById(Long idGroupEvent);
	
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
	public void saveGroupEvent(GroupEvent groupEvent);
	
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
	public void updateGroupEvent(GroupEvent groupEvent);
	
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
	public void deleteGroupEventById(Long idGroupEvent);
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method delete entity if entity not null.
	 * 
	 * @type GroupEvent
	 * @param groupEvent
	 * 
	 * @exception DataAccessException
	 */
	public void deleteGroupEvent(GroupEvent groupEvent);
	
	/**
	 * This method is basic for all entities. Method return list of entity. If entyty
	 * list not load return empty list.
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return List<Object>
	 */
	public List<Object> getListGroupEvent();	
}
