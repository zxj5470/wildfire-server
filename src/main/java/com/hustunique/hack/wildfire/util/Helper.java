package com.hustunique.hack.wildfire.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hustunique.hack.wildfire.model.ServerResponse;

public class Helper {
	private static final Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

	public static String returnResult(Object bean) {
		ServerResponse ret = new ServerResponse();
		if (bean == null) {
			ret.setStatus(400);
			ret.setResult(null);
		} else {
			ret.setStatus(0);
			ret.setResult(bean);
		}
		return gson.toJson(ret);
	}
}
