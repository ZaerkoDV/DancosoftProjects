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

import com.dancosoft.socialcommunity.model.UserSocialNetwork;

/**
 * <p>The interface UserSocialNetworkDAO contain methods ads which realize in class
 * UserSocialNetworkDAOImpl.Class UserSocialNetworkDAOImpl use DAO pattern which
 * describes layer of data access to object. DAO layer perform link between
 * relational and object model. Model for this dao layer describied in class
 * UserSocialNetwork. This interface contain ads methods which intended to
 * access operation with object. Interface produce special operation with
 * object.Base operation (for any object) include as separate interface
 * CommonEntityDAO which extend to this interface.Class use Spring framework to
 * work with ORM.In particular often use HibernateTemplate for integration
 * Hibernate and Spring technologys. For work with data base use hibernate
 * criteria.
 * 
 * @version 1.0 23.12.2015
 * @author Zaerko Denis
 */
public interface UserSocialNetworkDAO extends CommonEntityDAO {

	/**
	 * Method return user social nettwork with view status which use user.
	 * If social community not exist return null.
	 * 
	 * @type Long
	 * @type String
	 * @param idUser
	 * @param viewStatus
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
	 * @return Long
	 */
	public Long getIdUserByFacebookAddress(String facebookAddress);
}
