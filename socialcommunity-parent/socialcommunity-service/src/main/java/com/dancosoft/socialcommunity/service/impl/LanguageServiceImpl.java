/**
 * 
 */
package com.dancosoft.socialcommunity.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.dancosoft.socialcommunity.dao.LanguageDAO;
import com.dancosoft.socialcommunity.service.LanguageService;

/**
 * @author Zaerko_DV
 *
 */
@Service(value="languageService")
public class LanguageServiceImpl extends CommonEntityServiceImpl implements LanguageService {

	@Autowired
	@Qualifier(value="languageDAO")
	private LanguageDAO languageDAO;

	public void setLanguageDAO(LanguageDAO languageDAO) {
		this.languageDAO = languageDAO;
	}
}
