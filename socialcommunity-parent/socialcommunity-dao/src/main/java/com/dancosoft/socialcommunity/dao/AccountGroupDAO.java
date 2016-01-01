/**
 * Package com.dancosoft.socialcommunity.dao contain set of classes and interfaces which description
 * layer of data access object of SocialCommunity project. This project is based on MVC architecture.
 * This class is part of dao layer in MVC architecture. This layer offer abstract interface for work
 * with any type data base. This pattern give a chance work with DAO (data-access-object) without matter
 * what kind of storage engine is used and without need for a special way to match this storage engine.
 * All classes which contain word"DAO"provide to work DAL for ReducerLinks application.
 * 
 * Please contact with Zaerko Denis or send letter on zaerko1991@gmail.com if you need
 * to use information or have any questions.   
 */
package com.dancosoft.socialcommunity.dao;

import java.util.List;

import com.dancosoft.socialcommunity.model.AccountGroup;

/**
 * <p>
 * The interface AccountGroupDAO contain methods ads which realize in class
 * AccountGroupDAOImpl.Class AccountGroupDAOImpl use DAO pattern which describes
 * layer of data access to object. DAO layer perform link between relational and
 * object model. Model for this dao layer describied in class AccountGroup. This
 * interface contain ads methods which intended to access operation with object.
 * Interface produce special operation with object.Base operation (for any
 * object) include as separate interface CommonEntityDAO which extend to this
 * interface.Class use Spring framework to work whith ORM.In particular often
 * use HibernateTemplate for integration Hibernate and Spring technologys. For
 * work with data base use hibernate criteria.
 * 
 * @version 1.0 23.12.2015
 * @author Zaerko Denis
 */
public interface AccountGroupDAO extends CommonEntityDAO {

	/**
	 * Method cheack account group on block status by id group. If group
	 * is block return true else false
	 * 
	 * @type Long
	 * @param idAccountGroup
	 * 
	 * @return Boolean
	 */
	public Boolean isBlockAccountGroup(Long idAccountGroup);

	/**
	 * Method return  block status of account group by id group. 
	 * 
	 * @type String
	 * @param idAccount
	 * 
	 * @return String
	 */
	public String getAccountGroupBlockStatus(Long idAccount);

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
	public List<AccountGroup> getListAccountGroupWithBlockStatusByIdAccount(
			Long idAccount, String blockStatus);

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
	public List<AccountGroup> searchAccountGroupByGroupNameAccountName(
			String groupName, String accountName);

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
	public List<AccountGroup> getListAccountGroupWithViewStatusByIdAccount(
			Long idAccount, String viewStatus);
}
