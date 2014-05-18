package com.dandelion.membership.service;

import com.dandelion.membership.dao.UserDao;
import com.dandelion.membership.dao.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by fengxiang on 14-5-18.
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public User registerUser() {
        User user = new User();

        user = userDao.insertUser(user);
        return user;
    }
}
