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

import javax.persistence.NonUniqueResultException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.stereotype.Service;

import com.dancosoft.socialcommunity.dao.UserEmailDAO;
import com.dancosoft.socialcommunity.dao.UserSecurityDAO;
import com.dancosoft.socialcommunity.model.User;
import com.dancosoft.socialcommunity.model.UserEmail;
import com.dancosoft.socialcommunity.model.UserSecurity;
import com.dancosoft.socialcommunity.service.UserSecurityService;
import com.dancosoft.socialcommunity.service.support.email.EmailCreator;
import com.dancosoft.socialcommunity.service.support.security.GeneratorSecurityFeature;

/**
 * <p>The class UserSecurityServiceImpl use Service pattern which describes
 * business logic SocialCommunity application. Service layer perform link
 * between, presentation layer and DAO layer(UserSecurityDAO).This layer is the
 * main role becouse layer contents(set of methods in classes) affect on
 * functionality of all application. This class contain methods which describes
 * specific operation for UserSecurity.This class perform service layer to
 * UserSecurity.Class extend base class CommonEntityServiceImpl and implement
 * UserSecurityService interface which perform all methods of this class. For
 * logging use fasade slf4j and framework log4j. Class contain also private,
 * static variable logger, which use to call log message. Class use Spring
 * framework anatations to work with service layer.
 * 
 * @see org.springframework.stereotype
 * @see slf4j framework
 * @see log4j framework
 * 
 * @version 1.0 05.01.2016
 * @author Zaerko Denis
 */
@Service(value="userSecurityService")
public class UserSecurityServiceImpl extends CommonEntityServiceImpl implements UserSecurityService {

	private static final Logger logger = LoggerFactory.getLogger(UserSecurityServiceImpl.class);
	
	//length password as parametr
	GeneratorSecurityFeature generator= new GeneratorSecurityFeature(8);
	
	EmailCreator emailCreator=new EmailCreator();
	
	//LetterSender sender= new LetterSender();
	
	@Autowired
	@Qualifier(value="userSecurityDAO")
	private UserSecurityDAO userSecurityDAO;
	
	@Autowired
	@Qualifier(value="userEmailDAO")
	private UserEmailDAO userEmailDAO;
	
	public void setUserSecurityDAO(UserSecurityDAO userSecurityDAO) {
		this.userSecurityDAO = userSecurityDAO;
	}
	
	public void setUserEmailDAO(UserEmailDAO userEmailDAO) {
		this.userEmailDAO = userEmailDAO;
	}

	/**
	 * Method return user by login and password. If user is not exist return null.
	 * 
	 * @type String
	 * @param userLogin
	 * @param userPassword
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return User
	 */
	public User getUserByLoginPassword(String userLogin,String userPassword) {
		
		User user=null;
		if (userLogin.equals(null) || userLogin.equals("")) {
			throw new RuntimeException("UserSecurityService:User login must not null amd empty");
			
		} else if(userPassword.equals(null) || userPassword.equals("")){
			throw new RuntimeException("UserSecurityService:User password must not null and empty");
			
		}else{
			try {
				logger.info("UserSecurityService: User loaded by login and password.");
				user=userSecurityDAO.getUserByLoginPassword(userLogin, userPassword);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("UserSecurityService: User with login "+userLogin+" and password"
						+ " "+userPassword+". " + rf);
				
			} catch (DataAccessException da) {
				logger.error("UserSecurityService:Exeption connect with data base or other error= "+da);
			}
		}
		return user;
	}
	
	/**
	 * Method return id user by login and password. If user is not exist return null.
	 * 
	 * @type String
	 * @param userLogin
	 * @param userPassword
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return Long
	 */
	public Long getIdUserByLoginPassword(String userLogin,String userPassword){
		
		Long idUser=null;
		if (userLogin.equals(null) || userLogin.equals("")) {
			throw new RuntimeException("UserSecurityService:User login must not null amd empty");
			
		} else if(userPassword.equals(null) || userPassword.equals("")){
			throw new RuntimeException("UserSecurityService:User password must not null and empty");
			
		}else{
			try {
				logger.info("UserSecurityService:User id loaded sucessfully by his login and password.");
				idUser= userSecurityDAO.getIdUserByLoginPassword(userLogin, userPassword);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("UserSecurityService:Id user with login "+userLogin+" and password"
						+" "+userPassword+" not exist. " + rf);
				
			} catch (DataAccessException da) {
				logger.error("UserSecurityService:Exeption connect with data base or other error= "+da);
			}
		}
		return idUser;
	}
	
