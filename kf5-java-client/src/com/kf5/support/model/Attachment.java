package com.kf5.support.model;

public class Attachment {

	private int id; //����id����ϵͳ�Զ�����
	
	private String url; //��Դurl
	
	private String name; //��������
	
	private int size; //������С
	
	private String content_url; //������ȡ��ַ�������ص�ַ
	
	private String token; //������token��ƾ��token���Խ������󶨵������ظ�����Դ

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
