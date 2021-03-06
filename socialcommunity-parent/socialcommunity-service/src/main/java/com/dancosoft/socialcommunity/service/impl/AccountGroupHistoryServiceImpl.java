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

import com.dancosoft.socialcommunity.dao.AccountGroupHistoryDAO;
import com.dancosoft.socialcommunity.dao.impl.AccountGroupHistoryDAOImpl;
import com.dancosoft.socialcommunity.model.AccountGroupHistory;
import com.dancosoft.socialcommunity.service.AccountGroupHistoryService;

/**
 * <p>The class AccountGroupHistoryServiceImpl use Service pattern which describes business
 * logic SocialCommunity application. Service layer perform link between, presentation layer
 * and DAO layer(AccountGroupHistoryDAO).This layer is the main role becouse layer contents
 * (set of methods in classes) affect on functionality of all application.
 * This class contain methods which describes specific operation for AccountGroupHistory.This
 * class perform service layer to AccountGroupHistory.Class extend base class CommonEntityServiceImpl and
 * implement AccountGroupHistoryService interface which perform all methods of this class.For logging
 * use fasade slf4j and framework log4j. Class contain also private, static variable logger,
 * which use to call log message. Class use Spring framework anatations to work with service layer. 
 *  
 * @see org.springframework.stereotype
 * @see slf4j framework
 * @see log4j framework
 * 
 * @version 1.0 05.01.2016
 * @author Zaerko Denis
 */
@Service(value="accountGroupHistoryService")
public class AccountGroupHistoryServiceImpl implements AccountGroupHistoryService {

	private static final Logger logger = LoggerFactory.getLogger(AccountGroupHistoryDAOImpl.class);
	
	@Autowired
	@Qualifier(value="accountGroupHistoryDAO")
	private AccountGroupHistoryDAO accountGroupHistoryDAO;
	
	public void setAccountGroupHistoryDAO(AccountGroupHistoryDAO accountGroupHistoryDAO) {
		this.accountGroupHistoryDAO = accountGroupHistoryDAO;
	}

