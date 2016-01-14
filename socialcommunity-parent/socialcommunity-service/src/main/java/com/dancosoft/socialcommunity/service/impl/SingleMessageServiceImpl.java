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

import com.dancosoft.socialcommunity.dao.SingleMessageDAO;
import com.dancosoft.socialcommunity.dao.support.TimeConverter;
import com.dancosoft.socialcommunity.model.Account;
import com.dancosoft.socialcommunity.model.SingleMessage;
import com.dancosoft.socialcommunity.service.SingleMessageService;

/**
 * <p>The class SingleMessageServiceImpl use Service pattern which describes
 * business logic SocialCommunity application. Service layer perform link
 * between, presentation layer and DAO layer(SingleMessageDAO).This layer is
 * the main role becouse layer contents(set of methods in classes) affect on
 * functionality of all application. This class contain methods which describes
 * specific operation for SingleMessage.This class perform service layer to
 * SingleMessage.Class extend base class CommonEntityServiceImpl and implement
 * SingleMessageService interface which perform all methods of this class. For
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
@Service(value = "singleMessageService")
public class SingleMessageServiceImpl implements SingleMessageService {

	private static final Logger logger = LoggerFactory.getLogger(SingleMessageServiceImpl.class);

	@Autowired
	@Qualifier(value = "singleMessageDAO")
	private SingleMessageDAO singleMessageDAO;

	public void setSingleMessageDAO(SingleMessageDAO singleMessageDAO) {
		this.singleMessageDAO = singleMessageDAO;
	}

	TimeConverter converter = new TimeConverter();

	/**
	 * Method return list of user messages which created between date. If messages are not exist return empty list.
	 * 
	 * @type Date
	 * @type Long
	 * @param idAccount
	 * @param minDate
	 * @param maxDate
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return List<SingleMessage>
	 */
	public List<SingleMessage> getListSingleMessageBeetweenDateByIdAccount(Long idAccount,
			LocalDateTime minDateLDT, LocalDateTime maxDateLDT) {

		List<SingleMessage> list=Collections.emptyList();
		Date minDateD;
		Date maxDateD;
		if (idAccount.equals(null) || idAccount.equals("")) {
			throw new RuntimeException("SingleMessageService:Id account must not null and empty.");
			
		} else if(maxDateLDT.isBefore(minDateLDT)){
			throw new RuntimeException("SingleMessageService: Max date must not before min date!");
			
		}else{
			try {
				minDateD = converter.convertLocalDateTimeToDate(minDateLDT);
				maxDateD = converter.convertLocalDateTimeToDate(maxDateLDT);
				logger.info("SingleMessageService: List single account message which create between"
						+ " data load by id account.");
				list = singleMessageDAO.getListSingleMessageBeetweenDateByIdAccount(idAccount, minDateD, maxDateD);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("SingleMessageService: List single account message which create between"
						+ " data load by id account, but list is empty."+ rf);
				
			}catch (DataAccessException da) {
				logger.error("SingleMessageService: Exeption connect with data base or other error= "+da);
			}
		}
		return list;
	}

	/**
	 * Method return list of interlocutor account which speak with this account.
	 * If accounts are not exist return empty list. 
	 * 
	 * @type Long
	 * @param idAccount
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return List<Account>
	 */
	public List<Account> getListInterlocutorAccountByIdAccount(Long idAccount) {
		
		List<Account> list=Collections.emptyList();
		if (idAccount.equals(null) || idAccount.equals("")) {
			throw new RuntimeException("SingleMessageService:Id account must not null and empty.");
			
		}else{
			try {
				logger.info("SingleMessageService: List interlocutor account load by id account.");
				list=singleMessageDAO.getListInterlocutorAccountByIdAccount(idAccount);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("SingleMessageService: List interlocutor account load by id account,"
						+ " but list is empty." + rf);
				
			}catch (DataAccessException da) {
				logger.error("SingleMessageService:Exeption connect with data base or other error= "+da);
			}
		}
		return list;
	}
	
	/**
	 * Method return list of interlocutor account message which user account
	 * have between min and max date.If single messages are not exist return empty list.
	 * 
	 * @type Long
	 * @type Date
	 * @param idAccount
	 * @param idInterlocutorAccount
	 * @param minDate
	 * @param maxDate
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return List<SingleMessage>
	 */
	public List<SingleMessage> getListIntrlocutorSingleMessageBeetweenDateByIdAccount(Long idAccount,
			Long idInterlocutorAccount,LocalDateTime minDateLDT,LocalDateTime maxDateLDT) {
		
		List<SingleMessage> list=Collections.emptyList();
		Date minDateD;
		Date maxDateD;
		if (idAccount.equals(null) || idAccount.equals("")) {
			throw new RuntimeException("SingleMessageService:Id account id  must not null or empty.");
			
		}else if(idInterlocutorAccount.equals(null) || idInterlocutorAccount.equals("")){
			throw new RuntimeException("SingleMessageService:Id account interlocutor must not null or empty.");		
			
		}else if(maxDateLDT.isBefore(minDateLDT)){
			throw new RuntimeException("SingleMessageService: Max date must not before min date!");
			
		}else{
			try {
				minDateD = converter.convertLocalDateTimeToDate(minDateLDT);
				maxDateD = converter.convertLocalDateTimeToDate(maxDateLDT);
				logger.info("SingleMessageService: List dialog message which create between"
						+ " data load by id account and id interlocutor.");
				list=singleMessageDAO.getListIntrlocutorSingleMessageBeetweenDateByIdAccount(idAccount,
						idInterlocutorAccount, minDateD, maxDateD);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("SingleMessageService:List of single messages load but list is empty=" + rf);
				
			}catch (DataAccessException da) {
				logger.error("SingleMessageService:Exeption connect with data base or other error= "+da);
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
	 * @param idSingleMessage
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return SingleMessage
	 */
	public SingleMessage getSingleMessageById(Long idSingleMessage) {
		
		SingleMessage singleMessage = null;
		if (idSingleMessage.equals(null) || idSingleMessage.equals("")) {
			throw new RuntimeException("SingleMessageService:Id entity is null");
		} else {
			try {
				singleMessage = (SingleMessage) singleMessageDAO.getEntityById(idSingleMessage);
				logger.info("SingleMessageService:Entity loaded successfully id=" + idSingleMessage);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("SingleMessageService:Not found entity in data base=" + rf);
			
			} catch (DataAccessException da) {
				logger.error("SingleMessageService:Exeption connect with data base or other error= "+da);
			}
		}
		return singleMessage;
	}
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method save entity if entity not null.
	 * 
	 * @type SingleMessage
	 * @param singleMessage
	 * 
	 * @exception TypeMismatchDataAccessException
	 * @exception DataAccessException
	 */
	public void saveSingleMessage(SingleMessage singleMessage) {
		
		if(singleMessage.equals(null)){
			throw new RuntimeException("SingleMessageService: Entity not save becouse entity is null.");
		} else {
			try {
				singleMessageDAO.saveEntity(singleMessage);
				logger.info("SingleMessageService:Entity save successfully");
				
			} catch (TypeMismatchDataAccessException tm) {
				logger.error("SingleMessageService:New entity not save becouse mismatch field type "+tm);
				
			}catch (DataAccessException da) {
				logger.error("SingleMessageService:Exeption connect with data base or other error= "+da);
			}
		}
	}
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method update entity if entity not null.
	 * 
	 * @type SingleMessage
	 * @param singleMessage
	 * 
	 * @exception TypeMismatchDataAccessException
	 * @exception DataAccessException
	 */
	public void updateSingleMessage(SingleMessage singleMessage) {
		
		if (singleMessage.equals(null)) {
			throw new RuntimeException("SingleMessageService: Entity not save becouse entity is null.");
		} else {
			try {
				logger.info("SingleMessageService:Entity update successfully");
				singleMessageDAO.updateEntity(singleMessage);
				
			} catch (TypeMismatchDataAccessException tm) {
				logger.error("SingleMessageService:New entity not update becouse mismatch field type "+ tm);
				
			} catch (DataAccessException da) {
				logger.error("SingleMessageService:Exeption connect with data base or other error= "+da);
			}
		}
	}
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method delete entity by id if entity not null.
	 * 
	 * @type Long
	 * @param idSingleMessage
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 */
	public void deleteSingleMessageById(Long idSingleMessage) {
		
		if (idSingleMessage.equals(null) || idSingleMessage.equals("")) {
			throw new RuntimeException("EntityService:Id entity is null");
		} else{
			try {
				logger.info("SingleMessageService:Entity delete successfully,id=" + idSingleMessage);
				singleMessageDAO.deleteEntityById(idSingleMessage);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("SingleMessageService: Operation delete is faled becouse"
						+ " not found entity in data base by id=" + rf);
				
			} catch (DataAccessException da) {
				logger.error("SingleMessageService:Exeption connect with data base or other error= "+da);
			}
		}
	}
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method delete entity if entity not null.
	 * 
	 * @type SingleMessage
	 * @param singleMessage
	 * 
	 * @exception DataAccessException
	 */
	public void deleteSingleMessage(SingleMessage singleMessage) {
		
		if (singleMessage.equals(null)) {
			throw new RuntimeException("EntityService: Object is "+singleMessage+ " yet and not delete again.");
		}else{
			try {
				logger.info("EntityService:Entity " + singleMessage + " delete successfully");
				singleMessageDAO.deleteEntity(singleMessage);
				
			} catch (DataAccessException da) {
				logger.error("SingleMessageService:Exeption connect with data base or other error= "+da);
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
	public List<Object> getListSingleMessage() {
		
		List<Object>list=Collections.emptyList();
		try {
			logger.info("SingleMessageService: List of entity load");
			list=singleMessageDAO.getListEntity();
			
		} catch (DataRetrievalFailureException rf) {
			logger.warn("SingleMessageService: List of entity not load becouse list is empty=" + rf);
			
		}catch (DataAccessException da) {
			logger.error("SingleMessageService:Exeption connect with data base or other error= "+da);
		}
		return list;
	}
}
