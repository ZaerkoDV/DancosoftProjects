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

import com.dancosoft.socialcommunity.dao.UserDAO;
import com.dancosoft.socialcommunity.model.Account;
import com.dancosoft.socialcommunity.model.User;
import com.dancosoft.socialcommunity.service.UserService;

/**
 * <p>The class UserServiceImpl use Service pattern which describes business logic
 * SocialCommunity application. Service layer perform link between, presentation
 * layer and DAO layer(UserDAO).This layer is the main role becouse layer
 * contents(set of methods in classes) affect on functionality of all
 * application. This class contain methods which describes specific operation
 * for User.This class perform service layer to User.Class extend base class
 * CommonEntityServiceImpl and implement UserService interface which perform all
 * methods of this class. For logging use fasade slf4j and framework log4j.
 * Class contain also private, static variable logger, which use to call log
 * message. Class use Spring framework anatations to work with service layer.
 * 
 * @see org.springframework.stereotype
 * @see slf4j framework
 * @see log4j framework
 * 
 * @version 1.0 05.01.2016
 * @author Zaerko Denis
 */
@Service(value="userService")
public class UserServiceImpl extends CommonEntityServiceImpl implements UserService{

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	@Qualifier(value="userDAO")
	private UserDAO userDAO;

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	/**
	 * Method return list of user accounts. If user accounts are
	 * not exist return empty list.
	 * 
	 * @type Long
	 * @param idUser
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return List<Account>
	 */
	public List<Account> getListAccountByUserId(Long idUser) {
		
		List<Account> list=Collections.emptyList();
		if (idUser.equals(null)) {
			throw new RuntimeException("UserService:Id user must not null");
			
		} else{
			try {
				logger.info("UserService: Accounts by user id load.");
				list= userDAO.getListAccountByUserId(idUser);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("UserService:Accounts not belong to user with id "+idUser+".List is empty." + rf);
				
			} catch (DataAccessException da) {
				logger.error("UserService: Exeption connect with data base or other error= "+da);
			}
		}
		return list;
	}
	
	/**
	 * Method return list of user which belong to sex. If list
	 * of user is not exist return empty list
	 * 
	 * @type String
	 * @param sex
	 * 
	 * @exception DataRetrievalFailureException 
	 * @exception DataAccessException
	 * 
	 * @return List<User>
	 */
	public List<User> getListUserBySex(String sex) {
		
		List<User> list=Collections.emptyList();
		if (sex.equals(null) || sex.equals("")) {
			throw new RuntimeException("UserService:Sex must not null");
			
		} else{
			try {
				logger.info("UserService:List user loaded by sex");
				list= userDAO.getListUserBySex(sex);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("UserService:List of user with sex "+sex+" load, but list is empty. " + rf);
				
			} catch (DataAccessException da) {
				logger.error("UserService: Exeption connect with data base or other error= "+da);
			}
		}
		return list;
	}
	
	/**
	 * Method return list of user by first name, last name, middle name.
	 * If list user is not exist return empty list 
	 * 
	 * @type String
	 * @param firstName
	 * @param lastName
	 * @param middleName
	 * 
	 * @exception DataAccessException
	 * 
	 * @return List<User>
	 */
	public List<User> searchUserByFirstLastMiddleName(String firstName,String lastName,String middleName) {
		
		List<User> list=Collections.emptyList();
		try {
			logger.info("UserService:List user loaded by first name, last name, middle name.");
			list= userDAO.searchUserByFirstLastMiddleName(firstName, lastName, middleName);
			
		} catch (DataAccessException da) {
			logger.error("UserService: Exeption connect with data base or other error= "+da);
		}
		return list;
	}
}
