/**
 * 
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
 * @author Zaerko_DV
 *
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
