package com.dandelion.membership.model.hackathonmodel;

import com.dandelion.membership.model.bo.IDLApp;

import java.util.List;

public class UrlCatalogueResponse {
//    private List<String> work;
//    private List<String> home;
//    private List<String> news;
//    private List<String> social;
//    private List<String> finance;
//    private List<String> shopping;

    private List<IDLApp> urlList;

    public List<IDLApp> getUrlList() {
        return urlList;
    }

    public void setUrlList(List<IDLApp> urlList) {
        this.urlList = urlList;
    }
}
