package com.dandelion.membership.model.hackathonmodel;

import com.dandelion.membership.model.bo.IDLAppp;

import java.util.List;

public class UrlCatalogueResponse {
//    private List<String> work;
//    private List<String> home;
//    private List<String> news;
//    private List<String> social;
//    private List<String> finance;
//    private List<String> shopping;

    private List<IDLAppp> urlList;

    public List<IDLAppp> getUrlList() {
        return urlList;
    }

    public void setUrlList(List<IDLAppp> urlList) {
        this.urlList = urlList;
    }
}
