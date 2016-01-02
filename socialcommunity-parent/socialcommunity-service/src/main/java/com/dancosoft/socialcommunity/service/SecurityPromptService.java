/**
 * 
 */
package com.dancosoft.socialcommunity.service;

import com.dancosoft.socialcommunity.model.SecurityPrompt;

/**
 * @author Zaerko_DV
 *
 */
public interface SecurityPromptService extends CommonEntityService {

	public SecurityPrompt getSecurityPromptByIdUser(Long idUser);

	public SecurityPrompt getSecurityPromptByLogin(String userLogin);

	public Boolean signInUserByPromptAnswer(Long idSecurityPrompt,
			String userAnswer);

	public Long getIdUserByPromptAnswer(Long idSecurityPrompt, String userAnswer);

	public Boolean isUniquePrompt(String securityPrompt, String userAnswer);
}
