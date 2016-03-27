package com.kf5.support.model;

import org.kf5.support.fastjson.JSONObject;

public class MessageStatus {
	
	private int status;
	
	private JSONObject jsonObject;
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public JSONObject getJsonObject() {
		return jsonObject;
	}

	public void setJsonObject(JSONObject jsonObject) {
		this.jsonObject = jsonObject;
	}

}
