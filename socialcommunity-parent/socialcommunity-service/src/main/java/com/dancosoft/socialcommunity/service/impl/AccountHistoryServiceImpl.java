/**
 * 
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
 * @author Zaerko_DV
 *
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
