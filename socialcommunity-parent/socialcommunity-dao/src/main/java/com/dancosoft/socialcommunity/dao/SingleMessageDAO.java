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

import java.util.Date;
import java.util.List;

import com.dancosoft.socialcommunity.model.Account;
import com.dancosoft.socialcommunity.model.SingleMessage;

/**
 * <p>
 * The interface SingleMessageDAO contain methods ads which realize in class
 * SingleMessageDAOImpl.Class SingleMessageDAOImpl use DAO pattern which
 * describes layer of data access to object. DAO layer perform link between
 * relational and object model. Model for this dao layer describied in class
 * SingleMessage. This interface contain ads methods which intended to access
 * operation with object. Interface produce special operation with object.Base
 * operation (for any object) include as separate interface CommonEntityDAO
 * which extend to this interface.Class use Spring framework to work with ORM.In
 * particular often use HibernateTemplate for integration Hibernate and Spring
 * technologys. For work with data base use hibernate criteria.
 * 
 * @version 1.0 23.12.2015
 * @author Zaerko Denis
 */
public interface SingleMessageDAO extends CommonEntityDAO {

	/**
	 * Method return list of user messages which created between date. If messages are not exist return empty list.
	 * 
	 * @type Date
	 * @type Long
	 * @param idAccount
	 * @param minDate
	 * @param maxDate
	 * 
	 * @return List<SingleMessage>
	 */
	public List<SingleMessage> getListSingleMessageBeetweenDateByIdAccount(
			Long idAccount, Date minDate, Date maxDate);

	/**
	 * Method return list of interlocutor account which speak with this account.
	 * If accounts are not exist return empty list. 
	 * 
	 * @type Long
	 * @param idAccount
	 * 
	 * @return List<Account>
	 */
	public List<Account> getListInterlocutorAccountByIdAccount(Long idAccount);

	/**
	 * Method return list of interlocutor account message which user account
	 * have between min and max date.If single messages are not exist return empty list.
	 * 
	 * @type Long
	 * @type Date
	 * @param idAccount
	 * @param idInterlocutorAccount
	 * @param minDate
	 * @param maxDate
	 * 
	 * @return List<SingleMessage>
	 */
	public List<SingleMessage> getListIntrlocutorSingleMessageBeetweenDateByIdAccount(
			Long idAccount, Long idInterlocutorAccount, Date minDate, Date maxDate);
}
