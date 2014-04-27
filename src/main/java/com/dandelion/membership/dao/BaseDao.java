package com.dandelion.membership.dao;

import com.dandelion.membership.exception.IndefensibleErrors;
import com.dandelion.membership.exception.IndefensibleException;

import java.util.List;

/**
 * Created by Fengxiang on 2014/4/27 0027.
 */
public class BaseDao {
    protected Object getUniqueRecordFromList(List list) throws IndefensibleException {
        if (list.isEmpty()) {
            return null;
        }else if (list.size() > 1) {
            throw new IndefensibleException(
                    IndefensibleErrors.RECORD_DUPLICATED_CODE,
                    IndefensibleErrors.RECORD_DUPLICATED_MESSAGE);
        }else{
            return list.get(0);
        }
    }
}
