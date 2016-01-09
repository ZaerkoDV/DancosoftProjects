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

import com.dancosoft.socialcommunity.dao.GroupEventDAO;
import com.dancosoft.socialcommunity.model.Account;
import com.dancosoft.socialcommunity.model.GroupEvent;

/**
 * <p> The class GroupEventDAOImpl use DAO pattern which describes layer of data
 * access to object. DAO layer perform link between relational and object model.
 * Model for this dao layer describied in class GroupEvent. This class contain
 * methods which intended to access to special operation with GroupEvent entity.
 * Class extend CommonEntityDAOImpl class, which contain base set of
 * operation(CRUD). Class implements interface GroupEventDAO located in package
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
@Repository(value = "groupEventDAO")
public class GroupEventDAOImpl extends CommonEntityDAOImpl implements GroupEventDAO {

	private static final Logger logger = LoggerFactory.getLogger(GroupEventDAOImpl.class);

//	public GroupEventDAOImpl(){
//		super(GroupEvent.class);
//	}
	
	/**
	 * Method return group member account by id group event. Account
	 * ovner create this group event. If member is not exist return null
	 * 
	 * @type Long
	 * @param idGroupEvent
	 * 
	 * @return Account
	 */
	public Account getMemberAccountByIdGroupEvent(Long idGroupEvent) {

		Criteria criteria = this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createCriteria(GroupEvent.class);
		criteria.createAlias("groupMember", "gm");
		criteria.setProjection(Projections.property("gm.memberAccount"));
		criteria.add(Restrictions.eq("idGroupEvent", idGroupEvent));
		logger.info("GroupEventDAO:User account load by id user group event");
	
		return (Account) criteria.uniqueResult();
	}

	/**
	 * Method return list of group event by id account group. If group event is
	 * not exist return empty list.
	 * 
	 * @type Long
	 * @param idAccountGroup
	 * 
	 * @return List<GroupEvent>
	 */
	@SuppressWarnings("unchecked")
	public List<GroupEvent> getListGroupEventByIdAccountGroup(Long idAccountGroup) {

		Criteria criteria = this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createCriteria(GroupEvent.class);
		criteria.createAlias("groupMember", "gm");
		criteria.createAlias("gm.accountGroup", "ag");
		criteria.add(Restrictions.eq("ag.idAccountGroup", idAccountGroup));
		logger.info("GroupEventDAO:List group event load by id account group");

		return criteria.list();
	}

	/**
	 * Method return list of group event which created berween min and max date by id
	 * account group. If group event is not exist return empty list.
	 * 
	 * @type Long
	 * @param idAccountGroup
	 * 
	 * @return List<GroupEvent>
	 */
	@SuppressWarnings("unchecked")
	public List<GroupEvent> getListGroupEventBeetweenDateByIdAccountGroup(
			Long idAccountGroup, Date minDate, Date maxDate) {

		Criteria criteria = this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createCriteria(GroupEvent.class);

		criteria.createAlias("groupMember", "gm");
		criteria.createAlias("gm.accountGroup", "ag");
		Conjunction and = Restrictions.conjunction();
		// message belong to group
		and.add(Restrictions.eq("ag.idAccountGroup", idAccountGroup));
		// The date must be >= 17-04-2011 - 00h00
		and.add(Restrictions.ge("dateCreateGroupEvent", minDate));
		// And date must be < 18-04-2011 - 00h00
		and.add(Restrictions.lt("dateCreateGroupEvent", maxDate));
		logger.info("GroupEventDAO:List group event which"
					+ " creete between date load by id account group");

		return criteria.list();
	}

	/**
	 * Method return count of group event by id account group. If account group
	 * is not contain event return zero
	 * 
	 * @type Long
	 * @param idAccountGroup
	 * 
	 * @return int
	 */
	public int getCountGroupEventByIdAccountGroup(Long idAccountGroup) {

		Criteria criteria = this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createCriteria(GroupEvent.class);
		criteria.createAlias("groupMember", "gm");
		criteria.createAlias("gm.accountGroup", "ag");
		criteria.add(Restrictions.eq("ag.idAccountGroup", idAccountGroup));

		logger.info("GroupEventDAO:Count group event load for account group");
		int countGroupEvent;
		if(criteria.list().isEmpty()){
			countGroupEvent =0;
		}else{
			countGroupEvent = criteria.list().size();	
		}
		return countGroupEvent;
	}
}
