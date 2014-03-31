package com.dandelion.membership.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import com.dandelion.membership.hackathonmodel.UrlCatalogueRequest;
import com.dandelion.membership.hackathonmodel.UrlCatalogueResponse;
import com.dandelion.membership.service.UrlService;
import com.google.gson.Gson;

@Controller
@RequestMapping(value = "/api/url")
public class UrlController {
	
	@Autowired
	private UrlService urlService;
	@RequestMapping(value = "/catalogue", method = RequestMethod.GET)
	public ResponseEntity<UrlCatalogueResponse> getCatalogue(@RequestParam(value = "j", required = false) String j ,
                                                             WebRequest webRequest) throws Exception {
		String urlList = webRequest.getParameter("urlList");
		Gson gson = new Gson();
		UrlCatalogueRequest catalogueRequest = gson.fromJson(urlList, UrlCatalogueRequest.class);
		List<String> list = catalogueRequest.getUrlList();
		UrlCatalogueResponse result = urlService.getCatalogue(list);
		return new ResponseEntity<UrlCatalogueResponse>(result, HttpStatus.OK);
	}
}
