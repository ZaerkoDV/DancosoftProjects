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

import javax.persistence.NonUniqueResultException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.stereotype.Service;

import com.dancosoft.socialcommunity.dao.SecurityPromptDAO;
import com.dancosoft.socialcommunity.model.SecurityPrompt;
import com.dancosoft.socialcommunity.service.SecurityPromptService;

/**
 * <p>The class SecurityPromptServiceImpl use Service pattern which describes
 * business logic SocialCommunity application. Service layer perform link
 * between, presentation layer and DAO layer(SecurityPromptDAO).This layer is
 * the main role becouse layer contents(set of methods in classes) affect on
 * functionality of all application. This class contain methods which describes
 * specific operation for SecurityPrompt.This class perform service layer to
 * SecurityPrompt.Class extend base class CommonEntityServiceImpl and implement
 * SecurityPromptService interface which perform all methods of this class. For
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
@Service(value="securityPromptService")
public class SecurityPromptServiceImpl extends CommonEntityServiceImpl implements SecurityPromptService{

	private static final Logger logger = LoggerFactory.getLogger(SecurityPromptServiceImpl.class);
	
	@Autowired
	@Qualifier(value="securityPromptDAO")
	private SecurityPromptDAO securityPromptDAO;


	public void setSecurityPromptDAO(SecurityPromptDAO securityPromptDAO) {
		this.securityPromptDAO = securityPromptDAO;
	}
	
	/**
	 * Method return SecurityPrompt by id user. If SecurityPrompt is not exist return null.
	 * 
	 * @type Long
	 * @param idUser
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception NonUniqueResultException
	 * @exception DataAccessException
	 * 
	 * @return SecurityPrompt
	 */
	public SecurityPrompt getSecurityPromptByIdUser(Long idUser) {
		
		SecurityPrompt securityPrompt=null;
		if (idUser.equals(null) || idUser.equals("")) {
			throw new RuntimeException("SecurityPromptService:Id user must not null or empty.");
		}else{
			try {
				logger.info("SecurityPromptService: Security prompt load by user id sucessfully.");
				securityPrompt= securityPromptDAO.getSecurityPromptByIdUser(idUser);
				
			}catch (DataRetrievalFailureException rf) {
				logger.warn("SecurityPromptService: Security prompt not exist with user id "+idUser+" " + rf);
				
			}catch (NonUniqueResultException nu) {
				logger.error("SecurityPromptService:SecurityPrompt load by id user but is not unique." + nu);
				
			}catch (DataAccessException da) {
				logger.error("SecurityPromptService:Exeption connect with data base or other error= "+da);
			}
		}
		return securityPrompt;
	}
	
	/**
	 * Method return SecurityPrompt by user login. If SecurityPrompt is not exist return null.
	 * 
	 * @type String 
	 * @param userLogin
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception NonUniqueResultException
	 * @exception DataAccessException
	 * 
	 * @return SecurityPrompt
	 */
	public SecurityPrompt getSecurityPromptByLogin(String userLogin) {
		
		SecurityPrompt securityPrompt=null;
		if (userLogin.equals(null) || userLogin.equals("")) {
			throw new RuntimeException("SecurityPromptService:User login must not null or empty.");
		}else{
			try {
				logger.info("SecurityPromptService: User prompt load by user login sucessfully.");
				securityPrompt= securityPromptDAO.getSecurityPromptByLogin(userLogin);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("SecurityPromptService: SecurityPrompt not exist with user login "+userLogin+" " + rf);
				
			}catch (NonUniqueResultException nu) {
				logger.error("SecurityPromptService:SecurityPrompt load by user login but login is not unique." + nu);
				
			}catch (DataAccessException da) {
				logger.error("SecurityPromptService:Exeption connect with data base or other error= "+da);
			}
		}
		return securityPrompt;
	}
	
	/**
	 * Method return result of user sign in by user security prompt.
	 * If user not exist return false else return true.
	 * 
	 * @type Long
	 * @type String 
	 * @type Boolean
	 * @param userAnswer
	 * @param idSecurityPrompt
	 * 
	 * @exception DataRetrievalFailureException 
	 * @exception DataAccessException
	 * 
	 * @return Boolean
	 */
	public Boolean signInUserByPromptAnswer(Long idSecurityPrompt,String userAnswer) {
		
		Boolean signIn=false;
		if (idSecurityPrompt.equals(null) || idSecurityPrompt.equals("")) {
			throw new RuntimeException("SecurityPromptService:Id security"
					+ " prompt must not null or empty.");
		}else if(userAnswer.equals(null) || userAnswer.equals("")){
			throw new RuntimeException("SecurityPromptService: User answer no"
					+ " security question must not null or empty.");
		}else{
			try {
				logger.info("SecurityPromptService:User sign in system sucessfully by user answer");
				signIn= securityPromptDAO.signInUserByPromptAnswer(idSecurityPrompt, userAnswer);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("SecurityPromptService: User with id security prompt"
						+ " "+idSecurityPrompt+" and with user answer "+userAnswer+" not exist. "+ rf);
				
			}catch (DataAccessException da) {
				logger.error("SecurityPromptService: Exeption connect with data base or other error= "+da);
			}
		}
		return signIn;
	}

	/**
	 * Method return user id by user security prompt. If user
	 * is not exist return null.
	 * 
	 * @type Long
	 * @type String 
	 * @param idSecurityPrompt
	 * @param userAnswer
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return Long
	 */
	public Long getIdUserByPromptAnswer(Long idSecurityPrompt, String userAnswer) {
		
		Long idUser=null;
		if (idSecurityPrompt.equals(null) || idSecurityPrompt.equals("")) {
			throw new RuntimeException("SecurityPromptService:Id security"
					+ " prompt must not null or empty.");
		}else if(userAnswer.equals(null) || userAnswer.equals("")){
			throw new RuntimeException("SecurityPromptService: User answer no"
					+ " security question must not null or empty.");
		}else{
			try {
				logger.info("SecurityPromptService:User id load by user answer sucessfully");
				idUser= securityPromptDAO.getIdUserByPromptAnswer(idSecurityPrompt, userAnswer);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("SecurityPromptService: Id user with id security prompt"
						+ " "+idSecurityPrompt+" and with user answer "+userAnswer+" not exist. "+ rf);
				
			}catch (DataAccessException da) {
				logger.error("SecurityPromptService: Exeption connect with data base or other error= "+da);
			}
		}
		return idUser;
	}
	
	/**
	 * Method check security prompt on unique value. If security is
	 * unique return true else return false.
	 * 
	 * @type Long
	 * @type String 
	 * @param idSecurityPrompt
	 * @param userAnswer
	 * 
	 * @exception NonUniqueResultException
	 * @exception DataAccessException
	 * 
	 * @return Boolean
	 */
	public Boolean isUniquePrompt(String securityPrompt, String userAnswer) {
		
		Boolean isUnique=false;
		if (securityPrompt.equals(null) || securityPrompt.equals("")) {
			throw new RuntimeException("SecurityPromptService:security question"
					+ " must not null or empty.");
		}else if(userAnswer.equals(null) || userAnswer.equals("")){
			throw new RuntimeException("SecurityPromptService: security answer no"
					+ " security question must not null or empty.");
		}else{
			try {
				logger.info("SecurityPromptService:Check security prompt and user answer on unique value.");
				isUnique= securityPromptDAO.isUniquePrompt(securityPrompt, userAnswer);
				
			}catch (NonUniqueResultException nu) {
				logger.error("SecurityPromptService: SecurityPrompt and answer is is not unique." + nu);
				
			}catch (DataAccessException da) {
				logger.error("SecurityPromptService: Exeption connect with data base or other error= "+da);
			}
		}
		return isUnique;
	}
}
