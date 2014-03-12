package com.dandelion.membership.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dandelion.membership.dao.UrlDao;
import com.dandelion.membership.hackathonmodel.UrlCatalogueResponse;

@Service
public class UrlService {
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
				if (catalogue.equals("work")) {
					work.add(s);
				}
				if (catalogue.equals("home")) {
					home.add(s);
				}
				if (catalogue.equals("news")) {
					news.add(s);
				}
				if (catalogue.equals("social")) {
					social.add(s);
				}
				if (catalogue.equals("finance")) {
					finance.add(s);
				}
				if (catalogue.equals("shopping")) {
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
