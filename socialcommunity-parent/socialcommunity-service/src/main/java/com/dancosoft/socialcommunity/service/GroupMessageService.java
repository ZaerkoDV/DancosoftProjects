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

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.dao.TypeMismatchDataAccessException;

import com.dancosoft.socialcommunity.model.Account;
import com.dancosoft.socialcommunity.model.GroupMessage;

/**
 * <p>The interface GroupMessageService contain methods ads which realize in class
 * GroupMessageServiceImpl. Class GroupMessageServiceImpl use Service pattern which
 * describes service layer of application. This class contain general operation
 * to all classes.This interface contain ads methods which perform busness logic
 * all application. Interface extend CommonEntityService interface which contain
 * ads base operation of any entity.
 * 
 * @version 1.0 08.10.2015
 * @author Zaerko Denis
 */
public interface GroupMessageService {

	/**
	 * Method return member account by id message which user create in account group.
	 * If account member is not exist return null.
	 * 
	 * @type Long
	 * @param idGroupMessage
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return Account
	 */
	public Account getMemberAccountByIdGroupMessage(Long idGroupMessage);

	/**
	 * Method return list of group message which belong to account group by id account group.
	 * If group message are not exist return empty list.
	 * 
	 * @type Long
	 * @param idAccountGroup
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return List<GroupMessage>
	 */
	public List<GroupMessage> getListGroupMessageByIdAccountGroup(Long idAccountGroup);

	/**
	 * Method return list of group message which belong to account group and which create
	 * between date by id account group. If group message are not exist return empty list.
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
	 * @return List<GroupMessage> 
	 */
	public List<GroupMessage> getListGroupMessageBeetweenDateByIdAccountGroup(
			Long idAccountGroup, LocalDateTime minDateLDT,
			LocalDateTime maxDateLDT);

	/**
	 * Method return count of group messages. If group messages are
	 * not exist return zero.
	 * 
	 * @type int
	 * @param idAccountGroup
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return int 
	 */
	public int getCountGroupMessageByIdAccountGroup(Long idAccountGroup);
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method return entity by idEntity. If entity not exist return null(use
	 * hibernateTamplate method get)
	 * 
	 * @type Long
	 * @param idGroupMessage
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return GroupMessage
	 */
	public GroupMessage getGroupMessageById(Long idGroupMessage);
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method save entity if entity not null.
	 * 
	 * @type GroupMessage
	 * @param groupMessage
	 * 
	 * @exception TypeMismatchDataAccessException
	 * @exception DataAccessException
	 */
	public void saveGroupMessage(GroupMessage groupMessage);
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method update entity if entity not null.
	 * 
	 * @type GroupMessage
	 * @param groupMessage
	 * 
	 * @exception TypeMismatchDataAccessException
	 * @exception DataAccessException
	 */
	public void updateGroupMessage(GroupMessage groupMessage);
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method delete entity by id if entity not null.
	 * 
	 * @type Long
	 * @param idGroupMessage
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 */
	public void deleteGroupMessageById(Long idGroupMessage);
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method delete entity if entity not null.
	 * 
	 * @type GroupMessage
	 * @param groupMessage
	 * 
	 * @exception DataAccessException
	 */
	public void deleteGroupMessage(GroupMessage groupMessage);
	
	/**
	 * This method is basic for all entities. Method return list of entity. If entyty
	 * list not load return empty list.
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return List<Object>
	 */
	public List<Object> getListGroupMessage();
	
		
	
	
	
}
