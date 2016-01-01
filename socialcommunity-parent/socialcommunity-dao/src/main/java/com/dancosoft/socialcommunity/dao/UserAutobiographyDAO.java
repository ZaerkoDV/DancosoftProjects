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

import java.util.List;

import com.dancosoft.socialcommunity.model.User;
import com.dancosoft.socialcommunity.model.UserAutobiography;

/**
 * <p>The interface UserAutobiographyDAO contain methods ads which realize in class
 * UserAutobiographyDAOImpl.Class UserAutobiographyDAOImpl use DAO pattern which
 * describes layer of data access to object. DAO layer perform link between
 * relational and object model. Model for this dao layer describied in class
 * UserAutobiography. This interface contain ads methods which intended to
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
public interface UserAutobiographyDAO extends CommonEntityDAO {

	/**
	 * Method return user autobiogeaphy by id user. If user autobiography
	 * is not exist return null
	 * 
	 * @type Long
	 * @param idUser
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
	 * @return Boolean
	 */
	public Boolean isUserAdult(Long idUser, Long yearAdult);

	/**
	 * Method return list of adult user. If adult users are
	 * not exist return empty list.
	 * 
	 * @type Long
	 * @param yearAdult
	 * 
	 * @return List<User>
	 */
	public List<User> getListAdultUser(Long yearAdult);
}
