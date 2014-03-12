package com.dandelion.membership.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.dandelion.membership.dao.model.Applicant;
import com.dandelion.membership.dao.model.ApplicantForm;
import com.dandelion.membership.service.MemberService;

@Controller
@RequestMapping(value="Member")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	private static List<Applicant> applicants = new ArrayList<Applicant>();
	@Autowired
	private MemberService memberService;
	@RequestMapping(value = "Select")
	public ModelAndView selectApplicant(Locale locale, Model model, WebRequest request) {
		applicants = memberService.selectMember();
		ApplicantForm applicantForm = new ApplicantForm();
		applicantForm.setApplicants(applicants);
	    return new ModelAndView("member", "applicantForm", applicantForm);
	}
	
}
