/**
 * 
 */
package com.dancosoft.socialcommunity.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.dancosoft.socialcommunity.dao.AccountGroupHistoryDAO;
import com.dancosoft.socialcommunity.dao.impl.AccountGroupHistoryDAOImpl;
import com.dancosoft.socialcommunity.model.AccountGroupHistory;
import com.dancosoft.socialcommunity.service.AccountGroupHistoryService;

/**
 * @author Zaerko_DV
 *
 */
@Service(value="accountGroupHistoryService")
public class AccountGroupHistoryServiceImpl extends CommonEntityServiceImpl implements AccountGroupHistoryService {

	private static final Logger logger = LoggerFactory.getLogger(AccountGroupHistoryDAOImpl.class);
	
	@Autowired
	@Qualifier(value="accountGroupHistoryDAO")
	private AccountGroupHistoryDAO accountGroupHistoryDAO;
	
	public void setAccountGroupHistoryDAO(AccountGroupHistoryDAO accountGroupHistoryDAO) {
		this.accountGroupHistoryDAO = accountGroupHistoryDAO;
	}

	public AccountGroupHistory getAccountGroupHistoryByIdAccountGroup(Long idAccountGroup) {
		logger.info("AccountGroupHistoryService: Account group history load by id account group.");
		return accountGroupHistoryDAO.getAccountGroupHistoryByIdAccountGroup(idAccountGroup);		
	}
}
