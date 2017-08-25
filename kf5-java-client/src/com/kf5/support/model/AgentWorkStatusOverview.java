package com.kf5.support.model;

public class AgentWorkStatusOverview {

	private int serveCount;
	private int ratingNum;
	private int chatNum;
	private int messageNum;
	private int satisfaction;
	private float ratingRate;

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

	public int getSatisfaction() {
		return satisfaction;
	}

	public void setSatisfaction(int satisfaction) {
		this.satisfaction = satisfaction;
	}

	public float getRatingRate() {
		return ratingRate;
	}

	public void setRatingRate(float ratingRate) {
		this.ratingRate = ratingRate;
	}
}
