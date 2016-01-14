package com.dancosoft.socialcommunity.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.dancosoft.socialcommunity.service.AccountForumService;

@Controller(value="indexController")
public class IndexController {

	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	@Qualifier(value="accountForumService")
	private AccountForumService accountForumServive;

	public void setAccountForumService(AccountForumService accountForumService) {
		this.accountForumServive = accountForumService;
	}
	
	
	@RequestMapping(value ="/", method = RequestMethod.GET)
	public String getIndexPage() {
		logger.info("IndexController");
		return "/soclacommunity-web/index.html";
	}
	
}
