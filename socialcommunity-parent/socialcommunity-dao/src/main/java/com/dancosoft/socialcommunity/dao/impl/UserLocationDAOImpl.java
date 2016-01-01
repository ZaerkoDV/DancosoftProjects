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

import com.dancosoft.socialcommunity.dao.UserLocationDAO;
import com.dancosoft.socialcommunity.model.City;
import com.dancosoft.socialcommunity.model.Country;
import com.dancosoft.socialcommunity.model.Language;
import com.dancosoft.socialcommunity.model.UserLocation;

/**
 * <p>
 * The class UserLocationDAOImpl use DAO pattern which describes layer of data
 * access to object. DAO layer perform link between relational and object model.
 * Model for this dao layer describied in class UserLocation. This class contain
 * methods which intended to access to special operation with UserLocation
 * entity. Class extend CommonEntityDAOImpl class, which contain base set of
 * operation(CRUD). Class implements interface UserLocationDAO located in
 * package which have name com.dancosoft.socialcommunity.dao. All methods are
 * public in class. For logging use logger fasade slf4j and framework log4j.
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
@Repository(value="userLocationDAO")
public class UserLocationDAOImpl extends CommonEntityDAOImpl implements UserLocationDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(UserLocationDAOImpl.class);
	
//	public UserLocationDAOImpl(){
//		super(UserLocation.class);
//	}
	
	/**
	 * Method return user location by id user. If user
	 * location is not exist return null.
	 * 
	 * @type Long
	 * @param idUser
	 * 
	 * @return UserLocation
	 */
	public UserLocation getUserLocationByIdUser(Long idUser) {
		
		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(UserLocation.class);
		criteria.add(Restrictions.eq("user.idUser", idUser));
		logger.info("UserLocationDAO: User location load by id user.");

		return (UserLocation) criteria.uniqueResult();
	}
	
	/**
	 * Method return user language by id user. If user language
	 * not exist return null.
	 * 
	 * @type Long
	 * @param idUser
	 * 
	 * @return Language
	 */
	public Language getUserLanguageByIdUser(Long idUser) {
		
		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(UserLocation.class);
		criteria.setProjection(Projections.property("language"));
		criteria.add(Restrictions.eq("user.idUser", idUser));		
		logger.info("UserLocationDAO: User language load by id user.");

		return (Language) criteria.uniqueResult();
	}
	
	/**
	 * Method return user city by id user. If user city
	 * not exist return null.
	 * 
	 * @type Long
	 * @param idUser
	 * 
	 * @return City
	 */
	public City getUserCityByIdUser(Long idUser) {
		
		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(UserLocation.class);
		criteria.setProjection(Projections.property("city"));
		criteria.add(Restrictions.eq("user.idUser", idUser));	
		logger.info("UserLocationDAO: User city load by id user.");
	
		return (City) criteria.uniqueResult();
	}
	
	/**
	 * Method return user country by id user. If user country
	 * not exist return null. User must have city before.
	 * 
	 * @type Long
	 * @param idUser
	 * 
	 * @return Country
	 */
	public Country getUserCountryByIdUser(Long idUser) {
		
		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(UserLocation.class);
		criteria.createAlias("city", "c");
		criteria.setProjection(Projections.property("c.country"));
		criteria.add(Restrictions.eq("user.idUser", idUser));
		logger.info("UserLocationDAO: User country load by id user.");
	
		return (Country) criteria.uniqueResult();
	}
}
