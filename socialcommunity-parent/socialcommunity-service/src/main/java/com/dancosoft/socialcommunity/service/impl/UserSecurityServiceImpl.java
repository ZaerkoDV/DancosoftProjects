/**
 * 
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
import com.dancosoft.socialcommunity.model.UserSecurity;
import com.dancosoft.socialcommunity.service.UserSecurityService;
import com.dancosoft.socialcommunity.service.support.email.EmailCreator;
import com.dancosoft.socialcommunity.service.support.security.GeneratorSecurityFeature;

/**
 * @author Zaerko_DV
 *
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
	
	public Boolean updateLoginPasswordByIdUser(Long idUser){
		
		Boolean statusUpdate=false;
		String newLogin;
		String newPassword;
		if (idUser.equals(null)) {
			throw new RuntimeException("UserSecurityService:Id user must not null.");
		}else{
			try {
				
				logger.info("UserSecurityService:Login and password update by id user.");
				newLogin=generator.generateNewSecutityRow();
				newPassword=generator.generateNewSecutityRow();
				statusUpdate= userSecurityDAO.updateLoginPasswordByIdUser(idUser,newLogin,newPassword);
					
//				List<UserEmail> list=userEmailDAO.getListEmailByIdUser(idUser);
//				sender.sendEmail(list,newLogin,newPassword);
//				logger.info("UserSecurityService:New login and password send to post.");

				String content="\n Login:" + newLogin +"\n Password:" + newPassword;
				emailCreator.createSecurityMail("zaerko1991@mail.ru","zaerko1991@mail.ru",content);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("UserSecurityService: User with id "+idUser+" not exist."
						+ "Login and password not update "+ rf);
				
			}catch (DataAccessException da) {
				logger.error("UserSecurityService:Exeption connect with data base or other error= "+da);
			}
		}
		return statusUpdate;
	}
	
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
