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

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.dao.TypeMismatchDataAccessException;

import com.dancosoft.socialcommunity.model.AccountGroup;

/**
 * <p>The interface AccountGroupService contain methods ads which realize in class
 * AccountGroupServiceImpl. Class AccountGroupServiceImpl use Service pattern
 * which describes service layer of application. This class contain general
 * operation to all classes.This interface contain ads methods which perform
 * busness logic all application. Interface extend CommonEntityService interface
 * which contain ads base operation of any entity.
 * 
 * @version 1.0 08.10.2015
 * @author Zaerko Denis
 */
public interface AccountGroupService {

	/**
	 * Method cheack account group on block status by id group. If group
	 * is block return true else false
	 * 
	 * @type Long
	 * @param idAccountGroup
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return Boolean
	 */
	public Boolean isBlockAccountGroup(Long idAccountGroup);

	/**
	 * Method return  block status of account group by id group. 
	 * 
	 * @type String
	 * @param idAccount
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return String
	 */
	public String getAccountGroupBlockStatus(Long idAccount);

	/**
	 * Method return list of account group by id account which have status block. 
	 * 
	 * @type Long
	 * @type String
	 * @param idAccount
	 * @param blockStatus
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return List<AccountGroup>
	 */
	public List<AccountGroup> getListAccountGroupWithBlockStatusByIdAccount(
			Long idAccount, String blockStatus);

	/**
	 * Search account group by group name and account name. Method return list of account
	 * group else empty list.
	 * 
	 * @type String
	 * @param groupName
	 * @param accountName
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return List<AccountGroup>
	 */
	public List<AccountGroup> searchAccountGroupByGroupNameAccountName(
			String groupName, String accountName);

	/**
	 * Method return list of account group with view status by id account.
	 * 
	 * @type Long
	 * @type String
	 * @param idAccount
	 * @param viewStatus
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return List<AccountGroup>
	 */
	public List<AccountGroup> getListAccountGroupWithViewStatusByIdAccount(
			Long idAccount, String viewStatus);
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method return entity by idEntity. If entity not exist return null(use
	 * hibernateTamplate method get)
	 * 
	 * @type Long
	 * @type AccountGroup
	 * @param idAccountGroup
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return AccountGroup
	 */
	public AccountGroup getAccountGroupById(Long idAccountGroup);
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method save entity if entity not null.
	 * 
	 * @type AccountGroup
	 * @param accountGroup
	 * 
	 * @exception TypeMismatchDataAccessException
	 * @exception DataAccessException
	 */
	public void saveAccountGroup(AccountGroup accountGroup);
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method update entity if entity not null.
	 * 
	 * @type AccountGroup
	 * @param accountGroup
	 * 
	 * @exception TypeMismatchDataAccessException
	 * @exception DataAccessException
	 */
	public void updateAccountGroup(AccountGroup accountGroup);
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method delete entity by id if entity not null.
	 * 
	 * @type Long
	 * @param idAccountGroup
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 */
	public void deleteAccountGroupById(Long idAccountGroup);
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method delete entity if entity not null.
	 * 
	 * @type AccountGroup
	 * @param accountGroup
	 * 
	 * @exception DataAccessException
	 */
	public void deleteAccountGroup(AccountGroup accountGroup);
	
	/**
	 * This method is basic for all entities. Method return list of entity. If entyty
	 * list not load return empty list.
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return List<Object>
	 */
	public List<Object> getListAccountGroup();
}
