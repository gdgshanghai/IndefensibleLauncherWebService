package com.dandelion.membership.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import com.dandelion.membership.exception.MembershipException;
import com.dandelion.membership.service.FieldService;

@Controller
@RequestMapping(value="Field")
public class FieldController {
private static final Logger logger = LoggerFactory.getLogger(FieldController.class);
	
	@Autowired
	private FieldService fieldService;	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "Show", method = RequestMethod.GET)
	public String show() {
		return "field";
	}
	
	@RequestMapping(value = "Submit", method = RequestMethod.POST)
	public String reservationSubmit(WebRequest request) throws ParseException, MembershipException {
		Long fieldId = Long.valueOf(request.getParameter("fieldId"));
		String cleaningtime = request.getParameter("cleaningtime");
		String[] strings = cleaningtime.split("-");
		strings[0].trim();
		strings[1].trim();
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		Date startDate = format.parse(strings[0]);
		Date startEnd = format.parse(strings[1]);
		boolean b = fieldService.fieldSubmit(fieldId, startDate, startEnd);
		if (!b) {
			return "error";
		}
		return "home";
	}
	
	
	@RequestMapping(value = "Insert", method = RequestMethod.GET)
	public String insert() throws ParseException, MembershipException {
		fieldService.insert();
		return "home";
	}
}
