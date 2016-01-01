/**
 * 
 */
package com.dancosoft.socialcommunity.service;

import com.dancosoft.socialcommunity.model.AccountGroupHistory;

/**
 * @author Zaerko_DV
 *
 */
public interface AccountGroupHistoryService extends CommonEntityService {

	public AccountGroupHistory getAccountGroupHistoryByIdAccountGroup(Long idAccountGroup);
}
