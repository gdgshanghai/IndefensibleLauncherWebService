package com.dandelion.membership.dao;

import com.dandelion.membership.dao.data.UserMapper;
import com.dandelion.membership.dao.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * Created by fengxiang on 14-5-18.
 */
@Repository
public class UserDao {

    @Autowired
    private UserMapper userMapper;

    public User insertUser(User user) {
        Date date = new Date();
        user.setCreateddate(date);
        user.setModifieddate(date);
        userMapper.insertSelective(user);
        return user;
    }

    public User getUser(long id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