	/**
	 * Method return account group history by id account group. If account group
	 * history not exist return null.
	 * 
	 * @type Long
	 * @param idAccountGroup
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception NonUniqueResultException 
	 * @exception DataAccessException
	 * 
	 * @return AccountGroupHistory
	 */
	@Transactional
	public AccountGroupHistory getAccountGroupHistoryByIdAccountGroup(Long idAccountGroup) {
		
		AccountGroupHistory accountGroupHistory=null;
		if (idAccountGroup.equals(null) || idAccountGroup.equals("")) {
			throw new RuntimeException("AccountGroupHistoryService:Id Account group must not null");
			
		} else{
			try {
				logger.info("AccountGroupHistoryService: Account group history load by id account group.");
				accountGroupHistory=accountGroupHistoryDAO.getAccountGroupHistoryByIdAccountGroup(idAccountGroup);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("AccountGroupHistoryService:AccountGroupHistory not found by id group account." + rf);
				
			}catch (NonUniqueResultException nu) {
				logger.error("AccountGroupHistoryService:AccountGroupHistory load by id account group but is not unique." + nu);
				
			}catch (DataAccessException da) {
				logger.error("AccountGroupHistoryService: Exeption connect with data base or other error= "+da);
			}
		}
		return accountGroupHistory;
	}
		
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method return entity by idEntity. If entity not exist return null
	 * 
	 * @type Long
	 * @type AccountGroupHistory
	 * @param idAccountGroupHistory
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return AccountGroupHistory
	 */
	@Transactional
	public AccountGroupHistory getAccountGroupHistoryById(Long idAccountGroupHistory) {
		
		AccountGroupHistory accountGroupHistory = null;
		if (idAccountGroupHistory.equals(null) || idAccountGroupHistory.equals("")) {
			throw new RuntimeException("EntityService:Id entity is null");
			
		} else {
			try {
				accountGroupHistory = (AccountGroupHistory) accountGroupHistoryDAO.getEntityById(idAccountGroupHistory);
				logger.info("AccountGroupHistoryService:Entity loaded successfully id=" + idAccountGroupHistory);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("AccountGroupHistoryService:Not found entity in data base=" + rf);
				
			} catch (DataAccessException da) {
				logger.error("AccountGroupHistoryService:Exeption connect with data base or other error= "+da);
			}
		}
		return accountGroupHistory;
	}
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method save entity if entity not null.
	 * 
	 * @type AccountGroupHistory
	 * @param accountGroupHistory
	 * 
	 * @exception TypeMismatchDataAccessException
	 * @exception DataAccessException
	 */
	@Transactional
	public void saveAccountGroupHistory(AccountGroupHistory accountGroupHistory) {
		
		if(accountGroupHistory.equals(null)){
			throw new RuntimeException("AccountGroupHistoryService: Entity not save becouse entity is null.");
		} else {
			try {
				accountGroupHistoryDAO.saveEntity(accountGroupHistory);
				logger.info("AccountGroupHistoryService:Entity save successfully");
				
			} catch (TypeMismatchDataAccessException tm) {
				logger.error("AccountGroupHistoryService:New entity not save becouse mismatch field type "+tm);
				
			}catch (DataAccessException da) {
				logger.error("AccountGroupHistoryService:Exeption connect with data base or other error= "+da);
			}
		}
	}
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method update entity if entity not null.
	 * 
	 * @type AccountGroupHistory
	 * @param accountGroupHistory
	 * 
	 * @exception TypeMismatchDataAccessException
	 * @exception DataAccessException
	 */
	@Transactional
	public void updateAccountGroupHistory(AccountGroupHistory accountGroupHistory) {
		
		if (accountGroupHistory.equals(null)) {
			throw new RuntimeException("AccountGroupHistoryService: Entity not save becouse entity is null.");
		} else {
			try {
				logger.info("AccountGroupHistoryService:Entity update successfully");
				accountGroupHistoryDAO.updateEntity(accountGroupHistory);
				
			} catch (TypeMismatchDataAccessException tm) {
				logger.error("AccountGroupHistoryService:New entity not update becouse mismatch field type "+ tm);
				
			} catch (DataAccessException da) {
				logger.error("AccountGroupHistoryService:Exeption connect with data base or other error= "+da);
			}
		}
	}
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method delete entity by id if entity not null.
	 * 
	 * @type Long
	 * @param idAccountGroupHistory
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 */
	@Transactional
	public void deleteAccountGroupHistoryById(Long idAccountGroupHistory) {
		
		if (idAccountGroupHistory.equals(null) || idAccountGroupHistory.equals("")) {
			throw new RuntimeException("AccountGroupHistoryService:Id "+this.getClass().getName()+ " entity is null");
		} else{
			try {
				logger.info("AccountGroupHistoryService:Entity" + this.getClass().getName()+ " delete successfully,id=" + idAccountGroupHistory);
				accountGroupHistoryDAO.deleteEntityById(idAccountGroupHistory);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("AccountGroupHistoryService: Operation delete is faled becouse"
						+ " not found entity in data base by id=" + rf);
				
			} catch (DataAccessException da) {
				logger.error("AccountGroupHistoryService:Exeption connect with data base or other error= "+da);
			}
		}
	}
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method delete entity if entity not null.
	 * 
	 * @type AccountGroupHistory
	 * @param accountGroupHistory
	 * 
	 * @exception DataAccessException
	 */
	@Transactional
	public void deleteAccountGroupHistory(AccountGroupHistory accountGroupHistory) {
		
		if (accountGroupHistory.equals(null)) {
			throw new RuntimeException("AccountGroupHistoryService: Object is "+accountGroupHistory+ " yet and not delete again.");
		}else{
			try {
				logger.info("AccountGroupHistoryService:Entity " + accountGroupHistory + " delete successfully");
				accountGroupHistoryDAO.deleteEntity(accountGroupHistory);
				
			} catch (DataAccessException da) {
				logger.error("AccountGroupHistoryService:Exeption connect with data base or other error= "+da);
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
	public List<Object> getListAccountGroupHistory() {
		
		List<Object>list=Collections.emptyList();
		try {
			logger.info("AccountGroupHistoryService: List of entity" + this.getClass().getName()+ "load");
			list=accountGroupHistoryDAO.getListEntity();
			
		} catch (DataRetrievalFailureException rf) {
			logger.warn("AccountGroupHistoryService: List of entity not load becouse list is empty=" + rf);
			
		}catch (DataAccessException da) {
			logger.error("AccountGroupHistoryService:Exeption connect with data base or other error= "+da);
		}
		return list;
	}
}
