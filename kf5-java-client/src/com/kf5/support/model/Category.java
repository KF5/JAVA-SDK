package com.kf5.support.model;

public class Category {

	private int id; //文档分区id，由系统自动分配
	
	private String url; //资源url
	
	private String title; //文档分区名称
	
	private String content; //文档分区描述
	
	private int display_limit; //该分区在前台显示的每个分类的下的文档数量
	
	private int sort; //文档分区前台显示顺序

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getDisplay_limit() {
		return display_limit;
	}

	public void setDisplay_limit(int display_limit) {
		this.display_limit = display_limit;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}
	
	
	
}
