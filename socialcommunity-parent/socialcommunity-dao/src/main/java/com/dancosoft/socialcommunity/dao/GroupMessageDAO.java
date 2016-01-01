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
import com.dancosoft.socialcommunity.model.GroupMessage;

/**
 * <p> The interface GroupMessageDAO contain methods ads which realize in class
 * GroupMessageDAOImpl.Class GroupMessageDAOImpl use DAO pattern which describes
 * layer of data access to object. DAO layer perform link between relational and
 * object model. Model for this dao layer describied in class GroupMessage. This
 * interface contain ads methods which intended to access operation with object.
 * Interface produce special operation with object.Base operation (for any
 * object) include as separate interface CommonEntityDAO which extend to this
 * interface.Class use Spring framework to work with ORM.In particular often use
 * HibernateTemplate for integration Hibernate and Spring technologys. For work
 * with data base use hibernate criteria.
 * 
 * @version 1.0 23.12.2015
 * @author Zaerko Denis
 */
public interface GroupMessageDAO extends CommonEntityDAO {

	/**
	 * Method return member account by id message which user create in account group.
	 * If account member is not exist return null.
	 * 
	 * @type Long
	 * @param idGroupMessage
	 * 
	 * @return Account
	 */
	public Account getMemberAccountByIdGroupMessage(Long idGroupMessage);

	/**
	 * Method return list of group message which belong to account group by id account group.
	 * If group message are not exist return empty list.
	 * 
	 * @type Long
	 * @param idAccountGroup
	 * 
	 * @return List<GroupMessage>
	 */
	public List<GroupMessage> getListGroupMessageByIdAccountGroup(
			Long idAccountGroup);

	/**
	 * Method return list of group message which belong to account group and which create
	 * between date by id account group. If group message are not exist return empty list.
	 * 
	 * @type Long
	 * @type Date
	 * @param idAccountGroup
	 * @param minDate
	 * @param maxDate
	 * 
	 * @return List<GroupMessage> 
	 */
	public List<GroupMessage> getListGroupMessageBeetweenDateByIdAccountGroup(
			Long idAccountGroup, Date minDate, Date maxDate);

	/**
	 * Method return count of group messages. If group messages are
	 * not exist return zero.
	 * 
	 * @type int
	 * @param idAccountGroup
	 * 
	 * @return int 
	 */
	public int getCountGroupMessageByIdAccountGroup(Long idAccountGroup);
}
