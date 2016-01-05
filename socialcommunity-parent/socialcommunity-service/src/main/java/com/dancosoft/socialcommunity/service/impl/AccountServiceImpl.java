/**
 * 
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
 * @author Zaerko_DV
 *
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
