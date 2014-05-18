package com.dandelion.membership.model.bo;

import java.util.List;

/**
 * Created by fengxiang on 14-5-11.
 */
public class IDLApp {
    private String title;
    private String url;
    private String initial;
    private String icon;
    private List<String> collections;

    public String getInitial() {
        return initial;
    }

    public void setInitial(String initial) {
        this.initial = initial;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<String> getCollections() {
        return collections;
    }

    public void setCollections(List<String> collections) {
        this.collections = collections;
    }
}
