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

import com.dancosoft.socialcommunity.dao.UserAutobiographyDAO;
import com.dancosoft.socialcommunity.model.User;
import com.dancosoft.socialcommunity.model.UserAutobiography;
import com.dancosoft.socialcommunity.service.UserAutobiographyService;

/**
 * <p>The class UserAutobiographyServiceImpl use Service pattern which describes
 * business logic SocialCommunity application. Service layer perform link
 * between, presentation layer and DAO layer(UserAutobiographyDAO).This layer is
 * the main role becouse layer contents(set of methods in classes) affect on
 * functionality of all application. This class contain methods which describes
 * specific operation for UserAutobiography.This class perform service layer to
 * UserAutobiography.Class extend base class CommonEntityServiceImpl and
 * implement UserAutobiographyService interface which perform all methods of
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
@Service(value="userAutobiographyService")
public class UserAutobiographyServiceImpl implements UserAutobiographyService{

	private static final Logger logger = LoggerFactory.getLogger(UserAutobiographyServiceImpl.class);
	
	@Autowired
	@Qualifier(value="userAutobiographyDAO")
	private UserAutobiographyDAO userAutobiographyDAO;

	public void setUserAutobiographyDAO(UserAutobiographyDAO userAutobiographyDAO) {
		this.userAutobiographyDAO = userAutobiographyDAO;
	}
	
	/**
	 * Method return user autobiogeaphy by id user. If user autobiography
	 * is not exist return null
	 * 
	 * @type Long
	 * @param idUser
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return UserAutobiography
	 */
	@Transactional
	public UserAutobiography getUserAutobiographyByIdUser(Long idUser) {
		
		UserAutobiography userAutobiography=null;
		if (idUser.equals(null) || idUser.equals("")) {
			throw new RuntimeException("UserAutobiographyService:Id user must not null or empty.");
		} else{
			try {
				logger.info("UserAutobiographyService: User autobiography load by id user.");
				userAutobiography= userAutobiographyDAO.getUserAutobiographyByIdUser(idUser);	
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("UserAutobiographyService: User with id "+idUser+" not exist." + rf);
				
			} catch (DataAccessException da) {
				logger.error("UserAutobiographyService:Exeption connect with data base or other error= "+da);
			}
		}
		return userAutobiography;
	}
	
	/**
	 * Method return list of user with the same hobby.
	 * If users are not exist return empty list.
	 * 
	 * @type String
	 * @param hobby
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return UserAutobiography
	 */
	@Transactional
	public List<User> getListUserByHobby(String hobby) {
		
		List<User> list=Collections.emptyList();
		if (hobby.equals(null) || hobby.equals("")) {
			throw new RuntimeException("ForumMessageService:Hobby must not null and empty.");
		} else{
			try {
				logger.info("UserAutobiographyService:List user loaded by hobby.");
				list= userAutobiographyDAO.getListUserByHobby(hobby);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("UserAutobiographyService:List of user with hobby "+hobby+""
						+ " load but is empty" + rf);
				
			} catch (DataAccessException da) {
				logger.error("UserAutobiographyService:Exeption connect with data base or other error= "+da);
			}
		}
		return list;
	}
	
	/**
	 * Method return result of check user no adult value. Yers Adult is
	 * year value after which user become adult status. If user is adult
	 * returm true else false.
	 * 
	 * @type Long
	 * @param idUser
	 * @param yearAdult
	 * 
	 * @exception DataAccessException
	 * 
	 * @return Boolean
	 */
	@Transactional
	public Boolean isUserAdult(Long idUser,Long yearAdult) {
		
		Boolean isUserAdult=false;
		if (idUser.equals(null)) {
			throw new RuntimeException("UserAutobiographyService:Id user must not null.");
			
		} else if(yearAdult.equals(null) || yearAdult<0){
			throw new RuntimeException("UserAutobiographyService: Adult year must nor null and less then zero.");
			
		}else{
			try {
				logger.info("UserAutobiographyService:Check user on adult");
				isUserAdult= userAutobiographyDAO.isUserAdult(idUser, yearAdult);
		
			} catch (DataAccessException da) {
				logger.error("ForumMessageService:Exeption connect with data base or other error= "+da);
			}
		}
		return isUserAdult;
	}
	
	/**
	 * Method return list of adult user. If adult users are
	 * not exist return empty list.
	 * 
	 * @type Long
	 * @param yearAdult
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return List<User>
	 */
	@Transactional
	public List<User> getListAdultUser(Long yearAdult) {
		
		List<User> list=Collections.emptyList();
		if(yearAdult.equals(null) || yearAdult<0){
			throw new RuntimeException("UserAutobiographyService: Adult year must nor null and less then zero.");
			
		}else{
			try {
				logger.info("UserAutobiographyService:List adult user loaded");
				list= userAutobiographyDAO.getListAdultUser(yearAdult);
				 
			} catch (DataRetrievalFailureException rf) {
				logger.warn("UserAutobiographyService:List of adult user load but list is empty" + rf);
				
			} catch (DataAccessException da) {
				logger.error("UserAutobiographyService:Exeption connect with data base or other error= "+da);
			}
		}
		return list;
	}
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method return entity by idEntity. If entity not exist return null(use
	 * hibernateTamplate method get)
	 * 
	 * @type Long
	 * @param idUserAutobiographyService
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return UserAutobiographyService
	 */
	@Transactional
	public UserAutobiography getUserAutobiographyById(Long idUserAutobiography) {
		
		UserAutobiography userAutobiography = null;
		if (idUserAutobiography.equals(null) || idUserAutobiography.equals("")) {
			throw new RuntimeException("UserAutobiographyService:Id entity is null");
		} else {
			try {
				userAutobiography = (UserAutobiography) userAutobiographyDAO.getEntityById(idUserAutobiography);
				logger.info("UserAutobiographyService:Entity loaded successfully id=" + idUserAutobiography);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("UserAutobiographyService:Not found entity in data base=" + rf);
			
			} catch (DataAccessException da) {
				logger.error("UserAutobiographyService:Exeption connect with data base or other error= "+da);
			}
		}
		return userAutobiography;
	}
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method save entity if entity not null.
	 * 
	 * @type UserAutobiography
	 * @param userAutobiography
	 * 
	 * @exception TypeMismatchDataAccessException
	 * @exception DataAccessException
	 */
	@Transactional
	public void saveUserAutobiographyService(UserAutobiography userAutobiography) {
		
		if(userAutobiography.equals(null)){
			throw new RuntimeException("UserAutobiographyService: Entity not save becouse entity is null.");
		} else {
			try {
				userAutobiographyDAO.saveEntity(userAutobiography);
				logger.info("UserAutobiographyService:Entity save successfully");
				
			} catch (TypeMismatchDataAccessException tm) {
				logger.error("UserAutobiographyService:New entity not save becouse mismatch field type "+tm);
				
			}catch (DataAccessException da) {
				logger.error("UserAutobiographyService:Exeption connect with data base or other error= "+da);
			}
		}
	}
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method update entity if entity not null.
	 * 
	 * @type UserAutobiography
	 * @param userAutobiography
	 * 
	 * @exception TypeMismatchDataAccessException
	 * @exception DataAccessException
	 */
	@Transactional
	public void updateUserAutobiography(UserAutobiography userAutobiography) {
		
		if (userAutobiography.equals(null)) {
			throw new RuntimeException("UserAutobiographyService: Entity not save becouse entity is null.");
		} else {
			try {
				logger.info("UserAutobiographyService:Entity update successfully");
				userAutobiographyDAO.updateEntity(userAutobiography);
				
			} catch (TypeMismatchDataAccessException tm) {
				logger.error("UserAutobiographyService:New entity not update becouse mismatch field type "+ tm);
				
			} catch (DataAccessException da) {
				logger.error("UserAutobiographyService:Exeption connect with data base or other error= "+da);
			}
		}
	}
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method delete entity by id if entity not null.
	 * 
	 * @type Long
	 * @param idUserAutobiography
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 */
	@Transactional
	public void deleteUserAutobiographyById(Long idUserAutobiography) {
		
		if (idUserAutobiography.equals(null) || idUserAutobiography.equals("")) {
			throw new RuntimeException("UserAutobiographyService:Id entity is null");
		} else{
			try {
				logger.info("UserAutobiographyService:Entity  delete successfully,id=" + idUserAutobiography);
				userAutobiographyDAO.deleteEntityById(idUserAutobiography);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("UserAutobiographyService: Operation delete is faled becouse"
						+ " not found entity in data base by id=" + rf);
				
			} catch (DataAccessException da) {
				logger.error("UserAutobiographyService:Exeption connect with data base or other error= "+da);
			}
		}
	}
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method delete entity if entity not null.
	 * 
	 * @type UserAutobiography
	 * @param userAutobiography
	 * @exception DataAccessException
	 */
	@Transactional
	public void deleteUserAutobiography(UserAutobiography userAutobiography) {
		
		if (userAutobiography.equals(null)) {
			throw new RuntimeException("UserAutobiographyService: Object is "+userAutobiography+ " yet and not delete again.");
		}else{
			try {
				logger.info("UserAutobiographyService:Entity " + userAutobiography + " delete successfully");
				userAutobiographyDAO.deleteEntity(userAutobiography);
				
			} catch (DataAccessException da) {
				logger.error("UserAutobiographyService:Exeption connect with data base or other error= "+da);
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
	public List<Object> getListUserAutobiography() {
		
		List<Object>list=Collections.emptyList();
		try {
			logger.info("UserAutobiographyService: List of entity load");
			list=userAutobiographyDAO.getListEntity();
			
		} catch (DataRetrievalFailureException rf) {
			logger.warn("UserAutobiographyService: List of entity not load becouse list is empty=" + rf);
			
		}catch (DataAccessException da) {
			logger.error("UserAutobiographyService:Exeption connect with data base or other error= "+da);
		}
		return list;
	}
}
