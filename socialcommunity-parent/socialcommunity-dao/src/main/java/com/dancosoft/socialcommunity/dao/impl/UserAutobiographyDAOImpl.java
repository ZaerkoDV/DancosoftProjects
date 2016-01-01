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
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.dancosoft.socialcommunity.dao.UserAutobiographyDAO;
import com.dancosoft.socialcommunity.model.User;
import com.dancosoft.socialcommunity.model.UserAutobiography;

/**
 * <p> The class UserAutobiographyDAOImpl use DAO pattern which describes layer of
 * data access to object. DAO layer perform link between relational and object
 * model. Model for this dao layer describied in class UserAutobiography. This
 * class contain methods which intended to access to special operation with
 * UserAutobiography entity. Class extend CommonEntityDAOImpl class, which
 * contain base set of operation(CRUD). Class implements interface
 * UserAutobiographyDAO located in package which have name
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
@Repository(value="userAutobiographyDAO")
public class UserAutobiographyDAOImpl extends CommonEntityDAOImpl implements UserAutobiographyDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(UserAutobiographyDAOImpl.class);
	
//	public UserAutobiographyDAOImpl(){
//		super(UserAutobiography.class);
//	}
	
	/**
	 * Method return user autobiogeaphy by id user. If user autobiography
	 * is not exist return null
	 * 
	 * @type Long
	 * @param idUser
	 * 
	 * @return UserAutobiography
	 */
	public UserAutobiography getUserAutobiographyByIdUser(Long idUser) {
	
		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(UserAutobiography.class);
		criteria.add(Restrictions.eq("user.idUser", idUser));
		logger.info("UserAutobiographyDAO: User autobiography load by id user.");
	
		return (UserAutobiography) criteria.uniqueResult();
	}
	
	/**
	 * Method return list of user with the same hobby.
	 * If users are not exist return empty list.
	 * 
	 * @type String
	 * @param hobby
	 * 
	 * @return UserAutobiography
	 */
	@SuppressWarnings("unchecked")
	public List<User> getListUserByHobby(String hobby) {
		
		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(UserAutobiography.class);
		criteria.setProjection(Projections.property("user"));
		criteria.add(Restrictions.eq("hobby", hobby));
		logger.info("UserAutobiographyDAO:List user loaded by hobby.");

		return criteria.list();
	}
	
	/**
	 * Method return result of check user no adult value. Yers Adult is
	 * year value after which user become adult status. If user is adult
	 * returm true else false.
	 * 
	 * @type Long
	 * @param idUser
	 * @param yearAdult
	 * 
	 * @return Boolean
	 */
	public Boolean isUserAdult(Long idUser,Long yearAdult) {
		
		LocalDateTime borderAdultDate=LocalDateTime.now().minusYears(yearAdult);
		
		Criteria criteria = this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createCriteria(UserAutobiography.class);
		criteria.setProjection(Projections.property("user"));
	
		Conjunction and = Restrictions.conjunction();
		//Cheack user
		and.add(Restrictions.eq("user.idUser", idUser));
	    // Date birth must be < borderAdultDate
	    and.add( Restrictions.lt("birth", borderAdultDate)); 
		
	    Boolean isUserAdult=false;

		if (criteria.list().isEmpty()) {
			isUserAdult = false;
			logger.info("UserAutobiographyDAO:User " + idUser + " is not adult");
		} else {
			isUserAdult = true;
			logger.info("UserAutobiographyDAO:User "+idUser+" is adult");
		}
		return isUserAdult;
	}
	
	/**
	 * Method return list of adult user. If adult users are
	 * not exist return empty list.
	 * 
	 * @type Long
	 * @param yearAdult
	 * 
	 * @return List<User>
	 */
	@SuppressWarnings("unchecked")
	public List<User> getListAdultUser(Long yearAdult) {
		
		LocalDateTime borderAdultDate=LocalDateTime.now().minusYears(yearAdult);
		
		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(UserAutobiography.class);
		criteria.setProjection(Projections.property("user"));
		// Date birth must be < borderAdultDate
		//criteria.add(Restrictions.lt("birth", borderAdultDate)); 
		Conjunction and = Restrictions.conjunction();
	    and.add(Restrictions.lt("birth", borderAdultDate)); 
		
	    criteria.addOrder(Order.desc("birth"));
		criteria.setMaxResults(20);
		criteria.setFirstResult(0);		
	    logger.info("UserAutobiographyDAO:List adult user loaded");

		return criteria.list();
	}
}
