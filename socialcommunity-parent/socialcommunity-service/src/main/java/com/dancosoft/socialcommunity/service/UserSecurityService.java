/**
 * 
 */
package com.dancosoft.socialcommunity.service;

import java.util.List;

import com.dancosoft.socialcommunity.model.User;
import com.dancosoft.socialcommunity.model.UserSecurity;

/**
 * @author Zaerko_DV
 *
 */
public interface UserSecurityService extends CommonEntityService {

	public User getUserByLoginPassword(String userLogin, String userPassword);

	public Long getIdUserByLoginPassword(String userLogin, String userPassword);

	public Boolean signInUserByLoginPassword(String userLogin,
			String userPassword);

	public Boolean isUniqueLogin(String userLogin);

	public Boolean isUniquePassword(String userPassword);

	public String getUserRoleByIdUser(Long idUser);

	public List<User> getListUserWithUserRole();

	public List<User> getListUserWithAdminRole();

	public Boolean updateLoginPasswordByIdUser(Long idUser);

	public UserSecurity getLoginPasswordByIdUser(Long idUser);
}
