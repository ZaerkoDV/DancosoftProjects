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

import com.dancosoft.socialcommunity.model.User;
import com.dancosoft.socialcommunity.model.UserSecurity;

/**
 * <p>The interface UserSecurityService contain methods ads which realize in class
 * UserSecurityServiceImpl. Class UserSecurityServiceImpl use Service pattern
 * which describes service layer of application. This class contain general
 * operation to all classes.This interface contain ads methods which perform
 * busness logic all application. Interface extend CommonEntityService interface
 * which contain ads base operation of any entity.
 * 
 * @version 1.0 08.10.2015
 * @author Zaerko Denis
 */
public interface UserSecurityService extends CommonEntityService {

	/**
	 * Method return user by login and password. If user is not exist return null.
	 * 
	 * @type String
	 * @param userLogin
	 * @param userPassword
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return User
	 */
	public User getUserByLoginPassword(String userLogin, String userPassword);

	/**
	 * Method return id user by login and password. If user is not exist return null.
	 * 
	 * @type String
	 * @param userLogin
	 * @param userPassword
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return Long
	 */
	public Long getIdUserByLoginPassword(String userLogin, String userPassword);

	/**
	 * Method return status sign in user by user login and user password.
	 * If user exist with login and password return true else false
	 * 
	 * @type String
	 * @param userLogin
	 * @param userPassword
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return Boolean
	 */
	public Boolean signInUserByLoginPassword(String userLogin,
			String userPassword);

	/**
	 * Method check user login on unique value. If user login exist in
	 * system return false else true.
	 * 
	 * @type String
	 * @param userLogin
	 * 
	 * @exception NonUniqueResultException
	 * @exception DataAccessException 
	 * 
	 * @return Boolean
	 */
	public Boolean isUniqueLogin(String userLogin);

	/**
	 * Method check user password on unique value. If user password exist in
	 * system return false else true.
	 * 
	 * @type String
	 * @param userPassword
	 * 
	 * @exception NonUniqueResultException
	 * @exception DataAccessException
	 * 
	 * @return Boolean
	 */
	public Boolean isUniquePassword(String userPassword);

	/**
	 * Method return user role bu id user. If user role not
	 * exist return null else return true.
	 * 
	 * @type Long
	 * @param idUser
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception NonUniqueResultException
	 * @exception DataAccessException
	 * 
	 * @return String
	 */
	public String getUserRoleByIdUser(Long idUser);

	/**
	 * Method return list of user with User role. If user with user role is not
	 * exist in system return empty list.
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return List<User>
	 */
	public List<User> getListUserWithUserRole();

	/**
	 * Method return list of user with Administrator role. If user with administrator
	 * role is not exist in system return empty list.
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return List<User>
	 */
	public List<User> getListUserWithAdminRole();

	/**
	 * Method return result of update user password and login by user id.
	 * Also send on user email letter with security password and login(use
	 * emailCreator).If update is successfully completed return true else false. 
	 * 
	 * @type Long
	 * @type Boolean
	 * @param idUser
	 * 
	 * @return Boolean
	 */
	public Boolean updateLoginPasswordByIdUser(Long idUser);

	/**
	 * Method return new user password and login after updating.
	 * 
	 * @type Long
	 * @param idUser
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return UserSecurity
	 */
	public UserSecurity getLoginPasswordByIdUser(Long idUser);
}
