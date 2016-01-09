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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.stereotype.Service;

import com.dancosoft.socialcommunity.dao.AccountHistoryDAO;
import com.dancosoft.socialcommunity.model.AccountHistory;
import com.dancosoft.socialcommunity.service.AccountHistoryService;

/**
 * <p>The class AccountHistoryServiceImpl use Service pattern which describes
 * business logic SocialCommunity application. Service layer perform link
 * between, presentation layer and DAO layer(AccountHistoryDAO).This layer is
 * the main role becouse layer contents(set of methods in classes) affect on
 * functionality of all application. This class contain methods which describes
 * specific operation for AccountHistory.This class perform service layer to
 * AccountHistory.Class extend base class CommonEntityServiceImpl and implement
 * AccountHistoryService interface which perform all methods of this class. For
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
@Service(value="accountHistoryService")
public class AccountHistoryServiceImpl extends CommonEntityServiceImpl implements AccountHistoryService{
	
	private static final Logger logger = LoggerFactory.getLogger(AccountHistoryServiceImpl.class);
	
	@Autowired
	@Qualifier(value="accountHistoryDAO")
	private AccountHistoryDAO accountHistoryDAO;

	public void setAccountHistoryDAO(AccountHistoryDAO accountHistoryDAO) {
		this.accountHistoryDAO = accountHistoryDAO;
	}
	
	/**
	 * Method return account history by id account.If account history
	 * not exist return null
	 * 
	 * @type Long
	 * @param idAccount
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return AccountHistory
	 */
	public AccountHistory getAccountHistoryByIdAccount(Long idAccount) {
		
		AccountHistory accountHistory=null;
		if(idAccount.equals(null) || idAccount.equals("")){
			throw new RuntimeException("AccountHistoryService:Id Account must not null and empty.");
		} else {
			try {
				logger.info("AccountHistoryService: AccountHistory load by id account.");
				accountHistory = accountHistoryDAO.getAccountHistoryByIdAccount(idAccount);

			} catch (DataRetrievalFailureException rf) {
				logger.warn("AccountHistoryService:AccountHistory not found by id account=" + rf);
	
			} catch (DataAccessException da) {
				logger.error("AccountHistoryService:Exeption connect with data base or other error= "+da);
			}
		}
		return accountHistory;
	}
	
	/**
	 * Method return date of last visit account by id account. If date ont exist return null.
	 * 
	 * @type Long
	 * @param idAccount
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return LocalDateTime
	 */
	public LocalDateTime getLastVisitAccountByIdAccount(Long idAccount) {
		
		LocalDateTime lastVisit = null;
		if(idAccount.equals(null) || idAccount.equals("")){
			throw new RuntimeException("AccountHistoryService:Id Account must not null and empty.");
		} else {
			try {
				logger.info("AccountHistoryService: Date last visit account load by id account.");
				lastVisit= accountHistoryDAO.getLastVisitAccountByIdAccount(idAccount);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("AccountHistoryService:Date last visit account not load by id account=" + rf);
	
			} catch (DataAccessException da) {
				logger.error("AccountHistoryService:Exeption connect with data base or other error= "+da);
			}
		}
		return lastVisit;
	}
}
