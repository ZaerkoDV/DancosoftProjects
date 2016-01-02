/**
 * 
 */
package com.dancosoft.socialcommunity.service;

import java.util.List;

import com.dancosoft.socialcommunity.model.Account;
import com.dancosoft.socialcommunity.model.User;

/**
 * @author Zaerko_DV
 *
 */
public interface UserService extends CommonEntityService {

	public List<Account> getListAccountByUserId(Long idUser);

	public List<User> getListUserBySex(String sex);

	public List<User> searchUserByFirstLastMiddleName(String firstName,
			String lastName, String middleName);
}
