package com.dandelion.membership.service;

import com.dandelion.membership.dao.UrlDao;
import com.dandelion.membership.model.hackathonmodel.UrlCatalogueResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UrlService {
    public static final String WORK = "work";
    public static final String HOME = "home";
    public static final String NEWS = "news";
    public static final String SOCIAL = "social";
    public static final String FINANCE = "finance";
    public static final String SHOPPING = "shopping";
    @Autowired
    private UrlDao urlDao;

    public UrlCatalogueResponse getCatalogue(List<String> list) {
        Map<String, String> m = urlDao.initUrlCatalogue();

        List<String> work = new ArrayList<String>();
        List<String> home = new ArrayList<String>();
        List<String> news = new ArrayList<String>();
        List<String> social = new ArrayList<String>();
        List<String> finance = new ArrayList<String>();
        List<String> shopping = new ArrayList<String>();

        for (String s : list) {
            if (m.containsKey(s)) {
                String catalogue = m.get(s);
                if (catalogue.equals(WORK)) {
                    work.add(s);
                }
                if (catalogue.equals(HOME)) {
                    home.add(s);
                }
                if (catalogue.equals(NEWS)) {
                    news.add(s);
                }
                if (catalogue.equals(SOCIAL)) {
                    social.add(s);
                }
                if (catalogue.equals(FINANCE)) {
                    finance.add(s);
                }
                if (catalogue.equals(SHOPPING)) {
                    shopping.add(s);
                }
            }
        }
        UrlCatalogueResponse catalogueResponse = new UrlCatalogueResponse();
        catalogueResponse.setFinance(finance);
        catalogueResponse.setHome(home);
        catalogueResponse.setShopping(shopping);
        catalogueResponse.setNews(news);
        catalogueResponse.setSocial(social);
        catalogueResponse.setWork(work);
        return catalogueResponse;
    }

}
