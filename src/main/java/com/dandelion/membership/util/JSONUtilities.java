package com.dandelion.membership.util;

import org.json.JSONException;
import org.json.JSONObject;

import com.dandelion.membership.exception.MembershipException;

public class JSONUtilities {
	public static JSONObject getErrorJSON(MembershipException ex) {
		try {
			JSONObject json = new JSONObject();
			json.put("errorCode", ex.getErrorCode());
			json.put("errorMessage", ex.getMessage());
			return json;
		} catch (JSONException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
