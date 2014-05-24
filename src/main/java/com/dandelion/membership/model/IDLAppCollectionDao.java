package com.dandelion.membership.model;

import com.dandelion.membership.dao.data.IDLAppCollectionMapper;
import com.dandelion.membership.dao.model.IDLAppCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by fengxiang on 14-5-18.
 */
@Repository
public class IDLAppCollectionDao {
    @Autowired
    private IDLAppCollectionMapper idlAppCollectionMapper;

    private void insert(IDLAppCollection idlAppCollection) {
        idlAppCollectionMapper.insertSelective(idlAppCollection);
    }
}
