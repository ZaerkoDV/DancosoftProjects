/**
 * @package com.dancosoft.socialcommunity.service
 * 
 * Package com.dancosoft.socialcommunity.service contain set of interfaces which
 * description service layer of SocialCommunity project.Also this package contain
 * realization of interfaces in package com.dancosoft.socialcommunity.service.impl
 * and support classes in com.dancosoft.socialcommunity.service.support.This project
 * is based on MVC architecture.This inerface perform class which is part of service
 * layer in MVC architecture.This layer defines the boundary of the application and
 * a set of permitted operations. It encapsulates the business logic of the application
 * and controls the answers in the implementation of operations. All classes which
 * contain postfix “Service” provide to work Service for SocialCommunity application.
 * 
 * Please contact with Zaerko Denis or send letter on zaerko1991@gmail.com if you need
 * to use information or have any questions.   
 */
package com.dancosoft.socialcommunity.service;

import java.util.List;

import javax.persistence.NonUniqueResultException;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.dao.TypeMismatchDataAccessException;

import com.dancosoft.socialcommunity.model.SecurityPrompt;

/**
 * <p>The interface SecurityPromptService contain methods ads which realize in class
 * SecurityPromptServiceImpl. Class SecurityPromptServiceImpl use Service pattern which
 * describes service layer of application. This class contain general operation
 * to all classes.This interface contain ads methods which perform busness logic
 * all application. Interface extend CommonEntityService interface which contain
 * ads base operation of any entity.
 * 
 * @version 1.0 08.10.2015
 * @author Zaerko Denis
 */
public interface SecurityPromptService {

	/**
	 * Method return SecurityPrompt by id user. If SecurityPrompt is not exist return null.
	 * 
	 * @type Long
	 * @param idUser
	 * @exception DataRetrievalFailureException
	 * @exception NonUniqueResultException
	 * @exception DataAccessException
	 * 
	 * @return SecurityPrompt
	 */
	public SecurityPrompt getSecurityPromptByIdUser(Long idUser);

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
	public SecurityPrompt getSecurityPromptByLogin(String userLogin);

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
	public Boolean signInUserByPromptAnswer(Long idSecurityPrompt,
			String userAnswer);

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
	public Long getIdUserByPromptAnswer(Long idSecurityPrompt, String userAnswer);

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
	public Boolean isUniquePrompt(String securityPrompt, String userAnswer);
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method return entity by idEntity. If entity not exist return null(use
	 * hibernateTamplate method get)
	 * 
	 * @type Long
	 * @param idSecurityPrompt
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return SecurityPrompt
	 */
	public SecurityPrompt getSecurityPromptById(Long idSecurityPrompt);
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method save entity if entity not null.
	 * 
	 * @type SecurityPrompt
	 * @param securityPrompt
	 * 
	 * @exception TypeMismatchDataAccessException
	 * @exception DataAccessException
	 */
	public void saveSecurityPrompt(SecurityPrompt securityPrompt);
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method update entity if entity not null.
	 * 
	 * @type SecurityPrompt
	 * @param securityPrompt
	 * 
	 * @exception TypeMismatchDataAccessException
	 * @exception DataAccessException
	 */
	public void updateSecurityPrompt(SecurityPrompt securityPrompt);
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method delete entity by id if entity not null.
	 * 
	 * @type Long
	 * @param idSecurityPrompt
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 */
	public void deleteSecurityPromptById(Long idSecurityPrompt);
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method delete entity if entity not null.
	 * 
	 * @type SecurityPrompt
	 * @param securityPrompt
	 * 
	 * @exception DataAccessException
	 */
	public void deleteSecurityPrompt(SecurityPrompt securityPrompt);
	
	/**
	 * This method is basic for all entities. Method return list of entity. If entyty
	 * list not load return empty list.
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return List<Object>
	 */
	public List<Object> getListSecurityPrompt();
}
