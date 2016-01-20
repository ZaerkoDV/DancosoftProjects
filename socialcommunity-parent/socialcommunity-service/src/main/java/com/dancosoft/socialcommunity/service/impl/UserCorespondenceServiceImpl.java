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

import com.dancosoft.socialcommunity.dao.UserCorespondenceDAO;
import com.dancosoft.socialcommunity.model.UserCorespondence;
import com.dancosoft.socialcommunity.service.UserCorespondenceService;

/**
 * <p>The class UserCorespondenceServiceImpl use Service pattern which describes
 * business logic SocialCommunity application. Service layer perform link
 * between, presentation layer and DAO layer(UserCorespondenceDAO).This layer is
 * the main role becouse layer contents(set of methods in classes) affect on
 * functionality of all application. This class contain methods which describes
 * specific operation for UserCorespondence.This class perform service layer to
 * UserCorespondence.Class extend base class CommonEntityServiceImpl and
 * implement UserCorespondenceService interface which perform all methods of
 * this class. For logging use fasade slf4j and framework log4j. Class contain
 * also private, static variable logger, which use to call log message. Class
 * use Spring framework anatations to work with service layer.
 * 
 * @see org.springframework.stereotype
 * @see slf4j framework
 * @see log4j framework
 * 
 * @version 1.0 05.01.2016
 * @author Zaerko Denis
 */
@Service(value="userCorespondenceService")
public class UserCorespondenceServiceImpl implements UserCorespondenceService {

	private static final Logger logger = LoggerFactory.getLogger(UserCorespondenceServiceImpl.class);
	
	@Autowired
	@Qualifier(value="userCorespondenceDAO")
	private UserCorespondenceDAO userCorespondenceDAO;

	public void setUserCorespondenceDAO(UserCorespondenceDAO userCorespondenceDAO) {
		this.userCorespondenceDAO = userCorespondenceDAO;
	}
	
	/**
	 * Method return status user corespondence by id user corespondence.
	 * 
	 * @type Long
	 * @param idUserCorespondence
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return String
	 */
	@Transactional
	public String getCorespondViewStatusByIdUserCorespond(Long idUserCorespondence) {
		
		String viewStatus=null;
		if (idUserCorespondence.equals(null)) {
			throw new RuntimeException("ForumMessageService:Id Forum messages must not null");
		} else{			
			try {
				logger.info("UserCorespondenceService: User corespondence view status loaded.");
				viewStatus= userCorespondenceDAO.getCorespondViewStatusByIdUserCorespond(idUserCorespondence);
				
			}  catch (DataRetrievalFailureException rf) {
				logger.error("UserCorespondenceService: View status not load becouse user"
						+ " corespondence with id "+idUserCorespondence+" not exist." + rf);
				
			} catch (DataAccessException da) {
				logger.error("UserCorespondenceService:Exeption connect with data base or other error= "+da);
			}
		}
		return viewStatus;
	}
	
