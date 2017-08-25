package com.kf5.support.model;

public class AgentConversation {

	private int serveCount;
	private int sumResponseTime;
	private int chatNum;
	private int messageNum;
	private int sumServeTime;
	private long timestamp;

	public int getServeCount() {
		return serveCount;
	}

	public void setServeCount(int serveCount) {
		this.serveCount = serveCount;
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

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

}
