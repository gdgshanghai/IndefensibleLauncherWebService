package com.dandelion.membership.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
@RequestMapping(value="Account")
public class AccountController {
private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "Login")
	public String login(Locale locale, Model model, WebRequest request) {
		logger.info("Welcome home! The client locale is {}.", locale);
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		
		if("admin".equals(email)&&"admin".equals(password)){
			return "dashboard";
		}
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		
		return "";
	}
	
}
