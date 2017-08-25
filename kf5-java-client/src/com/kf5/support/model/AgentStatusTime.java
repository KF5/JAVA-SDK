package com.kf5.support.model;

public class AgentStatusTime {

	private int agent_id;
	private float onlineAverage;
	private float busyAverage;
	private float onlineTotal;
	private float busyTotal;

	public int getAgent_id() {
		return agent_id;
	}

	public void setAgent_id(int agent_id) {
		this.agent_id = agent_id;
	}

	public float getOnlineAverage() {
		return onlineAverage;
	}

	public void setOnlineAverage(float onlineAverage) {
		this.onlineAverage = onlineAverage;
	}


	public float getBusyAverage() {
		return busyAverage;
	}

	public void setBusyAverage(float busyAverage) {
		this.busyAverage = busyAverage;
	}

	public float getOnlineTotal() {
		return onlineTotal;
	}

	public void setOnlineTotal(float onlineTotal) {
		this.onlineTotal = onlineTotal;
	}

	public float getBusyTotal() {
		return busyTotal;
	}

	public void setBusyTotal(float busyTotal) {
		this.busyTotal = busyTotal;
	}

}
