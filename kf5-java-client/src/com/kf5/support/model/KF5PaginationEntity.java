package com.kf5.support.model;

public class KF5PaginationEntity<T> extends KF5Entity<T> {

	private int count ;
	
	private String nextPage;
	
	private String previousPage;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getNextPage() {
		return nextPage;
	}

	public void setNextPage(String nextPage) {
		this.nextPage = nextPage;
	}

	public String getPreviousPage() {
		return previousPage;
	}

	public void setPreviousPage(String previousPage) {
		this.previousPage = previousPage;
	}
	
}
