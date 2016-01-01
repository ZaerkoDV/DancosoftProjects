/**
 * @package com.dancosoft.socialcommunity.dao
 * 
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

import com.dancosoft.socialcommunity.model.Account;

/**
 * <p> The interface AccountDAO contain methods ads which realize in class
 * AccountDAOImpl.Class AccountDAOImpl use DAO pattern which describes layer of
 * data access to object. DAO layer perform link between relational and object
 * model. Model for this dao layer describied in class Account. This interface
 * contain ads methods which intended to access operation with object. Interface
 * produce special operation with object.Base operation (for any object) include
 * as separate interface CommonEntityDAO which extend to this interface.Class
 * use Spring framework to work with ORM.In particular often use
 * HibernateTemplate for integration Hibernate and Spring technologys. For work
 * with data base use hibernate criteria.
 * 
 * @version 1.0 23.12.2015
 * @author Zaerko Denis
 */
public interface AccountDAO extends CommonEntityDAO {

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
	public List<Account> searchAccountByAccountNameUserLastName(
			String accountName, String lastName);

	/**
	 * Get id ovner(User) of account.
	 * 
	 * @type Long
	 * @param idAccount
	 * 
	 * @return Long
	 */
	public Long getIdUserByIdAccount(Long idAccount);

	/**
	 * Cheack account block status. If status is block return true.
	 * 
	 * @type Boolean
	 * @param idAccount
	 * 
	 * @return Boolean
	 */
	public Boolean isAccountBlock(Long idAccount);

	/**
	 * Get block status(attribute) of account
	 * 
	 * @type Boolean
	 * @param idAccount
	 * 
	 * @return String
	 */
	public String getAccountStatus(Long idAccount);
}
