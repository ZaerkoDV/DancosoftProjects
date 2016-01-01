/**
 * 
 */
package com.dancosoft.socialcommunity.service;

import java.util.List;

import com.dancosoft.socialcommunity.model.AccountGroup;

/**
 * @author Zaerko_DV
 *
 */
public interface AccountGroupService extends CommonEntityService {

	public Boolean isBlockAccountGroup(Long idAccountGroup);

	public String getAccountGroupBlockStatus(Long idAccount);

	public List<AccountGroup> getListAccountGroupWithBlockStatusByIdAccount(
			Long idAccount, String blockStatus);

	public List<AccountGroup> searchAccountGroupByGroupNameAccountName(
			String groupName, String accountName);

	public List<AccountGroup> getListAccountGroupWithViewStatusByIdAccount(
			Long idAccount, String viewStatus);
}
