package com.kf5.support.model;

public class AgentStatus {

	private int serveCount;
	private int averageResponseTime;
	private float averageServeTime;
	private int agentId;
	private int chatNum;
	private int messageNum;
	private int maxServe;
	private String agentName;
	private String agentStatus;
	private int enabled;

	public int getServeCount() {
		return serveCount;
	}

	public void setServeCount(int serveCount) {
		this.serveCount = serveCount;
	}

	public int getAverageResponseTime() {
		return averageResponseTime;
	}

	public void setAverageResponseTime(int averageResponseTime) {
		this.averageResponseTime = averageResponseTime;
	}

	public float getAverageServeTime() {
		return averageServeTime;
	}

	public void setAverageServeTime(float averageServeTime) {
		this.averageServeTime = averageServeTime;
	}

	public int getAgentId() {
		return agentId;
	}

	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}

	public int getChatNum() {
		return chatNum;
	}

	public void setChatNum(int chatNum) {
		this.chatNum = chatNum;
	}

	public int getMessageNum() {
		return messageNum;
	}

	public void setMessageNum(int messageNum) {
		this.messageNum = messageNum;
	}

	public int getMaxServe() {
		return maxServe;
	}

	public void setMaxServe(int maxServe) {
		this.maxServe = maxServe;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public String getAgentStatus() {
		return agentStatus;
	}

	public void setAgentStatus(String agentStatus) {
		this.agentStatus = agentStatus;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

}
