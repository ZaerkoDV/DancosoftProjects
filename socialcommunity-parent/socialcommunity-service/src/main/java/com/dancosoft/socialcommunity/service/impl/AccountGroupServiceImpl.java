/**
 * 
 */
package com.dancosoft.socialcommunity.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.dancosoft.socialcommunity.dao.AccountGroupDAO;
import com.dancosoft.socialcommunity.model.AccountGroup;
import com.dancosoft.socialcommunity.service.AccountGroupService;

/**
 * @author Zaerko_DV
 *
 */
public class AccountGroupServiceImpl extends CommonEntityServiceImpl implements AccountGroupService {

	private static final Logger logger = LoggerFactory.getLogger(AccountGroupServiceImpl.class);
	
	@Autowired
	@Qualifier(value="accountGroupDAO")
	private AccountGroupDAO accountGroupDAO;

	public void setAccountGroupDAO(AccountGroupDAO accountGroupDAO) {
		this.accountGroupDAO = accountGroupDAO;
	}
	
	public Boolean isBlockAccountGroup(Long idAccountGroup) {
		logger.info("AccountGroupService:Check account group on block.");
		return accountGroupDAO.isBlockAccountGroup(idAccountGroup);
	}
	
	public String getAccountGroupBlockStatus(Long idAccount) {
		logger.info("AccountGroupService:Account group status is load.");
		return accountGroupDAO.getAccountGroupBlockStatus(idAccount);
	}
	
	public List<AccountGroup> getListAccountGroupWithBlockStatusByIdAccount(Long idAccount,String blockStatus) {
		logger.info("AccountGroupService:List AccountGroup with block status load by id account");
		return accountGroupDAO.getListAccountGroupWithBlockStatusByIdAccount(idAccount, blockStatus);
	}
	
	public List<AccountGroup> searchAccountGroupByGroupNameAccountName(String groupName, String accountName) {
		logger.info("AccountGroupService:List AccountGroup load by groupName and accountName.");
		return accountGroupDAO.searchAccountGroupByGroupNameAccountName(groupName, accountName);
	}
	
	public List<AccountGroup> getListAccountGroupWithViewStatusByIdAccount(Long idAccount,String viewStatus){
		logger.info("AccountGroupService:List AccountGroup with  view status load by id account");
		return accountGroupDAO.getListAccountGroupWithViewStatusByIdAccount(idAccount, viewStatus);
	}
}
