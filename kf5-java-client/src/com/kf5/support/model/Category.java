package com.kf5.support.model;

public class Category {

	private int id; //�ĵ�����id����ϵͳ�Զ�����
	
	private String url; //��Դurl
	
	private String title; //�ĵ���������
	
	private String content; //�ĵ���������
	
	private int display_limit; //�÷�����ǰ̨��ʾ��ÿ��������µ��ĵ�����
	
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
