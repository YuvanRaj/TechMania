package com.tech.util;

import com.google.gson.Gson;

public class JsonUtil<T> {
	public String convertObjectToJson(T t) {
		String json = new Gson().toJson(t);
		return json;
	}

}
