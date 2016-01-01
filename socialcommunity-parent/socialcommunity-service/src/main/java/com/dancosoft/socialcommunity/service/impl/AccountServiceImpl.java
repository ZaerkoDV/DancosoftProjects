/**
 * 
 */
package com.dancosoft.socialcommunity.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
		logger.info("AccountService:List account loaded by account name, last name.");
		return accountDAO.searchAccountByAccountNameUserLastName(accountName, lastName);
	}
	
	public Long getIdUserByIdAccount(Long idAccount) {
		logger.info("AccountService:Id user load by id account.");
		return accountDAO.getIdUserByIdAccount(idAccount);
	}
	
	public Boolean isAccountBlock(Long idAccount) {
		logger.info("AccountService: Check account on block status");
		return accountDAO.isAccountBlock(idAccount);
	}
	
	public String getAccountStatus(Long idAccount) {
		logger.info("AccountService: Account status is load.");
		return accountDAO.getAccountStatus(idAccount);
	}
}
