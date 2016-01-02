/**
 * 
 */
package com.dancosoft.socialcommunity.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
		logger.info("SecurityPromptService: User prompt load by user id sucessfully.");
		return securityPromptDAO.getSecurityPromptByIdUser(idUser);	
	}
	
	public SecurityPrompt getSecurityPromptByLogin(String userLogin) {
		logger.info("SecurityPromptService: User prompt load by user login sucessfully.");
		return securityPromptDAO.getSecurityPromptByLogin(userLogin);
	}
	
	public Boolean signInUserByPromptAnswer(Long idSecurityPrompt,String userAnswer) {
		logger.info("SecurityPromptService:User sign in system sucessfully by user answer");
		return securityPromptDAO.signInUserByPromptAnswer(idSecurityPrompt, userAnswer);
	}

	public Long getIdUserByPromptAnswer(Long idSecurityPrompt, String userAnswer) {
		logger.info("SecurityPromptService:User id load by user answer sucessfully");
		return securityPromptDAO.getIdUserByPromptAnswer(idSecurityPrompt, userAnswer);
	}
	
	public Boolean isUniquePrompt(String securityPrompt, String userAnswer) {
		logger.info("SecurityPromptService:Check security prompt and user answer on unique value.");
		return securityPromptDAO.isUniquePrompt(securityPrompt, userAnswer);
	}
	
}
