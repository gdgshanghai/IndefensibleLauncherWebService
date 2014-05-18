package com.dandelion.membership.model.hackathonmodel;

import com.dandelion.membership.model.bo.IDLApp;

import java.util.List;

/**
 * Created by fengxiang on 14-5-11.
 */
public class IDLAppRequestPO {
    private List<IDLApp> urlList;

    public List<IDLApp> getUrlList() {
        return urlList;
    }

    public void setUrlList(List<IDLApp> urlList) {
        this.urlList = urlList;
    }
}
