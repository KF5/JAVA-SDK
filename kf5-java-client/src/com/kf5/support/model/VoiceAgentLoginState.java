package com.kf5.support.model;

public class VoiceAgentLoginState {

	private String agent_id;// 语音账号ID
	private String created;// 创建时间
	private int type;// 0：离线 ，1：在线，2：忙碌，3：小休

	public String getAgent_id() {
		return agent_id;
	}

	public void setAgent_id(String agent_id) {
		this.agent_id = agent_id;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

}
