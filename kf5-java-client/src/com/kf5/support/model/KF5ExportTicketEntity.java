package com.kf5.support.model;

public class KF5ExportTicketEntity<T> extends KF5PaginationEntity<T> {

	private int startTime;
	
	private int endTime;

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public int getEndTime() {
		return endTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}
	
	
	
}
