package com.kf5.support.model;

import java.util.ArrayList;
import java.util.List;

public class Organization {

	private int id; //��˾��֯id����ϵͳ�Զ�����
	
	private String url; //��Դurl
	
	private String name; //��֯����
	
	private String domain; //������׺����ʽΪ{domain}.com�������û�ʱ���û�������ƥ����domain�ֶΣ����Զ�������֯
	
	private String desription; //��֯����
	
	private int group_id; //���乫˾��֯�Ĺ�����ָ���ͷ���
	
	private String created_at; //��֯����ʱ��
	 
	private List<OrganizationField> organizationFields = new ArrayList<OrganizationField>();//��˾��֯�Զ����ֶ�

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
