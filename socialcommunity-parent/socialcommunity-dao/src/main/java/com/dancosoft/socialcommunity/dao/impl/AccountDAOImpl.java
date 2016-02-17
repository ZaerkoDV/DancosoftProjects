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
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.dancosoft.socialcommunity.dao.AccountDAO;
import com.dancosoft.socialcommunity.model.Account;

/**
 * <p>
 * The class AccountDAOImpl use DAO pattern which describes layer of data access
 * to object. DAO layer perform link between relational and object model. Model
 * for this dao layer describied in class Account. This class contain methods
 * which intended to access to special operation with Account entity. Class
 * extend �ommonEntityDAOImpl class, which contain base set of operation(CRUD).
 * Class implements interface AccountDAO located in package which have name
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
@Repository(value = "accountDAO")
public class AccountDAOImpl extends CommonEntityDAOImpl implements AccountDAO {

	private static final Logger logger = LoggerFactory.getLogger(AccountDAOImpl.class);

	public AccountDAOImpl(){
		super(Account.class);
	}
	
	/**
	 * Search account by his attribute lastName and by last name his ovner.
	 * 
	 * @type Date
	 * @type String
	 * @param accountName
	 * @param lastName
	 * 
	 * @return List<Account>
	 */
	@SuppressWarnings("unchecked")
	public List<Account> searchAccountByAccountNameUserLastName(String accountName, String lastName) {

		Criteria criteria = this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createCriteria(Account.class);
		criteria.createAlias("user", "u");
		if((accountName!=null && !accountName.equals("")) && (lastName!=null && lastName.equals(""))){
			criteria.add(Restrictions.eq("accountName", accountName));
			criteria.add(Restrictions.eq("u.lastName", lastName));
			
		}else if (accountName!=null && !accountName.equals("")) {
			criteria.add(Restrictions.eq("accountName", accountName));
			
		}else if (lastName!=null && !lastName.equals("")) {
			criteria.add(Restrictions.eq("u.lastName", lastName));
		}
			
		criteria.addOrder(Order.desc("u.lastName"));
		criteria.setMaxResults(20);
		criteria.setFirstResult(0);
		logger.info("AccountDAO:List account loaded by account name, last name.");

		return criteria.list();
	}

	/**
	 * Get id ovner(User) of account.
	 * 
	 * @type Long
	 * @param idAccount
	 * 
	 * @return Long
	 */
	public Long getIdUserByIdAccount(Long idAccount) {

		Criteria criteria = this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createCriteria(Account.class);

		criteria.setProjection(Projections.property("user.idUser"));
		criteria.add(Restrictions.eq("idAccount", idAccount));

		logger.info("AccountDAO:Id user load by id account.");
	
		return (Long) criteria.uniqueResult();
	}

	/**
	 * Cheack account block status. If status is block return true.
	 * 
	 * @type Boolean
	 * @param idAccount
	 * 
	 * @return Boolean
	 */
	public Boolean isAccountBlock(Long idAccount) {

		Criteria criteria = this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createCriteria(Account.class);

		criteria.setProjection(Projections.property("accountBlockStatus"));
		criteria.add(Restrictions.eq("idAccount", idAccount));

		Boolean isAccountBlock;
		String status = (String) criteria.uniqueResult();
		
		if (status.equals("block")) {
			isAccountBlock = true;
			logger.info("AccountDAO:Account is block");
		} else {
			isAccountBlock = false;
			logger.info("AccountDAO:Account is not block");
		}
		return isAccountBlock;
	}

	/**
	 * Get block status(attribute) of account
	 * 
	 * @type Boolean
	 * @param idAccount
	 * 
	 * @return String
	 */
	public String getAccountStatus(Long idAccount) {

		Criteria criteria = this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createCriteria(Account.class);
		criteria.setProjection(Projections.property("accountBlockStatus"));
		criteria.add(Restrictions.eq("idAccount", idAccount));	
		
		logger.info("AccountDAO:Account status is load.");

		return (String) criteria.uniqueResult();
	}
}
