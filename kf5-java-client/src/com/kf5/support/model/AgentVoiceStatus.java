package com.kf5.support.model;

public class AgentVoiceStatus {

	/**
	 * "agent_id": "1000992", "agent_name": "aa", "user_id": "22291245",
	 * "status_updated": "1503492826", "type": "phone", "status": "0"
	 */

	private String agent_id;// 客服UID
	private String agent_name;// 客服名称
	private String user_id;// 用户UID
	private String status_updated;// 最近一次状态更新时间
	private String type;// phone：手机/落地号码上班，client：客户端上班
	private String status;// 离线 0，在线 1，忙碌 2，小休 3
	private String number;// 上班号码
	private String call_status;// 未通话 0，通话中 1

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCall_status() {
		return call_status;
	}

	public void setCall_status(String call_status) {
		this.call_status = call_status;
	}

	public String getAgent_id() {
		return agent_id;
	}

	public void setAgent_id(String agent_id) {
		this.agent_id = agent_id;
	}

	public String getAgent_name() {
		return agent_name;
	}

	public void setAgent_name(String agent_name) {
		this.agent_name = agent_name;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getStatus_updated() {
		return status_updated;
	}

	public void setStatus_updated(String status_updated) {
		this.status_updated = status_updated;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
