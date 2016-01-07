/**
 * 
 */
package com.dancosoft.socialcommunity.service;

import com.dancosoft.socialcommunity.model.UserPhoto;

/**
 * @author Zaerko_DV
 *
 */
public interface UserPhotoService extends CommonEntityService {

	public UserPhoto getUserPhotoByIdUser(Long idUser); 
	
	public String getPhotoNameByIdUser(Long idUser);
	
	public Boolean savePhotoAsFormat(Long idUser,String format, String path);
	
	public String loadPathToUserPhoto(Long idUser);
}
