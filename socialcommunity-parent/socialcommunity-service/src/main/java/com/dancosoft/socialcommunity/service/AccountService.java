/**
 * 
 */
package com.dancosoft.socialcommunity.service;

import java.util.List;

import com.dancosoft.socialcommunity.model.Account;

/**
 * @author Zaerko_DV
 *
 */
public interface AccountService extends CommonEntityService {

	public List<Account> searchAccountByAccountNameUserLastName(
			String accountName, String lastName);

	public Long getIdUserByIdAccount(Long idAccount);

	public Boolean isAccountBlock(Long idAccount);

	public String getAccountStatus(Long idAccount);
}
