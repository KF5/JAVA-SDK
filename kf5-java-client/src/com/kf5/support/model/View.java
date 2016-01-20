package com.kf5.support.model;

public class View {

	private int id; //查看分类id，由系统自动分配
	
	private String url; //资源url
	
	private String title; //查看分类名称
	
	private boolean active; //查看分类是否启用
	
	private String created_at; //查看分类创建时间
	
	private int slas_id ; //若是slas查看分类，此字段会带有值
	

	public int getSlas_id() {
		return slas_id;
	}

	public void setSlas_id(int slas_id) {
		this.slas_id = slas_id;
	}

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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	
	
}
