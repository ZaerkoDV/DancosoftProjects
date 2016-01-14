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

import java.util.List;

import javax.persistence.NonUniqueResultException;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.dao.TypeMismatchDataAccessException;

import com.dancosoft.socialcommunity.model.AccountGroupHistory;

/**
 * <p>
 * The interface AccountGroupHistoryService contain methods ads which realize in
 * class AccountGroupHistoryServiceImpl. Class AccountGroupHistoryServiceImpl
 * use Service pattern which describes service layer of application. This class
 * contain general operation to all classes.This interface contain ads methods
 * which perform busness logic all application. Interface extend
 * CommonEntityService interface which contain ads base operation of any entity.
 * 
 * @version 1.0 08.10.2015
 * @author Zaerko Denis
 */
public interface AccountGroupHistoryService {

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
	public AccountGroupHistory getAccountGroupHistoryByIdAccountGroup(Long idAccountGroup);
	
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
	public AccountGroupHistory getAccountGroupHistoryById(Long idAccountGroupHistory);
	
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
	public void saveAccountGroupHistory(AccountGroupHistory accountGroupHistory);
	
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
	public void updateAccountGroupHistory(AccountGroupHistory accountGroupHistory);
	
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
	public void deleteAccountGroupHistoryById(Long idAccountGroupHistory);
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method delete entity if entity not null.
	 * 
	 * @type AccountGroupHistory
	 * @param accountGroupHistory
	 * 
	 * @exception DataAccessException
	 */
	public void deleteAccountGroupHistory(AccountGroupHistory accountGroupHistory);
	
	/**
	 * This method is basic for all entities. Method return list of entity. If entyty
	 * list not load return empty list.
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return List<Object>
	 */
	public List<Object> getListAccountGroupHistory();
}
