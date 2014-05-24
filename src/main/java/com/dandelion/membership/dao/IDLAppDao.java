package com.dandelion.membership.dao;

import com.dandelion.membership.dao.data.IDLAppMapper;
import com.dandelion.membership.dao.model.IDLApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by fengxiang on 14-5-18.
 */
@Repository
public class IDLAppDao {
    @Autowired
    private IDLAppMapper idlAppMapper;

    public IDLApp insert(IDLApp idlApp) {
        idlAppMapper.insertSelective(idlApp);
        return idlApp;
    }

    public IDLApp[] insert(IDLApp[] idlApps) {
        for (IDLApp idlApp : idlApps) {
            idlApp.setId(insert(idlApp).getId());
        }
        return idlApps;
    }
}
