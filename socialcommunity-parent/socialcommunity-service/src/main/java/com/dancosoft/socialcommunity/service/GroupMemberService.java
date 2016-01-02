/**
 * 
 */
package com.dancosoft.socialcommunity.service;

import java.util.List;

import com.dancosoft.socialcommunity.model.Account;
import com.dancosoft.socialcommunity.model.GroupMember;

/**
 * @author Zaerko_DV
 *
 */
public interface GroupMemberService extends CommonEntityService{

	public List<GroupMember> getListGroupMemberByIdAccountGroup(Long idAccountGroup);
	public List<Account> getListAccountWithStatusByIdAccountGroup(Long idAccountGroup, String friendStatus);
}
