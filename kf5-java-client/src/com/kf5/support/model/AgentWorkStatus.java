package com.kf5.support.model;

public class AgentWorkStatus {

	private int averageResponseTime;
	private int serveCount;
	private int ratingNum;
	private float averageServeTime;
	private int chatNum;
	private String agent_id;
	private int messageNum;
	private int satisfaction;
	private int ratingRate;

	public int getAverageResponseTime() {
		return averageResponseTime;
	}

	public void setAverageResponseTime(int averageResponseTime) {
		this.averageResponseTime = averageResponseTime;
	}

	public int getServeCount() {
		return serveCount;
	}

	public void setServeCount(int serveCount) {
		this.serveCount = serveCount;
	}

	public int getRatingNum() {
		return ratingNum;
	}

	public void setRatingNum(int ratingNum) {
		this.ratingNum = ratingNum;
	}

	public float getAverageServeTime() {
		return averageServeTime;
	}

	public void setAverageServeTime(float averageServeTime) {
		this.averageServeTime = averageServeTime;
	}

	public int getChatNum() {
		return chatNum;
	}

	public void setChatNum(int chatNum) {
		this.chatNum = chatNum;
	}

	public String getAgent_id() {
		return agent_id;
	}

	public void setAgent_id(String agent_id) {
		this.agent_id = agent_id;
	}

	public int getMessageNum() {
		return messageNum;
	}

	public void setMessageNum(int messageNum) {
		this.messageNum = messageNum;
	}

	public int getSatisfaction() {
		return satisfaction;
	}

	public void setSatisfaction(int satisfaction) {
		this.satisfaction = satisfaction;
	}

	public int getRatingRate() {
		return ratingRate;
	}

	public void setRatingRate(int ratingRate) {
		this.ratingRate = ratingRate;
	}

}
