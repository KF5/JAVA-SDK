package com.kf5.support.model;

public class Upload {

	private int size; // 附件大小

	private int create;// 创建时间

	private String name;// 附件名称

	private int id; // 附件id

	private String type; // 附件类型

	public int getCreate() {
		return create;
	}

	public void setCreate(int create) {
		this.create = create;
	}

	private String url; // 附件网络url

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	
	/*
	 * ###########################################2017-8-22新增API################
	 * ###########################
	 */
	
	private int width;
	
	private String oss_token;
	
	private int height;
	
	private String token;

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public String getOss_token() {
		return oss_token;
	}

	public void setOss_token(String oss_token) {
		this.oss_token = oss_token;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
}
