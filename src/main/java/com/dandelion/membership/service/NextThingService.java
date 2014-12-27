package com.dandelion.membership.service;

import com.dandelion.membership.dao.NextThingDao;
import com.dandelion.membership.dao.model.Thing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Shaman on 12/27/14.
 */
@Service
public class NextThingService {

    @Autowired
    private NextThingDao nextThingDao;
    public void create(Thing thing) {
        nextThingDao.insertThing(thing);
    }
    public List<Thing> select() {
        List<Thing> list = nextThingDao.selectThing();
        return list;
    }
}
