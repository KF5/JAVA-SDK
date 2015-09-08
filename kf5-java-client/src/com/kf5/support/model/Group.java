package com.kf5.support.model;

import java.util.ArrayList;
import java.util.List;

public class Group {

	private int id;
	
	private String url;
	
	private String name;
	
	private String created_at;
	
	private List<Agent> listAgents = new ArrayList<Agent>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public List<Agent> getListAgents() {
		return listAgents;
	}

	public void setListAgents(List<Agent> listAgents) {
		this.listAgents = listAgents;
	}
	
}
