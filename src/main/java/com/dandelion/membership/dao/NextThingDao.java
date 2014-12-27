package com.dandelion.membership.dao;

import com.dandelion.membership.dao.data.ThingMapper;
import com.dandelion.membership.dao.model.Thing;
import com.dandelion.membership.dao.model.ThingExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by Shaman on 12/27/14.
 */
@Repository
public class NextThingDao {
    @Autowired
    private ThingMapper mapper;

    public void insertThing(Thing record) {
        Date date = new Date();
        record.setCreateTime(date);
        record.setModifyTime(date);
        mapper.insertSelective(record);
    }

    public List<Thing> selectThing() {
        ThingExample example = new ThingExample();
        example.createCriteria();
        example.setOrderByClause("vote DESC");
        return mapper.selectByExample(example);
    }

}
