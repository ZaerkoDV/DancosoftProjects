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

import com.dancosoft.socialcommunity.dao.AccountGroupDAO;
import com.dancosoft.socialcommunity.model.AccountGroup;
import com.dancosoft.socialcommunity.service.AccountGroupService;

/**
 * <p> The class AccountGroupServiceImpl use Service pattern which describes
 * business logic SocialCommunity application. Service layer perform link
 * between, presentation layer and DAO layer(AccountGroupDAO).This layer is the
 * main role becouse layer contents(set of methods in classes) affect on
 * functionality of all application. This class contain methods which describes
 * specific operation for AccountGroup.This class perform service layer to
 * AccountGroup.Class extend base class CommonEntityServiceImpl and implement
 * AccountGroupService interface which perform all methods of this class. For
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
@Service(value="accountGroupService")
public class AccountGroupServiceImpl implements AccountGroupService {

	private static final Logger logger = LoggerFactory.getLogger(AccountGroupServiceImpl.class);
	
	@Autowired
	@Qualifier(value="accountGroupDAO")
	private AccountGroupDAO accountGroupDAO;

	public void setAccountGroupDAO(AccountGroupDAO accountGroupDAO) {
		this.accountGroupDAO = accountGroupDAO;
	}
	
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
	@Transactional
	public Boolean isBlockAccountGroup(Long idAccountGroup) {
		
		Boolean isBlockAccountGroup=null;
		if (idAccountGroup.equals(null) || idAccountGroup.equals("")) {
			throw new RuntimeException("AccountGroupService:Id account group must not null.");
			
		} else{
			try {
				logger.info("AccountGroupService:Account group block status load by id account group.");
				isBlockAccountGroup=accountGroupDAO.isBlockAccountGroup(idAccountGroup);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("AccountGroupService: Account group with id "+ idAccountGroup+" not exist." + rf);
						
			} catch (DataAccessException da) {
				logger.error("AccountGroupService: Exeption connect with data base or other error. "+da);
			}
		}
		return isBlockAccountGroup;
	}
	
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
	@Transactional
	public String getAccountGroupBlockStatus(Long idAccount) {
		
		String blokStatus=null;
		if (idAccount.equals(null) || idAccount.equals("")) {
			throw new RuntimeException("AccountGroupService:Id account group must not null.");
	
		} else{
			try {
				logger.info("AccountGroupService:Account group status is load.");
				blokStatus=accountGroupDAO.getAccountGroupBlockStatus(idAccount);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("AccountGroupService: Block status for account group with id "+ idAccount+" not exist." + rf);
						
			} catch (DataAccessException da) {
				logger.error("AccountGroupService: Exeption connect with data base or other error. "+da);
			}
		}
		return blokStatus;
	}
	
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
	@Transactional
	public List<AccountGroup> getListAccountGroupWithBlockStatusByIdAccount(Long idAccount,String blockStatus) {
		
		List<AccountGroup> list=Collections.emptyList();
		if (idAccount.equals(null) || idAccount.equals("")) {
			throw new RuntimeException("AccountGroupService:Id account must not null.");
	
		} else{
			try {
				logger.info("AccountGroupService:List AccountGroup with block status load by id account");
				list=accountGroupDAO.getListAccountGroupWithBlockStatusByIdAccount(idAccount, blockStatus);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("AccountGroupService: List of account group not load becouse list is empty=" + rf);
				
			}catch (DataAccessException da) {
				logger.error("AccountGroupService:Exeption connect with data base or other error= "+da);
			}
		}
		return list;
	}
	
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
	@Transactional
	public List<AccountGroup> searchAccountGroupByGroupNameAccountName(String groupName, String accountName) {
		
		List<AccountGroup> list=Collections.emptyList();
		if ((groupName==null  && accountName==null)) {
			throw new RuntimeException("AccountGroupService:Account group or account"
					+ " name must not equals null at the same time.");
		}else{
			try {
				logger.info("AccountGroupService:List AccountGroup load by groupName and accountName.");
				list=accountGroupDAO.searchAccountGroupByGroupNameAccountName(groupName, accountName);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("AccountGroupService:Operation search account group by group name"
						+ " and by account name completed but list is empty=" + rf);
				
			}catch (DataAccessException da) {
				logger.error("AccountGroupService:Exeption connect with data base or other error= "+da);
			}		
		}
		return list;
	}
	
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
	@Transactional
	public List<AccountGroup> getListAccountGroupWithViewStatusByIdAccount(Long idAccount,String viewStatus){
		
		List<AccountGroup> list=Collections.emptyList();
		if ((idAccount.equals(null) || idAccount.equals("")) || (viewStatus.equals(null) || viewStatus.equals(""))) {
			throw new RuntimeException("AccountGroupService:Account group id and view status must not null or empty.");
			
		}else{	
			try {
				logger.info("AccountGroupService:List AccountGroup with view status load by id account");
				list=accountGroupDAO.getListAccountGroupWithViewStatusByIdAccount(idAccount, viewStatus);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("AccountGroupService:Account group with id="+idAccount+""
						+ " and status "+viewStatus+"not exists" + rf);
				
			}catch (DataAccessException da) {
				logger.error("AccountGroupService:Exeption connect with data base or other error= "+da);
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
	 * @type AccountGroup
	 * @param idAccountGroup
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return AccountGroup
	 */
	@Transactional
	public AccountGroup getAccountGroupById(Long idAccountGroup) {
		
		AccountGroup accountGroup = null;
		if (idAccountGroup.equals(null) || idAccountGroup.equals("")) {
			throw new RuntimeException("AccountGroupService:Id entity is null");
		} else {
			try {
				accountGroup = (AccountGroup) accountGroupDAO.getEntityById(idAccountGroup);
				logger.info("AccountGroupService:Entity loaded successfully id=" + idAccountGroup);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("AccountGroupService:Not found entity in data base=" + rf);
		
			} catch (DataAccessException da) {
				logger.error("AccountGroupService:Exeption connect with data base or other error= "+da);
			}
		}
		return accountGroup;
	}
	
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
	@Transactional
	public void saveAccountGroup(AccountGroup accountGroup) {
		
		if(accountGroup.equals(null)){
			throw new RuntimeException("AccountGroupService: Entity not save becouse entity is null.");
		} else {
			try {
				accountGroupDAO.saveEntity(accountGroup);
				logger.info("AccountGroupService:Entity save successfully");
				
			} catch (TypeMismatchDataAccessException tm) {
				logger.error("AccountGroupService:New entity not save becouse mismatch field type "+tm);
				
			}catch (DataAccessException da) {
				logger.error("AccountGroupService:Exeption connect with data base or other error= "+da);
			}
		}
	}
	
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
	@Transactional
	public void updateAccountGroup(AccountGroup accountGroup) {
		
		if (accountGroup.equals(null)) {
			throw new RuntimeException("AccountGroupService: Entity not save becouse entity is null.");
		} else {
			try {
				logger.info("AccountGroupService:Entity update successfully");
				accountGroupDAO.updateEntity(accountGroup);
				
			} catch (TypeMismatchDataAccessException tm) {
				logger.error("AccountGroupService:New entity not update becouse mismatch field type "+ tm);
				
			} catch (DataAccessException da) {
				logger.error("AccountGroupService:Exeption connect with data base or other error= "+da);
			}
		}
	}
	
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
	@Transactional
	public void deleteAccountGroupById(Long idAccountGroup) {
		
		if (idAccountGroup.equals(null) || idAccountGroup.equals("")) {
			throw new RuntimeException("AccountGroupService:Id "+this.getClass().getName() + " entity is null");
		} else{
			try {
				logger.info("AccountGroupService:Entity" + this.getClass().getName()+ " delete successfully,id=" + idAccountGroup);
				accountGroupDAO.deleteEntityById(idAccountGroup);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("AccountGroupService: Operation delete is faled becouse"
						+ " not found entity in data base by id=" + rf);
				
			} catch (DataAccessException da) {
				logger.error("AccountGroupService:Exeption connect with data base or other error= "+da);
			}
		}
	}
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method delete entity if entity not null.
	 * 
	 * @type AccountGroup
	 * @param accountGroup
	 * 
	 * @exception DataAccessException
	 */
	@Transactional
	public void deleteAccountGroup(AccountGroup accountGroup) {
		
		if (accountGroup.equals(null)) {
			throw new RuntimeException("AccountGroupService: Object is "+accountGroup+ " yet and not delete again.");
		}else{
			try {
				logger.info("AccountGroupService:Entity " + accountGroup + " delete successfully");
				accountGroupDAO.deleteEntity(accountGroup);
				
			} catch (DataAccessException da) {
				logger.error("AccountGroupService:Exeption connect with data base or other error= "+da);
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
	public List<Object> getListAccountGroup() {
		
		List<Object>list=Collections.emptyList();
		try {
			logger.info("AccountGroupService: List of entity" + this.getClass().getName()+ "load");
			list=accountGroupDAO.getListEntity();
			
		} catch (DataRetrievalFailureException rf) {
			logger.warn("AccountGroupService: List of entity not load becouse list is empty=" + rf);
			
		}catch (DataAccessException da) {
			logger.error("AccountGroupService:Exeption connect with data base or other error= "+da);
		}
		return list;
	}
}
