package com.kf5.support.model;

public class ViewCount {

	private int view_id; //分类id
	
	private String url; //对应资源url
	
	private int count; //工单数量

	public int getView_id() {
		return view_id;
	}

	public void setView_id(int view_id) {
		this.view_id = view_id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
}
