package com.dandelion.membership.controller;

import com.dandelion.membership.dao.model.Thing;
import com.dandelion.membership.service.NextThingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by Shaman on 12/26/14.
 */
@Controller
public class NextThingController extends BaseController {
    @Autowired
    private NextThingService nextThingService;
    @RequestMapping(value = "/thing", method = RequestMethod.POST)
    public ResponseEntity<Thing> addNextThing (
            @RequestParam(value = "j", required = true) String j)  {
        Thing request = gson.fromJson(j, Thing.class);
        nextThingService.create(request);
        return new ResponseEntity<Thing>(HttpStatus.OK);
    }

    @RequestMapping(value = "/thing", method = RequestMethod.GET)
    public ResponseEntity<List<Thing>> getThing ()  {
        List<Thing> list = nextThingService.select();
        return new ResponseEntity<List<Thing>>(list, HttpStatus.OK);
    }

}
