/**
 * 
 */
package com.dancosoft.socialcommunity.service;

import java.util.List;

import com.dancosoft.socialcommunity.model.UserSocialNetwork;

/**
 * @author Zaerko_DV
 *
 */
public interface UserSocialNetworkService extends CommonEntityService {

	public List<UserSocialNetwork> getListSocialNetworkWithStatusByIdUser(Long idUser,String viewStatus);
	public Boolean isUniqueSkype(String skypeAddress);
	public Boolean isUniqualFaceBook(String facebookAddress);
	public Long getIdUserByFacebookAddress(String facebookAddress);	
}
