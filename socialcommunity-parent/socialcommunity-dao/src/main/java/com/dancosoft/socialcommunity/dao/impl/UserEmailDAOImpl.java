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

import com.dancosoft.socialcommunity.dao.UserEmailDAO;
import com.dancosoft.socialcommunity.model.UserEmail;

/**
 * <p>The class UserEmailDAOImpl use DAO pattern which describes layer of data
 * access to object. DAO layer perform link between relational and object model.
 * Model for this dao layer describied in class UserEmail. This class contain
 * methods which intended to access to special operation with UserEmail entity.
 * Class extend CommonEntityDAOImpl class, which contain base set of
 * operation(CRUD). Class implements interface UserEmailDAO located in package
 * which have name com.dancosoft.socialcommunity.dao. All methods are public in
 * class.For logging use logger fasade slf4j and framework log4j. Class contain
 * also private, static variable logger, which use to call log message. This
 * class use Spring framework to work with ORM. In particular often use
 * HibernateTemplate for integration Hibernate and Spring technologys. For work
 * with data base use hibernate criteria. This technology provide as
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
@Repository(value = "userEmailDAO")
public class UserEmailDAOImpl extends CommonEntityDAOImpl implements UserEmailDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(UserEmailDAOImpl.class);	
	
	public UserEmailDAOImpl(){
		super(UserEmail.class);
	}
	
	/**
	 * Method return list of user email with view status. If list is not exist return empty list.
	 * 
	 * @type Long
	 * @type String
	 * @param idUser
	 * @param viewStatus
	 * 
	 * @return List<UserEmail>
	 */
	@SuppressWarnings("unchecked")
	public List<UserEmail> getListEmailWithStatusByIdUser(Long idUser,String viewStatus){
		
		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(UserEmail.class);
		criteria.createAlias("userCorespondence", "c");
		criteria.createAlias("c.user", "u");
		criteria.add(Restrictions.eq("u.idUser", idUser));
		criteria.add(Restrictions.eq("c.corespondenceViewStatus", viewStatus));
	
		logger.info("UserEmailDAO:List user email with status loaded.");

		return criteria.list();
	}
	
	/**
	 * Method return list of user email by user id. If list
	 * is not exist return empty list.
	 * 
	 * @type Long
	 * @param idUser
	 * 
	 * @return List<UserEmail>
	 */
	@SuppressWarnings("unchecked")
	public List<UserEmail> getListEmailByIdUser(Long idUser){
		
		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(UserEmail.class);
		criteria.createAlias("userCorespondence", "c");
		criteria.createAlias("c.user", "u");
		criteria.add(Restrictions.eq("u.idUser", idUser));
		
		logger.info("UserEmailDAO:List user email loaded.");
	
		return criteria.list();
	}
	
	/**
	 * Method check user email on unique value. If user email
	 * is not unique return false else true.
	 * 
	 * @type String
	 * @param userEmail
	 * 
	 * @return Boolean
	 */
	public Boolean isUniqueEmail(String userEmail){
		
		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(UserEmail.class);
		criteria.add(Restrictions.eq("userEmail", userEmail));
		
		Boolean isUnique;
		if (criteria.list().isEmpty()) {
			isUnique = true;
			logger.info("UserEmailDAO:User email is unique.");
		} else {
			isUnique = false;
			logger.info("UserEmailDAO:User email is not unique.");
		}
		return isUnique;
	}

	/**
	 * Method return id user by user email. If user is not exist return null.
	 * 
	 * @type String
	 * @param userEmail
	 * 
	 * @return long
	 */
	public Long getIdUserByEmail(String userEmail){
	
		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(UserEmail.class);
		criteria.createAlias("userCorespondence", "c");
		criteria.createAlias("c.user", "u");
		criteria.setProjection(Projections.property("u.idUser"));
		criteria.add(Restrictions.eq("userEmail", userEmail));
		
		logger.info("UserEmailDAO:User id load by email");
			
		return (Long)criteria.uniqueResult();
	}
}
