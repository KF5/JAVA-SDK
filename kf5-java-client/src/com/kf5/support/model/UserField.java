package com.kf5.support.model;

import java.util.ArrayList;
import java.util.List;

public class UserField {

	private int id; //用户字段id，由系统自动分配
	
	private String url; //当前资源url
	
	private String name; //用户字段的名称，格式为"field_{id}"
	
	private String type; //	字段类型
	
	private String title; //字段的显示名称
	
	private String description; //字段的显示说明
	
	private boolean active; //字段是否启用
	
	private List<CustomFieldOption> customFieldOptions = new ArrayList<CustomFieldOption>(); //下拉菜单字段的选项数组

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
