package com.kf5.support.model;

public class View {

	private int id; //�鿴����id����ϵͳ�Զ�����
	
	private String url; //��Դurl
	
	private String title; //�鿴��������
	
	private boolean active; //�鿴�����Ƿ�����
	
	private String created_at; //�鿴���ഴ��ʱ��
	
	private int slas_id ; //����slas�鿴���࣬���ֶλ����ֵ
	

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
