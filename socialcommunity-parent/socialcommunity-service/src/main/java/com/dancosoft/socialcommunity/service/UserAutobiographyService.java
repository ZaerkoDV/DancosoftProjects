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

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.dao.TypeMismatchDataAccessException;

import com.dancosoft.socialcommunity.model.SingleMessage;
import com.dancosoft.socialcommunity.model.User;
import com.dancosoft.socialcommunity.model.UserAutobiography;

/**
 * <p>The interface UserAutobiographyService contain methods ads which realize in class
 * UserAutobiographyServiceImpl. Class UserAutobiographyServiceImpl use Service pattern which
 * describes service layer of application. This class contain general operation
 * to all classes.This interface contain ads methods which perform busness logic
 * all application. Interface extend CommonEntityService interface which contain
 * ads base operation of any entity.
 * 
 * @version 1.0 08.10.2015
 * @author Zaerko Denis
 */
public interface UserAutobiographyService {

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
	public UserAutobiography getUserAutobiographyByIdUser(Long idUser);
	
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
	public List<User> getListUserByHobby(String hobby);
	
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
	public Boolean isUserAdult(Long idUser,Long yearAdult);
	
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
	public List<User> getListAdultUser(Long yearAdult);
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method return entity by idEntity. If entity not exist return null(use
	 * hibernateTamplate method get)
	 * 
	 * @type Long
	 * @param idSingleMessage
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return SingleMessage
	 */
	public SingleMessage getEntityById(Long idSingleMessage);
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method save entity if entity not null.
	 * 
	 * @type SingleMessage
	 * @param singleMessage
	 * 
	 * @exception TypeMismatchDataAccessException
	 * @exception DataAccessException
	 */
	public void saveSingleMessage(SingleMessage singleMessage);
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method update entity if entity not null.
	 * 
	 * @type SingleMessage
	 * @param singleMessage
	 * 
	 * @exception TypeMismatchDataAccessException
	 * @exception DataAccessException
	 */
	public void updateSingleMessage(SingleMessage singleMessage);
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method delete entity by id if entity not null.
	 * 
	 * @type Long
	 * @param idSingleMessage
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 */
	public void deleteSingleMessageById(Long idSingleMessage);
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method delete entity if entity not null.
	 * 
	 * @type SingleMessage
	 * @param singleMessage
	 * @exception DataAccessException
	 */
	public void deleteSingleMessage(SingleMessage singleMessage);
	
	/**
	 * This method is basic for all entities. Method return list of entity. If entyty
	 * list not load return empty list.
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return List<Object>
	 */
	public List<Object> getListEntity();
	
	
}
