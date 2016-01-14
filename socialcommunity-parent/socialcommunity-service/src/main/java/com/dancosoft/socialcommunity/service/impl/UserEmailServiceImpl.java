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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.NonUniqueResultException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.dao.TypeMismatchDataAccessException;
import org.springframework.stereotype.Service;

import com.dancosoft.socialcommunity.dao.UserEmailDAO;
import com.dancosoft.socialcommunity.model.UserEmail;
import com.dancosoft.socialcommunity.service.UserEmailService;

/**
 * <p>The class UserEmailServiceImpl use Service pattern which describes business
 * logic SocialCommunity application. Service layer perform link between,
 * presentation layer and DAO layer(UserEmailDAO).This layer is the main role
 * becouse layer contents(set of methods in classes) affect on functionality of
 * all application. This class contain methods which describes specific
 * operation for UserEmail.This class perform service layer to UserEmail.Class
 * extend base class CommonEntityServiceImpl and implement UserEmailService
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
@Service(value="userEmailService")
public class UserEmailServiceImpl implements UserEmailService {

	private static final Logger logger = LoggerFactory.getLogger(UserEmailServiceImpl.class);	
	
	private Pattern pattern;

	private Matcher matcher;
	
	private static final String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	@Autowired
	@Qualifier(value="userEmailDAO")
	private UserEmailDAO userEmailDAO;

	public void setUserEmailDAO(UserEmailDAO userEmailDAO) {
		this.userEmailDAO = userEmailDAO;
	}
	
	/**
	 * Method return list of user email with view status. If list is not exist return empty list.
	 * 
	 * @type Long
	 * @type String
	 * @param idUser
	 * @param viewStatus
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return List<UserEmail>
	 */
	public List<UserEmail> getListEmailWithStatusByIdUser(Long idUser,String viewStatus){
		
		List<UserEmail> list=Collections.emptyList();
		if (idUser.equals(null)) {
			throw new RuntimeException("UserEmailService:Id user must not null");
			
		}else if(viewStatus.equals(null) || viewStatus.equals("")){
			throw new RuntimeException("UserEmailService:View status must not null");
			
		}else{
			try {
				logger.info("UserEmailService:List of user email with status loaded by id user.");
				list= userEmailDAO.getListEmailWithStatusByIdUser(idUser, viewStatus);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("UserEmailService: List of user email with status loaded by id user.But list is empty." + rf);
				
			} catch (DataAccessException da) {
				logger.error("UserEmailService:Exeption connect with data base or other error= "+da);
			}
		}
		return list;
	}
	
	/**
	 * Method return list of user email by user id. If list
	 * is not exist return empty list.
	 * 
	 * @type Long
	 * @param idUser
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return List<UserEmail>
	 */
	public List<UserEmail> getListEmailByIdUser(Long idUser){
		
		List<UserEmail> list=Collections.emptyList();
		if (idUser.equals(null)) {
			throw new RuntimeException("UserEmailService:Id user must not null");
			
		}else{
			try {
				logger.info("UserEmailService:List of user email loaded by id user.");
				list= userEmailDAO.getListEmailByIdUser(idUser);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("UserEmailService:List of user email loaded by id user.But list is empty." + rf);
				
			} catch (DataAccessException da) {
				logger.error("UserEmailService:Exeption connect with data base or other error= "+da);
			}
		}
		return list;
	}
	
	/**
	 * Method check user email on unique value. If user email
	 * is not unique return false else true.
	 * 
	 * @type String
	 * @param userEmail
	 * 
	 * @exception NonUniqueResultException
	 * @exception DataAccessException
	 * 
	 * @return Boolean
	 */
	public Boolean isUniqueEmail(String userEmail){
		
		Boolean isUnique=false;
		if (userEmail.equals(null)) {
			throw new RuntimeException("UserEmailService:User email must not null");
		}else{
			try {
				logger.info("UserEmailService:Check user email on unique value.");
				isUnique= userEmailDAO.isUniqueEmail(userEmail);
				
			} catch (NonUniqueResultException nu) {
				logger.error("UserEmailService:Email is not unique." + nu);
				
			}catch (DataAccessException da) {
				logger.error("UserEmailService: Exeption connect with data base or other error= "+da);
			}
		}
		return isUnique; 
	}
	
	/**
	 * Method return id user by user email. If user is not exist return null.
	 * 
	 * @type String
	 * @param userEmail
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception NonUniqueResultException
	 * @exception DataAccessException
	 * 
	 * @return long
	 */
	public Long getIdUserByEmail(String userEmail){
		
		Long idUser=null;
		if (userEmail.equals(null)) {
			throw new RuntimeException("UserEmailService:User email must not null");
			
		}else{
			try {
				logger.info("UserEmailService:User id load by email");
				idUser= userEmailDAO.getIdUserByEmail(userEmail);
				
			}catch(DataRetrievalFailureException rf){
				logger.warn("UserEmailService:Id user with email not exist." + rf);
				
			} catch (NonUniqueResultException nu) {
				logger.error("UserEmailService:Email is not unique." + nu);
				
			}catch (DataAccessException da) {
				logger.error("UserEmailService: Exeption connect with data base or other error= "+da);
			}
		}
		return idUser;
	}
	
	/**
	 * Method check email on valid value. If valid return true else return false.
	 * 
	 * @type String
	 * @type Boolean
	 * @param email
	 * 
	 * @exception Exception
	 * 
	 * @return Boolean. If email is valid return true else false.
	 */
	public Boolean isValidEmail(String email){
		
		logger.info("UserEmailService:Cheack email on valid value is completed.");
		Boolean isValid;
		try {
			pattern = Pattern.compile(emailPattern);
			matcher = pattern.matcher(email);
			isValid=matcher.matches();
			
		} catch (Exception e) {
			isValid=false;
			logger.error("UserEmailService: Email "+email+" is invalid. ");
		}
		return isValid;
	}
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method return entity by idEntity. If entity not exist return null(use
	 * hibernateTamplate method get)
	 * 
	 * @type Long
	 * @param idUserEmail
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return UserEmail
	 */
	public UserEmail getUserEmailById(Long idUserEmail) {
		
		UserEmail userEmail = null;
		if (idUserEmail.equals(null) || idUserEmail.equals("")) {
			throw new RuntimeException("UserEmailService:Id entity is null");
		} else {
			try {
				userEmail= (UserEmail) userEmailDAO.getEntityById(idUserEmail);
				logger.info("UserEmailService:Entity loaded successfully id=" + idUserEmail);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("UserEmailService:Not found entity in data base=" + rf);
			
			} catch (DataAccessException da) {
				logger.error("UserEmailService:Exeption connect with data base or other error= "+da);
			}
		}
		return userEmail;
	}
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method save entity if entity not null.
	 * 
	 * @type UserEmail
	 * @param userEmail
	 * 
	 * @exception TypeMismatchDataAccessException
	 * @exception DataAccessException
	 */
	public void saveUserEmail(UserEmail userEmail) {
		
		if(userEmail.equals(null)){
			throw new RuntimeException("UserEmailService: Entity not save becouse entity is null.");
		} else {
			try {
				userEmailDAO.saveEntity(userEmail);
				logger.info("UserEmailService:Entity save successfully");
				
			} catch (TypeMismatchDataAccessException tm) {
				logger.error("UserEmailService:New entity not save becouse mismatch field type "+tm);
			}catch (DataAccessException da) {
				logger.error("UserEmailService:Exeption connect with data base or other error= "+da);
			}
		}
	}
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method update entity if entity not null.
	 * 
	 * @type UserEmail
	 * @param userEmail
	 * 
	 * @exception TypeMismatchDataAccessException
	 * @exception DataAccessException
	 */
	public void updateUserEmail(UserEmail userEmail) {
		
		if (userEmail.equals(null)) {
			throw new RuntimeException("UserEmailService: Entity not save becouse entity is null.");
		} else {
			try {
				logger.info("UserEmailService:Entity update successfully");
				userEmailDAO.updateEntity(userEmail);
				
			} catch (TypeMismatchDataAccessException tm) {
				logger.error("UserEmailService:New entity not update becouse mismatch field type "+ tm);
				
			} catch (DataAccessException da) {
				logger.error("UserEmailService:Exeption connect with data base or other error= "+da);
			}
		}
	}
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method delete entity by id if entity not null.
	 * 
	 * @type Long
	 * @param idUserEmail
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 */
	public void deleteUserEmailById(Long idUserEmail) {
		
		if (idUserEmail.equals(null) || idUserEmail.equals("")) {
			throw new RuntimeException("UserEmailService:Id entity is null");
		} else{
			try {
				logger.info("UserEmailService:Entity delete successfully,id=" + idUserEmail);
				userEmailDAO.deleteEntityById(idUserEmail);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("UserEmailService: Operation delete is faled becouse"
						+ " not found entity in data base by id=" + rf);
				
			} catch (DataAccessException da) {
				logger.error("UserEmailService:Exeption connect with data base or other error= "+da);
			}
		}
	}
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method delete entity if entity not null.
	 * 
	 * @type UserEmail
	 * @param userEmail
	 * @exception DataAccessException
	 */
	public void deleteUserEmail(UserEmail userEmail) {
		
		if (userEmail.equals(null)) {
			throw new RuntimeException("UserEmailService: Object is "+userEmail+ " yet and not delete again.");
		}else{
			try {
				logger.info("UserEmailService:Entity " + userEmail + " delete successfully");
				userEmailDAO.deleteEntity(userEmail);
				
			} catch (DataAccessException da) {
				logger.error("UserEmailService:Exeption connect with data base or other error= "+da);
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
	public List<Object> getListEntity() {
		
		List<Object>list=Collections.emptyList();
		try {
			logger.info("UserEmailService: List of entity load");
			list=userEmailDAO.getListEntity();
			
		} catch (DataRetrievalFailureException rf) {
			logger.warn("UserEmailService: List of entity not load becouse list is empty=" + rf);
			
		}catch (DataAccessException da) {
			logger.error("UserEmailService:Exeption connect with data base or other error= "+da);
		}
		return list;
	}
}
