/**
 * 
 */
package com.dancosoft.socialcommunity.service;

import java.util.List;

import com.dancosoft.socialcommunity.model.User;

/**
 * @author Zaerko_DV
 *
 */
public interface UserRoleService extends CommonEntityService {

	public List<User> getListUserByRole(String userRoleName);
	
	public int getCountUserByRole(String userRoleName);
}
