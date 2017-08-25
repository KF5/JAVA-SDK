package com.kf5.support.model;

import org.kf5.support.fastjson.JSONArray;

public class IMGroup {

	/**
	 * "name": "测试专用组，勿删", "id": "1007534", "agents": ["17459907", "22291245",
	 * "22799236"]
	 */

	private String name;
	private String id;
	private JSONArray agents;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public JSONArray getAgents() {
		return agents;
	}

	public void setAgents(JSONArray agents) {
		this.agents = agents;
	}

}
