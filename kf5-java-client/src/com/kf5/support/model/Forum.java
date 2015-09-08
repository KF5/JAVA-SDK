package com.kf5.support.model;

public class Forum {

	private int id; //文档分类id，由系统自动分配
	
	private String url; //资源url
	
	private int category_id; //该分类所属的文档分区id
	
	private String title; //文档分类名称
	
	private String content; //文档分类描述
	
	private String role_view; //文档分类查看权限, 可选值:all,logged_in,agent
	
	private int sort; //文档分类前台显示顺序

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

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
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

	public String getRole_view() {
		return role_view;
	}

	public void setRole_view(String role_view) {
		this.role_view = role_view;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}
	
}
