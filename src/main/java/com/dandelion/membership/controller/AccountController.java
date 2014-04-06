package com.dandelion.membership.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
@RequestMapping(value = "account")
public class AccountController extends BaseController {

    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";
    public static final String ADMIN = "admin";

    @RequestMapping(value = LOGIN)
    public String login(WebRequest request) {
        String email = request.getParameter(EMAIL);
        String password = request.getParameter(PASSWORD);
        if (ADMIN.equals(email) && ADMIN.equals(password)) {
            return TRUE;
        }
        return FALSE;
    }
}
