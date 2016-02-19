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

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.dancosoft.socialcommunity.dao.ForumMessageDAO;
import com.dancosoft.socialcommunity.model.Account;
import com.dancosoft.socialcommunity.model.ForumMessage;

/**
 * <p>The class ForumMessageDAOImpl use DAO pattern which describes layer of data
 * access to object. DAO layer perform link between relational and object model.
 * Model for this dao layer describied in class ForumMessage. This class contain
 * methods which intended to access to special operation with ForumMessage
 * entity. Class extend ForumMessageDAOImpl class, which contain base set of
 * operation(CRUD). Class implements interface ForumMessageDAO located in
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
 * @version 1.0 24.12.2015
 * @author Zaerko Denis
 */
@Repository(value = "forumMessageDAO")
public class ForumMessageDAOImpl extends CommonEntityDAOImpl implements ForumMessageDAO {

	private static final Logger logger = LoggerFactory.getLogger(ForumMessageDAOImpl.class);

	public ForumMessageDAOImpl(){
		super(ForumMessage.class);
	}
	
	/**
	 * Method return Account of author which create message. If account is not
	 * exist return null;
	 * 
	 * @type Long
	 * @param idForumMessage
	 * 
	 * @return Account
	 */
	public Account getAccountAuthorMessageByIdForumMessage(Long idForumMessage) {

		Criteria criteria = this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createCriteria(ForumMessage.class);
		criteria.setProjection(Projections.property("authorAccount"));
		criteria.add(Restrictions.eq("idForumMessage", idForumMessage));
		logger.info("ForumMessageDAO:Author account which create message load by id forum message");

		return (Account) criteria.uniqueResult();
	}

	/**
	 * Method return list of forum message by id forum topic. If messages are
	 * not exist return empty list
	 * 
	 * @type Long
	 * @param idForumTopic
	 * 
	 * @return List<ForumMessage>
	 */
	@SuppressWarnings("unchecked")
	public List<ForumMessage> getListForumMessageByIdForumTopic(Long idForumTopic) {

		Criteria criteria = this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createCriteria(ForumMessage.class);
		criteria.createAlias("forumTopic", "t");
		criteria.add(Restrictions.eq("t.idForumTopic", idForumTopic));
		logger.info("ForumMessageDAO: List forum message load by id forum topic.");

		return criteria.list();
	}

	/**
	 * Method return list of forum message which create between dates by id
	 * forum topic. If messages are not exist return empty list
	 * 
	 * @type Long
	 * @type Date
	 * @param idForumTopic
	 * @param minDate
	 * @param maxDate
	 * 
	 * @return List<ForumMessage>
	 */
	@SuppressWarnings("unchecked")
	public List<ForumMessage> getListForumMessageBetweenDateByIdForumTopic(Long idForumTopic, Date minDate, Date maxDate) {

		Criteria criteria = this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createCriteria(ForumMessage.class);
		criteria.createAlias("forumTopic", "t");
		
		Conjunction and = Restrictions.conjunction();
		and.add(Restrictions.eq("t.idForumTopic", idForumTopic));
		// The date must be >= 17-04-2011 - 00h00
		and.add(Restrictions.ge("dateCreateForumTopic", minDate));
		// And date must be < 18-04-2011 - 00h00
		and.add(Restrictions.lt("dateCreateForumTopic", maxDate));
		
		logger.info("ForumMessageDAO: List forum message which"
				+ " create between date load by id forum topic.");

		return criteria.list();
	}

	/**
	 * Method return list of forum message by idAccount(user). If Account not
	 * exist retunr null.
	 * 
	 * @type Long
	 * @param idForumTopic
	 * 
	 * @return List<ForumMessage>
	 */
	@SuppressWarnings("unchecked")
	public List<ForumMessage> getListForumMessagetByIdAccount(Long idAccount) {

		Criteria criteria = this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createCriteria(ForumMessage.class);
		criteria.createAlias("authorAccount", "a");
		criteria.add(Restrictions.eq("a.idAccount", idAccount));
		
		logger.info("ForumMessageDAO: List forum message which create account load by id account.");

		return criteria.list();
	}
}
