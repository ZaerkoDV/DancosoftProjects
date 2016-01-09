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
import org.springframework.stereotype.Service;

import com.dancosoft.socialcommunity.dao.AccountDAO;
import com.dancosoft.socialcommunity.model.Account;
import com.dancosoft.socialcommunity.service.AccountService;

/**
 * <p>The class AccountServiceImpl use Service pattern which describes business
 * logic SocialCommunity application. Service layer perform link between,
 * presentation layer and DAO layer(AccountDAO).This layer is the main role
 * becouse layer contents(set of methods in classes) affect on functionality of
 * all application. This class contain methods which describes specific
 * operation for Account.This class perform service layer to Account.Class
 * extend base class CommonEntityServiceImpl and implement AccountService
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
@Service(value="accountService")
public class AccountServiceImpl extends CommonEntityServiceImpl implements AccountService {

	private static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);
	
	@Autowired
	@Qualifier(value="accountDAO")
	private AccountDAO accountDAO;

	public void setAccountDAO(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}
	
	/**
	 * Search account by his attribute lastName and by last name his ovner.
	 * 
	 * @type Date
	 * @type String
	 * @param accountName
	 * @param lastName
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return List<Account>
	 */
	public List<Account> searchAccountByAccountNameUserLastName(String accountName, String lastName) {
		
		List<Account> list=Collections.emptyList();
		if ((accountName.equals(null) || accountName.equals("")) && (lastName.equals(null) ||lastName.equals(""))) {
			throw new RuntimeException("AccountService:Account name and name his"
					+ " owner must not equals null at the same time.");
		}else{
			try {
				logger.info("AccountService:List account loaded by account name, last name.");
				list=accountDAO.searchAccountByAccountNameUserLastName(accountName, lastName);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("AccountService: Operation search account by account name and by" + rf);
	
			} catch (DataAccessException da) {
				logger.error("EntityService:Exeption connect with data base or other error= "+da);
			}
		}
		return list;
	}
	
	/**
	 * Get id ovner(User) of account.
	 * 
	 * @type Long
	 * @param idAccount
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return Long
	 */
	public Long getIdUserByIdAccount(Long idAccount) {
		
		Long idUser=null;
		if (idAccount.equals(null) || idAccount.equals("")) {
			throw new RuntimeException("AccountService:Id account must not null");
		} else {
			try {
				logger.info("AccountService:Id user load by id account.");
				idUser=accountDAO.getIdUserByIdAccount(idAccount);
				
			}catch (DataRetrievalFailureException rf) {
				logger.warn("AccountService: Id user not found by id his account=" + rf);
				
			}catch (DataAccessException da) {
				logger.error("AccountService:Exeption connect with data base or other error= "+da);
			}
		}
		return idUser;
	}
	
	/**
	 * Cheack account block status. If status is block return true.
	 * 
	 * @type Boolean
	 * @param idAccount
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return Boolean
	 */
	public Boolean isAccountBlock(Long idAccount) {
		
		Boolean isAccountBlock=null;
		if (idAccount.equals(null) || idAccount.equals("")) {
			throw new RuntimeException("AccountService:Id account group must not null.");
		} else{
			try {
				logger.info("AccountService:Information about account block status load.");
				isAccountBlock=accountDAO.isAccountBlock(idAccount);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("AccountService:Information about account block status not load becouse"
						+ " account with id"+idAccount+" not exist" + rf);
						
			} catch (DataAccessException da) {
				logger.error("AccountService: Exeption connect with data base or other error. "+da);
			}
		}
		return isAccountBlock;
	}
	
	/**
	 * Get block status(attribute) of account
	 * 
	 * @type Boolean
	 * @param idAccount
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return String
	 */
	public String getAccountStatus(Long idAccount) {
		
		String blokStatus=null;
		if (idAccount.equals(null) || idAccount.equals("")) {
			throw new RuntimeException("AccountService:Id account group must not null.");
		} else{
			try {
				logger.info("AccountService: Account block status is load.");
				blokStatus=accountDAO.getAccountStatus(idAccount);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("AccountService: Block status for account group with id "+ idAccount+" not exist." + rf);
						
			} catch (DataAccessException da) {
				logger.error("AccountService: Exeption connect with data base or other error. "+da);
			}
		}
		return blokStatus;
	}
}
