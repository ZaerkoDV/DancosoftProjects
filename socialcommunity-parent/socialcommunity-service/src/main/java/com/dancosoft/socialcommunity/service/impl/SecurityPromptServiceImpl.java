/**
 * 
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
 * @author Zaerko_DV
 *
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
				
			}catch (DataAccessException da) {
				logger.error("SecurityPromptService:Exeption connect with data base or other error= "+da);
			}
		}
		return securityPrompt;
	}
	
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
