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

import com.dancosoft.socialcommunity.dao.AccountGroupDAO;
import com.dancosoft.socialcommunity.model.AccountGroup;
import com.dancosoft.socialcommunity.model.GroupMember;

/**
 * <p>
 * The class AccountGroupDAOImpl use DAO pattern which describes layer of data
 * access to object. DAO layer perform link between relational and object
 * model.Model for this dao layer describied in class AccountGroup. This class
 * contain methods which intended to access to special operation with
 * AccountGroup entity. Class extend CommonEntityDAOImpl class, which contain
 * base set of operation(CRUD).The Class implements interface AccountGroupDAO
 * located in package which have name com.dancosoft.socialcommunity.dao. All
 * methods are public in class. For logging use logger fasade slf4j and framework
 * log4j. Class contain also private, static variable logger, which use to call
 * log message. This class use Spring framework to work whith ORM. In particular
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
@Repository(value = "accountGroupDAO")
public class AccountGroupDAOImpl extends CommonEntityDAOImpl implements	AccountGroupDAO {

	private static final Logger logger = LoggerFactory.getLogger(AccountGroupDAOImpl.class);

	public AccountGroupDAOImpl(){
		super(AccountGroup.class);
	}
	
	/**
	 * Method cheack account group on block status by id group. If group
	 * is block return true else false
	 * 
	 * @type Long
	 * @param idAccountGroup
	 * 
	 * @return Boolean
	 */
	public Boolean isBlockAccountGroup(Long idAccountGroup) {
		
		Criteria criteria = this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createCriteria(AccountGroup.class);
		criteria.createAlias("account", "a");
		criteria.setProjection(Projections.property("accountGroupBlockStatus"));
		criteria.add(Restrictions.eq("a.idAccount", idAccountGroup));

		Boolean isAccountGroupBlock;
		String status=(String)criteria.uniqueResult();
		
		if (status.equals("block")) {
			isAccountGroupBlock = true;
			logger.info("AccountGroupDAO:Account group is block");
		} else {
			isAccountGroupBlock = false;
			logger.info("AccountGroupDAO:Account group is not block");
		}
		return isAccountGroupBlock;	
	}
	
	/**
	 * Method return  block status of account group by id group. 
	 * 
	 * @type String
	 * @param idAccount
	 * 
	 * @return String
	 */
	public String getAccountGroupBlockStatus(Long idAccount) {

		Criteria criteria = this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createCriteria(AccountGroup.class);
		criteria.createAlias("account","a");
		criteria.setProjection(Projections.property("accountGroupBlockStatus"));
		criteria.add(Restrictions.eq("a.idAccount", idAccount));
		logger.info("AccountGroupDAO:Account group status is load.");
		
		return (String)criteria.uniqueResult();
	}
	
	/**
	 * Method return list of account group by id account which have status block. 
	 * 
	 * @type Long
	 * @type String
	 * @param idAccount
	 * @param blockStatus
	 * 
	 * @return List<AccountGroup>
	 */	
	@SuppressWarnings("unchecked")
	public List<AccountGroup> getListAccountGroupWithBlockStatusByIdAccount(Long idAccount,String blockStatus) {
		
		Criteria criteria = this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createCriteria(GroupMember.class);
		criteria.setProjection(Projections.property("accountGroup"));
		
		criteria.createAlias("memberAccount", "a");
		criteria.createAlias("accountGroup", "g");
		criteria.add(Restrictions.eq("a.idAccount", idAccount));
		criteria.add(Restrictions.eq("g.accountGroupBlockStatus", blockStatus));

		criteria.setMaxResults(20);
		criteria.setFirstResult(0);
		logger.info("AccountGroupDAO:List AccountGroup with block status load by id account");

		return criteria.list();	
	}
	
	/**
	 * Search account group by group name and account name. Method return list of account
	 * group else empty list.
	 * 
	 * @type String
	 * @param groupName
	 * @param accountName
	 * 
	 * @return List<AccountGroup>
	 */
	@SuppressWarnings("unchecked")
	public List<AccountGroup> searchAccountGroupByGroupNameAccountName(String groupName, String accountName) {

		Criteria criteria = this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createCriteria(AccountGroup.class);
		criteria.createAlias("account", "a");

		if (groupName!=null && accountName!=null) {
			criteria.add(Restrictions.eq("groupName", groupName));
			criteria.add(Restrictions.eq("a.accountName", accountName));
			
		}else if(groupName!=null) {
			criteria.add(Restrictions.eq("groupName", groupName));
			
		}else if (accountName!=null) {
			criteria.add(Restrictions.eq("a.accountName", accountName));
		}
		criteria.addOrder(Order.desc("groupName"));
		criteria.setMaxResults(20);
		criteria.setFirstResult(0);
		logger.info("AccountGroupDAO:List AccountGroup load by groupName and accountName.");

		return criteria.list();
	}

	/**
	 * Method return list of account group with view status by id account.
	 * 
	 * @type Long
	 * @type String
	 * @param idAccount
	 * @param viewStatus
	 * 
	 * @return List<AccountGroup>
	 */
	@SuppressWarnings("unchecked")
	public List<AccountGroup> getListAccountGroupWithViewStatusByIdAccount(Long idAccount,String viewStatus){
		
		Criteria criteria = this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createCriteria(AccountGroup.class);
		criteria.createAlias("account", "a");
		
		criteria.add(Restrictions.eq("viewStatus", viewStatus));
		criteria.add(Restrictions.eq("a.idAccount", idAccount));
		criteria.addOrder(Order.desc("groupName"));
		criteria.setMaxResults(20);
		criteria.setFirstResult(0);
		logger.info("AccountGroupDAO:List AccountGroup with  view status load by id account");

		return criteria.list();
	}
}
