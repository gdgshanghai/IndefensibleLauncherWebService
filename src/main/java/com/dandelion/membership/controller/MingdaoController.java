package com.dandelion.membership.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import com.dandelion.membership.constant.HackathonConstant;
import com.dandelion.membership.mingdaosdk.Config;

@Controller
@RequestMapping(value = "/api/mingdao")
public class MingdaoController {
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public ResponseEntity<String> loginAnonymous(@RequestParam(value = "j", required = false) String j ,WebRequest request) throws Exception {
		return new ResponseEntity<String>("Hi", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(@RequestParam(value = "j", required = false) String j ,WebRequest request) throws Exception {
		return "redirect:" + Config.getAuthorizeUrl();
	}
	@RequestMapping(value = "/success", method = RequestMethod.GET)
	public String authSuccess(@RequestParam(value = "j", required = false) String j ,WebRequest request, HttpServletResponse httpResponse) throws Exception {
		String code = request.getParameter("code");
		String response = "";
		if ( code != null) {//使用的code方式
			response = Config.getAccessTokenByCode(code);
		}
		JSONObject json =  new JSONObject(response);
		String access_token = json.getString("access_token");
		httpResponse.addCookie(new Cookie(HackathonConstant.COOKIE_ACCESSTOKEN_KEY, access_token));
		return "closetab";
	}
}
