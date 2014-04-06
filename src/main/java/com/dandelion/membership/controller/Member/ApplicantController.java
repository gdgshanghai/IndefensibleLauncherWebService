package com.dandelion.membership.controller.Member;

import com.dandelion.membership.dao.model.Applicant;
import com.dandelion.membership.service.ApplicantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Controller
@RequestMapping(value = "Applicant")
public class ApplicantController {
    private static final Logger logger = LoggerFactory.getLogger(ApplicantController.class);

    @Autowired
    private ApplicantService applicantService;

    @RequestMapping(value = "Apply", method = RequestMethod.GET)
    public String apply(Locale locale, Model model) {
        logger.info("Welcome home! The client locale is {}.", locale);

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        String formattedDate = dateFormat.format(date);

        model.addAttribute("serverTime", formattedDate);

        return "apply";
    }

    @RequestMapping(value = "Submit", method = RequestMethod.POST)
    public String ApplicantSubmit(Locale locale, Model model, WebRequest request) throws ParseException {
        logger.info("submit", "submit");
        String applicantName = request.getParameter("applicantName");
        String applicantEmail = request.getParameter("applicantEmail");
        String applyDate = request.getParameter("applyDate");
        String referrerName = request.getParameter("referrerName");
        String creditCardNumber = request.getParameter("creditCardNumber");
        String memberType = request.getParameter("memberType");


        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse(applyDate);

        Applicant applicant = new Applicant();
        applicant.setApplicantname(applicantName);
        applicant.setApplicantemail(applicantEmail);
        applicant.setApplydate(date);
        applicant.setReferrername(referrerName);
        applicant.setCreditcardnumber(creditCardNumber);
        applicant.setMembertype(memberType);

        boolean result = applicantService.ApplicantSubmit(applicant);
        if (!result) {
            return "error";
        }

        return "home";
    }

}
