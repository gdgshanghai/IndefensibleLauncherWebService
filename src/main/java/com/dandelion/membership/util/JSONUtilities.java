package com.dandelion.membership.util;

import com.dandelion.membership.exception.IndefensibleException;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONUtilities {
	public static JSONObject getErrorJSON(IndefensibleException ex) {
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
