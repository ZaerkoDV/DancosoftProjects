/**
 * Package com.dancosoft.socialcommunity.dao contain set of classes and interfaces which description
 * layer of data access object of SocialCommunity project. This project is based on MVC architecture.
 * This class is part of dao layer in MVC architecture. This layer offer abstract interface for work
 * with any type data base. This pattern give a chance work with DAO (data-access-object) without matter
 * what kind of storage engine is used and without need for a special way to match this storage engine.
 * All classes which contain word"DAO"provide to work DAL for ReducerLinks application.
 * 
 * Please contact with Zaerko Denis or send letter on zaerko1991@gmail.com if you need
 * to use information or have any questions.   
 */
package com.dancosoft.socialcommunity.dao;

import com.dancosoft.socialcommunity.model.SecurityPrompt;

/**
 * <p>
 * The interface SecurityPromptDAO contain methods ads which realize in class
 * SecurityPromptDAOImpl.Class SecurityPromptDAOImpl use DAO pattern which
 * describes layer of data access to object. DAO layer perform link between
 * relational and object model. Model for this dao layer describied in class
 * SecurityPrompt. This interface contain ads methods which intended to access
 * operation with object. Interface produce special operation with object.Base
 * operation (for any object) include as separate interface CommonEntityDAO
 * which extend to this interface.Class use Spring framework to work with ORM.In
 * particular often use HibernateTemplate for integration Hibernate and Spring
 * technologys. For work with data base use hibernate criteria.
 * 
 * @version 1.0 23.12.2015
 * @author Zaerko Denis
 */
public interface SecurityPromptDAO extends CommonEntityDAO {

	/**
	 * Method return SecurityPrompt by id user. If SecurityPrompt is not exist return null.
	 * 
	 * @type Long
	 * @param idUser
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
	 * @return Boolean
	 */
	public Boolean isUniquePrompt(String securityPrompt, String userAnswer);
}
