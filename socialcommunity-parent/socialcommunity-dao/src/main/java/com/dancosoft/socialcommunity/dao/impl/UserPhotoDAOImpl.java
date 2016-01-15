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

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.dancosoft.socialcommunity.dao.UserPhotoDAO;
import com.dancosoft.socialcommunity.model.UserPhoto;

/**
 * <p>The class UserPhotoDAOImpl use DAO pattern which describes layer of data
 * access to object. DAO layer perform link between relational and object model.
 * Model for this dao layer describied in class UserPhoto. This class contain
 * methods which intended to access to special operation with UserPhoto entity.
 * Class extend CommonEntityDAOImpl class, which contain base set of
 * operation(CRUD). Class implements interface UserPhotoDAO located in package
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
 * @see org.springframework.stereotype
 * @see org.hibernate.Criteria
 * @see slf4j fasade
 * @see log4j framework
 * 
 * @version 1.0 23.12.2015
 * @author Zaerko Denis
 */
@Repository(value = "userPhotoDAO")
public class UserPhotoDAOImpl extends CommonEntityDAOImpl implements UserPhotoDAO {

	private static final Logger logger = LoggerFactory.getLogger(UserPhotoDAOImpl.class);

	public UserPhotoDAOImpl(){
		super(UserPhoto.class);
	}
	
	/**
	 * Method return user photo by id user. If user photo is not exist return null
	 * 
	 * @type Long
	 * @param idUser
	 * 
	 * @return UserPhoto
	 */
	public UserPhoto getUserPhotoByIdUser(Long idUser) {

		Criteria criteria = this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createCriteria(UserPhoto.class);
		criteria.createAlias("user", "u");
		criteria.add(Restrictions.eq("u.idUser", idUser));
		logger.info("UserPhotoDAO: User photo load by id user");

		return (UserPhoto) criteria.uniqueResult();
	}

	/**
	 * Method return return photo name by id user. If photo name
	 * is not exist return null.
	 * 
	 * @type Long
	 * @param idUser
	 * 
	 * @return String
	 */
	public String getPhotoNameByIdUser(Long idUser) {

		Criteria criteria = this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createCriteria(UserPhoto.class);
		criteria.setProjection(Projections.property("photoName"));
		criteria.createAlias("user", "u");
		criteria.add(Restrictions.eq("u.idUser", idUser));
		logger.info("UserPhotoDAO: Name user photo load by id user");

		return (String) criteria.uniqueResult();
	}
}
