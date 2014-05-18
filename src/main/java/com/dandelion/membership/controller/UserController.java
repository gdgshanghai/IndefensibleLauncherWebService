package com.dandelion.membership.controller;

import com.dandelion.membership.dao.UrlDao;
import com.dandelion.membership.dao.UserDao;
import com.dandelion.membership.dao.model.UrlCollection;
import com.dandelion.membership.dao.model.User;
import com.dandelion.membership.exception.IndefensibleException;
import com.dandelion.membership.model.bo.IDLApp;
import com.dandelion.membership.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fengxiang on 14-5-18.
 */
@Controller
public class UserController extends BaseController {
    @Autowired
    private UserDao userDao;

    @Autowired
    private UrlDao urlDao;

    @RequestMapping(value = "users", method = RequestMethod.POST)
    public ResponseEntity<User> createUser() throws IndefensibleException, InterruptedException {
        User user = new User();
        return new ResponseEntity<User>(userDao.insertUser(user), HttpStatus.CREATED);
    }

    @RequestMapping(value = "user/{id}/idlapps", method = RequestMethod.GET)
    public ResponseEntity<String> addApps(@PathVariable("id") long id, @RequestParam(value = "j", required = true) String j) throws IndefensibleException, InterruptedException {
        User user = userDao.getUser(id);
        if (user != null) {
            IDLApp[] idlApps = gson.fromJson(j, IDLApp[].class);
            idlApps = updateCollection(idlApps);
            return new ResponseEntity<String>(gson.toJson(idlApps), HttpStatus.OK);
//            IDLApps = IDLAppDao.save(IDLApps);
        }
        else {
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
//        return new ResponseEntity<User>(IDLApps, HttpStatus.CREATED);

    }

    private IDLApp[] updateCollection(IDLApp[] idlApps) throws IndefensibleException {
        for (IDLApp idlApp : idlApps) {
            String url = idlApp.getUrl();
            List<UrlCollection> result = urlDao.selectUrlCollectionByUrl(url);
            List<String> collections = new ArrayList<String>();
            for (UrlCollection urlCollection : result) {
                collections.add(urlCollection.getType());
            }
            idlApp.setCollection(collections);
        }
        return idlApps;
    }
}