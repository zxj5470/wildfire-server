package com.hustunique.hack.wildfire.util;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.*;
import com.hustunique.hack.wildfire.model.ServerResponse;

import java.io.IOException;

public class Helper {
	private static final GsonBuilder builder = new GsonBuilder().setDateFormat("yyyy/MM/dd HH:mm:ss");
	private static final Gson gson = builder.create();
	private static Gson nullGson = builder.registerTypeAdapter(String.class, new TypeAdapter<String>() {
		@Override
		public void write(JsonWriter out, String value) throws IOException {
			if (value == null) {
				// out.nullValue();
				out.value(""); // 序列化时将 null 转为 ""
			} else {
				out.value(value);
			}
		}

		@Override
		public String read(JsonReader in) throws IOException {
			if (in.peek() == JsonToken.NULL) {
				in.nextNull();
				return null;
			}
			// return in.nextString();
			String str = in.nextString();
			if (str.equals("")) { // 反序列化时将 "" 转为 null
				return null;
			} else {
				return str;
			}
		}

	}).create();

	public static final JsonParser jsonParser = new JsonParser();

	/**
	 * @param bean 传入null表示出现失败的情况
	 */
	public static String returnResult(Object bean) {
		return getString(bean, gson);
	}

	public static String returnResultWithNull(Object bean) {
		return getString(bean, nullGson);
	}

	private static String getString(Object bean, Gson nullGson) {
		ServerResponse ret = new ServerResponse();
		if (bean == null) {
			ret.setStatus(400);
			ret.setResults(null);
		} else {
			ret.setStatus(0);
			ret.setResults(bean);
		}
		return nullGson.toJson(ret);
	}

	public static String returnFailed(String message) {
		return getString(message, gson);
	}

	public static String returnFailedWithNull(String message) {
		return getString(message, nullGson);
	}

	private static String getString(String message, Gson nullGson) {
		ServerResponse ret = new ServerResponse();
		ret.setStatus(400);
		ret.setMessage(message);
		ret.setResults(null);
		return nullGson.toJson(ret);
	}
}
