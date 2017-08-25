package com.kf5.support.model;

public class AgentStatistics {

	private String role;
	private int agent_id;
	private int max_serve;
	private long created;
	private String name;
	private String photo;
	private String display_name;
	private String appStatus;
	private String webStatus;
	private String email;
	private int enabled;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getAgent_id() {
		return agent_id;
	}

	public void setAgent_id(int agent_id) {
		this.agent_id = agent_id;
	}

	public int getMax_serve() {
		return max_serve;
	}

	public void setMax_serve(int max_serve) {
		this.max_serve = max_serve;
	}

	public long getCreated() {
		return created;
	}

	public void setCreated(long created) {
		this.created = created;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getDisplay_name() {
		return display_name;
	}

	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}

	public String getAppStatus() {
		return appStatus;
	}

	public void setAppStatus(String appStatus) {
		this.appStatus = appStatus;
	}

	public String getWebStatus() {
		return webStatus;
	}

	public void setWebStatus(String webStatus) {
		this.webStatus = webStatus;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

}
