/**
 * 
 */
package com.dancosoft.socialcommunity.service;

import java.util.List;

import com.dancosoft.socialcommunity.model.UserEmail;

/**
 * @author Zaerko_DV
 *
 */
public interface UserEmailService extends CommonEntityService {

	public List<UserEmail> getListEmailWithStatusByIdUser(Long idUser,String viewStatus);
	
	public List<UserEmail> getListEmailByIdUser(Long idUser);
	
	public Boolean isUniqueEmail(String userEmail);

	public Long getIdUserByEmail(String userEmail);
}
