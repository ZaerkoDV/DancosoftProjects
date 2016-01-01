/**
 * 
 */
package com.dancosoft.socialcommunity.service.impl;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
		logger.info("AccountHistoryService: Account hostory load by id account.");
		return accountHistoryDAO.getAccountHistoryByIdAccount(idAccount);
	}
	
	public LocalDateTime getLastVisitAccountByIdAccount(Long idAccount) {
		logger.info("AccountHistoryService: Date last visit load for account.");
		return accountHistoryDAO.getLastVisitAccountByIdAccount(idAccount);
	}
}
