package com.kf5.support.model;

import java.util.ArrayList;
import java.util.List;

public class Organization {

	private int id; //公司组织id，由系统自动分配
	
	private String url; //资源url
	
	private String name; //组织名称
	
	private String domain; //域名后缀，格式为{domain}.com。创建用户时，用户邮箱若匹配上domain字段，则自动加入组织
	
	private String desription; //组织描述
	
	private int group_id; //分配公司组织的工单给指定客服组
	
	private String created_at; //组织创建时间
	 
	private List<OrganizationField> organizationFields = new ArrayList<OrganizationField>();//公司组织自定义字段

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

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getDesription() {
		return desription;
	}

	public void setDesription(String desription) {
		this.desription = desription;
	}

	public int getGroup_id() {
		return group_id;
	}

	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public List<OrganizationField> getOrganizationFields() {
		return organizationFields;
	}

	public void setOrganizationFields(List<OrganizationField> organizationFields) {
		this.organizationFields = organizationFields;
	}
	
	
	
}
