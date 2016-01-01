/**
 * @package com.dancosoft.socialcommunity.dao.impl
 * 
 * Package com.dancosoft.socialcommunity.dao.impl contain set of class which description
 * layer of data access object of SocialCommunity project. This project is based on MVC
 * architecture.This class is part of dao layer(DAL pattern) in MVC architecture. This
 * layer offer abstract interface for work with any type data base. This pattern give a
 * right work with DAO (data-access-object) without matter what kind of storage engine
 * is used and without need for a special way to match this storage engine. All classes
 * which contain word �DAO� provide to work DAL for Reducer links application.
 * 
 * Please contact with Zaerko Denis or send letter on zaerko1991@gmail.com if you need
 * to use information or have any questions.  
 */
package com.dancosoft.socialcommunity.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.dancosoft.socialcommunity.dao.UserSecurityDAO;
import com.dancosoft.socialcommunity.model.User;
import com.dancosoft.socialcommunity.model.UserSecurity;

/**
 * <p>The class UserSecurityDAOImpl use DAO pattern which describes layer of data
 * access to object. DAO layer perform link between relational and object model.
 * Model for this dao layer describied in class UserSecurity. This class contain
 * methods which intended to access to special operation with UserSecurity
 * entity. Class extend CommonEntityDAOImpl class, which contain base set of
 * operation(CRUD). Class implements interface UserSecurityDAO located in
 * package which have name com.dancosoft.socialcommunity.dao. All methods are
 * public in class.For logging use logger fasade slf4j and framework log4j.
 * Class contain also private, static variable logger, which use to call log
 * message. This class use Spring framework to work with ORM. In particular
 * often use HibernateTemplate for integration Hibernate and Spring technologys.
 * For work with data base use hibernate criteria. This technology provide as
 * object-oriented select query in relation to a particular entity, and allows
 * you to query the database without writing SQL code. Use Criteria is the most
 * successful approach to search interface with a variable number of conditions.
 * To create copies of the Criteria used class Session, which acts as a factory.
 * 
 * @see Collection
 * @see List
 * @see org.springframework.stereotype
 * @see org.springframework.orm
 * @see org.hibernate.Criteria
 * @see slf4j fasade
 * @see log4j framework
 * 
 * @version 1.0 23.12.2015
 * @author Zaerko Denis
 */
@Repository(value = "userSecurityDAO")
public class UserSecurityDAOImpl extends CommonEntityDAOImpl implements UserSecurityDAO {

	private static final Logger logger = LoggerFactory.getLogger(UserSecurityDAOImpl.class);

//	public UserSecurityDAOImpl(){
//		super(UserSecurity.class);
//	}
	
	/**
	 * Method return user by login and password. If user is not exist return null.
	 * 
	 * @type String
	 * @param userLogin
	 * @param userPassword
	 * 
	 * @return User
	 */
	public User getUserByLoginPassword(String userLogin,String userPassword) {

		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(UserSecurity.class);
		criteria.setProjection(Projections.property("user"));
		criteria.add(Restrictions.eq("userLogin", userLogin));
		criteria.add(Restrictions.eq("userPassword", userPassword));
		logger.info("UserSecurityDAO: User loaded by login and password.");
		
		return (User) criteria.uniqueResult();
	}

	/**
	 * Method return id user by login and password. If user is not exist return null.
	 * 
	 * @type String
	 * @param userLogin
	 * @param userPassword
	 * 
	 * @return Long
	 */
	public Long getIdUserByLoginPassword(String userLogin,String userPassword){

		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(UserSecurity.class);
		criteria.createAlias("user", "u");
		criteria.setProjection(Projections.property("u.idUser"));
		criteria.add(Restrictions.eq("userLogin", userLogin));
		criteria.add(Restrictions.eq("userPassword", userPassword));
	
		logger.info("UserDAO:User id loaded sucessfully by his login and password.");

		return (Long)criteria.uniqueResult();
	}

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
	public Boolean signInUserByLoginPassword(String userLogin, String userPassword){

		Boolean signIn = null;
		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(UserSecurity.class);
		criteria.setProjection(Projections.property("user"));
		criteria.add(Restrictions.eq("userLogin", userLogin));
		criteria.add(Restrictions.eq("userPassword", userPassword));
		logger.info("UserDAO:User sign in in system sucessfully");
		
		if (criteria.uniqueResult().toString().equals("")) {
			signIn = false;
		} else {
			signIn = true;
		}
		return signIn;
	}

