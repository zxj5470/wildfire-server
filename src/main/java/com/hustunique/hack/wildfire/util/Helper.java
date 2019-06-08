package com.hustunique.hack.wildfire.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hustunique.hack.wildfire.model.ServerResponse;

public class Helper {
	private static final Gson gson = new GsonBuilder().setDateFormat("yyyy/MM/dd HH:mm:ss").create();

	/**
	 *
	 * @param bean 传入null表示出现失败的情况
	 * @return
	 */
	public static String returnResult(Object bean) {
		ServerResponse ret = new ServerResponse();
		if (bean == null) {
			ret.setStatus(400);
			ret.setResults(null);
		} else {
			ret.setStatus(0);
			ret.setResults(bean);
		}
		return gson.toJson(ret);
	}
}
