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

import com.dancosoft.socialcommunity.model.Account;
import com.dancosoft.socialcommunity.model.GroupMember;

/**
 * <p> The interface GroupMemberDAO contain methods ads which realize in class
 * GroupMemberDAOImpl. Class GroupMemberDAOImpl use DAO pattern which describes layer of
 * data access to object. DAO layer perform link between relational and object
 * model. Model for this dao layer describied in class GroupMember. This interface
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
public interface GroupMemberDAO extends CommonEntityDAO {

	/**
	 * Method return list of group member by id account group. If group member
	 * is not exist return empty list.
	 * 
	 * @type Long
	 * @param idAccountGroup
	 * 
	 * @return List<GroupMember>
	 */
	public List<GroupMember> getListGroupMemberByIdAccountGroup(
			Long idAccountGroup);

	/**
	 * Method return list Account with friend status by id account group.
	 * If account members are not exist method return empty list
	 * 
	 * @type Long
	 * @type String
	 * @param idAccountGroup
	 * @param friendStatus
	 * 
	 * @return List<Account>
	 */
	public List<Account> getListAccountWithStatusByIdAccountGroup(
			Long idAccountGroup, String friendStatus);
	
	/**
	 * Method return GroupMember by id account group and id accoun.
	 * 
	 * @type Long
	 * @param idAccountGroup
	 * @param idAccount
	 * 
	 * @return GroupMember
	 */
	public GroupMember getGroupMemberInAccountGroupByIdAccount(Long idAccountGroup,Long idAccount);
}
