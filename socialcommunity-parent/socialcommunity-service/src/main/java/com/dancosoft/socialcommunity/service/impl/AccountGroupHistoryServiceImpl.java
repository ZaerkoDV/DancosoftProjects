/**
 * 
 */
package com.dancosoft.socialcommunity.service.impl;

import javax.persistence.NonUniqueResultException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataRetrievalFailureException;
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
}
