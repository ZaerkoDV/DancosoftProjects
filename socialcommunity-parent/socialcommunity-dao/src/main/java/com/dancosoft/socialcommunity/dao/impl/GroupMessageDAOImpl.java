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

import com.dancosoft.socialcommunity.dao.GroupMessageDAO;
import com.dancosoft.socialcommunity.model.Account;
import com.dancosoft.socialcommunity.model.GroupMessage;

/**
 * <p>
 * The class GroupMessageDAOImpl use DAO pattern which describes layer of data
 * access to object. DAO layer perform link between relational and object model.
 * Model for this dao layer describied in class GroupMessage. This class contain
 * methods which intended to access to special operation with GroupMessage
 * entity. Class extend CommonEntityDAOImpl class, which contain base set of
 * operation(CRUD). Class implements interface GroupMessageDAO located in
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
@Repository(value = "groupMessageDAO")
public class GroupMessageDAOImpl extends CommonEntityDAOImpl implements GroupMessageDAO {

	private static final Logger logger = LoggerFactory.getLogger(GroupMessageDAOImpl.class);

//	public GroupMessageDAOImpl(){
//		super(GroupMessage.class);
//	}
	
	/**
	 * Method return member account by id message which user create in account group.
	 * If account member is not exist return null.
	 * 
	 * @type Long
	 * @param idGroupMessage
	 * 
	 * @return Account
	 */
	public Account getMemberAccountByIdGroupMessage(Long idGroupMessage) {

		Criteria criteria = this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createCriteria(GroupMessage.class);
		criteria.createAlias("groupMember", "gm");
		criteria.setProjection(Projections.property("gm.memberAccount"));
		criteria.add(Restrictions.eq("idGroupMessage", idGroupMessage));
		logger.info("GroupMessageDAO:User account load by id user group message");

		return (Account) criteria.uniqueResult();
	}

	/**
	 * Method return list of group message which belong to account group by id account group.
	 * If group message are not exist return empty list.
	 * 
	 * @type Long
	 * @param idAccountGroup
	 * 
	 * @return List<GroupMessage>
	 */
	@SuppressWarnings("unchecked")
	public List<GroupMessage> getListGroupMessageByIdAccountGroup(Long idAccountGroup) {

		Criteria criteria = this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createCriteria(GroupMessage.class);
		criteria.createAlias("groupMember", "gm");
		criteria.createAlias("gm.accountGroup", "ag");
		criteria.add(Restrictions.eq("ag.idAccountGroup", idAccountGroup));
		logger.info("GroupMessageDAO:List group message load by id account group");

		return criteria.list();
	}

	/**
	 * Method return list of group message which belong to account group and which create
	 * between date by id account group. If group message are not exist return empty list.
	 * 
	 * @type Long
	 * @type Date
	 * @param idAccountGroup
	 * @param minDate
	 * @param maxDate
	 * 
	 * @return List<GroupMessage> 
	 */
	@SuppressWarnings("unchecked")
	public List<GroupMessage> getListGroupMessageBeetweenDateByIdAccountGroup(
			Long idAccountGroup, Date minDate, Date maxDate) {

		Criteria criteria = this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createCriteria(GroupMessage.class);
		criteria.createAlias("groupMember", "gm");
		criteria.createAlias("gm.accountGroup", "ag");

		Conjunction and = Restrictions.conjunction();
		// message belong to group
		and.add(Restrictions.eq("ag.idAccountGroup", idAccountGroup));
		// The date must be >= 17-04-2011 - 00h00
		and.add(Restrictions.ge("dateCreateGroupMessage", minDate));
		// And date must be < 18-04-2011 - 00h00
		and.add(Restrictions.lt("dateCreateGroupMessage", maxDate));

		logger.info("GroupMessageDAO:List group message which"
					+ " creete between date load by id account group");
	
		return criteria.list();
	}

	/**
	 * Method return count of group messages. If group messages are
	 * not exist return zero.
	 * 
	 * @type int
	 * @param idAccountGroup
	 * 
	 * @return int 
	 */
	public int getCountGroupMessageByIdAccountGroup(Long idAccountGroup) {

		Criteria criteria = this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createCriteria(GroupMessage.class);
		criteria.createAlias("groupMember", "gm");
		criteria.createAlias("gm.accountGroup", "ag");
		criteria.add(Restrictions.eq("ag.idAccountGroup", idAccountGroup));

		logger.info("GroupMessageDAO:Count group message load for account group");
		int countGroupMessage;
		if(criteria.list().isEmpty()){
			countGroupMessage =0;
		}else{
			countGroupMessage = criteria.list().size();
		}
		return countGroupMessage;
	}
}
