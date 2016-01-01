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

import java.time.LocalDateTime;
import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.dancosoft.socialcommunity.dao.AccountHistoryDAO;
import com.dancosoft.socialcommunity.dao.support.TimeConverter;
import com.dancosoft.socialcommunity.model.AccountHistory;

/**
 * <p>
 * The class AccountHistoryDAOImpl use DAO pattern which describes layer of data
 * access to object. DAO layer perform link between relational and object
 * model.Model for this dao layer describied in class AccountHistory. This class
 * contain methods which intended to access to special operation with
 * AccountHistory entity. Class extend �ommonEntityDAOImpl class, which contain
 * base set of operation(CRUD).The Class implements interface AccountHistoryDAO
 * located in package which have name com.dancosoft.socialcommunity.dao. All
 * methods are public in class. For logging use logger fasade slf4j and framework
 * log4j. Class contain also private, static variable logger, which use to call
 * log message. This class use Spring framework to work whith ORM. In particular
 * often use HibernateTemplate for integration Hibernate and Spring technologys.
 * For work with data base use hibernate criteria. This technology provide as
 * object-oriented select query in relation to a particular entity, and allows
 * you to query the database without writing SQL code. Use Criteria is the most
 * successful approach to search interface with a variable number of conditions.
 * To create copies of the Criteria used class Session, which acts as a factory.
 * 
 * @see org.springframework.stereotype
 * @see org.springframework.orm
 * @see org.hibernate.Criteria
 * @see slf4j fasade
 * @see log4j framework
 * @see com.dancosoft.socialcommunity.dao.support.TimeConverter;
 * 
 * @version 1.0 23.12.2015
 * @author Zaerko Denis
 */
@Repository(value="accountHistoryDAO")
public class AccountHistoryDAOImpl  extends CommonEntityDAOImpl implements AccountHistoryDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(AccountHistoryDAOImpl.class);
	
//	public AccountHistoryDAOImpl(){
//		super(AccountHistory.class);
//	}
	
	/**
	 * This is instance of class TimeConverter which
	 * use for converting format date
	 */
	TimeConverter converter=new TimeConverter();
	
	/**
	 * Method return account history by id account.If account history
	 * not exist return null
	 * 
	 * @type Long
	 * @param idAccount
	 * 
	 * @return AccountHistory
	 */
	public AccountHistory getAccountHistoryByIdAccount(Long idAccount) {
	
		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(AccountHistory.class);
		criteria.add(Restrictions.eq("account.idAccount", idAccount));
		logger.info("AccountHistoryDAO: Account hostory load by id account.");
	
		return (AccountHistory)criteria.uniqueResult();
	}
	
	/**
	 * Method return date of last visit account by id account. If date ont exist return null.
	 * 
	 * @type Long
	 * @param idAccount
	 * 
	 * @return LocalDateTime
	 */
	public LocalDateTime getLastVisitAccountByIdAccount(Long idAccount) {
		
		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(AccountHistory.class);
		criteria.setProjection(Projections.property("lastVisit"));
		criteria.add(Restrictions.eq("account.idAccount", idAccount));
		
		Date date=(Date) criteria.uniqueResult();
		LocalDateTime lastVisit=converter.convertDateToLocalDateTime(date);
		logger.info("AccountHistoryDAO: Date last visit load for account");

		return lastVisit;
	}
}
