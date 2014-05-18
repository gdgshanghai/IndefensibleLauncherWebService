package com.dandelion.membership.controller;

import com.dandelion.membership.dao.UserDao;
import com.dandelion.membership.dao.model.User;
import com.dandelion.membership.exception.IndefensibleException;
import com.dandelion.membership.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by fengxiang on 14-5-18.
 */
@Controller
public class UserController extends BaseController {
    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "users", method = RequestMethod.POST)
    public ResponseEntity<User> createUser() throws IndefensibleException, InterruptedException {
        User user = new User();
        return new ResponseEntity<User>(userDao.insertUser(user), HttpStatus.CREATED);
    }

}