package com.dandelion.membership.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;
@Repository
public class UrlDao {
	public Map<String, String> initUrlCatalogue() {
		Map<String, String> map = new HashMap<String, String>();
		//work
		map.put("mingdao.com", "work");
		map.put("drive.google.com", "work");
		map.put("github.com", "work");
		map.put("stackoverflow.com", "work");
		map.put("mail.google.com", "work");
		map.put("google.com", "work");
		//home
		map.put("youku.com", "home");
		map.put("yyets.com", "home");
		map.put("bilibili.tv", "home");
		map.put("bilibili.kankanews.com", "home");
		map.put("taobao.com", "home");
		map.put("mojichina.com", "home");
		//news
		map.put("sina.com.cn", "news");
		map.put("news.163.com", "news");
		map.put("news.qq.com", "news");
		map.put("36kr.com", "news");
		map.put("engadget.com", "news");
		map.put("news.dbanotes.net", "news");
		map.put("pingwest.com", "news");
		//social
		map.put("wx.qq.com", "social");
		map.put("facebook.com", "social");
		map.put("twitter.com", "social");
		map.put("weibo.com", "social");
		map.put("renren.com", "social");
		map.put("plus.google.com", "social");
		map.put("zhihu.com", "social");
		map.put("accounts.google.com", "social");
		//finance
		map.put("icbc.com.cn", "finance");
		map.put("boc.cn", "finance");
		map.put("alipay.com", "finance");
		map.put("wallet.google.com", "finance");
		//shopping
		map.put("jd.com", "shopping");
		map.put("yhd.com", "shopping");
		map.put("tmall.com", "shopping");
		return map;
	}
}
