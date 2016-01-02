/**
 * 
 */
package com.dancosoft.socialcommunity.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
		logger.info("GroupMemberService:List members of group load by id account group.");
		return groupMemberDAO.getListGroupMemberByIdAccountGroup(idAccountGroup);
	}
	
	public List<Account> getListAccountWithStatusByIdAccountGroup(Long idAccountGroup, String friendStatus) {
		logger.info("GroupMemberService:List members of group with"
				+ " status friend load by id account group.");
		return groupMemberDAO.getListAccountWithStatusByIdAccountGroup(idAccountGroup, friendStatus);
	}
}
