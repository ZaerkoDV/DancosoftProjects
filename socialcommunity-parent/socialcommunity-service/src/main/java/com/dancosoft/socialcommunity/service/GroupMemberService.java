/**
 * @package com.dancosoft.socialcommunity.service
 * 
 * Package com.dancosoft.socialcommunity.service contain set of interfaces which
 * description service layer of SocialCommunity project.Also this package contain
 * realization of interfaces in package com.dancosoft.socialcommunity.service.impl
 * and support classes in com.dancosoft.socialcommunity.service.support.This project
 * is based on MVC architecture.This inerface perform class which is part of service
 * layer in MVC architecture.This layer defines the boundary of the application and
 * a set of permitted operations. It encapsulates the business logic of the application
 * and controls the answers in the implementation of operations. All classes which
 * contain postfix “Service” provide to work Service for SocialCommunity application.
 * 
 * Please contact with Zaerko Denis or send letter on zaerko1991@gmail.com if you need
 * to use information or have any questions.   
 */
package com.dancosoft.socialcommunity.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataRetrievalFailureException;

import com.dancosoft.socialcommunity.model.Account;
import com.dancosoft.socialcommunity.model.GroupMember;

/**
 * <p>The interface GroupMemberService contain methods ads which realize in class
 * GroupMemberServiceImpl. Class GroupMemberServiceImpl use Service pattern which
 * describes service layer of application. This class contain general operation
 * to all classes.This interface contain ads methods which perform busness logic
 * all application. Interface extend CommonEntityService interface which contain
 * ads base operation of any entity.
 * 
 * @version 1.0 08.10.2015
 * @author Zaerko Denis
 */
public interface GroupMemberService extends CommonEntityService{

	/**
	 * Method return list of group member by id account group. If group member
	 * is not exist return empty list.
	 * 
	 * @type Long
	 * @param idAccountGroup
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return List<GroupMember>
	 */
	public List<GroupMember> getListGroupMemberByIdAccountGroup(Long idAccountGroup);
	
	/**
	 * Method return list Account with friend status by id account group.
	 * If account members are not exist method return empty list
	 * 
	 * @type Long
	 * @type String
	 * @param idAccountGroup
	 * @param friendStatus
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return List<Account>
	 */
	public List<Account> getListAccountWithStatusByIdAccountGroup(Long idAccountGroup, String friendStatus);
}
