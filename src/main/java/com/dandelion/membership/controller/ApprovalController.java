package com.dandelion.membership.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.dandelion.membership.dao.model.Applicant;
import com.dandelion.membership.dao.model.ApplicantForm;
import com.dandelion.membership.service.ApprovalService;

@Controller
@RequestMapping(value="Approval")
public class ApprovalController {
	private static final Logger logger = LoggerFactory.getLogger(ApprovalController.class);
	private static List<Applicant> applicants = new ArrayList<Applicant>();
	@Autowired
	private ApprovalService approvalService;

	@RequestMapping(value = "Select")
	public ModelAndView selectApplicant(Locale locale, Model model, WebRequest request) {
		applicants = approvalService.selectApplicant();
		logger.info(String.valueOf(applicants.size()));
		ApplicantForm applicantForm = new ApplicantForm();
		applicantForm.setApplicants(applicants);
	    return new ModelAndView("approval", "applicantForm", applicantForm);
	}
	
	
	@RequestMapping(value = "Save")
	public ModelAndView approval(@ModelAttribute("applicantForm") ApplicantForm applicantForm) {
		if(applicantForm == null) {
			logger.info("NULL");
			return new ModelAndView("approval");
		}
		List<Applicant> applicants = applicantForm.getApplicants();
		ApprovalController.applicants = applicants;
		if(null != applicants && applicants.size() > 0) {
			approvalService.approval(applicants);
		}
		
	    return new ModelAndView("approval");
	}
	
}
