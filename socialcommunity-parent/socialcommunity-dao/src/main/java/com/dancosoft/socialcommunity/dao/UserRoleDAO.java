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

/**
 * <p>The interface UserRoleDAO contain methods ads which realize in class
 * UserRoleDAOImpl.Class UserRoleDAOImpl use DAO pattern which describes layer
 * of data access to object. DAO layer perform link between relational and
 * object model. Model for this dao layer describied in class UserRole. This
 * interface contain ads methods which intended to access operation with object.
 * Interface produce special operation with object.Base operation (for any
 * object) include as separate interface CommonEntityDAO which extend to this
 * interface.Class use Spring framework to work with ORM.In particular often use
 * HibernateTemplate for integration Hibernate and Spring technologys. For work
 * with data base use hibernate criteria.
 * 
 * @version 1.0 23.12.2015
 * @author Zaerko Denis
 */
public interface UserRoleDAO extends CommonEntityDAO {

	/**
	 * Method return list user by user role. If users are not exist return empty list
	 * 
	 * @type String
	 * @param userRoleName
	 * 
	 * @return List<User>
	 */
	public List<User> getListUserByRole(String userRoleName);

	/**
	 * Method return count of user with role. If users with role are not exist return zero.
	 * 
	 * @type String
	 * @type int
	 * @param userRoleName
	 * 
	 * @return int
	 */
	public int getCountUserByRole(String userRoleName);
}
