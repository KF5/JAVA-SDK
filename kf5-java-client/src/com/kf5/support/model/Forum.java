package com.kf5.support.model;

public class Forum {

	private int id; //�ĵ�����id����ϵͳ�Զ�����
	
	private String url; //��Դurl
	
	private int category_id; //�÷����������ĵ�����id
	
	private String title; //�ĵ���������
	
	private String content; //�ĵ���������
	
	private String role_view; //�ĵ�����鿴Ȩ��, ��ѡֵ:all,logged_in,agent
	
	private int sort; //�ĵ�����ǰ̨��ʾ˳��

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
