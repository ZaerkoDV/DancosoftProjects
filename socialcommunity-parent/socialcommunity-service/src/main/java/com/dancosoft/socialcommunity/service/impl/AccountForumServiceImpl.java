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

import com.dancosoft.socialcommunity.dao.AccountForumDAO;
import com.dancosoft.socialcommunity.model.Account;
import com.dancosoft.socialcommunity.model.Forum;
import com.dancosoft.socialcommunity.service.AccountForumService;


/**
 * @author Zaerko_DV
 *
 */
@Service(value="accountForumService")
public class AccountForumServiceImpl extends CommonEntityServiceImpl implements AccountForumService {
	
	private static final Logger logger = LoggerFactory.getLogger(AccountForumServiceImpl.class);
	
	@Autowired
	@Qualifier(value="accountForumDAO")
	private AccountForumDAO accountForumDAO;

	public void setAccountForumDAO(AccountForumDAO accountForumDAO) {
		this.accountForumDAO = accountForumDAO;
	}
	
	public List<Account> getListAccountByIdForum(Long idForum) {
		logger.info("AccountForumService:List account load by id forum.");
		return accountForumDAO.getListAccountByIdForum(idForum);
	}
	
	public List<Forum> getListForumByIdAccount(Long idAccount) {
		logger.info("AccountForumService:List forum load by id account.");
		return accountForumDAO.getListForumByIdAccount(idAccount);
	}
}
