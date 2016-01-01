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

import com.dancosoft.socialcommunity.dao.ForumDAO;
import com.dancosoft.socialcommunity.model.Forum;

/**
 * <p>
 * The class ForumDAOImpl use DAO pattern which describes layer of data access
 * to object. DAO layer perform link between relational and object model. Model
 * for this dao layer describied in class Forum. This class contain methods
 * which intended to access to special operation with Forum entity. Class extend
 * CommonEntityDAOImpl class, which contain base set of operation(CRUD). Class
 * implements interface ForumDAO located in package which have name
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
@Repository(value = "forumDAO")
public class ForumDAOImpl extends CommonEntityDAOImpl implements ForumDAO {

	private static final Logger logger = LoggerFactory.getLogger(ForumDAOImpl.class);

//	public ForumDAOImpl(){
//		super(Forum.class);
//	}
	
	/**
	 * Method return list forum which crated between dates. If forums
	 * are not exist return empty list.
	 * 
	 * @type Date
	 * @param minDate
	 * @param maxDate
	 * 
	 * @return List<Forum>
	 */
	@SuppressWarnings("unchecked")
	public List<Forum> getListForumCreatedBetweenDateByIdForum(Date minDate,Date maxDate) {

		Criteria criteria = this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createCriteria(Forum.class);
		Conjunction and = Restrictions.conjunction();
		and.add(Restrictions.ge("dateCreateForum", minDate));
		and.add(Restrictions.lt("dateCreateForum", maxDate));
		logger.info("ForumDAO:List forum which create between date load.");

		return criteria.list();
	}

	/**
	 * Method return total count of forums. If forums are not exist return zero. 
	 * 
	 * @type int
	 * @return int
	 */
	public int getCountForum() {

		Criteria criteria = this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createCriteria(Forum.class);
		int countForum= criteria.list().size();
		logger.info("ForumDAO: Count of forums.");
		
		if(criteria.list().isEmpty()){
			countForum=0;
		}else{
			countForum= criteria.list().size();
		}
		return countForum;
	}

	/**
	 * Method return list forum by forum name. If forums are not
	 * exist return empty list
	 * 
	 * @type String 
	 * @param forumName
	 * 
	 * @return List<Forum>
	 */
	@SuppressWarnings("unchecked")
	public List<Forum> searchForumByForumName(String forumName) {

		Criteria criteria = this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createCriteria(Forum.class);
		criteria.add(Restrictions.eq("forumName", forumName));
		logger.info("ForumDAO:List forum load by name.");
		
		return criteria.list();
	}

	/**
	 * Method return list forum with view status. If forums are not
	 * exist return empty list.
	 * 
	 * @type String 
	 * @param viewStatus
	 * 
	 * @return List<Forum>
	 */
	@SuppressWarnings("unchecked")
	public List<Forum> getListForumWithStatus(String viewStatus) {

		Criteria criteria = this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createCriteria(Forum.class);
		criteria.add(Restrictions.eq("viewStatus", viewStatus));
		logger.info("ForumDAO:List forum load by view status.");

		return criteria.list();
	}

	/**
	 * Method return result of check forum on private view status.
	 * 
	 * @type Long
	 * @type Boolean
	 * @param idForum
	 * 
	 * @return Boolean
	 */
	public Boolean isPrivateForum(Long idForum) {

		Criteria criteria = this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createCriteria(Forum.class);
		criteria.setProjection(Projections.property("viewStatus"));
		criteria.add(Restrictions.eq("idForum", idForum));
		criteria.add(Restrictions.eq("viewStatus", "private"));

		Boolean isPrivateForum;
		if (criteria.list().isEmpty()) {
			isPrivateForum = false;
			logger.info("ForumDAO:Forum is public");
		} else {
			isPrivateForum = true;
			logger.info("ForumDAO:Forum is private");
		}
		return isPrivateForum;
	}
}
