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

import com.dancosoft.socialcommunity.dao.UserSocialNetworkDAO;
import com.dancosoft.socialcommunity.model.UserSocialNetwork;

/**
 * <p>
 * The class UserSocialNetworkDAOImpl use DAO pattern which describes layer of
 * data access to object. DAO layer perform link between relational and object
 * model. Model for this dao layer describied in class UserSocialNetwork. This
 * class contain methods which intended to access to special operation with
 * UserSocialNetwork entity. Class extend CommonEntityDAOImpl class, which
 * contain base set of operation(CRUD). Class implements interface
 * UserSocialNetworkDAO located in package which have name
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
@Repository(value="userSocialNetworkDAO")
public class UserSocialNetworkDAOImpl extends CommonEntityDAOImpl implements UserSocialNetworkDAO  {

	private static final Logger logger = LoggerFactory.getLogger(UserSocialNetworkDAOImpl.class);
	
	public UserSocialNetworkDAOImpl(){
		super(UserSocialNetwork.class);
	}
	
	/**
	 * Method return user social nettwork with view status which use user.
	 * If social community not exist return null.
	 * 
	 * @type Long
	 * @type String
	 * @param idUser
	 * @param viewStatus
	 * 
	 * @return UserSocialNetwork
	 */
	public UserSocialNetwork getSocialNetworkWithStatusByIdUser(Long idUser,String viewStatus){
		
		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(UserSocialNetwork.class);
		criteria.createAlias("userCorespondence", "c");
		criteria.createAlias("c.user", "u");
		criteria.add(Restrictions.eq("u.idUser", idUser));
		criteria.add(Restrictions.eq("c.corespondenceViewStatus", viewStatus));		
		logger.info("UserSocialNetworkDAO:List user social network with status loaded.");

		return (UserSocialNetwork) criteria.uniqueResult();
	}
	
	/**
	 * Method cheak user skype address on uniqule value. If user
	 * skype have unique value return true else return false.
	 * 
	 * @type String
	 * @param skypeAddress
	 * 
	 * @return Boolean
	 */
	public Boolean isUniqueSkype(String skypeAddress){
		
		Criteria criteria = this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createCriteria(UserSocialNetwork.class);
		criteria.add(Restrictions.eq("skypeAddress", skypeAddress));

		Boolean isUnique;
		if (criteria.list().isEmpty()) {
			isUnique = true;
			logger.info("UserSocialNetworkDAO:User skype address is unique.");
		} else {
			isUnique = false;
			logger.info("UserSocialNetworkDAO:User skype address is not unique.");
		}
		return isUnique;
	}
	
	/**
	 * Method cheak user facebook address on uniqule value. If user
	 * facebook have unique value return true else return false.
	 * 
	 * @type String
	 * @param facebookAddress
	 * 
	 * @return Boolean
	 */
	public Boolean isUniqualFaceBook(String facebookAddress){
		
		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(UserSocialNetwork.class);
		criteria.add(Restrictions.eq("facebookAddress", facebookAddress));
		
		Boolean isUnique;
		if (criteria.list().isEmpty()) {
			isUnique = true;
			logger.info("UserSocialNetworkDAO:User facebook address is unique.");
		} else {
			isUnique = false;
			logger.info("UserSocialNetworkDAO:User facebook address is not unique.");
		}
		return isUnique;
	}
	
	/**
	 * Method return id user by user face book address. If user
	 * is not exist return null.
	 * 
	 * @type String
	 * @param facebookAddress
	 * 
	 * @return Long
	 */
	public Long getIdUserByFacebookAddress(String facebookAddress){
		
		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(UserSocialNetwork.class);
		criteria.createAlias("userCorespondence", "c");
		criteria.createAlias("c.user", "u");
		criteria.setProjection(Projections.property("u.idUser"));
		criteria.add(Restrictions.eq("facebookAddress", facebookAddress));

		logger.info("UserSocialNetworkDAO:User id load by facebook address");
	
		return (Long)criteria.uniqueResult();
	}
}
