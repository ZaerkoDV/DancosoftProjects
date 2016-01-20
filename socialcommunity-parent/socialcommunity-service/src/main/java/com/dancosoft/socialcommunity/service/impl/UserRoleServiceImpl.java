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
import org.springframework.dao.TypeMismatchDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dancosoft.socialcommunity.dao.UserRoleDAO;
import com.dancosoft.socialcommunity.model.User;
import com.dancosoft.socialcommunity.model.UserRole;
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
public class UserRoleServiceImpl implements UserRoleService{
	
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
	@Transactional
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
	@Transactional
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
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method return entity by idEntity. If entity not exist return null(use
	 * hibernateTamplate method get)
	 * 
	 * @type Long
	 * @param idUserRole
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return UserRole
	 */
	@Transactional
	public UserRole getUserRoleById(Long idUserRole) {
		
		UserRole userRole = null;
		if (idUserRole.equals(null) || idUserRole.equals("")) {
			throw new RuntimeException("UserRoleService:Id entity is null");
		} else {
			try {
				userRole = (UserRole) userRoleDAO.getEntityById(idUserRole);
				logger.info("UserRoleService:Entity loaded successfully id=" + idUserRole);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("UserRoleService:Not found entity in data base=" + rf);
				
			} catch (DataAccessException da) {
				logger.error("UserRoleService:Exeption connect with data base or other error= "+da);
			}
		}
		return userRole;
	}
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method save entity if entity not null.
	 * 
	 * @type UserRole
	 * @param userRole
	 * 
	 * @exception TypeMismatchDataAccessException
	 * @exception DataAccessException
	 */
	@Transactional
	public void saveUserRole(UserRole userRole) {
		
		if(userRole.equals(null)){
			throw new RuntimeException("UserRoleService: Entity not save becouse entity is null.");
		} else {
			try {
				userRoleDAO.saveEntity(userRole);
				logger.info("UserRoleService:Entity save successfully");
				
			} catch (TypeMismatchDataAccessException tm) {
				logger.error("UserRoleService:New entity not save becouse mismatch field type "+tm);
				
			}catch (DataAccessException da) {
				logger.error("UserRoleService:Exeption connect with data base or other error= "+da);
			}
		}
	}
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method update entity if entity not null.
	 * 
	 * @type UserRole
	 * @param userRole
	 * 
	 * @exception TypeMismatchDataAccessException
	 * @exception DataAccessException
	 */
	@Transactional
	public void updateUserRole(UserRole userRole) {
		
		if (userRole.equals(null)) {
			throw new RuntimeException("UserRoleService: Entity not save becouse entity is null.");
		} else {
			try {
				logger.info("UserRoleService:Entity update successfully");
				userRoleDAO.updateEntity(userRole);
				
			} catch (TypeMismatchDataAccessException tm) {
				logger.error("UserRoleService:New entity not update becouse mismatch field type "+ tm);
				
			} catch (DataAccessException da) {
				logger.error("UserRoleService:Exeption connect with data base or other error= "+da);
			}
		}
	}
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method delete entity by id if entity not null.
	 * 
	 * @type Long
	 * @param idUserRole
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 */
	@Transactional
	public void deleteUserRoleById(Long idUserRole) {
		
		if (idUserRole.equals(null) || idUserRole.equals("")) {
			throw new RuntimeException("UserRoleService:Id entity is null");
		} else{
			try {
				logger.info("UserRoleService:Entity  delete successfully,id=" + idUserRole);
				userRoleDAO.deleteEntityById(idUserRole);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("UserRoleService: Operation delete is faled becouse"
						+ " not found entity in data base by id=" + rf);
				
			} catch (DataAccessException da) {
				logger.error("UserRoleService:Exeption connect with data base or other error= "+da);
			}
		}
	}
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method delete entity if entity not null.
	 * 
	 * @type UserRole
	 * @param userRole
	 * 
	 * @exception DataAccessException
	 */
	@Transactional
	public void deleteUserRoleService(UserRole userRole) {
		
		if (userRole.equals(null)) {
			throw new RuntimeException("UserRoleService: Object is "+userRole+ " yet and not delete again.");
		}else{
			try {
				logger.info("UserRoleService:Entity " + userRole + " delete successfully");
				userRoleDAO.deleteEntity(userRole);
				
			} catch (DataAccessException da) {
				logger.error("UserRoleService:Exeption connect with data base or other error= "+da);
			}
		}
	}
	
	/**
	 * This method is basic for all entities. Method return list of entity. If entyty
	 * list not load return empty list.
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return List<Object>
	 */
	@Transactional
	public List<Object> getListUserRole() {
		
		List<Object>list=Collections.emptyList();
		try {
			logger.info("UserRoleService: List of entity load");
			list=userRoleDAO.getListEntity();
			
		} catch (DataRetrievalFailureException rf) {
			logger.warn("UserRoleService: List of entity not load becouse list is empty=" + rf);
			
		}catch (DataAccessException da) {
			logger.error("UserRoleService:Exeption connect with data base or other error= "+da);
		}
		return list;
	}
}
