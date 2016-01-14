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

import com.dancosoft.socialcommunity.dao.GroupMessageDAO;
import com.dancosoft.socialcommunity.dao.support.TimeConverter;
import com.dancosoft.socialcommunity.model.Account;
import com.dancosoft.socialcommunity.model.GroupMessage;
import com.dancosoft.socialcommunity.service.GroupMessageService;

/**
 * <p>The class GroupMessageServiceImpl use Service pattern which describes business
 * logic SocialCommunity application. Service layer perform link between,
 * presentation layer and DAO layer(GroupMessageDAO).This layer is the main role
 * becouse layer contents(set of methods in classes) affect on functionality of
 * all application. This class contain methods which describes specific
 * operation for GroupMessage.This class perform service layer to GroupMessage.Class
 * extend base class CommonEntityServiceImpl and implement GroupMessageService
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
@Service(value="groupMessageService")
public class GroupMessageServiceImpl implements GroupMessageService {

	private static final Logger logger = LoggerFactory.getLogger(GroupMessageServiceImpl.class);
	
	TimeConverter converter = new TimeConverter();
	
	@Autowired
	@Qualifier(value="groupMessageDAO")
	private GroupMessageDAO groupMessageDAO;

	public void setGroupMessageDAO(GroupMessageDAO groupMessageDAO) {
		this.groupMessageDAO = groupMessageDAO;
	}
	
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
	public Account getMemberAccountByIdGroupMessage(Long idGroupMessage) {
		
		Account account= null;
		if (idGroupMessage.equals(null) || idGroupMessage.equals("")) {
			throw new RuntimeException("GroupMessageService:Id group messages must not null or empty");
		} else{
			try {
				logger.info("GroupMessageService:User account load by id user group message");
				account=groupMessageDAO.getMemberAccountByIdGroupMessage(idGroupMessage);	
				
			}  catch (DataRetrievalFailureException rf) {
				logger.warn("GroupMessageService: Member account which create group"
						+ " message not exist with idGroupMessage." + rf);
				
			} catch (DataAccessException da) {
				logger.error("GroupMessageService:Exeption connect with data base or other error= "+da);
			}
		}
		return account;
	}
	
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
	public List<GroupMessage> getListGroupMessageByIdAccountGroup(Long idAccountGroup) {
		
		List<GroupMessage> list=Collections.emptyList();
		if (idAccountGroup.equals(null) || idAccountGroup.equals("")) {
			throw new RuntimeException("GroupMessageService:Id group messages must not null or empty");
			
		} else{
			try {
				logger.info("GroupMessageService:List group message load by id account group");
				list= groupMessageDAO.getListGroupMessageByIdAccountGroup(idAccountGroup);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("GroupMessageService: List group message load, but list is empty." + rf);
				
			} catch (DataAccessException da) {
				logger.error("GroupMessageService:Exeption connect with data base or other error= "+da);
			}
		}
		return list;
	}
	
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
			Long idAccountGroup, LocalDateTime minDateLDT, LocalDateTime maxDateLDT) {

		List<GroupMessage> list = Collections.emptyList();
		Date minDateD;
		Date maxDateD;
		if (idAccountGroup.equals(null) || idAccountGroup.equals("")) {
			throw new RuntimeException("ForumMessageService:Id account group must not null or empty.");
			
		} else if (maxDateLDT.isBefore(minDateLDT)) {
			throw new RuntimeException("ForumMessageService: Max date must not before min date!");

		} else {
			try {
				minDateD = converter.convertLocalDateTimeToDate(minDateLDT);
				maxDateD = converter.convertLocalDateTimeToDate(maxDateLDT);
				logger.info("GroupMessageService:List group message which"
						+ " creete between date load by id account group");
				list = groupMessageDAO.getListGroupMessageBeetweenDateByIdAccountGroup(idAccountGroup, minDateD, maxDateD);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("GroupMessageService: List group message which create between"
						+ " date load, but list is empty." + rf);
				
			} catch (DataAccessException da) {
				logger.error("GroupMessageService:Exeption connect with data base or other error= "+da);
			}
		}
		return list;
	}
	
	/**
	 * Method return count of group messages. If group messages are
	 * not exist return zero.
	 * 
	 * @type int
	 * @param idAccountGroup
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return int 
	 */
	public int getCountGroupMessageByIdAccountGroup(Long idAccountGroup) {
		
		int count=0;
		if (idAccountGroup.equals(null) || idAccountGroup.equals("")) {
			throw new RuntimeException("ForumMessageService:Id account group must not null or empty.");
		}else{
			try {
				logger.info("GroupMessageService:Count group message load for account group.");
				count=groupMessageDAO.getCountGroupMessageByIdAccountGroup(idAccountGroup);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("GroupMessageService: Count of group messages load for account group"
						+ ", but is equals zero." + rf);
				
			} catch (DataAccessException da) {
				logger.error("GroupMessageService:Exeption connect with data base or other error= "+da);
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
	 * @param idGroupMessage
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return GroupMessage
	 */
	public GroupMessage getGroupMessageById(Long idGroupMessage) {
		
		GroupMessage groupMessage = null;
		if (idGroupMessage.equals(null) || idGroupMessage.equals("")) {
			throw new RuntimeException("GroupMessageService:Id entity is null");
		} else {
			try {
				groupMessage = (GroupMessage) groupMessageDAO.getEntityById(idGroupMessage);
				logger.info("GroupMessageService:Entity loaded successfully id=" + idGroupMessage);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("GroupMessageService:Not found entity in data base=" + rf);
		
			} catch (DataAccessException da) {
				logger.error("GroupMessageService:Exeption connect with data base or other error= "+da);
			}
		}
		return groupMessage;
	}
	
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
	public void saveGroupMessage(GroupMessage groupMessage) {
		
		if(groupMessage.equals(null)){
			throw new RuntimeException("GroupMessageService: Entity not save becouse entity is null.");
		} else {
			try {
				groupMessageDAO.saveEntity(groupMessage);
				logger.info("GroupMessageService:Entity save successfully");
				
			} catch (TypeMismatchDataAccessException tm) {
				logger.error("GroupMessageService:New entity not save becouse mismatch field type "+tm);
				
			}catch (DataAccessException da) {
				logger.error("GroupMessageService:Exeption connect with data base or other error= "+da);
			}
		}
	}
	
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
	public void updateGroupMessage(GroupMessage groupMessage) {
		
		if (groupMessage.equals(null)) {
			throw new RuntimeException("GroupMessageService: Entity not save becouse entity is null.");
		} else {
			try {
				logger.info("GroupMessageService:Entity update successfully");
				groupMessageDAO.updateEntity(groupMessage);
				
			} catch (TypeMismatchDataAccessException tm) {
				logger.error("GroupMessageService:New entity not update becouse mismatch field type "+ tm);
				
			} catch (DataAccessException da) {
				logger.error("GroupMessageService:Exeption connect with data base or other error= "+da);
			}
		}
	}
	
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
	public void deleteGroupMessageById(Long idGroupMessage) {
		
		if (idGroupMessage.equals(null) || idGroupMessage.equals("")) {
			throw new RuntimeException("GroupMessageService:Id entity is null");
		} else{
			try {
				logger.info("GroupMessageService:Entity delete successfully,id=" + idGroupMessage);
				groupMessageDAO.deleteEntityById(idGroupMessage);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("GroupMessageService: Operation delete is faled becouse"
						+ " not found entity in data base by id=" + rf);
				
			} catch (DataAccessException da) {
				logger.error("GroupMessageService:Exeption connect with data base or other error= "+da);
			}
		}
	}
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method delete entity if entity not null.
	 * 
	 * @type GroupMessage
	 * @param groupMessage
	 * 
	 * @exception DataAccessException
	 */
	public void deleteGroupMessage(GroupMessage groupMessage) {
		
		if (groupMessage.equals(null)) {
			throw new RuntimeException("GroupMessageService: Object is "+groupMessage+ " yet and not delete again.");
		}else{
			try {
				logger.info("GroupMessageService:Entity " + groupMessage + " delete successfully");
				groupMessageDAO.deleteEntity(groupMessage);
				
			} catch (DataAccessException da) {
				logger.error("EntityService:Exeption connect with data base or other error= "+da);
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
	public List<Object> getListGroupMessage() {
		
		List<Object>list=Collections.emptyList();
		try {
			logger.info("GroupMessageService: List of entity load");
			list=groupMessageDAO.getListEntity();
			
		} catch (DataRetrievalFailureException rf) {
			logger.warn("GroupMessageService: List of entity not load becouse list is empty=" + rf);
			
		}catch (DataAccessException da) {
			logger.error("GroupMessageService:Exeption connect with data base or other error= "+da);
		}
		return list;
	}
}
