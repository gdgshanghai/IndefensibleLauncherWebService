package com.dandelion.membership.mingdaosdk;

public class Config {

	public static final String AUTHURL = "https://api.mingdao.com/oauth2/authorize?";
	public static final String ACCEURL = "https://api.mingdao.com/oauth2/access_token?";

	public static final String APPKEY = "6B9EEB4FDEA65D67BF623A6386C465D";// 需要换成您的应用的appkey
	public static final String APPSECRET = "70EB2704C158CDB1423CAB387FD7FBF";// 需要换成您的应用的appSecret
	public static final String RESPONSE_TYPE = "token";// token或者code
	public static final String REDIRECT_URI = "http://shaman.incstage.com:8080/indefensible-launcher/api/mingdao/success";// 需要换成您的应用设置的回调地址

	public static String getAuthorizeUrl() {
		String url = AUTHURL + "app_key=" + APPKEY + "&redirect_uri="
				+ REDIRECT_URI + "&response_type=" + RESPONSE_TYPE;
		return url;
	}

	public static String getAccessTokenUrl(String code) {
		String url = ACCEURL + "app_key=" + APPKEY + "&app_secret=" + APPSECRET
				+ "&grant_type=authorization_code" + "&format=json"
				+ "&redirect_uri=" + REDIRECT_URI + "&code=" + code;
		return url;
	}

	public static String getAccessTokenByCode(String code) {
		String url = getAccessTokenUrl(code);
		String result = HttpUtil.httpByGet2StringSSL(url, null, null);
		return result;
	}
}