	/**
	 * Method return status sign in user by user login and user password.
	 * If user exist with login and password return true else false
	 * 
	 * @type String
	 * @param userLogin
	 * @param userPassword
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return Boolean
	 */
	public Boolean signInUserByLoginPassword(String userLogin, String userPassword){
		
		Boolean signIn=false;
		if (userLogin.equals(null) || userLogin.equals("")) {
			throw new RuntimeException("UserSecurityService:User login must not null amd empty");
			
		} else if(userPassword.equals(null) || userPassword.equals("")){
			throw new RuntimeException("UserSecurityService:User password must not null and empty");
			
		}else{
			try {
				logger.info("UserSecurityService:User sign in in system sucessfully");
				signIn= userSecurityDAO.signInUserByLoginPassword(userLogin, userPassword);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("UserSecurityService: User with login "+userLogin+" and password"
						+" "+userPassword+" not exist. SignIn have status false." + rf);
				
			} catch (DataAccessException da) {
				logger.error("UserSecurityService:Exeption connect with data base or other error= "+da);
			}
		}
		return signIn;
	}
	
	/**
	 * Method check user login on unique value. If user login exist in
	 * system return false else true.
	 * 
	 * @type String
	 * @param userLogin
	 * 
	 * @exception NonUniqueResultException
	 * @exception DataAccessException 
	 * 
	 * @return Boolean
	 */
	public Boolean isUniqueLogin(String userLogin){
		
		Boolean isUnique=false;
		if (userLogin.equals(null) || userLogin.equals("")) {
			throw new RuntimeException("UserSecurityService:User login must not null amd empty");
			
		}else{
			try {
				logger.info("UserSecurityService:Check login on unique value.");
				isUnique= userSecurityDAO.isUniqueLogin(userLogin);
			
			}catch (NonUniqueResultException nu) {
				logger.error("UserSecurityService: User login is not unique." + nu);
				
			} catch (DataAccessException da) {
				logger.error("UserSecurityService:Exeption connect with data base or other error= "+da);
			}
		}		
		return isUnique;
	}
	
	/**
	 * Method check user password on unique value. If user password exist in
	 * system return false else true.
	 * 
	 * @type String
	 * @param userPassword
	 * 
	 * @exception NonUniqueResultException
	 * @exception DataAccessException
	 * 
	 * @return Boolean
	 */
	public Boolean isUniquePassword(String userPassword){
		
		Boolean isUnique=false;
		if (userPassword.equals(null) || userPassword.equals("")) {
			throw new RuntimeException("UserSecurityService:User password must not null amd empty");
			
		}else{
			try {
				logger.info("UserSecurityService:Check password on unique value.");
				isUnique= userSecurityDAO.isUniquePassword(userPassword);
				
			} catch (NonUniqueResultException nu) {
				logger.error("UserSecurityService: User password is not unique." + nu);
				
			} catch (DataAccessException da) {
				logger.error("UserSecurityService:Exeption connect with data base or other error= "+da);
			}
		}
		return isUnique;
	}
	
	/**
	 * Method return user role bu id user. If user role not
	 * exist return null else return true.
	 * 
	 * @type Long
	 * @param idUser
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception NonUniqueResultException
	 * @exception DataAccessException
	 * 
	 * @return String
	 */
	public String getUserRoleByIdUser(Long idUser){
		
		String userRole=null;
		if (idUser.equals(null)) {
			throw new RuntimeException("UserSecurityService:Id user must not null.");
		}else{
			try {
				logger.info("UserSecurityService:User role loaded by id user.");
				userRole= userSecurityDAO.getUserRoleByIdUser(idUser);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("UserSecurityService: User role for user with id "+idUser+"not exist" + rf);
				
			} catch (NonUniqueResultException nu) {
				logger.error("UserSecurityService:User role for user with id is not unique." + nu);
				
			} catch (DataAccessException da) {
				logger.error("UserSecurityService:Exeption connect with data base or other error= "+da);
			}
		}
		return userRole;
	}
	
