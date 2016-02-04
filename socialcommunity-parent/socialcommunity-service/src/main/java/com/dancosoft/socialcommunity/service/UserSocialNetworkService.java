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
import org.springframework.transaction.annotation.Transactional;

import com.dancosoft.socialcommunity.model.UserSocialNetwork;

/**
 * <p>The interface UserSocialNetworkService contain methods ads which realize in
 * class UserSocialNetworkServiceImpl. Class UserSocialNetworkServiceImpl use
 * Service pattern which describes service layer of application. This class
 * contain general operation to all classes.This interface contain ads methods
 * which perform busness logic all application. Interface extend
 * CommonEntityService interface which contain ads base operation of any entity.
 * 
 * @version 1.0 08.10.2015
 * @author Zaerko Denis
 */
public interface UserSocialNetworkService {

	/**
	 * Method return user social nettwork with view status which use user.
	 * If social community not exist return null.
	 * 
	 * @type Long
	 * @type String
	 * @param idUser
	 * @param viewStatus
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException 
	 * 
	 * @return UserSocialNetwork
	 */
	public UserSocialNetwork getSocialNetworkWithStatusByIdUser(Long idUser,String viewStatus);

	/**
	 * Method cheak user skype address on uniqule value. If user
	 * skype have unique value return true else return false.
	 * 
	 * @type String
	 * @param skypeAddress
	 * 
	 * @exception DataAccessException
	 * 
	 * @return Boolean
	 */
	public Boolean isUniqueSkype(String skypeAddress);

	/**
	 * Method cheak user facebook address on uniqule value. If user
	 * facebook have unique value return true else return false.
	 * 
	 * @type String
	 * @param facebookAddress
	 * 
	 * @exception DataAccessException
	 * 
	 * @return Boolean
	 */
	public Boolean isUniqualFaceBook(String facebookAddress);

	/**
	 * Method return id user by user face book address. If user
	 * is not exist return null.
	 * 
	 * @type String
	 * @param facebookAddress
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception NonUniqueResultException
	 * @exception DataAccessException
	 * 
	 * @return Long
	 */
	public Long getIdUserByFacebookAddress(String facebookAddress);
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method return entity by idEntity. If entity not exist return null(use
	 * hibernateTamplate method get)
	 * 
	 * @type Long
	 * @param idUserSocialNetwork
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return UserSocialNetwork
	 */
	public UserSocialNetwork getUserSocialNetworkById(Long idUserSocialNetwork);
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method save entity if entity not null.
	 * 
	 * @type UserSocialNetwork
	 * @param userSocialNetwork
	 * 
	 * @exception TypeMismatchDataAccessException
	 * @exception DataAccessException
	 */
	public void saveUserSocialNetwork(UserSocialNetwork userSocialNetwork);
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method update entity if entity not null.
	 * 
	 * @type UserSocialNetwork
	 * @param userSocialNetwork
	 * 
	 * @exception TypeMismatchDataAccessException
	 * @exception DataAccessException
	 */
	public void updateUserSocialNetwork(UserSocialNetwork userSocialNetwork);
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method delete entity by id if entity not null.
	 * 
	 * @type Long
	 * @param idUserSocialNetwork
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 */
	public void deleteUserSocialNetworkById(Long idUserSocialNetwork);
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method delete entity if entity not null.
	 * 
	 * @type UserSocialNetwork
	 * @param userSocialNetwork
	 * 
	 * @exception DataAccessException
	 */
	public void deleteUserSocialNetwork(UserSocialNetwork userSocialNetwork);
	
	/**
	 * This method is basic for all entities. Method return list of entity. If entyty
	 * list not load return empty list.
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return List<Object>
	 */
	public List<Object> getListUserSocialNetwork();
}
