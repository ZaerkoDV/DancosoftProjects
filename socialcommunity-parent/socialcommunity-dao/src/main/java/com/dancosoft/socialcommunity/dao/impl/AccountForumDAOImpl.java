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

import com.dancosoft.socialcommunity.dao.AccountForumDAO;
import com.dancosoft.socialcommunity.model.Account;
import com.dancosoft.socialcommunity.model.AccountForum;
import com.dancosoft.socialcommunity.model.Forum;

/**
 * <p>
 * The class AccountForumDAOImpl use DAO pattern which describes layer of data
 * access to object. DAO layer perform link between relational and object
 * model.Model for this dao layer describied in class AccountForum. This class
 * contain methods which intended to access to special operation with
 * AccountForum entity. Class extend CommonEntityDAOImpl class, which contain
 * base set of operation(CRUD). Class implements interface AccountForumDAOImpl
 * located in package which have name com.dancosoft.socialcommunity.dao. All
 * methods are public in class.For logging use logger fasade slf4j and framework
 * log4j. Class contain also private, static variable logger, which use to call
 * log message. This class use Spring framework to work whith ORM. In particular
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
@Repository(value="accountForumDAO")
public class AccountForumDAOImpl extends CommonEntityDAOImpl implements AccountForumDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(AccountForumDAOImpl.class);
	
	public AccountForumDAOImpl(){
		super(AccountForum.class);
	}
	
	/**
	 * Method return list forum by id account. List contain forums which use in account.
	 * 
	 * @type Long
	 * @param idForum
	 * 
	 * @return List<Account>
	 */
	@SuppressWarnings("unchecked")
	public List<Account> getListAccountByIdForum(Long idForum) {
		
		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(AccountForum.class);
		criteria.createAlias("forum", "f");
		criteria.setProjection(Projections.property("account"));
		criteria.add(Restrictions.eq("f.idForum", idForum));
		logger.info("AccountForumDAO:List account load by id forum.");

		return criteria.list();		
	}
	
	/**
	 * Method return list forum by id account. List contain accounts which use in forum.
	 * 
	 * @type Long
	 * @param idAccount
	 * 
	 * @return List<Forum>
	 */
	@SuppressWarnings("unchecked")
	public List<Forum> getListForumByIdAccount(Long idAccount) {
		
		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(AccountForum.class);
		criteria.createAlias("account", "a");
		criteria.setProjection(Projections.property("forum"));
		criteria.add(Restrictions.eq("a.idAccount", idAccount));	
		logger.info("AccountForumDAO:List forum load by id account.");
	
		return criteria.list();	
	}
}
