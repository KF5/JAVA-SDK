package com.kf5.support.model;

public class AgentConversationOverview {

	private int serveCount;
	private int averageResponseTime;
	private int averageServeTime;
	private int sumResponseTime;
	private int chatNum;
	private int messageNum;
	private int sumServeTime;

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

	public int getAverageServeTime() {
		return averageServeTime;
	}

	public void setAverageServeTime(int averageServeTime) {
		this.averageServeTime = averageServeTime;
	}

	public int getSumResponseTime() {
		return sumResponseTime;
	}

	public void setSumResponseTime(int sumResponseTime) {
		this.sumResponseTime = sumResponseTime;
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

	public int getSumServeTime() {
		return sumServeTime;
	}

	public void setSumServeTime(int sumServeTime) {
		this.sumServeTime = sumServeTime;
	}
}
