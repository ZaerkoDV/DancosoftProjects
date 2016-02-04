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

import com.dancosoft.socialcommunity.model.Account;
import com.dancosoft.socialcommunity.model.User;

/**
 * <p>
 * The interface UserDAO contain methods ads which realize in class
 * UserDAOImpl.Class UserDAOImpl use DAO pattern which describes layer of data
 * access to object. DAO layer perform link between relational and object model.
 * Model for this dao layer describied in class User. This interface contain ads
 * methods which intended to access operation with object. Interface produce
 * special operation with object.Base operation (for any object) include as
 * separate interface CommonEntityDAO which extend to this interface.Class use
 * Spring framework to work with ORM.In particular often use HibernateTemplate
 * for integration Hibernate and Spring technologys. For work with data base use
 * hibernate criteria.
 * 
 * @version 1.0 23.12.2015
 * @author Zaerko Denis
 */
public interface UserDAO extends CommonEntityDAO {
	
	/**
	 * Method return user accounts. If user accounts is not exist
	 * return null.
	 * 
	 * @type Long
	 * @param idUser
	 * 
	 * @return Account
	 */
	public Account getAccountByUserId(Long idUser);

	/**
	 * Method return list of user which belong to sex. If list of user is not
	 * exist return empty list
	 * 
	 * @type String
	 * @param sex
	 * 
	 * @return List<User>
	 */
	public List<User> getListUserBySex(String sex);

	/**
	 * Method return list of user by first name, last name, middle name. If list
	 * user is not exist return empty list
	 * 
	 * @type String
	 * @param firstName
	 * @param lastName
	 * @param middleName
	 * 
	 * @return List<User>
	 */
	public List<User> searchUserByFirstLastMiddleName(String firstName,
			String lastName, String middleName);
}
