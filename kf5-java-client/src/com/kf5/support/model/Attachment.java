package com.kf5.support.model;

public class Attachment {

	private int id; //附件id，由系统自动分配
	
	private String url; //资源url
	
	private String name; //附件名称
	
	private int size; //附件大小
	
	private String content_url; //附件获取地址，即下载地址
	
	private String token; //附件的token，凭借token可以将附件绑定到工单回复等资源

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getContent_url() {
		return content_url;
	}

	public void setContent_url(String content_url) {
		this.content_url = content_url;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	
}
