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

import com.dancosoft.socialcommunity.dao.UserRoleDAO;
import com.dancosoft.socialcommunity.model.User;
import com.dancosoft.socialcommunity.service.UserRoleService;


/**
 * <p>The class UserRoleServiceImpl use Service pattern which describes business
 * logic SocialCommunity application. Service layer perform link between,
 * presentation layer and DAO layer(UserRoleDAO).This layer is the main role
 * becouse layer contents(set of methods in classes) affect on functionality of
 * all application. This class contain methods which describes specific
 * operation for UserRole.This class perform service layer to UserRole.Class
 * extend base class CommonEntityServiceImpl and implement UserRoleService
 * interface which perform all methods of this class. For logging use fasade
 * slf4j and framework log4j. Class contain also private, static variable
 * logger, which use to call log message. Class use Spring framework anatations
 * to work with service layer.
 * 
 * @see org.springframework.stereotype
 * @see slf4j framework
 * @see log4j framework
 * 
 * @version 1.0 05.01.2016
 * @author Zaerko Denis
 */
@Service(value="userRoleService")
public class UserRoleServiceImpl extends CommonEntityServiceImpl implements UserRoleService{
	
	private static final Logger logger = LoggerFactory.getLogger(UserRoleServiceImpl.class);
	
	@Autowired
	@Qualifier(value="userRoleDAO")
	private UserRoleDAO userRoleDAO;

	public void setUserRoleDAO(UserRoleDAO userRoleDAO) {
		this.userRoleDAO = userRoleDAO;
	}
	
	/**
	 * Method return list user by user role. If users are not exist return empty list
	 * 
	 * @type String
	 * @param userRoleName
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return List<User>
	 */
	public List<User> getListUserByRole(String userRoleName) {
		
		List<User> list=Collections.emptyList();
		if (userRoleName.equals(null) || userRoleName.equals("")) {
			throw new RuntimeException("UserRoleService:Name of user role must not null and empty.");
			
		} else{
			try {
				logger.info("UserRoleService:List user with role "+userRoleName+" loaded successfully.");
				list= userRoleDAO.getListUserByRole(userRoleName);
				
			}catch (DataRetrievalFailureException rf) {
				logger.warn("UserRoleService: List of user with role "+userRoleName+" load, but list is empty=" + rf);
				
			}catch (DataAccessException da) {
				logger.error("UserRoleService:Exeption connect with data base or other error= "+da);
			}
		}
		return list;
	}
	
	/**
	 * Method return count of user with role. If users with role are not exist return zero.
	 * 
	 * @type String
	 * @type int
	 * @param userRoleName
	 * 
	 * @exception DataAccessException
	 * 
	 * @return int
	 */
	public int getCountUserByRole(String userRoleName) {
		
		int count=0;
		if (userRoleName.equals(null) || userRoleName.equals("")) {
			throw new RuntimeException("UserRoleService:Name of user role must not null and empty.");
			
		} else{
			try {
				logger.info("UserRoleService:Count of user with role " + userRoleName + " loaded successfully.");
				count= userRoleDAO.getCountUserByRole(userRoleName);
				
			} catch (DataAccessException da) {
				logger.error("UserRoleService:Exeption connect with data base or other error= "+da);
			}
		}
		return count;
	}
}
