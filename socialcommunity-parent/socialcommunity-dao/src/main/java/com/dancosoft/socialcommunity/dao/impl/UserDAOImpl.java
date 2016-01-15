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
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.dancosoft.socialcommunity.dao.UserDAO;
import com.dancosoft.socialcommunity.model.Account;
import com.dancosoft.socialcommunity.model.User;

/**
 * <p>The class UserDAOImpl use DAO pattern which describes layer of data access to
 * object. DAO layer perform link between relational and object model. Model for
 * this dao layer describied in class User. This class contain methods which
 * intended to access to special operation with User entity. Class extend
 * CommonEntityDAOImpl, which contain base set of operation(CRUD). Class
 * implements interface UserDAO located in package which have name
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
@Repository(value = "userDAO")
public class UserDAOImpl extends CommonEntityDAOImpl implements UserDAO {

	private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);

	public UserDAOImpl(){
		super(User.class);
	}
	
	/**
	 * Method return list of user accounts. If user accounts are
	 * not exist return empty list.
	 * 
	 * @type Long
	 * @param idUser
	 * 
	 * @return List<Account>
	 */
	@SuppressWarnings("unchecked")
	public List<Account> getListAccountByUserId(Long idUser) {

		Criteria criteria = this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createCriteria(Account.class);
		criteria.createAlias("user", "u");
		criteria.add(Restrictions.eq("u.idUser", idUser));
		criteria.addOrder(Order.desc("accountName"));
		criteria.setMaxResults(20);
		criteria.setFirstResult(0);
		
		logger.info("UserDAO: Accounts by user id load.");

		return criteria.list();
	}

	/**
	 * Method return list of user which belong to sex. If list
	 * of user is not exist return empty list
	 * 
	 * @type String
	 * @param sex
	 * 
	 * @return List<User>
	 */
	@SuppressWarnings("unchecked")
	public List<User> getListUserBySex(String sex) {

		Criteria criteria = this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("sex", sex));
		criteria.addOrder(Order.desc("lastName"));
		criteria.setMaxResults(20);
		criteria.setFirstResult(0);

		logger.info("UserDAO:List user loaded by sex ");

		return criteria.list();
	}

	/**
	 * Method return list of user by first name, last name, middle name.
	 * If list user is not exist return empty list 
	 * 
	 * @type String
	 * @param firstName
	 * @param lastName
	 * @param middleName
	 * 
	 * @return List<User>
	 */
	@SuppressWarnings("unchecked")
	public List<User> searchUserByFirstLastMiddleName(String firstName,String lastName,String middleName) {

		Criteria criteria = this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createCriteria(User.class);

		if(!firstName.equals(null) && !firstName.equals("")){
			criteria.add(Restrictions.eq("firstName", firstName));
		}
		if(!lastName.equals(null) && !lastName.equals("")){
			criteria.add(Restrictions.eq("lastName", lastName));
		}
		if(!middleName.equals(null) && !middleName.equals("")){
			criteria.add(Restrictions.eq("middleName", middleName));
		}
		criteria.addOrder(Order.desc("lastName"));
		criteria.setMaxResults(20);
		criteria.setFirstResult(0);

		logger.info("UserDAO:List user loaded by first name, last name, middle name.");

		return criteria.list();
	}
}
