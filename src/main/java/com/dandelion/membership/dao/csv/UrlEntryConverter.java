package com.dandelion.membership.dao.csv;

import com.dandelion.membership.dao.model.UrlCollection;
import com.googlecode.jcsv.writer.CSVEntryConverter;

/**
 * Created by Fengxiang on 2014/4/27 0027.
 */
public class UrlEntryConverter implements CSVEntryConverter<UrlCollection> {
    @Override
    public String[] convertEntry(UrlCollection urlCollection) {
        String[] columns = new String[2];
        columns[0] = urlCollection.getUrl();
        columns[1] = urlCollection.getType();
        return columns;
    }
}