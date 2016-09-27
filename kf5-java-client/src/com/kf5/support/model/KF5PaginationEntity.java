package com.kf5.support.model;

public class KF5PaginationEntity<T> extends KF5Entity<T> {

	private int count ;
	
	private int nextPage;
	
	private int previousPage;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public int getPreviousPage() {
		return previousPage;
	}

	public void setPreviousPage(int previousPage) {
		this.previousPage = previousPage;
	}
	
	
	
	
}
