/**
 * @package com.dancosoft.socialcommunity.service.impl
 * 
 * Package com.dancosoft.socialcommunity.service.impl contain set of class which description
 * service layer(modul) in SocialCommunity project. This project based on MVC architecture.
 * This class is part of service layer in MVC architecture.This layer defines the boundary
 * of the application and a set of permitted operations. It encapsulates the business logic
 * of the application and controls the answers in the implementation of operations.All classes
 * which contain postfix “Service” provide to work Service for SocialCommunity application.
 * Also this package user support classes: for generate new passworl and login,for sending
 * email to user and other from com.dancosoft.socialcommunity.service.support package.
 * 
 * Please contact with Zaerko Denis or send letter on zaerko1991@gmail.com if you need
 * to use information or have any questions.   
 */
package com.dancosoft.socialcommunity.service.impl;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.stereotype.Service;

import com.dancosoft.socialcommunity.dao.GroupMemberDAO;
import com.dancosoft.socialcommunity.model.Account;
import com.dancosoft.socialcommunity.model.GroupMember;
import com.dancosoft.socialcommunity.service.GroupMemberService;

/**
 * <p>The class GroupEventServiceImpl use Service pattern which describes business
 * logic SocialCommunity application. Service layer perform link between,
 * presentation layer and DAO layer(GroupEventDAO).This layer is the main role
 * becouse layer contents(set of methods in classes) affect on functionality of
 * all application. This class contain methods which describes specific
 * operation for GroupEvent.This class perform service layer to GroupEvent.Class
 * extend base class CommonEntityServiceImpl and implement GroupEventService
 * interface which perform all methods of this class. For logging use fasade
 * slf4j and framework log4j. Class contain also private, static variable
 * logger, which use to call log message. Class use Spring framework anatations
 * to work with service layer.
 * 
 * @see org.springframework.stereotype
 * @see slf4j framework
 * @see log4j framework
 * 
 * @version 1.0 05.01.2016
 * @author Zaerko Denis
 */
@Service(value="groupMemberService")
public class GroupMemberServiceImpl extends CommonEntityServiceImpl implements GroupMemberService{

	private static final Logger logger = LoggerFactory.getLogger(GroupMemberServiceImpl.class);
	
	@Autowired
	@Qualifier(value="groupMemberDAO")
	private GroupMemberDAO groupMemberDAO;

	public void setGroupMemberDAO(GroupMemberDAO groupMemberDAO) {
		this.groupMemberDAO = groupMemberDAO;
	}
	
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
	public List<GroupMember> getListGroupMemberByIdAccountGroup(Long idAccountGroup){
		
		List<GroupMember> list=Collections.emptyList();
		if (idAccountGroup.equals(null) || idAccountGroup.equals("")) {
			throw new RuntimeException("GroupMemberService:Id account group must not null or empty.");
			
		}else{
			try {
				logger.info("GroupMemberService:List members of group load by id account group.");
				list= groupMemberDAO.getListGroupMemberByIdAccountGroup(idAccountGroup);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("GroupMemberService: List of group members load by id"
						+ " account group. But list is empty=" + rf);
				
			}catch (DataAccessException da) {
				logger.error("GroupMemberService: Exeption connect with data base or other error= "+da);
			}
		}
		return list;
	}
	
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
	public List<Account> getListAccountWithStatusByIdAccountGroup(Long idAccountGroup, String friendStatus) {
		
		List<Account> list=Collections.emptyList();
		if (idAccountGroup.equals(null) || idAccountGroup.equals("")) {
			throw new RuntimeException("GroupMemberService:Id account group must not null or empty.");
			
		}else{
			try {
				logger.info("GroupMemberService:List members of group with status friend load by id account group.");
				list= groupMemberDAO.getListAccountWithStatusByIdAccountGroup(idAccountGroup, friendStatus);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("GroupMemberService:List members of group with status friend load,"
						+ " but list is empty." + rf);
				
			}catch (DataAccessException da) {
				logger.error("GroupMemberService: Exeption connect with data base or other error= "+da);
			}
		}
		return list;
	}
}
