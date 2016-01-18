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
import com.dancosoft.socialcommunity.model.UserRole;
import com.dancosoft.socialcommunity.model.UserSecurity;

/**
 * <p>The interface UserSecurityDAO contain methods ads which realize in class
 * UserSecurityDAOImpl.Class UserSecurityDAOImpl use DAO pattern which describes
 * layer of data access to object. DAO layer perform link between relational and
 * object model. Model for this dao layer describied in class UserSecurity. This
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
public interface UserSecurityDAO extends CommonEntityDAO {

	/**
	 * Method return user by login and password. If user is not exist return null.
	 * 
	 * @type String
	 * @param userLogin
	 * @param userPassword
	 * 
	 * @return User
	 */
	public User getUserByLoginPassword(String login, String password);

	/**
	 * Method return id user by login and password. If user is not exist return null.
	 * 
	 * @type String
	 * @param userLogin
	 * @param userPassword
	 * 
	 * @return Long
	 */
	public Long getIdUserByLoginPassword(String login, String password);

	/**
	 * Method return status sign in user by user login and user password.
	 * If user exist with login and password return true else false
	 * 
	 * @type String
	 * @param userLogin
	 * @param userPassword
	 * 
	 * @return Boolean
	 */
	public Boolean signInUserByLoginPassword(String login, String password);

	/**
	 * Method check user login on unique value. If user login exist in
	 * system return false else true.
	 * 
	 * @type String
	 * @param userLogin
	 * 
	 * @return Boolean
	 */
	public Boolean isUniqueLogin(String login);

	/**
	 * Method check user password on unique value. If user password exist in
	 * system return false else true.
	 * 
	 * @type String
	 * @param userPassword
	 * 
	 * @return Boolean
	 */
	public Boolean isUniquePassword(String password);

	/**
	 * Method return user role bu id user. If user role not
	 * exist return null else return true.
	 * 
	 * @type Long
	 * @param idUser
	 * 
	 * @return String
	 */
	public String getUserRoleByIdUser(Long idUser);

	/**
	 * Method return user role by id user. If user role not
	 * exist return null else return true.
	 * 
	 * @type UserRole
	 * @param idUser
	 * 
	 * @return UserRole
	 */
	public UserRole getUserRoleAsObjectByIdUser(Long idUser);
	
	/**
	 * Method return list of user with User role. If user with user role is not
	 * exist in system return empty list.
	 * 
	 * @return List<User>
	 */
	public List<User> getListUserWithUserRole();

	/**
	 * Method return list of user with Administrator role. If user with administrator
	 * role is not exist in system return empty list.
	 * 
	 * @return List<User>
	 */
	public List<User> getListUserWithAdminRole();

	/**
	 * Method return result of update user password and login by user id.
	 * If update is successfully completed return true else false.
	 * 
	 * @type Long
	 * @type Boolean
	 * @param idUser
	 * @param newLogin
	 * @param newPassword
	 * 
	 * @return Boolean
	 */
	public Boolean updateLoginPasswordByIdUser(Long idUser, String newLogin, String newPassword);

	/**
	 * Method return new user password and login after updating.
	 * 
	 * @type Long
	 * @param idUser
	 * 
	 * @return UserSecurity
	 */
	public UserSecurity getLoginPasswordByIdUser(Long idUser);
}
