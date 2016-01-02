/**
 * 
 */
package com.dancosoft.socialcommunity.service;

import java.util.List;

import com.dancosoft.socialcommunity.model.User;
import com.dancosoft.socialcommunity.model.UserAutobiography;

/**
 * @author Zaerko_DV
 *
 */
public interface UserAutobiographyService extends CommonEntityService {

	public UserAutobiography getUserAutobiographyByIdUser(Long idUser);
	
	public List<User> getListUserByHobby(String hobby);
	
	public Boolean isUserAdult(Long idUser,Long yearAdult);
	
	public List<User> getListAdultUser(Long yearAdult);
}
