/**
 * 
 */
package com.dancosoft.socialcommunity.service;

import java.time.LocalDateTime;

import com.dancosoft.socialcommunity.model.AccountHistory;

/**
 * @author Zaerko_DV
 *
 */
public interface AccountHistoryService extends CommonEntityService {

	public AccountHistory getAccountHistoryByIdAccount(Long idAccount);
	
	public LocalDateTime getLastVisitAccountByIdAccount(Long idAccount);
}
