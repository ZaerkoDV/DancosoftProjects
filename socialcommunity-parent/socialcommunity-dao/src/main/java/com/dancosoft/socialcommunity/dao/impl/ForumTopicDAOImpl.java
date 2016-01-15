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

import com.dancosoft.socialcommunity.dao.ForumTopicDAO;
import com.dancosoft.socialcommunity.model.Account;
import com.dancosoft.socialcommunity.model.ForumTopic;

/**
 * <p>
 * The class ForumTopicDAOImpl use DAO pattern which describes layer of data access
 * to object. DAO layer perform link between relational and object model. Model
 * for this dao layer describied in class ForumTopic. This class contain methods
 * which intended to access to special operation with ForumTopic entity. Class
 * extend CommonEntityDAOImpl class, which contain base set of operation(CRUD).
 * Class implements interface ForumTopicDAO located in package which have name
 * com.dancosoft.socialcommunity.dao. All methods are public in class.For
 * logging use logger fasade slf4j and framework log4j. Class contain also
 * private, static variable logger, which use to call log message. This class
 * use Spring framework to work with ORM. In particular often use
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
@Repository(value="forumTopicDAO")
public class ForumTopicDAOImpl extends CommonEntityDAOImpl implements ForumTopicDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(ForumTopicDAOImpl.class);
	
	public ForumTopicDAOImpl(){
		super(ForumTopic.class);
	}
	
	/**
	 * Method return account(author) which create forum topic by id forum topic.
	 * If author not exist return null  
	 * 
	 * @type Long
	 * @param idForumTopic
	 * 
	 * @return Account
	 */
	public Account getAuthorAccountForumTopic(Long idForumTopic) {
		
		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(ForumTopic.class);
		criteria.setProjection(Projections.property("authorAccount"));
		criteria.add(Restrictions.eq("idForumTopic", idForumTopic));
		logger.info("ForumTopicDAO:Author account which create topic load by id forum topic");
	
		return (Account) criteria.uniqueResult();
	}
	
	/**
	 * Method return list of forum topic which belong forum. If forum
	 * topic not exist return empty list.
	 * 
	 * @type Long
	 * @param idForum
	 * 
	 * @return List<ForumTopic>
	 */
	@SuppressWarnings("unchecked")
	public List<ForumTopic> getListForumTopicByIdForum(Long idForum) {
		
		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(ForumTopic.class);
		criteria.createAlias("forum", "f");
		criteria.add(Restrictions.eq("f.idForum", idForum));		
		logger.info("ForumTopicDAO:List forum topic load by id forum");

		return criteria.list();
	}
	
	/**
	 * Method return list of forum topic which created between minDate and maxDate by forum id.
	 * If forum topic not exist return empty list.
	 * 
	 * @type Long
	 * @type Date
	 * @param idForum
	 * @param minDate
	 * @param maxDate
	 * 
	 * @return List<ForumTopic>
	 */
	@SuppressWarnings("unchecked")
	public List<ForumTopic> getListForumTopicCreateBetweenDateByIdForum(Long idForum, Date minDate, Date maxDate) {
		
		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(ForumTopic.class);
		criteria.createAlias("forum", "f");
		
		Conjunction and = Restrictions.conjunction();
		//message belong to group
		and.add(Restrictions.eq("f.idForum", idForum));
	    // The date must be >= 17-04-2011 - 00h00
	    and.add( Restrictions.ge("dateCreateForumTopic", minDate));
	    // And date must be < 18-04-2011 - 00h00
	    and.add( Restrictions.lt("dateCreateForumTopic", maxDate)); 
	    
		logger.info("ForumTopicDAO:List forum topic which create between dates load by id forum");

		return criteria.list();
	}
	
	/**
	 * Method return count of forum topic which belong to forum.
	 * 
	 * @type Long
	 * @param idForum
	 * 
	 * @return int
	 */
	public int getCountForumTopic(Long idForum) {
		
		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(ForumTopic.class);
		criteria.createAlias("forum", "f");
		criteria.add(Restrictions.eq("f.idForum", idForum));
		logger.info("ForumTopicDAO:Count forum topic load by idforum");
		
		int countForumTopic;
		if(criteria.list().isEmpty()){
			countForumTopic=0;
		}else{
			countForumTopic =criteria.list().size();
		}
		return countForumTopic;
	}
}
