package com.kf5.support.model;

import java.util.ArrayList;
import java.util.List;

public class UserField {

	private int id; //�û��ֶ�id����ϵͳ�Զ�����
	
	private String url; //��ǰ��Դurl
	
	private String name; //�û��ֶε����ƣ���ʽΪ"field_{id}"
	
	private String type; //	�ֶ�����
	
	private String title; //�ֶε���ʾ����
	
	private String description; //�ֶε���ʾ˵��
	
	private boolean active; //�ֶ��Ƿ�����
	
	private List<CustomFieldOption> customFieldOptions = new ArrayList<CustomFieldOption>(); //�����˵��ֶε�ѡ������

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<CustomFieldOption> getCustomFieldOptions() {
		return customFieldOptions;
	}

	public void setCustomFieldOptions(List<CustomFieldOption> customFieldOptions) {
		this.customFieldOptions = customFieldOptions;
	}
	
	
	
}
