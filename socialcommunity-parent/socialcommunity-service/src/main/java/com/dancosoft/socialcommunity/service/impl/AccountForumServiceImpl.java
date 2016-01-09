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
 * <p>The class AccountForumServiceImpl use Service pattern which describes business logic
 * SocialCommunity application. Service layer perform link between, presentation layer and
 * DAO layer(AccountForumDAO).This layer is the main role becouse layer contents(set of
 * methods in classes) affect on functionality of all application.
 * This class contain methods which describes specific operation for AccountForum.This class
 * perform service layer to AccountForum.Class extend base class CommonEntityServiceImpl and
 * implement AccountForumService interface which perform all methods of this class.For logging
 * use fasade slf4j and framework log4j. Class contain also private, static variable logger,
 * which use to call log message. Class use Spring framework anatations to work with service layer. 
 *  
 * @see org.springframework.stereotype
 * @see slf4j framework
 * @see log4j framework
 * 
 * @version 1.0 05.01.2016
 * @author Zaerko Denis
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
	
	/**
	 * Method return list forum by id account. List contain forums which use in account.
	 * 
	 * @type Long
	 * @param idForum
	 * @exception DataRetrievalFailureException
	 * @exeption DataAccessException
	 * 
	 * @return List<Account>
	 */
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
	
	/**
	 * Method return list forum by id account. List contain accounts which use in forum.
	 * 
	 * @type Long
	 * @param idAccount
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return List<Forum>
	 */
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
