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
}
