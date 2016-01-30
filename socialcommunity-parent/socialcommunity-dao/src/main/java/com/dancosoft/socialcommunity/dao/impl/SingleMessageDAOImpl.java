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
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.dancosoft.socialcommunity.dao.SingleMessageDAO;
import com.dancosoft.socialcommunity.model.Account;
import com.dancosoft.socialcommunity.model.SingleMessage;

/**
 * <p>
 * The class SingleMessageDAOImpl use DAO pattern which describes layer of data
 * access to object. DAO layer perform link between relational and object model.
 * Model for this dao layer describied in class SingleMessage. This class
 * contain methods which intended to access to special operation with
 * SingleMessage entity. Class extend SingleMessageDAOImpl class, which contain
 * base set of operation(CRUD). Class implements interface SingleMessage located
 * in package which have name com.dancosoft.socialcommunity.dao. All methods are
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
@Repository(value="singleMessageDAO")
public class SingleMessageDAOImpl extends CommonEntityDAOImpl implements SingleMessageDAO {

	private static final Logger logger = LoggerFactory.getLogger(SingleMessageDAOImpl.class);

	public SingleMessageDAOImpl(){
		super(SingleMessage.class);
	}
	
	/**
	 * Method return list of user messages which created between date. If messages are not exist return empty list.
	 * 
	 * @type Date
	 * @type Long
	 * @param idAccount
	 * @param minDate
	 * @param maxDate
	 * 
	 * @return List<SingleMessage>
	 */
	@SuppressWarnings("unchecked")
	public List<SingleMessage> getListSingleMessageBeetweenDateByIdAccount(Long idAccount,Date minDate,Date maxDate) {

		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(SingleMessage.class);
		Conjunction and = Restrictions.conjunction();
		//message belong to group
		and.add(Restrictions.eq("account.idAccount", idAccount));
		// The date must be >= 17-04-2011 - 00h00
		and.add( Restrictions.ge("dateCreateSingleMessage", minDate));
		// And date must be < 18-04-2011 - 00h00
		and.add( Restrictions.lt("dateCreateSingleMessage", maxDate)); 

		logger.info("SingleMessageDAO: List single account message"
				+ " which create between data load by id account.");

		return criteria.list();
	}

	/**
	 * Method return list of interlocutor account which speak with this account.
	 * If accounts are not exist return empty list. 
	 * 
	 * @type Long
	 * @param idAccount
	 * 
	 * @return List<Account>
	 */
	@SuppressWarnings("unchecked")
	public List<Account> getListInterlocutorAccountByIdAccount(Long idAccount) {

		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(SingleMessage.class);
		criteria.createAlias("account", "a");
		criteria.setProjection(Projections.property("interlocutorAccount"));
		criteria.add(Restrictions.eq("a.idAccount", idAccount));
		logger.info("SingleMessageDAO: List interlocutor account load by id account.");
			
		return criteria.list();
	}

	/**
	 * Method return list of interlocutor account message which user account
	 * have between min and max date.If single messages are not exist return empty list.
	 * 
	 * @type Long
	 * @type Date
	 * @param idAccount
	 * @param idInterlocutorAccount
	 * @param minDate
	 * @param maxDate
	 * 
	 * @return List<SingleMessage>
	 */
	@SuppressWarnings("unchecked")
	public List<SingleMessage> getListIntrlocutorSingleMessageBeetweenDateByIdAccount(Long idAccount,
			Long idInterlocutorAccount,Date minDate,Date maxDate) {
		
		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(SingleMessage.class);

//		Conjunction and = Restrictions.conjunction();
//		//message belong to group
//		and.add(Restrictions.eq("account.idAccount", idAccount));
//		and.add(Restrictions.eq("interlocutorAccount.idAccount", idInterlocutorAccount));
//		// The date must be >= 17-04-2011 - 00h00
//		and.add( Restrictions.ge("dateCreateSingleMessage", minDate));
//		// And date must be < 18-04-2011 - 00h00
//		and.add( Restrictions.lt("dateCreateSingleMessage", maxDate)); 
		
		Criterion rest1= Restrictions.and(Restrictions.eq("account.idAccount", idAccount));
		Criterion rest2= Restrictions.and(Restrictions.eq("interlocutorAccount.idAccount", idInterlocutorAccount)); 
		Criterion rest3= Restrictions.and(Restrictions.eq("account.idAccount",idInterlocutorAccount));
		Criterion rest4= Restrictions.and(Restrictions.eq("interlocutorAccount.idAccount", idAccount)); 
		
		criteria.add(Restrictions.or(Restrictions.and(rest1, rest2),Restrictions.and(rest3, rest4)));
		// The date must be >= 17-04-2011 - 00h00
		criteria.add( Restrictions.ge("dateCreateSingleMessage", minDate));
		// And date must be < 18-04-2011 - 00h00
		criteria.add( Restrictions.lt("dateCreateSingleMessage", maxDate)); 
		
		logger.info("SingleMessageDAO: List dialog message which create between"
					+ " data load by id account and id interlocutor.");
			
		return criteria.list();
	}
}
