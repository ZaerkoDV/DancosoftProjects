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
		
		List<Account> list;
		if (idForum.equals(null) || idForum.equals("")) {
			throw new RuntimeException("AccountForumService: id forum must not null");
			
		}else{
			try {
				logger.info("AccountForumService:List account load by id forum.");
				list=accountForumDAO.getListAccountByIdForum(idForum);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("AccountForumService:Not found account in data base by id forum. List is empty. " + rf);
				list=Collections.emptyList();
				
			} catch (DataAccessException da) {
				logger.error("AccountForumService:Exeption connect with data base or other error= "+da);
				list=Collections.emptyList();
			}
		}
		return list;
	}
	
	public List<Forum> getListForumByIdAccount(Long idAccount) {
		
		List<Forum> list;
		if (idAccount.equals(null) || idAccount.equals("")) {
			throw new RuntimeException("AccountForumService: id account must not null");
		}else{
			try {
				logger.info("AccountForumService:List forum load by id account.");
				list= accountForumDAO.getListForumByIdAccount(idAccount);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("AccountForumService:Not found forum in data base by id account. List is empty." + rf);
				list=Collections.emptyList();
				
			} catch (DataAccessException da) {
				logger.error("AccountForumService:Exeption connect with data base or other error= "+da);
				list=Collections.emptyList();
			}
		}
		return list;
	}
}
