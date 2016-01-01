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

import com.dancosoft.socialcommunity.dao.SecurityPromptDAO;
import com.dancosoft.socialcommunity.model.SecurityPrompt;

/**
 * <p>
 * The class SecurityPromptDAOImpl use DAO pattern which describes layer of data
 * access to object. DAO layer perform link between relational and object model.
 * Model for this dao layer describied in class SecurityPrompt. This class
 * contain methods which intended to access to special operation with
 * SecurityPrompt entity. Class extend CommonEntityDAOImpl class, which contain
 * base set of operation(CRUD). Class implements interface SecurityPromptDAO
 * located in package which have name com.dancosoft.socialcommunity.dao. All
 * methods are public in class.For logging use logger fasade slf4j and framework
 * log4j. Class contain also private, static variable logger, which use to call
 * log message. This class use Spring framework to work with ORM. In particular
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
@Repository(value = "securityPromptDAO")
public class SecurityPromptDAOImpl extends CommonEntityDAOImpl implements SecurityPromptDAO {

	private static final Logger logger = LoggerFactory.getLogger(SecurityPromptDAOImpl.class);

//	public SecurityPromptDAOImpl(){
//		super(SecurityPrompt.class);
//	}
	
	/**
	 * Method return SecurityPrompt by id user. If SecurityPrompt is not exist return null.
	 * 
	 * @type Long
	 * @param idUser
	 * 
	 * @return SecurityPrompt
	 */
	public SecurityPrompt getSecurityPromptByIdUser(Long idUser) {

		Criteria criteria = this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createCriteria(SecurityPrompt.class);
		criteria.createAlias("userSecurity", "us");
		criteria.createAlias("us.user", "u");
		criteria.add(Restrictions.eq("u.idUser", idUser));		
		logger.info("SecurityPromptDAO: User prompt load by user id sucessfully.");

		return (SecurityPrompt) criteria.uniqueResult();
	}

	/**
	 * Method return SecurityPrompt by user login. If SecurityPrompt is not exist return null.
	 * 
	 * @type String 
	 * @param userLogin
	 * 
	 * @return SecurityPrompt
	 */
	public SecurityPrompt getSecurityPromptByLogin(String userLogin) {

		Criteria criteria = this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createCriteria(SecurityPrompt.class);
		criteria.createAlias("userSecurity", "u");
		criteria.add(Restrictions.eq("u.userLogin", userLogin));
		logger.info("SecurityPromptDAO: User prompt load by user login sucessfully.");

		return (SecurityPrompt) criteria.uniqueResult();
	}

	/**
	 * Method return result of user sign in by user security prompt.
	 * If user not exist return false else return true.
	 * 
	 * @type Long
	 * @type String 
	 * @type Boolean
	 * @param userAnswer
	 * @param idSecurityPrompt
	 * 
	 * @return Boolean
	 */
	public Boolean signInUserByPromptAnswer(Long idSecurityPrompt,String userAnswer) {

		Criteria criteria = this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createCriteria(SecurityPrompt.class);

		criteria.createAlias("userSecurity", "us");
		criteria.setProjection(Projections.property("us.user"));

		criteria.add(Restrictions.eq("idSecurityPrompt", idSecurityPrompt));
		criteria.add(Restrictions.eq("userAnswer", userAnswer));

		logger.info("SecurityPromptDAO:User sign in system sucessfully by user answer");
		Boolean signIn = false;
		if (criteria.list().isEmpty()) {
			signIn = false;
		} else {
			signIn = true;
		}
		return signIn;
	}

	/**
	 * Method return user id by user security prompt. If user
	 * is not exist return null.
	 * 
	 * @type Long
	 * @type String 
	 * @param idSecurityPrompt
	 * @param userAnswer
	 * 
	 * @return Long
	 */
	public Long getIdUserByPromptAnswer(Long idSecurityPrompt, String userAnswer) {

		Criteria criteria = this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createCriteria(SecurityPrompt.class);
		criteria.createAlias("userSecurity", "us");
		criteria.createAlias("us.user", "u");
		criteria.setProjection(Projections.property("u.idUser"));
		criteria.add(Restrictions.eq("idSecurityPrompt", idSecurityPrompt));
		criteria.add(Restrictions.eq("userAnswer", userAnswer));
		
		logger.info("SecurityPromptDAO:User id load by user answer sucessfully");

		return (Long) criteria.uniqueResult();
	}

	/**
	 * Method check security prompt on unique value. If security is
	 * unique return true else return false.
	 * 
	 * @type Long
	 * @type String 
	 * @param idSecurityPrompt
	 * @param userAnswer
	 * 
	 * @return Boolean
	 */
	public Boolean isUniquePrompt(String securityPrompt, String userAnswer) {

		Criteria criteria = this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createCriteria(SecurityPrompt.class);
		criteria.add(Restrictions.eq("securityPrompt", securityPrompt));
		criteria.add(Restrictions.eq("userAnswer", userAnswer));

		Boolean isUnique = false;
		if (criteria.list().isEmpty()) {
			isUnique = true;
			logger.info("SecurityPromptDAO: Security prompt and user answer is unique.");
		} else {
			isUnique = false;
			logger.info("SecurityPromptDAO: Security prompt or user answer isn't unique.");
		}
		return isUnique;
	}
}
