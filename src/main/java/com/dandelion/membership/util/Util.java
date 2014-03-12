package com.dandelion.membership.util;

public class Util {
	public static boolean isEmpty(String str) {
		if (str == null || "".equals(str)) {
			return true;
		} else {
			return false;
		}
	}
}
