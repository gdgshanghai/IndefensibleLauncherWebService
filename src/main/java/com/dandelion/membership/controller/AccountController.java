package com.dandelion.membership.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
@RequestMapping(value = "account")
public class AccountController extends BaseController {
    @RequestMapping(value = "login")
    public String login(WebRequest request) {
        logger.info("login");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if ("admin".equals(email) && "admin".equals(password)) {
            return TRUE;
        }
        return FALSE;
    }

}
