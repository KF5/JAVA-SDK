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

}