	/**
	 * Method check user login on unique value. If user login exist in
	 * system return false else true.
	 * 
	 * @type String
	 * @param userLogin
	 * 
	 * @return Boolean
	 */
	public Boolean isUniqueLogin(String userLogin){

		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(UserSecurity.class);
		criteria.add(Restrictions.eq("userLogin", userLogin));

		Boolean isUnique = null;
		if (criteria.list().isEmpty()) {
			isUnique = true;
			logger.info("UserSecurityDAO: Login is unique.");
		} else {
			isUnique = false;
			logger.info("UserSecurityDAO: Login  isn't unique.");
		}
		return isUnique;
	}

	/**
	 * Method check user password on unique value. If user password exist in
	 * system return false else true.
	 * 
	 * @type String
	 * @param userPassword
	 * 
	 * @return Boolean
	 */
	public Boolean isUniquePassword(String userPassword){

		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(UserSecurity.class);
		criteria.add(Restrictions.eq("userPassword", userPassword));

		Boolean isUnique = null;
		if (criteria.list().isEmpty()) {
			isUnique = true;
			logger.info("UserSecurityDAO: Password is unique.");
		} else {
			isUnique = false;
			logger.info("UserSecurityDAO: Password isn't unique.");
		}
		return isUnique;
	}

	/**
	 * Method return user role bu id user. If user role not
	 * exist return null else return true.
	 * 
	 * @type Long
	 * @param idUser
	 * 
	 * @return String
	 */
	public String getUserRoleByIdUser(Long idUser){

		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(UserSecurity.class);
		criteria.createAlias("userRole", "r");
		criteria.setProjection(Projections.property("r.userRoleName"));
		criteria.createAlias("user", "u");
		criteria.add(Restrictions.eq("u.idUser", idUser));
		
		logger.info("UserSecurityDAO:User role loaded by id user.");
	
		return (String) criteria.uniqueResult();
	}

	/**
	 * Method return list of user with User role. If user with user role is not
	 * exist in system return empty list.
	 * 
	 * @return List<User>
	 */
	@SuppressWarnings("unchecked")
	public List<User> getListUserWithUserRole(){

		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(UserSecurity.class);
		criteria.setProjection(Projections.property("user"));
		
		criteria.createAlias("userRole", "r");
		criteria.add(Restrictions.eq("r.userRoleName", "User"));
		criteria.setMaxResults(20);
		criteria.setFirstResult(0);
		logger.info("UserSecurityDAO:List user loaded successfully.");

		return criteria.list();
	}

	/**
	 * Method return list of user with Administrator role. If user with administrator
	 * role is not exist in system return empty list.
	 * 
	 * @return List<User>
	 */
	@SuppressWarnings("unchecked")
	public List<User> getListUserWithAdminRole(){

		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(UserSecurity.class);
		criteria.setProjection(Projections.property("user"));

		criteria.createAlias("userRole", "r");
		criteria.add(Restrictions.eq("r.userRoleName", "Admin"));
		criteria.setMaxResults(20);
		criteria.setFirstResult(0);
		logger.info("UserSecurityDAO:List administrators loaded successfully.");
		
		return criteria.list();
	}

	/**
	 * Method return result of update user password and login by user id.
	 * If update is successfully completed return true else false.
	 * 
	 * @type Long
	 * @type Boolean
	 * @param idUser
	 * 
	 * @return Boolean
	 */
///how to generate new Password?
	public Boolean updateLoginPasswordByIdUser(Long idUser){
		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(UserSecurity.class);
		criteria.createAlias("user", "u");
		criteria.add(Restrictions.eq("u.idUser", idUser));

		Boolean status;
		logger.info("UserSecurityDAO:Login and password loaded by id user.");
		UserSecurity userSecurity=(UserSecurity) criteria.uniqueResult();
		
		String lastLogin=userSecurity.getUserLogin();
		String lastPassword=userSecurity.getUserPassword();

		userSecurity.setUserLogin("newLogin");
		userSecurity.setUserPassword("newPassword");
		this.getHibernateTemplate().update(userSecurity);
		
		if(!lastLogin.equals(userSecurity.getUserLogin()) && !lastPassword.equals(userSecurity.getUserPassword())){
			status=true;
			logger.info("UserSecurityDAO:Login and password updated.");
		}else{
			status=false;
			logger.info("UserSecurityDAO:Login and password not updated");	
		}
		return status;
	}

	/**
	 * Method return new user password and login after updating.
	 * 
	 * @type Long
	 * @param idUser
	 * 
	 * @return UserSecurity
	 */
	public UserSecurity getLoginPasswordByIdUser(Long idUser){

		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(UserSecurity.class);
		criteria.createAlias("user", "u");
		criteria.add(Restrictions.eq("u.idUser", idUser));
		logger.info("UserSecurityDAO:Login and password loaded by id user.");

		return (UserSecurity) criteria.uniqueResult();
	}
}