	/**
	 * Method return list of user with User role. If user with user role is not
	 * exist in system return empty list.
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return List<User>
	 */
	public List<User> getListUserWithUserRole(){
		
		List<User> list=Collections.emptyList();
		try {
			logger.info("UserSecurityService:List of user with user role loaded successfully.");
			list= userSecurityDAO.getListUserWithUserRole();
			
		} catch (DataRetrievalFailureException rf) {
			logger.warn("UserSecurityService: List of user with user role load, but list is empty" + rf);
			
		}catch (DataAccessException da) {
			logger.error("UserSecurityService:Exeption connect with data base or other error= "+da);
		}
		return list;
	}
	
	/**
	 * Method return list of user with Administrator role. If user with administrator
	 * role is not exist in system return empty list.
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return List<User>
	 */
	public List<User> getListUserWithAdminRole(){
		
		List<User> list=Collections.emptyList();
		try {
			logger.info("UserSecurityService:List of user with administrator role loaded successfully.");
			list= userSecurityDAO.getListUserWithAdminRole();
			
		} catch (DataRetrievalFailureException rf) {
			logger.warn("UserSecurityService: List of user with administrator role user load,"
					+ " but list is empty" + rf);
			
		}catch (DataAccessException da) {
			logger.error("UserSecurityService:Exeption connect with data base or other error= "+da);
		}
		return list;
	}
	
	/**
	 * Method return result of update user password and login by user id.
	 * Also send on user email letter with security password and login(use
	 * emailCreator).If update is successfully completed return true else false. 
	 * 
	 * @type Long
	 * @type Boolean
	 * @param idUser
	 * 
	 * @return Boolean
	 */
	public Boolean updateLoginPasswordByIdUser(Long idUser){
		
		Boolean statusUpdate=false;
		String newLogin = null;
		String newPassword = null;
		
		String contentEmail="\n Login:" + newLogin +"\n Password:" + newPassword;
		String fromeEmail="zaerko1991@mail.ru";
		String toEmail;
		List<UserEmail> list=Collections.emptyList();
			
		if (idUser.equals(null)) {
			throw new RuntimeException("UserSecurityService:Id user must not null.");
		}else{
			try {
				//generate new security feature
				newLogin=generator.generateNewSecutityRow();
				newPassword=generator.generateNewSecutityRow();
				statusUpdate= userSecurityDAO.updateLoginPasswordByIdUser(idUser,newLogin,newPassword);
				logger.info("UserSecurityService:Login and password update by id user.");
				
				//get user email
				//list=userEmailDAO.getListEmailByIdUser(idUser);
				//toEmail=list.get(0).getUserEmail();
				
				//send login amd password on user email
				//emailCreator.createSecurityEmail(fromeEmail, toEmail,contentEmail);
				//logger.info("UserSecurityService:New login and password send to post.");
				
				////sender.sendEmail(list,newLogin,newPassword);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("UserSecurityService: User with id "+idUser+" not exist or user email not exist!"
						+ "(User must have email before update login amd password!)"
						+ "Login and password not update "+ rf);
				
			}catch (DataAccessException da) {
				logger.error("UserSecurityService:Exeption connect with data base or other error= "+da);
			}
		}
		return statusUpdate;
	}
	
	/**
	 * Method return new user password and login after updating.
	 * 
	 * @type Long
	 * @param idUser
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return UserSecurity
	 */
	public UserSecurity getLoginPasswordByIdUser(Long idUser){
		
		UserSecurity userSecurity=null;
		if (idUser.equals(null)) {
			throw new RuntimeException("UserSecurityService:Id user must not null.");
		}else{
			try {
				logger.info("UserSecurityService:Login and password loaded by id user.");
				userSecurity= userSecurityDAO.getLoginPasswordByIdUser(idUser);
				
			}catch (DataRetrievalFailureException rf) {
				logger.warn("UserSecurityService: User with id "+idUser+" not exist."+ rf);
				
			}catch (DataAccessException da) {
				logger.error("UserSecurityService:Exeption connect with data base or other error= "+da);
			}
		}
		return userSecurity;
	}
}