	/**
	 * Method return list of users corespondence with view status public. If user
	 * corspondence are not exist return empty list.
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return List<UserCorespondence>
	 */
	@Transactional
	public List<UserCorespondence> getListUserCorespondenceForBroadcastInfo() {
		
		List<UserCorespondence> list=Collections.emptyList();
		try {
			logger.info("UserCorespondenceService: List users corespondence"
					+ " with public view status loaded.");
			list=userCorespondenceDAO.getListUserCorespondenceForBroadcastInfo();
			
		} catch (DataRetrievalFailureException rf) {
			logger.warn("UserCorespondenceService: List users corespondence"
					+ " with public view status load but is empty." + rf);
			
		} catch (DataAccessException da) {
			logger.error("UserCorespondenceService:Exeption connect with data base"
					+ " or other error= "+da);
		}
		return list;
	}
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method return entity by idEntity. If entity not exist return null(use
	 * hibernateTamplate method get)
	 * 
	 * @type Long
	 * @param idUserCorespondence
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return UserCorespondence
	 */
	@Transactional
	public UserCorespondence getUserCorespondenceById(Long idUserCorespondence) {
		
		UserCorespondence userCorespondence = null;
		if (idUserCorespondence.equals(null) || idUserCorespondence.equals("")) {
			throw new RuntimeException("UserCorespondenceService:Id entity is null");
		} else {
			try {
				userCorespondence = (UserCorespondence) userCorespondenceDAO.getEntityById(idUserCorespondence);
				logger.info("UserCorespondenceService:Entity loaded successfully id=" + idUserCorespondence);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("UserCorespondenceService:Not found entity in data base=" + rf);
			
			} catch (DataAccessException da) {
				logger.error("UserCorespondenceService:Exeption connect with data base or other error= "+da);
			}
		}
		return userCorespondence;
	}
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method save entity if entity not null.
	 * 
	 * @type UserCorespondence
	 * @param userCorespondence
	 * 
	 * @exception TypeMismatchDataAccessException
	 * @exception DataAccessException
	 */
	@Transactional
	public void saveUserCorespondence(UserCorespondence userCorespondence) {
		
		if(userCorespondence.equals(null)){
			throw new RuntimeException("UserCorespondenceService: Entity not save becouse entity is null.");
		} else {
			try {
				userCorespondenceDAO.saveEntity(userCorespondence);
				logger.info("UserCorespondenceService:Entity save successfully");
				
			} catch (TypeMismatchDataAccessException tm) {
				logger.error("UserCorespondenceService:New entity not save becouse mismatch field type "+tm);
				
			}catch (DataAccessException da) {
				logger.error("UserCorespondenceService:Exeption connect with data base or other error= "+da);
			}
		}
	}
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method update entity if entity not null.
	 * 
	 * @type UserCorespondence
	 * @param userCorespondence
	 * 
	 * @exception TypeMismatchDataAccessException
	 * @exception DataAccessException
	 */
	@Transactional
	public void updateUserCorespondence(UserCorespondence userCorespondence) {
		
		if (userCorespondence.equals(null)) {
			throw new RuntimeException("UserCorespondenceService: Entity not save becouse entity is null.");
		} else {
			try {
				logger.info("UserCorespondenceService:Entity update successfully");
				userCorespondenceDAO.updateEntity(userCorespondence);
				
			} catch (TypeMismatchDataAccessException tm) {
				logger.error("UserCorespondenceService:New entity not update becouse mismatch field type "+ tm);
				
			} catch (DataAccessException da) {
				logger.error("UserCorespondenceService:Exeption connect with data base or other error= "+da);
			}
		}
	}
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method delete entity by id if entity not null.
	 * 
	 * @type Long
	 * @param idUserCorespondence
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 */
	@Transactional
	public void deleteUserCorespondenceById(Long idUserCorespondence) {
		
		if (idUserCorespondence.equals(null) || idUserCorespondence.equals("")) {
			throw new RuntimeException("UserCorespondenceService:Id entity is null");
		} else{
			try {
				logger.info("UserCorespondenceService:Entity delete successfully,id=" + idUserCorespondence);
				userCorespondenceDAO.deleteEntityById(idUserCorespondence);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("UserCorespondenceService: Operation delete is faled becouse"
						+ " not found entity in data base by id=" + rf);
				
			} catch (DataAccessException da) {
				logger.error("UserCorespondenceService:Exeption connect with data base or other error= "+da);
			}
		}
	}
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method delete entity if entity not null.
	 * 
	 * @type UserCorespondence
	 * @param userCorespondence
	 * @exception DataAccessException
	 */
	@Transactional
	public void deleteUserCorespondence(UserCorespondence userCorespondence) {
		
		if (userCorespondence.equals(null)) {
			throw new RuntimeException("UserCorespondenceService: Object is "+userCorespondence+ " yet and not delete again.");
		}else{
			try {
				logger.info("UserCorespondenceService:Entity " + userCorespondence + " delete successfully");
				userCorespondenceDAO.deleteEntity(userCorespondence);
				
			} catch (DataAccessException da) {
				logger.error("UserCorespondenceService:Exeption connect with data base or other error= "+da);
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
	public List<Object> getListEntity() {
		
		List<Object>list=Collections.emptyList();
		try {
			logger.info("UserCorespondenceService: List of entity load");
			list=userCorespondenceDAO.getListEntity();
			
		} catch (DataRetrievalFailureException rf) {
			logger.warn("UserCorespondenceService: List of entity not load becouse list is empty=" + rf);
			
		}catch (DataAccessException da) {
			logger.error("UserCorespondenceService:Exeption connect with data base or other error= "+da);
		}
		return list;
	}
}
